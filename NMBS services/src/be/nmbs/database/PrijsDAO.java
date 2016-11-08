package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.nmbs.logic.Prijs;

public class PrijsDAO extends BaseDAO {

	public PrijsDAO(){}
	
 ArrayList<Prijs> getAll() {
		ArrayList<Prijs> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM Prijs";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<Prijs>();

			while (res.next()) {
				int prijs_id = res.getInt("prijs_id");
				String omschrijving= res.getString("omschrijving");
				int prijs = res.getInt("prijs");
				String type = res.getString("type");
				boolean actief = res.getBoolean("actief");
				
				Prijs p = new Prijs(prijs_id,omschrijving, prijs, type, actief);
				lijst.add((p));
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
	 * Deze methode gaat een insert statement uitvoeren
	 * @param gebruiker
	 * @return
	 */
	public int insert(Prijs prijs) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO prijs VALUES(?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, prijs.getPrijs_id());
			prep.setString(2, prijs.getOmschrijving());
			prep.setInt(3, prijs.getPrijs());
			prep.setString(4, prijs.getType());
			prep.setBoolean(5, prijs.getActief());
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
	
	/**
	 * Deze methode gaat een gebruiker verwijderen uit mijn databank
	 * @param gebruiker
	 * @return
	 */
	public int delete(Prijs prijs) {
		String sql = "DELETE FROM Prijs WHERE prijs_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, prijs.getPrijs_id());
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
