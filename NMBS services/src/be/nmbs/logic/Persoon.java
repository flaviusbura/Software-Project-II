package be.nmbs.logic;

public class Persoon {
	private String voornaam;
	private String achternaam;
	private Adres adres;
	private char geslacht;
	
	// Constructor
	public Persoon(String voornaam, String achternaam, Adres adres, char geslacht) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.adres = adres;
		this.geslacht = geslacht;
	}

	// Getters
	public String getVoornaam() { return voornaam; }
	public String getAchternaam() { return achternaam; }
	public Adres getAdres() { return adres; }
	public char getGeslacht() { return geslacht; }
	
	// Setters
	public void setVoornaam(String voornaam) { this.voornaam = voornaam; }
	public void setAchternaam(String achternaam) { this.achternaam = achternaam; }
	public void setAdres(Adres adres) { this.adres = adres; }
	public void setGeslacht(char geslacht) { this.geslacht = geslacht; }
	
	// Methods
	public void wijzigAdres(Adres adres) {
		this.adres = adres;
	}
}