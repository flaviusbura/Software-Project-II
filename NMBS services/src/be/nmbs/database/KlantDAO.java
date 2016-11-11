package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.nmbs.logic.Klant;

public class KlantDAO extends BaseDAO {
	/**
	 * Default constructor
	 */
	public KlantDAO() {}
	
	/**
	 * Deze methode gaat een lijst terug sturen met alle data in mijn tabel klant_contact
	 * @return
	 */
	public ArrayList<Klant> getAll() {
		ArrayList<Klant> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM klant_contact";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<Klant>();

			while (res.next()) {
				int contactId = res.getInt("contact_id");
				String voornaam = res.getString("voornaam");
				String achternaam = res.getString("naam");
				int adresId = res.getInt("adres_id");
				String telefoon = res.getString("telefoon");
				boolean actief = res.getBoolean("actief");
				
				Klant klant = new Klant(contactId, voornaam, achternaam, adresId, telefoon, actief);
				lijst.add((klant));
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
	 * @param klant
	 * @return
	 */
	public int insert(Klant klant) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO klant_contact VALUES(?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, klant.getContactId());
			prep.setString(2, klant.getVoornaam());
			prep.setString(3, klant.getAchternaam());
			prep.setInt(4, klant.getAdresId());
			prep.setString(5, klant.getTelefoon());
			prep.setInt(6, klant.isActief());
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
	 * Deze methode gaat een klant verwijderen uit mijn databank
	 * @param klant
	 * @return
	 */
	public int delete(Klant klant) {
		String sql = "DELETE FROM klant_contact WHERE contact_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, klant.getContactId());
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
	 * Door gebruik te maken van deze methde kan het telefoonnummer van een klant veranderd worden
	 * @param klant
	 * @return
	 */
	public int updateTelefoonByContactId(Klant klant) {
        String sql = "UPDATE klant_contact SET telefoon=? WHERE contact_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setString(1, klant.getTelefoon());
            prep.setInt(2, klant.getContactId());
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
