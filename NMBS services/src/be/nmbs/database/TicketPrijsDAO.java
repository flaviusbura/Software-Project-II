package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import be.nmbs.logic.Klant;
import be.nmbs.logic.Prijs_ticket;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;
import be.nmbs.logic.TypeAbonnement;

public class TicketPrijsDAO extends BaseDAO{
	
	
	public int insert(Prijs_ticket pt) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO prijs_ticket VALUES(null,?,?,?,?)";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prep.setInt(1, pt.getType_ticketid());
			prep.setInt(2,pt.getCoefficient_ticketid());
			prep.setInt(3, pt.getBasisprijs_ticketid());
			prep.setDouble(4, pt.getTotaal());
			
			prep.executeUpdate();
			 ResultSet rs = prep.getGeneratedKeys();
			 int last_inserted_id = 0;
             if(rs.next())
             {
                 last_inserted_id = rs.getInt(1);
             }
			return last_inserted_id;
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
	
	public Prijs_ticket getPrijs_ticketObjectOpPrijs_ticketId(int id) {
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM prijs_ticket where prijs_ticketid = ?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1,id);
			res = prep.executeQuery();
			
				int prijs_ticketid = res.getInt("prijs_ticketid");
				int type_ticketid = res.getInt("type_ticketid");
				int coefficient_ticketid = res.getInt("coefficient_ticketid");
				int basisprijs_ticketid = res.getInt("basisprijs_ticketid");
				double totaal = res.getDouble("totaal");
				
				Prijs_ticket prijs_ticket = new Prijs_ticket(prijs_ticketid,type_ticketid,coefficient_ticketid,basisprijs_ticketid,totaal);
			
			
			return prijs_ticket;
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

	public Prijs_ticket getPrijs_ticketObjectOpPrijs_ticketIdOFFLINE(int id) {
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM prijs_ticket where prijs_ticketid = ?";
		try {
			if (DatabaseSingleton.getDatabaseSingleton().getLocalConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			
			prep = DatabaseSingleton.getDatabaseSingleton().getLocalConnection().prepareStatement(sql);
			prep.setInt(1,id);
			res = prep.executeQuery();
			
				int prijs_ticketid = res.getInt("prijs_ticketid");
				int type_ticketid = res.getInt("type_ticketid");
				int coefficient_ticketid = res.getInt("coefficient_ticketid");
				int basisprijs_ticketid = res.getInt("basisprijs_ticketid");
				double totaal = res.getDouble("totaal");
				
				Prijs_ticket prijs_ticket = new Prijs_ticket(prijs_ticketid,type_ticketid,coefficient_ticketid,basisprijs_ticketid,totaal);
			
			
			return prijs_ticket;
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
	
	public ArrayList<Prijs_ticket> getAllForDatabase() {
		ArrayList<Prijs_ticket> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM prijs_ticket";
		try {
			if (DatabaseSingleton.getDatabaseSingleton().getLocalConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			
			prep = DatabaseSingleton.getDatabaseSingleton().getLocalConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<Prijs_ticket>();
			
			while (res.next()) {
				int prijs_ticketid = res.getInt("prijs_ticketid");
				int type_ticketid = res.getInt("type_ticketid");
				int coefficient_ticketid = res.getInt("coefficient_ticketid");
				int basisprijs_ticketid = res.getInt("basisprijs_ticketid");
				double totaal = res.getDouble("totaal");
				System.out.println(totaal);
				Prijs_ticket prijs_ticket = new Prijs_ticket(prijs_ticketid,type_ticketid,coefficient_ticketid,basisprijs_ticketid,totaal);
			
				lijst.add(prijs_ticket);
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
	
	public int deleteAlles() {
		String sql = "DELETE from prijs_ticket";
		PreparedStatement prep = null;
		try {
			if (DatabaseSingleton.getDatabaseSingleton().getLocalConnection().isClosed())
				throw new IllegalStateException("Unexpected error!");

			prep = DatabaseSingleton.getDatabaseSingleton().getLocalConnection().prepareStatement(sql);
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
