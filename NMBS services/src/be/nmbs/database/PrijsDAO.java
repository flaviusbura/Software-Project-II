package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import be.nmbs.logic.Prijs;

/**
 * Deze klasse is een DAO. Hiermee kunnen er Prijs-objecten naar de de database
 * geschreven, gevraagd en verwijderd worden.
 * 
 * @author flaviusb
 *
 */
public class PrijsDAO extends BaseDAO {

	/**
	 * Default constructor.
	 */
	public PrijsDAO() {
	}

	/**
	 * Deze methode gaat aan de database alle gegevens vragen inde tabel prijs.
	 * 
	 * @return Een ArrayList met alle Prijs-objecten in de tabel prijs
	 */
	public ArrayList<Prijs> getAll() {
		ArrayList<Prijs> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM prijs";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<Prijs>();

			while (res.next()) {
				int prijs_id = res.getInt("prijs_id");
				String omschrijving = res.getString("omschrijving");
				double prijs = res.getDouble("prijs");
				String type = res.getString("type");
				boolean actief = res.getBoolean("actief");

				Prijs p = new Prijs(prijs_id, omschrijving, prijs, type, actief);
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
	 * 
	 * @param prijs
	 * @return Een int om aan te geven hoeveel rijen zijn aangepast
	 */
	public int insert(Prijs prijs) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO prijs VALUES(?,?,?,?,?)";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, prijs.getPrijsId());
			prep.setString(2, prijs.getOmschrijving());
			prep.setDouble(3, prijs.getPrijs());
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
	 * Deze methode gaat een prijs verwijderen uit mijn databank
	 * 
	 * @param prijs
	 * @return Een int om aan te geven hoeveel rijen zijn aangepast
	 */
	public int delete(Prijs prijs) {
		String sql = "DELETE FROM prijs WHERE prijs_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, prijs.getPrijsId());
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
	 * Deze methode gaat de prijs gaan zoeken op prijsId
	 * 
	 * @param prijsId
	 * @return Een Prijs-object
	 */
	public Prijs getPrijsByPrijsId(int prijsId) {
		Prijs prijsObject = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM prijs WHERE prijs_id=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, prijsId);
			res = prep.executeQuery();

			while (res.next()) {
				int prijs_id = res.getInt("prijs_id");
				String omschrijving = res.getString("omschrijving");
				double prijs = res.getDouble("prijs");
				String type = res.getString("type");
				boolean actief = res.getBoolean("actief");

				prijsObject = new Prijs(prijs_id, omschrijving, prijs, type, actief);
			}
			return prijsObject;
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
}
