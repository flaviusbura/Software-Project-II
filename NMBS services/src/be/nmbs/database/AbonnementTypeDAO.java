package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.nmbs.database.BaseDAO;

public class AbonnementTypeDAO extends BaseDAO{
	
	public int insertTypeAbonnement(int id, String type) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO abonnementType VALUES(null,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, id);
			prep.setString(2, type);
		
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
	public int updateTypeAbonnement(int id,String type){
		PreparedStatement prep=null;
		String sql = "UPDATE abonnementType SET type=? WHERE abonnement_id=?";
		
		try{
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, id);
			prep.setString(2, type);
			return prep.executeUpdate();
		}catch (SQLException e) {
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
	public String getTypeVanAbonnement(int id){
		PreparedStatement prep=null;
		ResultSet res = null;
		String sql="SELECT * FROM abonnementType WHERE abonnement_id=?";
		String type="";
		try{
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, id);
			res = prep.executeQuery();
			while (res.next()) {
				type=res.getString("type");
			}
			return type;
		}catch (SQLException e) {
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
