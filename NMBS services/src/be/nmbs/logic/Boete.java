package be.nmbs.logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Deze klasse gaat gebruikt worden om Boete-objecten aan te maken.
 * 
 * @author flaviusb
 *
 */
public class Boete {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int boeteId;
	private int klantContactId;
	private double prijs;
	private Timestamp datum;
	private Timestamp betaalDatum;
	private boolean betaald;

	/**
	 * Default constructor.
	 */
	public Boete() {}

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
	
	public Boete(int boeteId, int klantContactId, double prijs, Timestamp datum, Timestamp betaalDatum,
			boolean betaald) {
		super();
		this.boeteId = boeteId;
		this.klantContactId = klantContactId;
		this.prijs = prijs;
		this.datum = datum;
		this.betaalDatum = betaalDatum;
		this.betaald = betaald;
	}

	/**
	 * Deze methode gaat het betaaldatum berekenen.
	 * @return Een Timestampobject dat de tijd van het aanmaken bevat plus 14 dagen.
	 */
	public Timestamp getTimestampBetaalDatum() {
		Timestamp timestamp = getTimestampNow();
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.DAY_OF_WEEK, 14);
		timestamp = new Timestamp(cal.getTime().getTime());
		return timestamp;
	}

	/**
	 * Deze methode wordt gebruikt om de tijd te bepalen om het moement dat deze methode wordt aangeroepen.
	 * @return Een Timestampobject dat de tijd zal bevatten om  het moment van het aanroepen van deze methode.
	 */
	public Timestamp getTimestampNow() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		Timestamp timestamp = new Timestamp(now.getTime());
		return timestamp;
	}

	/**
	 * Deze methode gaat de datum terugsturen zonder de nanoseconden.
	 * @return Een Stringobject met datum en tijd zonder nanoseconden.
	 */
	public String getDatumWithoutNonoSec() {
		String currentDate = sdf.format(datum);
		return currentDate;
	}

	/**
	 * Deze methode gaat de betaaldatum terugsturen zonder de nanoseconden.
	 * @return Een Stringobject met datum en tijd zonder nanoseconden.
	 */
	public String getBetaalDatumWithoutNonoSec() {
		String currentDate = sdf.format(betaalDatum);
		return currentDate;
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
	 * Deze methode gaat terugsturen of een bepaalde boete betaald of niet
	 * betaald is.
	 * 
	 * @return Een boolean.
	 */
	public boolean isBetaald() {
		return betaald;
	}

	public Timestamp getDatum() {
		return datum;
	}

	public void setDatum(Timestamp datum) {
		this.datum = datum;
	}

	public Timestamp getBetaalDatum() {
		return betaalDatum;
	}

	public void setBetaalDatum(Timestamp betaalDatum) {
		this.betaalDatum = betaalDatum;
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