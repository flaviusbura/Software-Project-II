package be.nmbs.logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Deze klasse wordt gebruikt om een abonnementobject aan te maken.
 * 
 * @author flaviusb
 *
 */
public class Abonnement {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int abonnementId;
	private Klant klant;
	private int gebruikerId;
	private String route;
	private Timestamp startDatum;
	private Timestamp eindDatum;
	private int prijsId2;
	private Prijs prijs;
	private Korting korting;
	private boolean actief;
	private int klant_contactId;
	
	private int kortingId;
	private Prijs_abonnement prijsId;
	/**
	 * Deze constructor wordt gebruikt om een abonnement aan te maken en de datamembers gelijk te stellen aan de waarden 
	 * op de databse.
	 * @param abonnementId
	 * @param klant
	 * @param gebruikerId
	 * @param route
	 * @param startDatum
	 * @param eindDatum
	 * @param prijs
	 * @param korting
	 * @param actief
	 */
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

	/**
	 * Deze constructor wordt gebruikt om een abonnement aan te maken en de datamembers gelijk te stellen aan de waarden 
	 * op de databse.
	 * @param abonnementId
	 * @param klant_contactId
	 * @param gebruikerId
	 * @param route
	 * @param startDatum
	 * @param eindDatum
	 * @param prijsId
	 * @param kortingId
	 * @param actief
	 */
	public Abonnement(int abonnementId, int klant_contactId, int gebruikerId, String route, Timestamp startDatum,
			Timestamp eindDatum, Prijs_abonnement prijsId, int kortingId, boolean actief) {
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

	/**
	 * Default constructor.
	 */
	public Abonnement() 
	{
		
	}
	
	
	/**
	 * Deze constructor wordt gebruikt om een nieuw abonnement aan te maken.
	 * @param klantId
	 * @param gebruikerId
	 * @param route
	 * @param eindDatum
	 * @param prijsId
	 * @param kortingId
	 * @param actief
	 */
	public Abonnement(int klantId, int gebruikerId, String route, Timestamp startDatum, int kortingId,
			boolean actief) {

		this.startDatum = startDatum;
		this.klant_contactId = klantId;
		this.gebruikerId = gebruikerId;
		this.route = route;
		this.kortingId = kortingId;
		this.actief = actief;
	}

	public Abonnement(int klantId, int gebruikerId, String route, Timestamp startDatum, int kortingId,
			Prijs_abonnement prijs_abonnement, boolean actief) {
		this.startDatum = startDatum;
		this.klant_contactId = klantId;
		this.gebruikerId = gebruikerId;
		this.route = route;
		this.kortingId = kortingId;
		this.actief = actief;
	}
	/**
	 * Deze constructor is noding om de getAll methode in AbonnementDAO te laten werken
	 * @param abonnementId
	 * @param klantContactId
	 * @param gebruikerId
	 * @param route
	 * @param startDatum
	 * @param eindDatum
	 * @param prijsId
	 * @param kortingId
	 * @param actief
	 */
	public Abonnement(int abonnementId, int klantContactId, int gebruikerId, String route, Timestamp startDatum,
			Timestamp eindDatum, int prijsId, int kortingId, boolean actief) {
		this.eindDatum = eindDatum;
		this.klant_contactId = klantContactId;
		this.gebruikerId = gebruikerId;
		this.kortingId = kortingId;
		this.actief = actief;
		this.abonnementId = abonnementId;
		this.route = route;
		this.startDatum = startDatum;
		this.prijsId2 = prijsId;
		this.actief = actief;
	}

	/**
	 * Deze methode gaat de startdatum terugsturen zonder de nanoseconden.
	 * @return Een Stringobject met datum en tijd zonder nanoseconden.
	 */
	public String getStartDatumWithoutNonoSec() {
		String currentDate = sdf.format(startDatum);
		return currentDate;
	}
	
	/**
	 * Deze methode gaat de einddatum terugsturen zonder de nanoseconden.
	 * @return Een Stringobject met datum en tijd zonder nanoseconden.
	 */
	public String getEindDatumWithoutNonoSec() {
		String currentDate = sdf.format(eindDatum);
		return currentDate;
	}

	/**
	 * Deze methode voegt drie maanden tijd toe aan het Timestampobject dat wordt megegeven.
	 * @param timestamp De tijd waaraan je 3 maanden tijd wilt toevoegen.
	 * @return Een Timestampobject dat drie maanden extra heeft gekregen.
	 */
	public Timestamp getTimestampDrieMaandAbonnemant(Timestamp timestamp) {
		System.out.println("1------1  "+timestamp);
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.MONTH, 3);
		cal.add(Calendar.SECOND, -1);
		timestamp = new Timestamp(cal.getTime().getTime());
		System.out.println("2------2  "+timestamp);
		return timestamp;
	}
	
	/**
	 * Deze methode voegt zes maanden tijd toe aan het Timestampobject dat wordt megegeven.
	 * @param timestamp De tijd waaraan je 6 maanden tijd wilt toevoegen.
	 * @return Een Timestampobject dat zes maanden extra heeft gekregen.
	 */
	public Timestamp getTimestampZesMaandAbonnemant(Timestamp timestamp) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.MONTH, 6);
		cal.add(Calendar.SECOND, -1);
		timestamp = new Timestamp(cal.getTime().getTime());
		
		return timestamp;
	}
	
	/**
	 * Deze methode voegt negen maanden tijd toe aan het Timestampobject dat wordt megegeven.
	 * @param timestamp De tijd waaraan je 9 maanden tijd wilt toevoegen.
	 * @return Een Timestampobject dat negen maanden extra heeft gekregen.
	 */
	public Timestamp getTimestampNegenMaandAbonnemant(Timestamp timestamp) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.MONTH, 9);
		cal.add(Calendar.SECOND, -1);
		timestamp = new Timestamp(cal.getTime().getTime());
		return timestamp;
	}

	/**
	 * Deze methode voegt een jaar tijd toe aan het Timestampobject dat wordt megegeven.
	 * @param timestamp De tijd waaraan je 1 jaar tijd wilt toevoegen.
	 * @return Een Timestampobject dat een jaar extra heeft gekregen.
	 */
	public Timestamp getTimestampJaarAbonnemant(Timestamp timestamp) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.SECOND, -1);
		timestamp = new Timestamp(cal.getTime().getTime());
		return timestamp;
	}

	public Prijs_abonnement getPrijsId() {
		return prijsId;
	}

	public void setPrijsId(Prijs_abonnement prijsId) {
		this.prijsId = prijsId;
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
	/*
	@Override
	public String toString() {
		return " " + abonnementId;
	}
	*/
	@Override
	public String toString() {
		return "Abonnement [sdf=" + sdf + ", abonnementId=" + abonnementId + ", klant=" + klant + ", gebruikerId="
				+ gebruikerId + ", route=" + route + ", startDatum=" + startDatum + ", eindDatum=" + eindDatum
				+ ", prijs=" + prijs + ", korting=" + korting + ", actief=" + actief + ", klant_contactId="
				+ klant_contactId + ", prijsId=" + prijsId + ", kortingId=" + kortingId + "]";
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
}