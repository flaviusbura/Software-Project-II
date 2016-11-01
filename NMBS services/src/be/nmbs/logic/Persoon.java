package be.nmbs.logic;

import java.util.Date;

public class Persoon {
	public enum Geslacht { MAN, VROUW, ONBEKEND }
	private String voornaam;
	private String achternaam;
	private Adres adres;
	private Date geboorteDatum;
	private Geslacht geslacht;
	
	// Constructor
	public Persoon(String voornaam, String achternaam, Adres adres, Geslacht geslacht) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.adres = adres;
		this.geslacht = geslacht;
	}

	// Getters
	public String getVoornaam() { return voornaam; }
	public String getAchternaam() { return achternaam; }
	public Adres getAdres() { return adres; }
	public Geslacht getGeslacht() { return geslacht; }
	public Date getGeboorteDatum() {return geboorteDatum; }
	
	// Setters
	public void setVoornaam(String voornaam) { this.voornaam = voornaam; }
	public void setAchternaam(String achternaam) { this.achternaam = achternaam; }
	public void setAdres(Adres adres) { this.adres = adres; }
	public void setGeslacht(Geslacht geslacht) { this.geslacht = geslacht; }
	public void setGeboorteDatum(Date geboorteDatum) {this.geboorteDatum = geboorteDatum; }
	
	// Methods
	public void wijzigAdres(Adres adres) {
		this.adres = adres;
	}
}