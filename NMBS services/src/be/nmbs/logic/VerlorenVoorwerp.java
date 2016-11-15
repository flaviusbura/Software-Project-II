package be.nmbs.logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VerlorenVoorwerp {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int id;
	private Station station;
	private String omschrijving;
	private Timestamp timestamp;
	private boolean actief;

	public VerlorenVoorwerp() {}
	
	public VerlorenVoorwerp(int id, Station station, String omschrijving, boolean actief) {
		this.id = id;
		this.station = station;
		this.omschrijving = omschrijving;
		this.actief = actief;
	}
	
	public VerlorenVoorwerp(int id, Station station, String omschrijving, Timestamp timestamp, boolean actief) {
		this.id = id;
		this.station = station;
		this.omschrijving = omschrijving;
		this.timestamp = timestamp;
		this.actief = actief;
	}

	public int getId() {
		return id;
	}

	public Station getStation() {
		return station;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public boolean isActief() {
		return actief;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public Timestamp getTimestampNow() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		Timestamp timestamp = new Timestamp(now.getTime());
		return timestamp;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public void setActief(boolean actief) {
		this.actief = actief;
	}
	
	public String getTimestampWithoutNonoSec() {
		String currentDate = sdf.format(timestamp);
		return currentDate;
	}
}
