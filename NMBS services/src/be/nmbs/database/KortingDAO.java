package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.nmbs.logic.Adres;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Korting;

public class KortingDAO extends BaseDAO {
	/**
	 * Default constructor
	 */
	public KortingDAO(){}
	
	/**
	 * @return
	 */
	public Korting getKorting(int korting_id) {
		
		Korting korting =null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM korting where korting_id=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1,korting_id);
			res = prep.executeQuery();
			
			while (res.next()) {
				int korting_id2=res.getInt("korting_id");
				double hoeveelheid=res.getDouble("hoeveelheid");
				String omschrijving=res.getString("omschrijving");
				boolean actief=res.getBoolean("actief");
				String typeKorting=res.getString("typeKorting");
				 korting=new Korting(korting_id2,hoeveelheid,omschrijving,actief,typeKorting);
				
			}
			return korting;
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
	public int insert(Korting korting) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO korting VALUES(?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, korting.getId());
			prep.setDouble(2,korting.getHoeveelheid());
			prep.setString(3, korting.getOmschrijving());
			prep.setBoolean(4, korting.getActief());
			prep.setString(5, korting.getTypeKorting());
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
	 * Deze methode gaat een korting verwijderen
	 * @param adres
	 * @return
	 */
	public int delete(Korting korting) {
		String sql = "UPDATE korting SET actief=0 WHERE korting_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1,korting.getId());
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
	
	public int update(Korting korting){
		String sql = "UPDATE korting SET actief=0 WHERE korting_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, korting.getId());
			prep.executeUpdate();
			PreparedStatement prep2 = null;
			String sql2 = "INSERT INTO korting VALUES(?,?,?,?,?)";
			
			try {
				if (getConnection().isClosed()) {
					throw new IllegalStateException("Unexpected error!");
				}
				prep2 = getConnection().prepareStatement(sql2);
				
				prep2.setInt(1, korting.getId());
				prep2.setDouble(2,korting.getHoeveelheid());
				prep2.setString(3, korting.getOmschrijving());
				prep2.setBoolean(4, korting.getActief());
				prep2.setString(5, korting.getTypeKorting());
				return prep2.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				throw new RuntimeException(e.getMessage());
			} finally {
				try {
					if (prep2 != null)
						prep2.close();

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
