package be.nmbs.logic;

import java.util.Date;

/**
 * Deze klasse gaat gebruikt worden om Boete-objecten aan te maken.
 * 
 * @author flaviusb
 *
 */
public class Boete {
	private int boeteId;
	private int klantContactId;
	private double prijs;
	private Date datum;
	private Date betaalDatum;
	private boolean betaald;

	/**
	 * Default constructor.
	 */
	public Boete() {
	}

	/**
	 * Deze constructor gaat een object aanmaken met alle nodige parameters.
	 * 
	 * @param boeteId
	 * @param klantContactId
	 * @param prijs
	 * @param datum
	 * @param betaalDatum
	 * @param betaald
	 */
	public Boete(int boeteId, int klantContactId, double prijs, Date datum, Date betaalDatum, boolean betaald) {
		super();
		this.boeteId = boeteId;
		this.klantContactId = klantContactId;
		this.prijs = prijs;
		this.datum = datum;
		this.betaalDatum = betaalDatum;
		this.betaald = betaald;
	}

	/**
	 * Deze methode gaat het id van de boete terugsturen.
	 * 
	 * @return Een int met de id van de boete
	 */
	public int getBoeteId() {
		return boeteId;
	}

	/**
	 * Deze methode sets de het boeteId
	 * 
	 * @param boeteId
	 */
	public void setBoeteId(int boeteId) {
		this.boeteId = boeteId;
	}

	/**
	 * Deze methode gaat de klantId terugsturen waaraan de boete is gekoppeld
	 * 
	 * @return Een int met de id van de klant
	 */
	public int getKlantContactId() {
		return klantContactId;
	}

	/**
	 * Deze methode sets klantContactId
	 * 
	 * @param klantContactId
	 */
	public void setKlantContactId(int klantContactId) {
		this.klantContactId = klantContactId;
	}

	/**
	 * Deze methode gaat de prijs die betaald dient te worden terugsturen.
	 * 
	 * @return Een double die de prijs zal bevatten
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
	 * Deze methode gaat een Date-object terugsturen om aan te geven wanneer de
	 * boete aangemaakt is geweest.
	 * 
	 * @return Een Date-object die een datum zal bevatten
	 */
	public Date getDatum() {
		return datum;
	}

	/**
	 * Deze methode sets de datum.
	 * 
	 * @param datum
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
	}

	/**
	 * Deze methode gaat de datum tegen wanneer de boete ten laatste betaald
	 * dient te worden terugsturen.
	 * 
	 * @return Een Date-object die een datum zal bevatten
	 */
	public Date getBetaalDatum() {
		return betaalDatum;
	}

	/**
	 * Deze methode sets betaalDatum.
	 * 
	 * @param betaalDatum
	 */
	public void setBetaalDatum(Date betaalDatum) {
		this.betaalDatum = betaalDatum;
	}

	/**
	 * Deze methode gaat terugsturen of een bepaalde boete betaald of niet
	 * betaald is.
	 * 
	 * @return Een boolean.
	 */
	public boolean isBetaald() {
		return betaald;
	}

	/**
	 * Deze methode sets betaald.
	 * 
	 * @param betaald
	 */
	public void setBetaald(boolean betaald) {
		this.betaald = betaald;
	}

	/**
	 * Deze methode overrides de Object.hashcode().
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datum == null) ? 0 : datum.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prijs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Deze methode overrides de Object.equals().
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boete other = (Boete) obj;
		if (datum == null) {
			if (other.datum != null)
				return false;
		} else if (!datum.equals(other.datum))
			return false;
		if (Double.doubleToLongBits(prijs) != Double.doubleToLongBits(other.prijs))
			return false;
		return true;
	}
}