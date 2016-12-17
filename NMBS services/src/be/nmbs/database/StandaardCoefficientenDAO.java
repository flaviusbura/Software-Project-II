package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StandaardCoefficientenDAO extends BaseDAO{
	public int insertCoefficient(String omschrijving,double coefficient,boolean actief) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO standaardCoefficient VALUES(null,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setString(1, omschrijving);
			prep.setDouble(2, coefficient);
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
		String sql = "UPDATE standaardCoefficient SET actief=0 WHERE id=?";
		
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
	public int updateSetNietActiefByOmschrijving(String omschrijving) {
		PreparedStatement prep = null;
		String sql = "UPDATE standaardCoefficient SET actief=0 WHERE omschrijving=?";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setString(1, omschrijving);
			
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
		String sql = "UPDATE standaardCoefficient SET actief=1 WHERE id=?";
		
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
