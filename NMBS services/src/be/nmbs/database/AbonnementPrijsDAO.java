package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import be.nmbs.logic.Prijs_abonnement;

public class AbonnementPrijsDAO extends BaseDAO{
	
	
	public int insert(Prijs_abonnement pa) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO prijs_abonnement VALUES(null,?,?,?,?)";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prep.setInt(1, pa.getType_abonnementid());
			prep.setInt(2,pa.getCoefficient_abonnementid());
			prep.setInt(3, pa.getBasisprijs_abonnementid());
			prep.setDouble(4, pa.getTotaal());
			
			prep.executeUpdate();
			
			ResultSet rs = prep.getGeneratedKeys();
			int last_inserted_id = 0;
	        if(rs.next()) {
	        	last_inserted_id = rs.getInt(1);
	        }
	        
			return last_inserted_id;
		} catch (SQLException e) {
			return 0;
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
	
	public Prijs_abonnement getPrijs_ticketObjectOpPrijs_ticketId(int id) {
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM prijs_abonnement where prijs_abonnementid = ? LIMIT 1";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1,id);
			res = prep.executeQuery();
			res.next();
			
			int prijs_abonnementid = res.getInt("prijs_abonnementid");
			int type_abonnementid = res.getInt("type_abonnementid");
			int coefficient_abonnementid = res.getInt("coefficient_abonnementid");
			int basisprijs_abonnementid = res.getInt("basisprijs_abonnementid");
			double totaal = res.getDouble("totaal");
			
			Prijs_abonnement prijs_abonnement = new Prijs_abonnement(prijs_abonnementid,type_abonnementid,coefficient_abonnementid,basisprijs_abonnementid,totaal);
			
			
			return prijs_abonnement;
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
