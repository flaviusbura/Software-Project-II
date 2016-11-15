package be.nmbs.logic;

/**
 * Deze klasse gaat gebruikt worden om Prijs-objecten aan te maken.
 * 
 * @author Abdel-Portable
 *
 */

public class Prijs {
	private int prijsId;
	private String omschrijving;
	private double prijs;
	private String type;
	private boolean actief;

	/**
	 * Default constructor.
	 */
	public Prijs() {
	}

	/**
	 * Constructor met alle nodige parameters.
	 * 
	 * @param prijs_id
	 * @param omschrijving
	 * @param prijs
	 * @param type
	 * @param actief
	 */
	public Prijs(int prijsId, String omschrijving, double prijs, String type, boolean actief) {
		this.prijsId = prijsId;
		this.omschrijving = omschrijving;
		this.prijs = prijs;
		this.type = type;
		this.actief = actief;
	}

	/**
	 * Deze methode gaat de prijs_id terugsturen.
	 * 
	 * @return Een int, het id van de prijs.
	 */
	public int getPrijsId() {
		return prijsId;
	}

	/**
	 * Deze methode sets het prijs_id.
	 * 
	 * @param id
	 */
	public void setPrijs_id(int id) {
		this.prijsId = id;
	}

	/**
	 * Deze methode gaat de omschrijving van de prijs terugsturen.
	 * 
	 * @return Een String-object met de omschrijving
	 */
	public String getOmschrijving() {
		return omschrijving;
	}

	/**
	 * Deze methode sets de omschrijving.
	 * 
	 * @param omsc
	 */
	public void setOmschrijving(String omsc) {
		this.omschrijving = omsc;
	}

	/**
	 * Deze methode gaat de prijs terugsturen.
	 * 
	 * @return Een double
	 */
	public double getPrijs() {
		return prijs;
	}

	/**
	 * Deze methode sets de prijs.
	 * 
	 * @param prijs
	 */
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	/**
	 * Deze methode gaat het type van de prijs terugsturen.
	 * 
	 * @return Een String-object met het type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Deze methode sets het type.
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Deze methode gaat terugsturen of het type prijs nog actief is.
	 * 
	 * @return Een boolean
	 */
	public boolean getActief() {
		return actief;
	}

	/**
	 * Deze methode sets actief
	 * 
	 * @param act
	 */
	public void setActief(boolean actief) {
		this.actief = actief;
	}
}
