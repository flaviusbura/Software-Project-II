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
	
	public ArrayList<Klant> getAllByAchternaam(String naam) {
		ArrayList<Klant> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM klant_contact where naam = ?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setString(1, naam);
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
	 * Deze methode gaat alle gegevens terugvinden via een voornaam
	 * @author Abdel
	 * @param naam
	 * @return
	 */
	public ArrayList<Klant> getAllByVoornaam(String voornaam) {
		ArrayList<Klant> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM klant_contact where voornaam = ?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setString(1, voornaam);
			res = prep.executeQuery();
			lijst = new ArrayList<Klant>();

			while (res.next()) {
				int contactId = res.getInt("contact_id");
				String voornaam2 = res.getString("voornaam");
				String achternaam = res.getString("naam");
				int adresId = res.getInt("adres_id");
				String telefoon = res.getString("telefoon");
				boolean actief = res.getBoolean("actief");
				
				Klant klant = new Klant(contactId, voornaam2, achternaam, adresId, telefoon, actief);
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
	
	public ArrayList<Klant> getAllByContact_Id(int contact_Id) {
		ArrayList<Klant> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM klant_contact where contact_Id = ?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, contact_Id);
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
		String sql = "INSERT INTO klant_contact VALUES(null,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setString(1, klant.getVoornaam());
			prep.setString(2, klant.getAchternaam());
			prep.setInt(3, klant.getAdresId());
			prep.setString(4, klant.getTelefoon());
			prep.setBoolean(5, klant.isActief());
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
	
	/**
	 * Deze methode gaat een KlantObject terug sturen op naam en voornaam
	 */
	public Klant getKlantOpNaamEnVoornaam(Klant klant) {
		Klant klant2 = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM klant_contact WHERE voornaam=? AND naam=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setString(1, klant.getVoornaam());
			prep.setString(2, klant.getAchternaam());
			res = prep.executeQuery();
			
			while (res.next()) {
				int contactId = res.getInt("contact_id");
				String voornaam = res.getString("voornaam");
				String achternaam = res.getString("naam");
				int adresId = res.getInt("adres_id");
				String telefoon = res.getString("telefoon");
				boolean actief = res.getBoolean("actief");
				
				klant2 = new Klant(contactId, voornaam, achternaam, adresId, telefoon, actief);
			}
			return klant2;
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
	 * Deze methode gaat een klant opzoeken op basis van KlantId
	 * @param KlantContactId
	 * @return Een Klant-object
	 */
	public Klant getKlantById(int KlantContactId) {
		Klant klant = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM klant_contact WHERE contact_id=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, KlantContactId);
			res = prep.executeQuery();
			
			while (res.next()) {
				int contactId = res.getInt("contact_id");
				String voornaam = res.getString("voornaam");
				String achternaam = res.getString("naam");
				int adresId = res.getInt("adres_id");
				String telefoon = res.getString("telefoon");
				boolean actief = res.getBoolean("actief");
				
				klant = new Klant(contactId, voornaam, achternaam, adresId, telefoon, actief);
			}
			return klant;
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
	
	public int getAdresIdOpNaamEnVoornaam(String voornaam, String naam) {
		PreparedStatement prep = null;
		ResultSet res = null;
		int adresId = 0;
		String sql = "SELECT adres_id FROM klant_contact WHERE voornaam = ? AND naam = ?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setString(1, voornaam);
			prep.setString(2, naam);
			res = prep.executeQuery();
			while (res.next()) {
				adresId = res.getInt("adres_id");
			}
			return adresId;
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
	
	public int getContactIdOpNaamEnVoornaam(String voornaam, String naam) {
		PreparedStatement prep = null;
		ResultSet res = null;
		int contactId = 0;
		String sql = "SELECT contact_id FROM klant_contact WHERE voornaam = ? AND naam = ?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setString(1, voornaam);
			prep.setString(2, naam);
			res = prep.executeQuery();
			while (res.next()) {
				contactId = res.getInt("contact_id");
			}
			return contactId;
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
	
	public int updateVoornaamByContactId(int contactID, String voornaam) {
        String sql = "UPDATE klant_contact SET voornaam = ? WHERE contact_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setString(1, voornaam);
            prep.setInt(2, contactID);
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
	
	public int updateAchternaamByContactId(int contactID, String voornaam) {
        String sql = "UPDATE klant_contact SET naam = ? WHERE contact_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setString(1, voornaam);
            prep.setInt(2, contactID);
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
	
	public int updateTelefoonByContactId(int contactID, String telefoon) {
        String sql = "UPDATE klant_contact SET telefoon = ? WHERE contact_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setString(1, telefoon);
            prep.setInt(2, contactID);
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

