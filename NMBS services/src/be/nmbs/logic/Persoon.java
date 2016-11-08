package be.nmbs.logic;

<<<<<<< HEAD

=======
import java.util.Date;
>>>>>>> branch 'Sam' of https://github.com/flaviusbura/Software-Project-II.git

public class Persoon {
<<<<<<< HEAD
	
=======
	public enum Geslacht { MAN, VROUW, ONBEKEND }
>>>>>>> branch 'Sam' of https://github.com/flaviusbura/Software-Project-II.git
	private String voornaam;
	private String achternaam;
	private Adres adres;
<<<<<<< HEAD
	private String telefoonnr;
	private int id;
	private boolean actief;
=======
	private Date geboorteDatum;
	private Geslacht geslacht;
>>>>>>> branch 'Sam' of https://github.com/flaviusbura/Software-Project-II.git
	
	// Constructor
<<<<<<< HEAD
	public Persoon(int id,String voornaam, String achternaam, Adres adres,String telefoonnr, boolean actief) {
		this.id = id;
=======
	public Persoon(String voornaam, String achternaam, Adres adres, Geslacht geslacht) {
>>>>>>> branch 'Sam' of https://github.com/flaviusbura/Software-Project-II.git
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
<<<<<<< HEAD
	public String getTelefoonnr(){return telefoonnr;}
	public int getId() { return id; }
	public boolean getActief(){return actief;};
=======
	public Geslacht getGeslacht() { return geslacht; }
	public Date getGeboorteDatum() {return geboorteDatum; }
	
>>>>>>> branch 'Sam' of https://github.com/flaviusbura/Software-Project-II.git
	// Setters
	public void setVoornaam(String voornaam) { this.voornaam = voornaam; }
	public void setAchternaam(String achternaam) { this.achternaam = achternaam; }
	public void setAdres(Adres adres) { this.adres = adres; }
<<<<<<< HEAD
	public void setTelefoonnr(String telefoonnr){this.telefoonnr = telefoonnr;}
	public void setId(int id){this.id = id;}
	public void setActief(boolean actief){this.actief=actief;};
=======
	public void setGeslacht(Geslacht geslacht) { this.geslacht = geslacht; }
	public void setGeboorteDatum(Date geboorteDatum) {this.geboorteDatum = geboorteDatum; }
	
>>>>>>> branch 'Sam' of https://github.com/flaviusbura/Software-Project-II.git
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