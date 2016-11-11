package be.nmbs.logic;
public class Gebruiker {
	private int id;
	private String voornaam;
	private String achternaam;
	private String wachtwoord;
	private int rol;
	private boolean actief;
	
	/**
	 * Default constructor
	 */
	public Gebruiker() {}
	
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
		if (rol < 1) {
			this.rol = 2;
		} else if (rol > 2) {
			this.rol = 2;
		} else {
			this.rol = rol;
		}
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
		if (rol < 1) {
			this.rol = 2;
		} else if (rol > 2) {
			this.rol = 2;
		} else {
			this.rol = rol;
		}
	}
	
	/**
	 * Stuurt een int terug. Een 1 als het actief is en een nul als niet actief is.
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
	
	/**
	 * Overrides Object.hashcode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achternaam == null) ? 0 : achternaam.hashCode());
		result = prime * result + ((voornaam == null) ? 0 : voornaam.hashCode());
		return result;
	}

	/**
	 * Overrides Object.equals(). Deze methode stuurt true terug als achternaam en voornaam gelijk zijn.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gebruiker other = (Gebruiker) obj;
		if (achternaam == null) {
			if (other.achternaam != null)
				return false;
		} else if (!achternaam.equals(other.achternaam))
			return false;
		if (voornaam == null) {
			if (other.voornaam != null)
				return false;
		} else if (!voornaam.equals(other.voornaam))
			return false;
		return true;
	}
}