package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import be.nmbs.logic.Boete;

/**
 * Deze klasse is een DAO. Hiermee kunnen er Boete-objecten naar de de database
 * geschreven, gevraagd, gewijzigd en verwijderd worden.
 * 
 * @author flaviusb
 *
 */
public class BoeteDAO extends BaseDAO {
	SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/DD");

	/**
	 * Default constructor.
	 */
	public BoeteDAO() {
	}

	/**
	 * Deze methode gaat een lijst terug sturen met alle data in mijn tabel
	 * boeten
	 * 
	 * @return Een ArrayList van Boete-Objecten
	 */
	public ArrayList<Boete> getAll() {
		ArrayList<Boete> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM boeten";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<Boete>();

			while (res.next()) {
				int boeteId = res.getInt("boeten_id");
				int klantContactId = res.getInt("klant_contact_id");
				double prijs = res.getDouble("prijs");
				Date datum = res.getDate("datum");
				Date betaalDatum = res.getDate("betaal_datum");
				boolean betaald = res.getBoolean("betaald");

				Boete boete = new Boete(boeteId, klantContactId, prijs, datum, betaalDatum, betaald);
				lijst.add(boete);
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
	 * Deze methode gaat een Boete-object naar de database schrijven.
	 * 
	 * @param boete
	 * @return Een int om aan te geven hoeveel rijen aangepast zijn.
	 */
	public int insert(Boete boete) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO boeten VALUES(?,?,?,?,?,?)";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, boete.getBoeteId());
			prep.setInt(2, boete.getKlantContactId());
			prep.setDouble(3, boete.getPrijs());
			java.sql.Date sqlDate = new java.sql.Date(boete.getDatum().getTime());
			prep.setDate(4, sqlDate);
			sqlDate = new java.sql.Date(boete.getBetaalDatum().getTime());
			prep.setDate(5, sqlDate);
			prep.setBoolean(6, boete.isBetaald());
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
	 * Deze methode gaat de betaald status in de tabel boeten wijzigen.
	 * 
	 * @param klantId
	 * @return Een int om aan te geven hoeveel rijen aangepast zijn.
	 */
	public int updateBetaaldByKlantId(Boete boete) {
		String sql = "UPDATE boeten SET betaald=? WHERE boeten_id=? AND klant_contact_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setBoolean(1, boete.isBetaald());
			prep.setInt(2, boete.getBoeteId());
			prep.setInt(3, boete.getKlantContactId());
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
