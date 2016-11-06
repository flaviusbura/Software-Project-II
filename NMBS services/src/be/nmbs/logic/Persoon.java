package be.nmbs.logic;



public class Persoon {
	
	private String voornaam;
	private String achternaam;
	private Adres adres;
	private String telefoonnr;
	private int id;
	private boolean actief;
	
	// Constructor
	public Persoon(int id,String voornaam, String achternaam, Adres adres,String telefoonnr, boolean actief) {
		this.id = id;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.adres = adres;
		this.telefoonnr = telefoonnr;
		this.actief = actief;
	}

	// Getters
	public String getVoornaam() { return voornaam; }
	public String getAchternaam() { return achternaam; }
	public Adres getAdres() { return adres; }
	public String getTelefoonnr(){return telefoonnr;}
	public int getId() { return id; }
	public boolean getActief(){return actief;};
	// Setters
	public void setVoornaam(String voornaam) { this.voornaam = voornaam; }
	public void setAchternaam(String achternaam) { this.achternaam = achternaam; }
	public void setAdres(Adres adres) { this.adres = adres; }
	public void setTelefoonnr(String telefoonnr){this.telefoonnr = telefoonnr;}
	public void setId(int id){this.id = id;}
	public void setActief(boolean actief){this.actief=actief;};
	// Methods
	public void wijzigAdres(Adres adres) {
		this.adres = adres;
	}
	
	public int isActief() {
		if (actief == true)
			return 1;
		return 0;
	}
}