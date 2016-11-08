package be.nmbs.logic;

public class Adres {
	private String straat;
	private int huisnummer;
	private int postcode;
	private String bus;
	private String woonplaats;
	private int adresId;
	
	// Constructor
	public Adres(String straat, int huisnummer, int postcode, String bus, String woonplaats, int adresId) {
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.postcode = postcode;
		this.bus = bus;
		this.woonplaats = woonplaats;
		this.adresId = adresId;
	}
	
	public int getAdresId() {
		return adresId;
	}

	public void setAdresId(int adresId) {
		this.adresId = adresId;
	}

	// Getters
	public String getStraat() { return straat; }
	public int getHuisnummer() { return huisnummer; }
	public int getPostcode() { return postcode; }
	public String getBus() { return bus; }
	public String getWoonplaats() { return woonplaats; }
	
	// Setters
	public void setStraat(String straat) { this.straat = straat; }
	public void setHuisnummer(int huisnummer) { this.huisnummer = huisnummer; }
	public void setPostcode(int postcode) { this.postcode = postcode; }
	public void setBus(String bus) { this.bus = bus; }
	public void setWoonplaats(String woonplaats) { this.woonplaats = woonplaats; }
}