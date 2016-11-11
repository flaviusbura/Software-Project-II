package be.nmbs.logic;

import java.util.Date;

public class VerlorenVoorwerp {
	private int id;
	private String station;
	private String omschrijving;
	private Date datum;
	private boolean actief;
	
	// Constructor
	public VerlorenVoorwerp(int id, String station, String omschrijving, Date datum, boolean actief) {
		this.id = id;
		this.station = station;
		this.omschrijving = omschrijving;
		this.datum = datum;
		this.actief = actief;
	}

	// Getters
	public int getId() { return id; }
	public String getStation() { return station; }
	public String getOmschrijving() { return omschrijving; }
	public Date getDatum() { return datum; }
	public boolean isActief() { return actief; }
	
	// Setters
	public void setId(int id) { this.id = id; }
	public void setStation(String station) { this.station = station; }
	public void setOmschrijving(String omschrijving) { this.omschrijving = omschrijving; }
	public void setDatum(Date datum) { this.datum = datum; }
	public void setActief(boolean actief) { this.actief = actief; }	
}
