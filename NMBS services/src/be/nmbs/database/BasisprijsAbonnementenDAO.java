package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import be.nmbs.logic.Abonnement;

public class BasisprijsAbonnementenDAO extends BaseDAO{
	public int insertPrijs(String type,double prijs,boolean actief) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO basisprijsabonnementen VALUES(null,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setString(1, type);
			prep.setDouble(2, prijs);
			prep.setBoolean(3, actief);
			
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
	public int updateSetNietActiefById(int id) {
		PreparedStatement prep = null;
		String sql = "UPDATE basisprijsabonnementen SET actief=0 WHERE basisprijs_id=?";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, id);
			
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
	public int updateSetNietActiefByType(String type) {
		PreparedStatement prep = null;
		String sql = "UPDATE basisprijsabonnementen SET actief=0 WHERE abonnement_type=?";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setString(1, type);
			
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
	public int updateSetActief(int id) {
		PreparedStatement prep = null;
		String sql = "UPDATE basisprijsabonnementen SET actief=1 WHERE basisprijs_id=?";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, id);
			
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
