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
	private int klant_contactId;
	private int prijsId;
	private int kortingId;

	public Abonnement(Object object) {
	}

	public Abonnement(int klant_contactId, int gebruikerId, String route,Timestamp startDatum,
			Timestamp eindDatum, int prijsId, int kortingId,
			boolean actief) {
		super();
		this.startDatum = startDatum;
		this.eindDatum = eindDatum;
		this.klant_contactId = klant_contactId;
		this.gebruikerId = gebruikerId;
		this.route = route;
		this.prijsId = prijsId;
		this.kortingId = kortingId;
		this.actief = actief;
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

	public Abonnement(int abonnementId, int klant_contactId, int gebruikerId, String route, Timestamp startDatum,
			Timestamp eindDatum, int prijsId, int kortingId, boolean actief) {
		super();
		this.abonnementId = abonnementId;
		this.klant_contactId = klant_contactId;
		this.gebruikerId = gebruikerId;
		this.route = route;
		this.startDatum = startDatum;
		this.eindDatum = eindDatum;
		this.prijsId = prijsId;
		this.kortingId = kortingId;
		this.actief = actief;
	}
	public Abonnement(Klant klant, int gebruikerId, String route, Timestamp startDatum, Timestamp eindDatum,
			Prijs prijs, Korting korting, boolean actief) {
		super();
		
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


	public Abonnement() {
		// TODO Auto-generated constructor stub
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

	public Timestamp getTimestampDrieMaandAbonnemant(Timestamp timestamp) {
		/*
		java.sql.Timestamp ts = ...
				Calendar cal = Calendar.getInstance();
				cal.setTime(ts);
				cal.add(Calendar.DAY_OF_WEEK, 14);
				ts.setTime(cal.getTime().getTime()); // or
				ts = new Timestamp(cal.getTime().getTime());
		*/
		//Timestamp timestamp = AbonnementDAO.getEindDatum(abonnement);
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.MONTH, 3);
		cal.add(Calendar.SECOND, -1);
		timestamp = new Timestamp(cal.getTime().getTime());
		return timestamp;
	}

	public Timestamp getTimestampZesMaandAbonnemant(Timestamp timestamp) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.MONTH, 6);
		cal.add(Calendar.SECOND, -1);
		timestamp = new Timestamp(cal.getTime().getTime());
		return timestamp;
	}

	public Timestamp getTimestampNegenMaandAbonnemant(Timestamp timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.MONTH, 9);
		cal.add(Calendar.SECOND, -1);
		timestamp = new Timestamp(cal.getTime().getTime());
		return timestamp;
	}

	public Timestamp getTimestampJaarAbonnemant(Timestamp timestamp) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.SECOND, -1);
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

	
	@Override
	public String toString() {
		return " " + abonnementId;
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

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public int getKlant_contactId() {
		return klant_contactId;
	}

	public void setKlant_contactId(int klant_contactId) {
		this.klant_contactId = klant_contactId;
	}

	public int getKortingId() {
		return kortingId;
	}

	public void setKortingId(int kortingId) {
		this.kortingId = kortingId;
	}

	public void setPrijsId(int prijsId) {
		this.prijsId = prijsId;
	}

	public int getPrijsId() {

		return prijsId;
	}
	
}