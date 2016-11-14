package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import be.nmbs.logic.VerlorenVoorwerp;

/**
 * Deze klasse is een DAO. Hiermee kunnen er Verlorenvoorwerpen-objecten naar de
 * de database geschreven, gevraagd, gewijzigd en verwijderd worden.
 * 
 * @author flaviusb
 *
 */
public class VerlorenVoorwerpenDAO extends BaseDAO {
	/**
	 * Default constructor.
	 */
	public VerlorenVoorwerpenDAO() {
	}

	/**
	 * Deze methode gaat alle rijen gaan opvragen in de tabel
	 * verloprenvoorwerpen.
	 * 
	 * @return Een ArrayList met alle Verlorenvoorwerpen-objecten
	 */
	public ArrayList<VerlorenVoorwerp> getAll() {
		ArrayList<VerlorenVoorwerp> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM verlorenvoorwerp";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<VerlorenVoorwerp>();

			while (res.next()) {
				int id = res.getInt("voorwerp_id");
				String station = res.getString("station");
				String omschrijving = res.getString("omschrijving");
				Date datum = res.getDate("datum");
				boolean actief = res.getBoolean("actief");

				VerlorenVoorwerp voorwerp = new VerlorenVoorwerp(id, station, omschrijving, datum, actief);
				lijst.add((voorwerp));
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
	 * Deze methode gaat een verlorenvoorwerp opzoek op basis van een id.
	 * 
	 * @param id
	 * @return Het verlopren voorwerp met dat bepaald id las het bestaat
	 */
	public VerlorenVoorwerp getById(int id) {
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM verlorenvoorwerpen WHERE ID = ?";
		try {
			if (getConnection().isClosed())
				throw new IllegalStateException("Unexpected error!");

			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, id);

			res = prep.executeQuery();

			String station = res.getString("station");
			String omschrijving = res.getString("omschrijving");
			Date datum = res.getDate("datum");
			boolean actief = res.getBoolean("actief");

			VerlorenVoorwerp voorwerp = new VerlorenVoorwerp(id, station, omschrijving, datum, actief);

			return voorwerp;
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
	 * Deze methode gaat een insert statement uitvoeren.
	 * 
	 * @param voorwerp
	 * @return Een int om aan te geven hoeveel rijen aangepast zijn
	 */
	public int insert(VerlorenVoorwerp voorwerp) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO verlorenvoorwerp VALUES(?,?,?,?,?)";

		try {
			if (getConnection().isClosed())
				throw new IllegalStateException("Unexpected error!");

			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, voorwerp.getId());
			prep.setString(2, voorwerp.getStation());
			prep.setString(3, voorwerp.getOmschrijving());
			prep.setDate(4, new java.sql.Date(voorwerp.getDatum().getTime()));
			prep.setBoolean(5, voorwerp.isActief());
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
	 * Deze methode gaat een Verlorenvoorwerp verwijderen op de database.
	 * 
	 * @param voorwerp
	 * @return Een int om aan te geven hoeveel rijen aangepast zijn
	 */
	public int delete(VerlorenVoorwerp voorwerp) {
		String sql = "DELETE FROM verlorenvoorwerpen WHERE voorwerp_id = ?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed())
				throw new IllegalStateException("Unexpected error!");

			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, voorwerp.getId());
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