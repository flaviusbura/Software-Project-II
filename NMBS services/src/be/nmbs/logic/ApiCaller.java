package be.nmbs.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

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
	
	public void getTrainInfo(String stepOn, String stepOff) throws Exception {
		try {
		    JSONObject json = new JSONObject(readUrl("https://traintracks.online/api/Route/" + stepOn + "/" + stepOff));
		    
		    JSONArray title = (JSONArray) json.get("Routes");
		    System.out.println(title);
		} catch (JSONException e) {
		    e.printStackTrace();
		}
	}
}