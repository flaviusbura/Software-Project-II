package be.nmbs.logic;

public class Klant {
	private int contactId;
	private String voornaam;
	private String achternaam;
	private int adresId;
	private String telefoon;
	private boolean actief;
	
	/**
	 * Default constructor
	 */
	public Klant() {}
	
	/**
	 * Constructor met alle parameters
	 * @param contactId
	 * @param voornaam
	 * @param achternaam
	 * @param adresId
	 * @param telefoon
	 * @param actief
	 */
	public Klant(int contactId, String voornaam, String achternaam, int adresId, String telefoon, boolean actief) {
		super();
		this.contactId = contactId;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.adresId = adresId;
		this.telefoon = telefoon;
		this.actief = actief;
	}
	
	/**
	 * Deze methode stuurt mijn contactId van de klant terug
	 * @return
	 */
	public int getContactId() {
		return contactId;
	}

	/**
	 * Deze methode sets mijn contactId
	 * @param contactId
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	/**
	 * Deze methode stuurt de voornaam van de klant terug
	 * @return
	 */
	public String getVoornaam() {
		return voornaam;
	}

	/**
	 * Deze mothode sets mijn voornaam
	 * @param voornaam
	 */
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	/**
	 * Deze methode stuurt mijn achternaam terug
	 * @param achternaam
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
	 * Deze methode stuurt mijn adresId terug
	 * @return
	 */
	public int getAdresId() {
		return adresId;
	}
	
	/**
	 * Deze methode sets mijn adresId
	 * @param adresId
	 */
	public void setAdresId(int adresId) {
		this.adresId = adresId;
	}

	/**
	 * Deze methode stuurt de telefoonnummer van de klant terug
	 * @return
	 */
	public String getTelefoon() {
		return telefoon;
	}

	/**
	 * Deze methode sets het telefoonnummer van de klant
	 */
	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
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
	 * Deze krijgt een boolean waarde als parameter en sets actief
	 * @param actief
	 */
	public void setActief(boolean actief) {
		this.actief = actief;
	}
	
	/**
	 * Deze methode overrides Object.hascode()
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
	 * Deze methode overrides Object.equals(). Deze methode stuurt true terug
	 *  als achternaam en voornaam gelijk zijn.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Klant other = (Klant) obj;
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