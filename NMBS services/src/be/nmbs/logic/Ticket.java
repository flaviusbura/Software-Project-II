package be.nmbs.logic;

import java.util.Date;

public class Ticket {
	private int id;
	private String startStation;
	private String eindStation;
	private Date datum;
	private double prijs;
	private Klasse klasse;
	public enum Klasse { EERSTE, TWEEDE };
	
	// Constructor
	public Ticket(int id, String startStation, String eindStation, Date datum, double prijs, Klasse klasse) {
		this.id = id;
		this.startStation = startStation;
		this.eindStation = eindStation;
		this.datum = datum;
		this.prijs = prijs;
		this.klasse = klasse;
	}
	
	// Getters
	public int getId() { return id; }
	public String getStartStation() { return startStation; }
	public String getEindStation() { return eindStation; }
	public Date getDatum() { return datum; }
 	public double getPrijs() { return prijs; }
	public Klasse getKlasse() { return klasse; }
	
	// Setters
	public void setId(int id) { this.id = id; }
	public void setStartStation(String startStation) { this.startStation = startStation; }
	public void setEindStation(String eindStation) { this.eindStation = eindStation; }
	public void setDatum(Date datum) { this.datum = datum; }
	public void setPrijs(double prijs) { this.prijs = prijs; }
 	public void setKlasse(Klasse klasse) { this.klasse = klasse; }
}