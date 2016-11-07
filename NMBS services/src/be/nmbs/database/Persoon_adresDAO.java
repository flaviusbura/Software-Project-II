package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.nmbs.logic.Gebruiker;

public class Persoon_adresDAO extends BaseDAO {
	/**
	 * Default constructor
	 */
	public Persoon_adresDAO(){}
	
	/**
	 * @return
	 */
	public Adres getAdres(int adres_id) {
		Adres adres=null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM klant_adres where adres_id=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			sql.setInt(1,adres_id);
			res = prep.executeQuery();
			lijst = new ArrayList<Gebruiker>();

			while (res.next()) {
				String straat=res.getString("straat");
				int huisnummer=res.getInt("nr");
				int postcode=res.getInt("postcode");
				String bus=res.getString("bus");
				String woonplaats=res.getString("stad");
				int adresId=res.getInt("adres_id");
				String land=res.getString("land");
				boolean actief=res.getInt("actief");
				
				Adres adres=new Adres(straat,huisnummer,postcode,bus,woonplaats,adresId,land,actief);
				
			}
			return adres;
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
	public int insert(Adres adres) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO klant_adres VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, adres.getId());
			prep.setString(2, adres.getLand());
			prep.setString(3, adres.getWoonplaats());
			prep.setInt(4, adres.getPostcode());
			prep.setString(5, adres.getStraat());
			prep.setInt(6, adres.getHuisnummer());
			prep.setString(7,adres.getBus());
			prep.setInt(8,adres.getActief());
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
	 * Deze methode gaat een adres verwijderen
	 * @param adres
	 * @return
	 */
	public int delete(Adres adres) {
		String sql = "DELETE FROM klant_adres WHERE adres_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, adres.getId());
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
	
	public int update(Adres adres){
		String sql = "UPDATE klant_adres SET actief=0 WHERE adres_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, adres.getId());
			prep.executeUpdate();
			PreparedStatement prep = null;
			String sql = "INSERT INTO klant_adres VALUES(?,?,?,?,?,?,?,?)";
			
			try {
				if (getConnection().isClosed()) {
					throw new IllegalStateException("Unexpected error!");
				}
				prep = getConnection().prepareStatement(sql);
				
				prep.setInt(1, adres.getId());
				prep.setString(2, adres.getLand());
				prep.setString(3, adres.getWoonplaats());
				prep.setInt(4, adres.getPostcode());
				prep.setString(5, adres.getStraat());
				prep.setInt(6, adres.getHuisnummer());
				prep.setString(7,adres.getBus());
				prep.setInt(8,adres.getActief());
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
