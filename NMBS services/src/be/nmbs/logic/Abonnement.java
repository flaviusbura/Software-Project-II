package be.nmbs.logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Abonnement {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int abonnementId;
	private Klant klant;
	private int gebruikerId;
	private String route;
	private Timestamp startDatum;
	private Timestamp eindDatum;
	private Prijs prijs;
	private Korting korting;
	private boolean actief;

	public Abonnement() {
	}

	public Abonnement(int abonnementId, Klant klant, int gebruikerId, String route, Timestamp startDatum,
			Timestamp eindDatum, Prijs prijs, Korting korting, boolean actief) {
		super();
		this.abonnementId = abonnementId;
		this.klant = klant;
		this.gebruikerId = gebruikerId;
		this.route = route;
		this.startDatum = startDatum;
		this.eindDatum = eindDatum;
		this.prijs = prijs;
		this.korting = korting;
		this.actief = actief;
	}

	public Abonnement(int abonnementId, Klant klant, int gebruikerId, String route, Prijs prijs, Korting korting,
			boolean actief) {
		super();
		this.abonnementId = abonnementId;
		this.klant = klant;
		this.gebruikerId = gebruikerId;
		this.route = route;
		this.prijs = prijs;
		this.korting = korting;
		this.actief = actief;
	}

	public Timestamp getTimestampNow() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		Timestamp timestamp = new Timestamp(now.getTime());
		return timestamp;
	}

	public String getStartDatumWithoutNonoSec() {
		String currentDate = sdf.format(startDatum);
		return currentDate;
	}

	public String getEindDatumWithoutNonoSec() {
		String currentDate = sdf.format(eindDatum);
		return currentDate;
	}

	public Timestamp getTimestampDrieMaandAbonnemant() {
		Timestamp timestamp = getTimestampNow();
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.MONTH, 3);
		timestamp = new Timestamp(cal.getTime().getTime());
		return timestamp;
	}

	public Timestamp getTimestampZesMaandAbonnemant() {
		Timestamp timestamp = getTimestampNow();
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.MONTH, 6);
		timestamp = new Timestamp(cal.getTime().getTime());
		return timestamp;
	}

	public Timestamp getTimestampNegenMaandAbonnemant() {
		Timestamp timestamp = getTimestampNow();
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.MONTH, 9);
		timestamp = new Timestamp(cal.getTime().getTime());
		return timestamp;
	}

	public Timestamp getTimestampJaarAbonnemant() {
		Timestamp timestamp = getTimestampNow();
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.YEAR, 1);
		timestamp = new Timestamp(cal.getTime().getTime());
		return timestamp;
	}

	public Klant getKlant() {
		return klant;
	}

	public String getRoute() {
		return route;
	}

	public Korting getKorting() {
		return korting;
	}

	public boolean isActief() {
		return actief;
	}

	// Setters
	public void setKlant(Klant klant) {
		this.klant = klant;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public void setKorting(Korting korting) {
		this.korting = korting;
	}

	public void setActief(boolean actief) {
		this.actief = actief;
	}

	public int getAbonnementId() {
		return abonnementId;
	}

	public void setAbonnementId(int abonnementId) {
		this.abonnementId = abonnementId;
	}

	public int getGebruikerId() {
		return gebruikerId;
	}

	public void setGebruikerId(int gebruikerId) {
		this.gebruikerId = gebruikerId;
	}

	public Timestamp getStartDatum() {
		return startDatum;
	}

	public void setStartDatum(Timestamp startDatum) {
		this.startDatum = startDatum;
	}

	public Timestamp getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(Timestamp eindDatum) {
		this.eindDatum = eindDatum;
	}

	public Prijs getPrijs() {
		return prijs;
	}

	public void setPrijs(Prijs prijs) {
		this.prijs = prijs;
	}

	public int getKlantContactId() {
		return klant.getContactId();
	}

	public int getKortingID() {

		return korting.getId();
	}

	public int getPrijsId() {

		return prijs.getPrijsId();
	}
}