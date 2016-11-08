package be.nmbs.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiCaller {
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader r = null;
	    try {
	    	URLConnection connection = new URL(urlString).openConnection();
	    	connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
	    	connection.connect();
	    	
	        r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = r.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (r != null)
	            r.close();
	    }
	}
	
	public List<Route> getRouteInfo(String stepOn, String stepOff) throws Exception {
		try {
		    JSONObject json = new JSONObject(readUrl("https://traintracks.online/api/Route/" + stepOn + "/" + stepOff));
		    
		    JSONArray routes = (JSONArray) json.get("Routes");
		    
		    List<Route> r = new ArrayList<Route>();
		    List<Overstap> o = new ArrayList<Overstap>();
		    List<Trein> t = new ArrayList<Trein>();
		    
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			format.setTimeZone(TimeZone.getTimeZone("GMT+1"));
			
			// Alle routes overgaan -> length -1 vanwege één valse route meegegeven door api
		    for (int i = 0; i < routes.length() - 1; i++) {
		    	JSONObject route = routes.getJSONObject(i);
		    	JSONArray treinen = route.getJSONArray("Trains");
		    	JSONArray overstappen = route.getJSONArray("TransferStations");
		    	
		    	// Checken voor treinen
		    	for (int j = 0; j < treinen.length(); j++) {
		    		JSONObject trein = treinen.optJSONObject(j);
		    		JSONArray stations = trein.getJSONObject("Stops").getJSONArray("Stations");
		    		List<Station> s = new ArrayList<Station>();
		    		
		    		Date aDate = null, aaDate = null, dDate = null, adDate = null;
		    		// Time checking
		    		for (int k = 0; k < stations.length(); k++) {
		    			JSONObject station = stations.getJSONObject(k);
		    			JSONObject time = station.getJSONObject("Time");
		    			
		    			String sDate = "";
		    			// Checking arrival en actual arrival time
		    			if (k != 0) {
		    				
		    				// Arrival time
		    				sDate = time.getString("Arrival");
		    				if (sDate.endsWith("+01:00"))
			    				sDate = sDate.substring(0, sDate.length() - 6);

		    				aDate = format.parse(sDate);
		    				
		    				// Actual arrival time
		    				sDate = time.getString("ActualArrival");
			    			if (sDate.endsWith("+01:00"))
			    				sDate = sDate.substring(0, sDate.length() - 6);
			    			
		    				aaDate = format.parse(sDate);
		    			} else { aDate = null; aaDate = null; }
		  
		    			// Checking departure en actual departure time
		    			if (k != stations.length() - 1) {
		    				// Departure time
			    			sDate = time.getString("Departure");
			    			if (sDate.endsWith("+01:00"))
			    				sDate = sDate.substring(0, sDate.length() - 6);
			    			
		    				dDate = format.parse(sDate);
		    				
		    				// Actual departure time
		    				sDate = time.getString("ActualDeparture");
			    			if (sDate.endsWith("+01:00"))
			    				sDate = sDate.substring(0, sDate.length() - 6);
			    			
		    				adDate = format.parse(sDate);
		    			} else { dDate = null; adDate = null; }
		    			
		    			if (k == 0)
		    				s.add(new Station(station.getString("Name"), null, station.getString("DeparturePlatform"), aDate, aaDate, dDate, adDate));
		    			else if (k == stations.length() - 1)
		    				s.add(new Station(station.getString("Name"), station.getString("ArrivalPlatform"), null, aDate, aaDate, dDate, adDate));
		    			else
		    				s.add(new Station(station.getString("Name"), station.getString("ArrivalPlatform"), station.getString("DeparturePlatform"), aDate, aaDate, dDate, adDate));
		    		}
		    		
		    		t.add(new Trein(trein.getString("FullId"), trein.get("DepartureStation").toString(), trein.getString("TerminusStation"), s, trein.getBoolean("Cancelled")));
		    	}
		    	
		    	// Checken voor overstappen
		    	for (int j = 0; j < overstappen.length(); j++) {
		    		JSONObject overstap = overstappen.optJSONObject(j);
			    	if (!overstap.isNull("TransferAt"))
			    		o.add(new Overstap(overstap.get("TransferAt").toString(), overstap.getInt("ArrivalPlatform"), overstap.getInt("DeparturePlatform")));
		    	}
			    
		    	r.add(new Route(route.getString("Departure"), route.getString("Arrival"), t, o));
		    	o.clear();
		    	t.clear();
		    }

		    return r;
		} catch (JSONException e) {
		    e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("Geen routes gevonden. Een waarde die u hebt ingegeven bestaat niet.");
			return null;
		}
	}
	
	public Trein getTreinInfo(String id) throws Exception {
		try {
		    JSONObject trein = new JSONObject(readUrl("https://traintracks.online/api/Train/" + id));
		    
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			format.setTimeZone(TimeZone.getTimeZone("GMT+1"));
			
			// Checken voor treinen
    		JSONArray stations = trein.getJSONObject("Stops").getJSONArray("Stations");
    		List<Station> s = new ArrayList<Station>();
    		
    		Date aDate = null, aaDate = null, dDate = null, adDate = null;
    		// Time checking
    		for (int k = 0; k < stations.length(); k++) {
    			JSONObject station = stations.getJSONObject(k);
    			JSONObject time = station.getJSONObject("Time");
    			
    			String sDate = "";
    			// Checking arrival en actual arrival time
    			if (k != 0) {
    				
    				// Arrival time
    				sDate = time.getString("Arrival");
    				if (sDate.endsWith("+01:00"))
	    				sDate = sDate.substring(0, sDate.length() - 6);

    				aDate = format.parse(sDate);
    				
    				// Actual arrival time
    				sDate = time.getString("ActualArrival");
	    			if (sDate.endsWith("+01:00"))
	    				sDate = sDate.substring(0, sDate.length() - 6);
	    			
    				aaDate = format.parse(sDate);
    			} else { aDate = null; aaDate = null; }
  
    			// Checking departure en actual departure time
    			if (k != stations.length() - 1) {
    				// Departure time
	    			sDate = time.getString("Departure");
	    			if (sDate.endsWith("+01:00"))
	    				sDate = sDate.substring(0, sDate.length() - 6);
	    			
    				dDate = format.parse(sDate);
    				
    				// Actual departure time
    				sDate = time.getString("ActualDeparture");
	    			if (sDate.endsWith("+01:00"))
	    				sDate = sDate.substring(0, sDate.length() - 6);
	    			
    				adDate = format.parse(sDate);
    			} else { dDate = null; adDate = null; }
    			
    			if (k == 0)
    				s.add(new Station(station.getString("Name"), null, station.getString("DeparturePlatform"), aDate, aaDate, dDate, adDate));
    			else if (k == stations.length() - 1)
    				s.add(new Station(station.getString("Name"), station.getString("ArrivalPlatform"), null, aDate, aaDate, dDate, adDate));
    			else
    				s.add(new Station(station.getString("Name"), station.getString("ArrivalPlatform"), station.getString("DeparturePlatform"), aDate, aaDate, dDate, adDate));
    		}
    		
    		Trein t = new Trein(trein.getString("FullId"), trein.get("DepartureStation").toString(), trein.getString("TerminusStation"), s, trein.getBoolean("Cancelled"));

		    return t;
		} catch (JSONException e) {
		    e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("Geen trein gevonden. Een waarde die u hebt ingegeven bestaat niet.");
			return null;
		}
	}
}