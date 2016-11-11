package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.nmbs.logic.Gebruiker;

public class GebruikerDAO extends BaseDAO {
	/**
	 * Default constructor
	 */
	public GebruikerDAO(){}
	
	/**
	 * Deze methode gaat een lijst terug sturen met alle data in mijn tabel gebruiker
	 * @return
	 */
	public ArrayList<Gebruiker> getAll() {
		ArrayList<Gebruiker> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM gebruiker";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<Gebruiker>();

			while (res.next()) {
				int gebruikerId = res.getInt("gebruiker_id");
				String voornaam = res.getString("voornaam");
				String achternaam = res.getString("achternaam");
				String wachtwoord = res.getString("paswoord");
				int rol = res.getInt("rol");
				boolean actief = res.getBoolean("actief");
				
				Gebruiker gebruiker = new Gebruiker(gebruikerId, voornaam, achternaam, wachtwoord, rol, actief);
				lijst.add((gebruiker));
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
	public int insert(Gebruiker gebruiker) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO gebruiker VALUES(?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, gebruiker.getId());
			prep.setString(2, gebruiker.getVoornaam());
			prep.setString(3, gebruiker.getAchternaam());
			prep.setString(4, gebruiker.getWachtwoord());
			prep.setInt(5, gebruiker.getRol());
			prep.setInt(6, gebruiker.isActief());
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
	public int delete(Gebruiker gebruiker) {
		String sql = "DELETE FROM gebruiker WHERE gebruiker_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, gebruiker.getId());
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
	 * Door gebruik te maken van deze methde kan het wachtwoord van een gebruiker veranderd worden
	 * @param gebruiker
	 * @return
	 */
	public int updateWachtwoordById(Gebruiker gebruiker) {
        String sql = "UPDATE gebruiker SET paswoord=? WHERE gebruiker_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setString(1, gebruiker.getWachtwoord());
            prep.setInt(2, gebruiker.getId());
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
	 * Deze methode gaat een GebruikerObject terug sturen op naam en voornaam
	 */
	public Gebruiker getGebruikerOpNaamEnVoornaam(Gebruiker gebruiker) {
		Gebruiker gebruiker2 = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM gebruiker WHERE voornaam=? AND achternaam=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setString(1, gebruiker.getVoornaam());
			prep.setString(2, gebruiker.getAchternaam());
			res = prep.executeQuery();
			
			while (res.next()) {
				int gebruikerId = res.getInt("gebruiker_id");
				String voornaam = res.getString("voornaam");
				String achternaam = res.getString("achternaam");
				String wachtwoord = res.getString("paswoord");
				int rol = res.getInt("rol");
				boolean actief = res.getBoolean("actief");
				
				gebruiker2 = new Gebruiker(gebruikerId, voornaam, achternaam, wachtwoord, rol, actief);
			}
			return gebruiker2;
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
