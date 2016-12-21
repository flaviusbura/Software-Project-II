package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import be.nmbs.logic.Prijs_ticket;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;
import be.nmbs.userInterface.View;

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
			Prijs_ticket prijsticket = new Prijs_ticket();
			TicketPrijsDAO tpdao = new TicketPrijsDAO();
			
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
				prijsticket = tpdao.getPrijs_ticketObjectOpPrijs_ticketId(prijsId);
				int kortingId = res.getInt("korting_id");
				station.setNaam(res.getString("station"));
				int gebrukerId = res.getInt("gebruiker_id");
				Ticket ticket = new Ticket(ticketId, startStation, soort, timestamp, klas, actief, eindStation, omschrijving,prijsticket,
						kortingId, station, gebrukerId);
			
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
			if(View.getIngelogdGebruiker().getUsername().equals("offline"))
			{
		
				Long datumLong = ticket.getTimestamp().getTime();
				Timestamp timestamp = new Timestamp(datumLong);
				System.out.println("datum timestamp insert dao " + timestamp);
				String S = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(timestamp);
				System.out.println(S);
				prep.setString(3, S);
			}
			else
			{
			prep.setTimestamp(3, ticket.getTimestampNow());
			}
			prep.setInt(4, ticket.getKlas());
			prep.setBoolean(5, ticket.isActief());
			prep.setString(6, ticket.getEindStation().getNaam());
			prep.setString(7, ticket.getOmschrijving());
			prep.setInt(8, ticket.getPrijsId().getPrijs_ticketid());
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