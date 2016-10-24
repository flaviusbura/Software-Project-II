package be.nmbs.logic;

import java.util.Date;

public class Abonnement {
	private Klant klant;
	private String startStation;
	private String eindStation;
	private Date startDatum;
	private Date eindDatum;
	
	// Constructor
	public Abonnement(Klant klant, String startStation, String eindStation, Date startDatum, Date eindDatum) {
		this.klant = klant;
		this.startStation = startStation;
		this.eindStation = eindStation;
		this.startDatum = startDatum;
		this.eindDatum = eindDatum;
	}
	
	// Getters
	public Klant getKlant() { return klant; }
	public String getStartStation() { return startStation; }
	public String getEindStation() { return eindStation; }
	public Date getStartDatum() { return startDatum; }
	public Date getEindDatum() { return eindDatum; }
	
	// Setters
	public void setKlant(Klant klant) { this.klant = klant; }
	public void setStartStation(String startStation) { this.startStation = startStation; }
	public void setEindStation(String eindStation) { this.eindStation = eindStation; }
	public void setStartDatum(Date startDatum) { this.startDatum = startDatum; }
	public void setEindDatum(Date eindDatum) { this.eindDatum = eindDatum; }	
}