package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import be.nmbs.logic.Station;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;
/**
 * Deze klasse is een DAO. Hiermee kunnen er Ticket-objecten naar de de database 
 * geschreven, gevraagd, gewijzigd en verwijderd worden.
 * @author flaviusb
 *
 */
public class TicketDAO extends BaseDAO{
	/**
	 * Default constructor.
	 */
	public TicketDAO() {}
	
	/**
	 * Deze methode gaat een lijst terug sturen met alle data in mijn tabel ticket
	 * @return Een ArrayList van Ticket-Objecten
	 */
	public ArrayList<Ticket> getAll() {
		ArrayList<Ticket> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM ticket";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<Ticket>();
			StationNMBS startStation = new StationNMBS();
			StationNMBS eindStation = new StationNMBS();
			StationNMBS station = new StationNMBS();
			
			while (res.next()) {
				int ticketId = res.getInt("ticket_id");
				startStation.setNaam(res.getString("start_station"));
				String soort = res.getString("soort");
				Timestamp timestamp = res.getTimestamp("datum");
				int klas = res.getInt("klas");
				boolean actief = res.getBoolean("actief");
				eindStation.setNaam(res.getString("eind_station"));
				String omschrijving = res.getString("omschrijving");
				int prijsId = res.getInt("prijs_id");
				int kortingId = res.getInt("korting_id");
				station.setNaam(res.getString("station"));
				int gebrukerId = res.getInt("gebruiker_id");
				Ticket ticket = new Ticket(ticketId, startStation, soort, timestamp, klas, actief, eindStation, omschrijving,
						prijsId, kortingId, station, gebrukerId);
				lijst.add(ticket);
			}
			return lijst;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (prep != null)
					prep.close();
				if (res != null)
					res.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException("Unexpected error!");
			}
		}
	}
	
	/**
	 * Deze methode gaat een Ticket-object naar de database doorsturen.
	 * @param ticket
	 * @return Een int om aan te geven dat het succesvol is
	 */
	public int insert(Ticket ticket) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO ticket VALUES(null,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setString(1, ticket.getStartStation().getNaam());
			prep.setString(2, ticket.getSoort());
			prep.setTimestamp(3, ticket.getTimestamp());
			prep.setInt(4, ticket.getKlas());
			prep.setBoolean(5, ticket.isActief());
			prep.setString(6, ticket.getEindStation().getNaam());
			prep.setString(7, ticket.getOmschrijving());
			prep.setInt(8, ticket.getPrijsId());
			prep.setInt(9, ticket.getKortingId());
			prep.setString(10, ticket.getStation().getNaam());
			prep.setInt(11, ticket.getGebruikerId());
			return prep.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (prep != null)
					prep.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException("Unexpected error!");
			}
		}
	}
}