package be.nmbs.database;

import java.sql.Timestamp;
import java.util.ArrayList;
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
	
	public int insertDrieMaandAbonnement(Abonnement abonnement, Timestamp startDatum) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO abonnement VALUES(null,?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, abonnement.getKlant_contactId());
			prep.setInt(2, abonnement.getGebruikerId());
			prep.setString(3, abonnement.getRoute());
			prep.setTimestamp(4, startDatum);
			prep.setTimestamp(5, abonnement.getTimestampDrieMaandAbonnemant(abonnement.getStartDatum()));
			prep.setInt(6, abonnement.getPrijsId());
			prep.setInt(7,abonnement.getKortingId());
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
	
	public int insertZesMaandAbonnement(Abonnement abonnement, Timestamp startDatum) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO abonnement VALUES(null,?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, abonnement.getKlant_contactId());
			prep.setInt(2, abonnement.getGebruikerId());
			prep.setString(3, abonnement.getRoute());
			prep.setTimestamp(4, startDatum);
			prep.setTimestamp(5, abonnement.getTimestampZesMaandAbonnemant(abonnement.getStartDatum()));
			prep.setInt(6, abonnement.getPrijsId());
			prep.setInt(7,abonnement.getKortingId());
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
	
	public int insertNegenMaandAbonnement(Abonnement abonnement, Timestamp startDatum) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO abonnement VALUES(null,?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, abonnement.getKlant_contactId());
			prep.setInt(2, abonnement.getGebruikerId());
			prep.setString(3, abonnement.getRoute());
			prep.setTimestamp(4, startDatum);
			prep.setTimestamp(5, abonnement.getTimestampNegenMaandAbonnemant(abonnement.getStartDatum()));
			prep.setInt(6, abonnement.getPrijsId());
			prep.setInt(7,abonnement.getKortingId());
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
	
	public int insertEenJaarAbonnement(Abonnement abonnement, Timestamp startDatum) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO abonnement VALUES(null,?,?,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, abonnement.getKlant_contactId());
			prep.setInt(2, abonnement.getGebruikerId());
			prep.setString(3, abonnement.getRoute());
			prep.setTimestamp(4, startDatum);
			prep.setTimestamp(5, abonnement.getTimestampJaarAbonnemant(abonnement.getStartDatum()));
			prep.setInt(6, abonnement.getPrijsId());
			prep.setInt(7,abonnement.getKortingId());
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
		String sql = "UPDATE abonnement SET start_datum = ?, eind_datum = ? WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			abonnement.getEindDatum().setTime(abonnement.getEindDatum().getTime() + (1 * 1000));
			
			prep.setTimestamp(1, abonnement.getEindDatum());
			prep.setTimestamp(2, abonnement.getTimestampDrieMaandAbonnemant(abonnement.getEindDatum()));
			prep.setInt(3, abonnement.getAbonnementId());
			
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
		String sql = "UPDATE abonnement SET start_datum = ?, eind_datum = ? WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			abonnement.getEindDatum().setTime(abonnement.getEindDatum().getTime() + (1 * 1000));
			
			prep.setTimestamp(1, abonnement.getEindDatum());
			prep.setTimestamp(2, abonnement.getTimestampZesMaandAbonnemant(abonnement.getEindDatum()));
			prep.setInt(3, abonnement.getAbonnementId());
			
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
		String sql = "UPDATE abonnement SET start_datum = ?, eind_datum = ? WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			abonnement.getEindDatum().setTime(abonnement.getEindDatum().getTime() + (1 * 1000));
			
			prep.setTimestamp(1, abonnement.getEindDatum());
			prep.setTimestamp(2, abonnement.getTimestampNegenMaandAbonnemant(abonnement.getEindDatum()));
			prep.setInt(3, abonnement.getAbonnementId());
			
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
		String sql = "UPDATE abonnement SET start_datum = ?, eind_datum = ? WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			abonnement.getEindDatum().setTime(abonnement.getEindDatum().getTime() + (1 * 1000));
			
			prep.setTimestamp(1, abonnement.getEindDatum());
			prep.setTimestamp(2, abonnement.getTimestampJaarAbonnemant(abonnement.getEindDatum()));
			prep.setInt(3, abonnement.getAbonnementId());
			
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
			//dit later veranderen naar getKlantContactId();
			prep.setInt(1, abonnement.getKlant_contactId());

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
	public ArrayList<Abonnement> getAll() {
		ArrayList<Abonnement> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM abonnement";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<Abonnement>();
//			public Abonnement(int abonnementId, int klant_contactId, int gebruikerId, String route, Timestamp startDatum,
//			Timestamp eindDatum, int prijsId, int kortingId, boolean actief)
			while (res.next()) {
				int abonnementId=res.getInt("abonnement_id");
				int klantContactId = res.getInt("klant_contact_id");
				int gebruikerId = res.getInt("gebruiker_id");
				String route=res.getString("route");
				Timestamp startDatum = res.getTimestamp("start_datum");
				Timestamp eindDatum = res.getTimestamp("eind_datum");
				int prijsId=res.getInt("prijs_id");
				int kortingId =res.getInt("korting_id");
				boolean actief=res.getBoolean("actief");

				Abonnement abonnement = new Abonnement(abonnementId, klantContactId, gebruikerId, route, startDatum, 
						 eindDatum, prijsId, kortingId, actief);
				
				lijst.add((abonnement));
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
	
	public Abonnement getAll_ByID(int id) {
		Abonnement abonnement = new Abonnement();
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM abonnement";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			
//			public Abonnement(int abonnementId, int klant_contactId, int gebruikerId, String route, Timestamp startDatum,
//			Timestamp eindDatum, int prijsId, int kortingId, boolean actief)
			while (res.next()) {
				int abonnementId=res.getInt("abonnement_id");
				int klantContactId = res.getInt("klant_contact_id");
				int gebruikerId = res.getInt("gebruiker_id");
				String route=res.getString("route");
				Timestamp startDatum = res.getTimestamp("start_datum");
				Timestamp eindDatum = res.getTimestamp("eind_datum");
				int prijsId=res.getInt("prijs_id");
				int kortingId =res.getInt("korting_id");
				boolean actief=res.getBoolean("actief");

				abonnement = new Abonnement(abonnementId, klantContactId, gebruikerId, route, startDatum, 
						 eindDatum, prijsId, kortingId, actief);
				

			}
			return abonnement;
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
