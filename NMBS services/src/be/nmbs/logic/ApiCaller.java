package be.nmbs.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Deze klasse spreekt de API aan en vraagt gegevens in verband met trainen, stations, etc.
 * @author flaviusb
 *
 */
public class ApiCaller {
	/**
	 * Maakt een connectie met de API door gebruik te maken van een url.
	 * 
	 * @param urlString Bevat de url van de API.
	 * @return
	 */
	// readUrl klasse geleend van user dacwe op Stack Overflow
	// (http://stackoverflow.com/questions/7467568/parsing-json-from-url)
	private static String readUrl(String urlString) {
		BufferedReader r = null;
		try {
			// User agent code overgenomen van Esailija op Stack Overflow
			// (http://stackoverflow.com/questions/13670692/403-forbidden-with-java-but-not-web-browser)
			URLConnection connection = new URL(urlString).openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.connect();

			r = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = r.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} catch (FileNotFoundException e) {
			return "";
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			return "";
		} finally {
			if (r != null)
				try {
					r.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * Vraagt een lijst van routes op en geeft deze terug in een ArrayList.
	 * 
	 * @param stepOn
	 * @param stepOff
	 * @return
	 */
	public static ArrayList<Route> getRouteInfo(String stepOn, String stepOff) {
		try {
			String text = readUrl("https://traintracks.online/api/Route/" + stepOn + "/" + stepOff);
			if (text != "") {
				JSONObject json = new JSONObject(text);

				JSONArray routes = (JSONArray) json.get("Routes");

				ArrayList<Route> r = new ArrayList<Route>();
				ArrayList<Overstap> o = new ArrayList<Overstap>();
				ArrayList<Trein> t = new ArrayList<Trein>();

				Overstap endOverstap = null;

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				format.setTimeZone(TimeZone.getTimeZone("GMT+1"));

				// Alle routes overgaan -> length -1 vanwege ��n valse route
				// meegegeven door api
				for (int i = 0; i < routes.length() - 1; i++) {
					JSONObject route = routes.getJSONObject(i);
					JSONArray treinen = route.getJSONArray("Trains");
					JSONArray overstappen = route.getJSONArray("TransferStations");

					// Checken voor treinen
					for (int j = 0; j < treinen.length(); j++) {
						JSONObject trein = treinen.optJSONObject(j);
						JSONArray stations = trein.getJSONObject("Stops").getJSONArray("Stations");
						List<Station> s = new ArrayList<Station>();

						JSONObject trainTime = trein.getJSONObject("Time");

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
							} else {
								aDate = null;
								aaDate = null;
							}

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
							} else {
								dDate = null;
								adDate = null;
							}

							if (time.getString("Arrival") == trainTime.getString("Arrival")) {
								endOverstap = new Overstap("", station.getString("Name"),
										station.getString("ArrivalPlatform"), "",
										format.parse(time.getString("Arrival")), null, "");
							}

							if (k == 0)
								s.add(new Station(station.getString("Name"), null,
										station.getString("DeparturePlatform"), aDate, aaDate, dDate, adDate));
							else if (k == stations.length() - 1)
								s.add(new Station(station.getString("Name"), station.getString("ArrivalPlatform"), null,
										aDate, aaDate, dDate, adDate));
							else
								s.add(new Station(station.getString("Name"), station.getString("ArrivalPlatform"),
										station.getString("DeparturePlatform"), aDate, aaDate, dDate, adDate));
						}

						Date tDate = format.parse(trainTime.getString("Arrival"));
						t.add(new Trein(trein.getString("FullId"), trein.get("DepartureStation").toString(),
								trein.getString("TerminusStation"), s, trein.getBoolean("Cancelled"), tDate));
					}

					// Checken voor overstappen
					for (int j = 0; j < overstappen.length(); j++) {
						JSONObject overstap = overstappen.optJSONObject(j);
						String ar = overstap.getString("ArrivalTime");
						Date arrival = format.parse(ar);

						String dep = overstap.getString("DepartureTime");
						Date departure = format.parse(dep);
						if (overstap.get("ArrivalPlatform") == null)
							o.add(new Overstap(overstap.get("FullId").toString(), overstap.get("TransferAt").toString(),
									null, overstap.getString("DeparturePlatform"), arrival, departure,
									overstap.getString("TerminusStation")));
						else
							o.add(new Overstap(overstap.get("FullId").toString(), overstap.get("TransferAt").toString(),
									overstap.getString("ArrivalPlatform"), overstap.getString("DeparturePlatform"),
									arrival, departure, overstap.getString("TerminusStation")));
					}

					o.add(new Overstap("", endOverstap.getStation(), endOverstap.getStepOffPlatform(), "",
							endOverstap.getArrival(), null, ""));

					r.add(new Route(route.getString("Departure"), route.getString("Arrival"), t, o));
					o.clear();
					t.clear();
				}

				return r;
			} else {
				return null;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Vraagt een lijst van routes op een gegeven tijdstip op en geeft deze
	 * terug in een ArrayList.
	 * 
	 * @param stepOn
	 * @param stepOff
	 * @param date
	 * @return
	 */
	public static ArrayList<Route> getTimedRouteInfo(String stepOn, String stepOff, Date date) {
		try {
			long ms = (date.getTime() + 3600) / 1000;
			String text = readUrl("https://traintracks.online/api/Route/" + stepOn + "/" + stepOff + "/" + ms);
			if (text != "") {
				JSONObject json = new JSONObject(text);

				JSONArray routes = (JSONArray) json.get("Routes");

				ArrayList<Route> r = new ArrayList<Route>();
				ArrayList<Overstap> o = new ArrayList<Overstap>();
				ArrayList<Trein> t = new ArrayList<Trein>();

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				format.setTimeZone(TimeZone.getTimeZone("GMT+1"));

				// Alle routes overgaan -> length -1 vanwege ��n valse route
				// meegegeven door api
				for (int i = 0; i < routes.length() - 1; i++) {
					JSONObject route = routes.getJSONObject(i);
					JSONArray treinen = route.getJSONArray("Trains");
					JSONArray overstappen = route.getJSONArray("TransferStations");

					Overstap endOverstap = null;

					// Checken voor treinen
					for (int j = 0; j < treinen.length(); j++) {
						JSONObject trein = treinen.optJSONObject(j);
						JSONArray stations = trein.getJSONObject("Stops").getJSONArray("Stations");
						List<Station> s = new ArrayList<Station>();

						JSONObject trainTime = trein.getJSONObject("Time");

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
							} else {
								aDate = null;
								aaDate = null;
							}

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
							} else {
								dDate = null;
								adDate = null;
							}

							if (format.parse(trainTime.getString("Arrival")).equals(aDate))
								endOverstap = new Overstap("", station.getString("Name"),
										station.getString("ArrivalPlatform"), "",
										format.parse(time.getString("Arrival")), null, "");

							if (k == 0 && !station.isNull("DeparturePlatform"))
								s.add(new Station(station.getString("Name"), null,
										station.getString("DeparturePlatform"), aDate, aaDate, dDate, adDate));
							else if (k == stations.length() - 1 && !station.isNull("ArrivalPlatform"))
								s.add(new Station(station.getString("Name"), station.getString("ArrivalPlatform"), null,
										aDate, aaDate, dDate, adDate));
							else if (station.isNull("DeparturePlatform") && station.isNull("ArrivalPlatform"))
								s.add(new Station(station.getString("Name"), null, null, aDate, aaDate, dDate, adDate));
							else
								s.add(new Station(station.getString("Name"), station.getString("ArrivalPlatform"),
										station.getString("DeparturePlatform"), aDate, aaDate, dDate, adDate));
						}

						Date tDate = format.parse(trainTime.getString("Arrival"));
						t.add(new Trein(trein.getString("FullId"), trein.get("DepartureStation").toString(),
								trein.getString("TerminusStation"), s, trein.getBoolean("Cancelled"), tDate));
					}

					// Checken voor overstappen
					for (int j = 0; j < overstappen.length(); j++) {
						JSONObject overstap = overstappen.optJSONObject(j);
						String ar = overstap.getString("ArrivalTime");
						Date arrival = format.parse(ar);

						String dep = overstap.getString("DepartureTime");
						Date departure = format.parse(dep);

						if (overstap.isNull("TransferAt")) {
							if (overstap.isNull("ArrivalPlatform"))
								o.add(new Overstap(overstap.get("FullId").toString(), route.get("Departure").toString(),
										null, null, arrival, departure, overstap.getString("TerminusStation")));
							else
								o.add(new Overstap(overstap.get("FullId").toString(), route.get("Departure").toString(),
										(String) overstap.get("ArrivalPlatform"),
										overstap.getString("DeparturePlatform"), arrival, departure,
										overstap.getString("TerminusStation")));
						} else {
							if (overstap.isNull("ArrivalPlatform"))
								o.add(new Overstap(overstap.get("FullId").toString(),
										overstap.get("TransferAt").toString(), null, null, arrival, departure,
										overstap.getString("TerminusStation")));
							else
								o.add(new Overstap(overstap.get("FullId").toString(),
										overstap.get("TransferAt").toString(), (String) overstap.get("ArrivalPlatform"),
										overstap.getString("DeparturePlatform"), arrival, departure,
										overstap.getString("TerminusStation")));
						}
					}

					if (endOverstap != null)
						o.add(new Overstap("", endOverstap.getStation(), endOverstap.getStepOffPlatform(), "",
								endOverstap.getArrival(), null, ""));

					r.add(new Route(route.getString("Departure"), route.getString("Arrival"), t, o));
					o.clear();
					t.clear();
				}

				for (int i = 0; i < r.size(); i++) {
					r.get(i).toString();
				}

				return r;
			} else {
				return null;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Vraagt een trein op met behulp van een id en geeft het resultaat terug.
	 * 
	 * @param id
	 * @return
	 */
	public static Trein getTreinInfo(String id) {
		try {
			String text = readUrl("https://traintracks.online/api/Train/" + id);

			if (text != "") {
				JSONObject trein = new JSONObject(text);

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
					} else {
						aDate = null;
						aaDate = null;
					}

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
					} else {
						dDate = null;
						adDate = null;
					}

					if (k == 0 && !station.isNull("DeparturePlatform"))
						s.add(new Station(station.getString("Name"), null,
								station.getString("DeparturePlatform"), aDate, aaDate, dDate, adDate));
					else if (k == stations.length() - 1 && !station.isNull("ArrivalPlatform"))
						s.add(new Station(station.getString("Name"), station.getString("ArrivalPlatform"), null,
								aDate, aaDate, dDate, adDate));
					else if (station.isNull("DeparturePlatform") && station.isNull("ArrivalPlatform"))
						s.add(new Station(station.getString("Name"), null, null, aDate, aaDate, dDate, adDate));
					else
						s.add(new Station(station.getString("Name"), station.getString("ArrivalPlatform"),
								station.getString("DeparturePlatform"), aDate, aaDate, dDate, adDate));
				}

				JSONObject trainTime = trein.getJSONObject("Time");
				Date tDate = format.parse(trainTime.getString("Arrival"));
				Trein t = new Trein(trein.getString("FullId"), trein.get("DepartureStation").toString(),
						trein.getString("TerminusStation"), s, trein.getBoolean("Cancelled"), tDate);

				return t;
			} else {
				return null;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}