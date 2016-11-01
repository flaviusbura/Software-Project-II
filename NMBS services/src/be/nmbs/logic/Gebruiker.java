package be.nmbs.logic;
public class Gebruiker {
	private int id;
	private String voornaam;
	private String achternaam;
	private String wachtwoord;
	private int rol;
	private boolean actief;
	
	/**
	 * Constructor met vijf parameters. Maakt een gebruiker object aan.
	 * @param voornaam
	 * @param achternaam
	 * @param wachtwoord
	 * @param rol
	 * @param actief
	 */
	public Gebruiker(int id, String voornaam, String achternaam, String wachtwoord,
			int rol, boolean actief) {
		this.id = id;
		this.voornaam =voornaam;
		this.achternaam = achternaam;
		this.wachtwoord = wachtwoord;
		this.rol = rol;
		this.actief = actief;
	}
	
	/**
	 * Deze stuurt de ID van de gebruiker terug
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Deze methode sets mijn ID van de gebruiker
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Stuurt voornaam terug
	 * @return
	 */
	public String getVoornaam() {
		return voornaam;
	}
	
	/**
	 * Deze methode sets mijn voornaam
	 * @param voornaam
	 */
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	
	/**
	 * Stuurt mijn achternaam terug
	 * @return
	 */
	public String getAchternaam() {
		return achternaam;
	}
	
	/**
	 * Deze methode sets mijn achternaam
	 * @param achternaam
	 */
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	
	/**
	 * Stuurt mijn wachtwoord terug
	 * @return
	 */
	public String getWachtwoord() {
		return wachtwoord;
	}
	
	/**
	 * Deze methode sets mijn wachtwoord
	 * @param wachtwoord
	 */
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
	
	/**
	 * Stuurt mijn rol terug als int
	 * @return
	 */
	public int getRol() {
		return rol;
	}
	
	/**
	 * Deze methode sets mijn rol
	 * @param rol
	 */
	public void setRol(int rol) {
		this.rol = rol;
	}
	
	/**
	 * Stuurt een int terug
	 * @return
	 */
	public int isActief() {
		if (actief == true)
			return 1;
		return 0;
	}
	
	/**
	 * Deze methode sets mijn actief datamember
	 * @param actief
	 */
	public void setActief(boolean actief) {
		this.actief = actief;
	}
}