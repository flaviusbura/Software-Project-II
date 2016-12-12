package be.nmbs.logic;

/**
 * Deze klasse wordt gebruikt om een Adresobject aan te maken.
 * @author flaviusb
 *
 */
public class Adres {
	private String straat;
	private int huisnummer;
	private int postcode;
	private String bus;
	private String woonplaats;
	private int adresId;
	private String land;
	private boolean actief;

	/**
	 * Deze constructor maakt een anders aan met alles parameters.
	 * @param straat
	 * @param huisnummer
	 * @param postcode
	 * @param bus
	 * @param woonplaats
	 * @param adresId
	 * @param land
	 * @param actief
	 */
	public Adres(String straat, int huisnummer, int postcode, String bus, String woonplaats, int adresId, String land,
			boolean actief) {
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.postcode = postcode;
		this.bus = bus;
		this.woonplaats = woonplaats;
		this.adresId = adresId;
		this.land = land;
		this.actief = actief;
	}
	
	/**
	 * Deze constructor maakt een adres aan zonder adresId want deze hebben we niet nodig bij het sturen naar de database.
	 * @param straat
	 * @param huisnummer
	 * @param postcode
	 * @param bus
	 * @param woonplaats
	 * @param land
	 * @param actief
	 */
	public Adres(String straat, int huisnummer, int postcode, String bus, String woonplaats, String land,
			boolean actief) {
		this.straat = straat;
		this.huisnummer = huisnummer;
		this.postcode = postcode;
		this.bus = bus;
		this.woonplaats = woonplaats;
		this.land = land;
		this.actief = actief;
	}

	public int getAdresId() {
		return adresId;
	}

	public void setAdresId(int adresId) {
		this.adresId = adresId;
	}

	public String getStraat() {
		return straat;
	}

	public int getHuisnummer() {
		return huisnummer;
	}

	public int getPostcode() {
		return postcode;
	}

	public String getBus() {
		return bus;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public int getId() {
		return adresId;
	}

	public String getLand() {
		return land;
	}

	public boolean getActief() {
		return actief;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public void setHuisnummer(int huisnummer) {
		this.huisnummer = huisnummer;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public void setActief(boolean actief) {
		this.actief = actief;
	}
}