package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import be.nmbs.logic.Adres;
import be.nmbs.logic.Persoon;

public class PersoonDAO extends BaseDAO{

	
	/**
	 * Default constructor
	 */
	public PersoonDAO(){}
	
	/**
	 * Deze methode gaat een lijst terug sturen met alle data in mijn tabel klant_contact
	 * @return
	 */
	public ArrayList<Persoon> getAll() {
		ArrayList<Persoon> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM klant_contact";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<Persoon>();

			while (res.next()) {
				int persoonId = res.getInt("contact_id");
				String voornaam = res.getString("voornaam");
				String achternaam = res.getString("achternaam");
				String telefoonnr = res.getString("telefoon");
				boolean actief = res.getBoolean("actief");
				int adres_id = res.getInt("adres_id");
				 Persoon persoon = new Persoon(persoonId, voornaam, achternaam, adres, telefoonnr, actief);
				lijst.add((persoon));
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
	 * @param persoon
	 * @return
	 */
	public int insert(Persoon persoon) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO persoon_contact VALUES(?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, persoon.getId());
			prep.setString(2, persoon.getVoornaam());
			prep.setString(3, persoon.getAchternaam());
			prep.setInt(4, persoon.getAdres());
			prep.setString(5, persoon.getTelefoonnr());
			prep.setInt(6, persoon.isActief());
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
	 * Deze methode gaat een persoon verwijderen uit mijn databank
	 * @param persoon
	 * @return
	 */
	public int delete(Persoon persoon) {
		String sql = "DELETE klant_contact , persoon_adres FROM klant_contact INNER JOIN persoon_adres where klant_contact.adres_id = persoon_adres.adres_id and klant_contact.adres_id = ?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, persoon.getId());
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
