package be.nmbs.database;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import be.nmbs.logic.Station;
import be.nmbs.logic.Ticket;
/**
 * Deze klasse is een DAO. Hiermee kunnen er Ticket-objecten naar de de database 
 * geschreven, gevraagd, gewijzigd en verwijderd worden.
 * @author flaviusb
 *
 */
public class TicketDAO extends BaseDAO{
	SimpleDateFormat format = new SimpleDateFormat( "YYYY/MM/DD" );
	
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
			Station startStation = new Station();
			Station eindStation = new Station();
			Station station = new Station();
			
			while (res.next()) {
				int ticketId = res.getInt("ticket_id");
				startStation.setName(res.getString("start_station"));
				String soort = res.getString("soort");
				Date datum = res.getDate("datum");
				int klas = res.getInt("klas");
				boolean actief = res.getBoolean("actief");
				eindStation.setName(res.getString("eind_station"));
				String omschrijving = res.getString("omschrijving");
				int prijsId = res.getInt("prijs_id");
				int kortingId = res.getInt("korting_id");
				station.setName(res.getString("station"));
				
				Ticket ticket = new Ticket(ticketId, startStation, soort, datum, klas, actief, eindStation, omschrijving, prijsId, kortingId, station);
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
		String sql = "INSERT INTO ticket VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, ticket.getTicket_id());
			prep.setString(2, ticket.getStartStation().getName());
			prep.setString(3, ticket.getSoort());
			java.sql.Date sqlDate= new java.sql.Date(ticket.getDatum().getTime());
			prep.setDate(4, sqlDate);
			prep.setInt(5, ticket.getKlas());
			prep.setBoolean(6, ticket.isActief());
			prep.setString(7, ticket.getEindStation().getName());
			prep.setString(8, ticket.getOmschrijving());
			prep.setInt(9, ticket.getPrijsId());
			prep.setInt(10, ticket.getKortingId());
			prep.setString(11, ticket.getStation().getName());
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

