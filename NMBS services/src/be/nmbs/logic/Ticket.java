package be.nmbs.logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Deze klasse gaat gebruikt worden om Ticket-objecten aan te maken. 
 * @author flaviusb
 *
 */
public class Ticket {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int ticket_id;
	private StationNMBS startStation;
	private String soort;
	private Timestamp timestamp;
	private int klas;
	private boolean actief;
	private StationNMBS eindStation;
	private String omschrijving;
	private int prijsId;
	private int kortingId;
	private StationNMBS station; 
	private int gebruikerId;
	
	/**
	 * Default constructor.
	 */
	public Ticket() {}
	
	/**
	 * Deze constructor gaat een Ticket-object aanmaken met alle nodige parameters.
	 * @param ticket_id Het Id van het ticket.
	 * @param startStation Station waar de reiziger vertrekt
	 * @param soort Welk soort ticket is het: dagTicket, groepsTicket
	 * @param datum Datum van aankoop
	 * @param klas Welke klasse reist de klant
	 * @param actief is ticket nog actief/geldig
	 * @param eindStation Tot waar reist de klant
	 * @param omschrijving Omschrijving van het ticket
	 * @param prijsId Het prijsId om de prijs aan te duiden
	 * @param kortingId Het kortingId om aan te duiden hoeveel koring de klant krijgt
	 * @param station Waar is het ticket aangekocht?
	 * @param gebruikerId De gebruiker die een ticket aanmaakt
	 */
	public Ticket(int ticket_id, StationNMBS startStation, String soort, Timestamp timestamp, int klas, boolean actief,
			StationNMBS eindStation, String omschrijving, int kortingId, StationNMBS station, int gebruikerId) {
		super();
		this.ticket_id = ticket_id;
		this.startStation = startStation;
		this.soort = soort;
		this.timestamp = timestamp;
		this.klas = klas;
		this.actief = actief;
		this.eindStation = eindStation;
		this.omschrijving = omschrijving;
		this.kortingId = kortingId;
		this.station = station;
		this.gebruikerId = gebruikerId;
	}
	
	public Ticket(StationNMBS startStation, String soort, Timestamp timestamp, int klas, boolean actief,
			StationNMBS eindStation, String omschrijving,int kortingId, StationNMBS station, int gebruikerId) {
		this(0, startStation, soort, timestamp, klas, actief, eindStation, omschrijving, kortingId, station, gebruikerId);
	}
	
	
	public Ticket(int ticket_id, StationNMBS startStation, String soort, int klas, boolean actief,
			StationNMBS eindStation, String omschrijving, int prijsId, int kortingId, StationNMBS station, int gebruikerId) {
		super();
		this.ticket_id = ticket_id;
		this.startStation = startStation;
		this.soort = soort;
		this.klas = klas;
		this.actief = actief;
		this.eindStation = eindStation;
		this.omschrijving = omschrijving;
		this.prijsId = prijsId;
		this.kortingId = kortingId;
		this.station = station;
		this.gebruikerId = gebruikerId;
	}
	

	public int getGebruikerId() {
		return gebruikerId;
	}

	public void setGebruikerId(int gebruikerId) {
		this.gebruikerId = gebruikerId;
	}
	
	public Timestamp getTimestampNow() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		Timestamp timestamp = new Timestamp(now.getTime());
		return timestamp;
	}
	
	public String getTimestampWithoutNonoSec() {
		String currentDate = sdf.format(timestamp);
		return currentDate;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * Deze methode stuurt mijn ticketId terug.
	 * @return Een ticketID
	 */
	public int getTicket_id() {
		return ticket_id;
	}

	/**
	 * Deze methode sets het ticketId.
	 * @param ticket_id
	 */
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	/**
	 * Deze methode gaat een Station-object terugsturen, het startStation.
	 * @return Een Station-object
	 */
	public StationNMBS getStartStation() {
		return startStation;
	}

	/**
	 * Deze methode sets de startStation.
	 * @param startStation
	 */
	public void setStartStation(StationNMBS startStation) {
		this.startStation = startStation;
	}

	/**
	 * Deze methode gaat het soort ticket terugsturen.
	 * @return Een String-object
	 */ 
	public String getSoort() {
		return soort;
	}

	/**
	 * Deze methode sets het soort ticket.
	 * @param soort
	 */
	public void setSoort(String soort) {
		this.soort = soort;
	}

	/**
	 * Deze methode gaat de klasse waarbinnen de klant reist terugsturen.
	 * @return Een int om aan te duiden welke klasse
	 */
	public int getKlas() {
		return klas;
	}

	/**
	 * Deze methode sets de klas
	 * @param klas
	 */
	public void setKlas(int klas) {
		this.klas = klas;
	}

	/**
	 * Deze methode gaat een 1 terugsturen bij true en 0 bij false.
	 * @return Een int aan aan te duiden true of false
	 */
	public boolean isActief() {
		return actief;
	}

	/**
	 * Deze methode gaat een Station-object terugsturen, het eindStation.
	 * @return Een Station-object
	 */
	public StationNMBS getEindStation() {
		return eindStation;
	}

	/**
	 * Deze methode sets het eindStation.
	 * @param eindStation
	 */
	public void setEindStation(StationNMBS eindStation) {
		this.eindStation = eindStation;
	}

	/**
	 * Deze methode stuurt een String-object terug met de omschrijving van het ticket.
	 * @return Een String-object
	 */
	public String getOmschrijving() {
		return omschrijving;
	}

	/**
	 * Deze methode sets de omschrijving.
	 * @param omschrijving
	 */
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	/**
	 * Deze methode gaat de prijsId van het ticket terugsturen.
	 * @return Een int om aan te geven wat het prijsId is.
	 */
	public int getPrijsId() {
		return prijsId;
	}

	/**
	 * Deze methode sets de prijsId.
	 * @param prijsId
	 */
	public void setPrijsId(int prijsId) {
		this.prijsId = prijsId;
	}

	/**
	 * Deze methode stuurt een kortingId terug.
	 * @return Een int om aan te geven hoeveel korting de klant krijgt.
	 */
	public int getKortingId() {
		return kortingId;
	}

	/**
	 * Deze methode sets de kortingId.
	 * @param kortingId
	 */
	public void setKortingId(int kortingId) {
		this.kortingId = kortingId;
	}

	/**
	 * Deze methode gaat een Station-object terugsturen.
	 * @return Een Station-object om aan te geven waar het ticket aangekoscht is
	 */
	public StationNMBS getStation() {
		return station;
	}

	/**
	 * Deze methode sets het station.
	 * @param station
	 */
	public void setStation(StationNMBS station) {
		this.station = station;
	}
	
	/**
	 * Deze methode overrides de Object.hashcode() methode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + klas;
		result = prime * result + ((omschrijving == null) ? 0 : omschrijving.hashCode());
		result = prime * result + ((soort == null) ? 0 : soort.hashCode());
		return result;
	}

	/**
	 * Deze methode overrides de Object.equals() methode.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (klas != other.klas)
			return false;
		if (omschrijving == null) {
			if (other.omschrijving != null)
				return false;
		} else if (!omschrijving.equals(other.omschrijving))
			return false;
		if (soort == null) {
			if (other.soort != null)
				return false;
		} else if (!soort.equals(other.soort))
			return false;
		return true;
	}
}