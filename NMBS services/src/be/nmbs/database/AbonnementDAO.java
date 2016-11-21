package be.nmbs.database;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Korting;
import be.nmbs.database.BaseDAO;
import be.nmbs.database.KlantDAO;
import be.nmbs.database.KortingDAO;
import be.nmbs.database.PrijsDAO;
import be.nmbs.logic.Klant;
import be.nmbs.logic.Prijs;

public class AbonnementDAO extends BaseDAO{
	
	public int insertDrieMaandAbonnement(Abonnement abonnement) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO abonnement VALUES(null,?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, abonnement.getKlantContactId());
			prep.setInt(2, abonnement.getGebruikerId());
			prep.setString(3, abonnement.getRoute());
			prep.setTimestamp(4, abonnement.getTimestampNow());
			prep.setTimestamp(5, abonnement.getTimestampDrieMaandAbonnemant(abonnement));
			prep.setInt(6, abonnement.getPrijsId());
			prep.setInt(7,abonnement.getKortingID());
			prep.setBoolean(8, abonnement.isActief());
		
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
	
	public int insertZesMaandAbonnement(Abonnement abonnement) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO abonnement VALUES(null,?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, abonnement.getKlantContactId());
			prep.setInt(2, abonnement.getGebruikerId());
			prep.setString(3, abonnement.getRoute());
			prep.setTimestamp(4, abonnement.getTimestampNow());
			prep.setTimestamp(5, abonnement.getTimestampZesMaandAbonnemant(abonnement));
			prep.setInt(6, abonnement.getPrijsId());
			prep.setInt(7,abonnement.getKortingID());
			prep.setBoolean(8, abonnement.isActief());
		
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
	
	public int insertNegenMaandAbonnement(Abonnement abonnement) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO abonnement VALUES(null,?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, abonnement.getKlantContactId());
			prep.setInt(2, abonnement.getGebruikerId());
			prep.setString(3, abonnement.getRoute());
			prep.setTimestamp(4, abonnement.getTimestampNow());
			prep.setTimestamp(5, abonnement.getTimestampNegenMaandAbonnemant(abonnement));
			prep.setInt(6, abonnement.getPrijsId());
			prep.setInt(7,abonnement.getKortingID());
			prep.setBoolean(8, abonnement.isActief());
		
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
	
	public int insertEenJaarAbonnement(Abonnement abonnement) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO abonnement VALUES(null,?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, abonnement.getKlantContactId());
			prep.setInt(2, abonnement.getGebruikerId());
			prep.setString(3, abonnement.getRoute());
			prep.setTimestamp(4, abonnement.getTimestampNow());
			prep.setTimestamp(5, abonnement.getTimestampJaarAbonnemant(abonnement));
			prep.setInt(6, abonnement.getPrijsId());
			prep.setInt(7,abonnement.getKortingID());
			prep.setBoolean(8, abonnement.isActief());
		
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
	
	public int verlengAbonnementMetDrieMaand(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET eind_datum=? WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setTimestamp(1, abonnement.getTimestampDrieMaandAbonnemant(abonnement));
			prep.setInt(2, abonnement.getAbonnementId());
			
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
	
	public int verlengAbonnementMetZesMaand(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET eind_datum = ? WHERE abonnement_id = ?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setTimestamp(1, abonnement.getTimestampZesMaandAbonnemant(abonnement));
			prep.setInt(2, abonnement.getAbonnementId());
			
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
	
	public int verlengAbonnementMetNegenMaand(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET eind_datum = ? WHERE abonnement_id = ?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setTimestamp(1, abonnement.getTimestampNegenMaandAbonnemant(abonnement));
			prep.setInt(2, abonnement.getAbonnementId());
			
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
	
	public int verlengAbonnementMetEenJaar(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET eind_datum = ? WHERE abonnement_id = ?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setTimestamp(1, abonnement.getTimestampJaarAbonnemant(abonnement));
			prep.setInt(2, abonnement.getAbonnementId());
			
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
	

	public int deleteAbonnement(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET actief = 0 WHERE abonnement_id = ?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1,abonnement.getAbonnementId());
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
	
	public Abonnement zoekAbonnement(Abonnement abonnement) {
		String sql = "SELECT * FROM abonnement WHERE klant_contact_id=?";
		PreparedStatement prep = null;
		Abonnement abo = null;
		ResultSet res = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, abonnement.getKlantContactId());

			res = prep.executeQuery();
			while (res.next()) {
				int abonnementId=res.getInt("abbonement_id");
				int klantContactId = res.getInt("klant_contact_id");
				int gebruikerId = res.getInt("gebruiker_id");
				String route=res.getString("route");
				Timestamp startDatum = res.getTimestamp("start_datum");
				Timestamp eindDatum = res.getTimestamp("eind_datum");
				int prijsId=res.getInt("prijs_id");
				int kortingId =res.getInt("korting_id");
				boolean actief=res.getBoolean("actief");
				
				KortingDAO kortingdao = new KortingDAO();
				Korting korting = kortingdao.getKorting(kortingId);
				KlantDAO klantdao = new KlantDAO();
				Klant klant = klantdao.getKlantById(klantContactId);
				PrijsDAO prijsdao = new PrijsDAO();
				Prijs prijs = prijsdao.getPrijsByPrijsId(prijsId);
				
				 abo = new Abonnement(abonnementId, klant, gebruikerId, route, startDatum, 
						 eindDatum, prijs, korting, actief);
			}
			return abo;
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
	
	public static Timestamp getEindDatum(Abonnement abonnement) {
		String sql = "SELECT * FROM abonnement WHERE abonnement_id = ?";
		PreparedStatement prep = null;
		ResultSet res = null;
		Timestamp timestamp = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1, abonnement.getAbonnementId());
			res = prep.executeQuery();
			while (res.next()) {
			timestamp = res.getTimestamp("eind_datum");
			}
			return timestamp;
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
