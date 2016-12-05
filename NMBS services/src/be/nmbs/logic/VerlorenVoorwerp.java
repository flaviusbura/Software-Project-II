package be.nmbs.logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VerlorenVoorwerp {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int id;
	private StationNMBS station;
	private String omschrijving;
	private String type;
	private Timestamp timestamp;
	private boolean actief;

	public VerlorenVoorwerp() {}
	
	public VerlorenVoorwerp(int id, StationNMBS station, String omschrijving, boolean actief) {
		this.id = id;
		this.station = station;
		this.omschrijving = omschrijving;
		this.actief = actief;
	}
	
	public VerlorenVoorwerp(int id, StationNMBS station, String omschrijving, String type,Timestamp timestamp, boolean actief) {
		this.id = id;
		this.station = station;
		this.omschrijving = omschrijving;
		this.timestamp = timestamp;
		this.actief = actief;
		this.type=type;
	}

	public VerlorenVoorwerp( StationNMBS station, String omschrijving, String type,Timestamp timestamp, boolean actief) {
		
		this.station = station;
		this.omschrijving = omschrijving;
		this.timestamp = timestamp;
		this.actief = actief;
		this.type=type;
	}
	public int getId() {
		return id;
	}

	public StationNMBS getStationStationNMBS() {
		return station;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isActief() {
		return actief;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public StationNMBS getStation() {
		return station;
	}

	public void setStation(StationNMBS station) {
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
