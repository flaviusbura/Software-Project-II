package be.nmbs.logic;

public class Persoon {
	private String voornaam;
	private String achternaam;
	private Adres adres;
	
	// Methods
	public void wijzigAdres(Adres a) {
		this.adres = a;
	}
	
	// Getters
	public String getVoornaam() { return voornaam; }
	public String getAchternaam() { return achternaam; }
	public Adres getAdres() { return adres; }
	
	// Setters
	public void setVoornaam(String voornaam) { this.voornaam = voornaam; }
	public void setAchternaam(String achternaam) { this.achternaam = achternaam; }
	public void setAdres(Adres adres) { this.adres = adres; }
}