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
import be.nmbs.logic.Prijs_abonnement;

public class AbonnementDAO extends BaseDAO {

	public boolean insertDrieMaandAbonnement(Abonnement abonnement) {
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
			prep.setTimestamp(4, abonnement.getStartDatum());
			prep.setTimestamp(5, abonnement.getTimestampDrieMaandAbonnemant(abonnement.getStartDatum()));
			prep.setInt(6, abonnement.getKortingId());
			
			System.out.println("Prijs ID DAO" +abonnement.getPrijsId());
			System.out.println("Prijs abonnement ID DAO:"+abonnement.getPrijsId().getPrijs_abonnementid());
			prep.setInt(7, abonnement.getPrijsId().getPrijs_abonnementid());
			prep.setBoolean(8, abonnement.isActief());

			prep.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			return false;
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

	public boolean insertZesMaandAbonnement(Abonnement abonnement) {
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
			prep.setTimestamp(4, abonnement.getStartDatum());
			prep.setTimestamp(5, abonnement.getTimestampZesMaandAbonnemant(abonnement.getStartDatum()));
			prep.setInt(6, abonnement.getKortingId());
			prep.setInt(7, abonnement.getPrijsId().getPrijs_abonnementid());
			prep.setBoolean(8, abonnement.isActief());

			prep.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			return false;
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

	public boolean insertNegenMaandAbonnement(Abonnement abonnement) {
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
			prep.setTimestamp(4, abonnement.getStartDatum());
			prep.setTimestamp(5, abonnement.getTimestampNegenMaandAbonnemant(abonnement.getStartDatum()));
			prep.setInt(6, abonnement.getKortingId());
			prep.setInt(7, abonnement.getPrijsId().getPrijs_abonnementid());
			prep.setBoolean(8, abonnement.isActief());

			prep.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			return false;
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

	public boolean insertEenJaarAbonnement(Abonnement abonnement) {
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
			prep.setTimestamp(4, abonnement.getStartDatum());
			prep.setTimestamp(5, abonnement.getTimestampJaarAbonnemant(abonnement.getStartDatum()));
			prep.setInt(6, abonnement.getKortingId());
			prep.setInt(7, abonnement.getPrijsId().getPrijs_abonnementid());
			prep.setBoolean(8, abonnement.isActief());

			prep.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			return false;
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

	public boolean verlengAbonnementMetDrieMaand(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET start_datum = ?, eind_datum = ? WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			abonnement.getEindDatum().setTime(abonnement.getEindDatum().getTime() + (1 * 1000));
			
			prep.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			prep.setTimestamp(2, abonnement.getTimestampDrieMaandAbonnemant(abonnement.getEindDatum()));
			prep.setInt(3, abonnement.getAbonnementId());

			prep.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			return false;
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

	public boolean verlengAbonnementMetZesMaand(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET start_datum = ?, eind_datum = ? WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			abonnement.getEindDatum().setTime(abonnement.getEindDatum().getTime() + (1 * 1000));

			prep.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			prep.setTimestamp(2, abonnement.getTimestampZesMaandAbonnemant(abonnement.getEindDatum()));
			prep.setInt(3, abonnement.getAbonnementId());

			prep.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			return false;
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

	public boolean verlengAbonnementMetNegenMaand(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET start_datum = ?, eind_datum = ? WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			abonnement.getEindDatum().setTime(abonnement.getEindDatum().getTime() + (1 * 1000));

			prep.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			prep.setTimestamp(2, abonnement.getTimestampNegenMaandAbonnemant(abonnement.getEindDatum()));
			prep.setInt(3, abonnement.getAbonnementId());

			prep.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			return false;
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

	public boolean verlengAbonnementMetEenJaar(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET start_datum = ?, eind_datum = ? WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			abonnement.getEindDatum().setTime(abonnement.getEindDatum().getTime() + (1 * 1000));

			prep.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			prep.setTimestamp(2, abonnement.getTimestampJaarAbonnemant(abonnement.getEindDatum()));
			prep.setInt(3, abonnement.getAbonnementId());

			prep.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			return false;
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

			prep.setInt(1, abonnement.getAbonnementId());
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
			// dit later veranderen naar getKlantContactId();
			prep.setInt(1, abonnement.getKlant_contactId());

			res = prep.executeQuery();
			while (res.next()) {
				int abonnementId = res.getInt("abbonement_id");
				int klantContactId = res.getInt("klant_contact_id");
				int gebruikerId = res.getInt("gebruiker_id");
				String route = res.getString("route");
				Timestamp startDatum = res.getTimestamp("start_datum");
				Timestamp eindDatum = res.getTimestamp("eind_datum");
				int prijsId = res.getInt("prijs_id");
				int kortingId = res.getInt("korting_id");
				boolean actief = res.getBoolean("actief");

				KortingDAO kortingdao = new KortingDAO();
				Korting korting = kortingdao.getKorting(kortingId);
				KlantDAO klantdao = new KlantDAO();
				Klant klant = klantdao.getKlantById(klantContactId);
				PrijsDAO prijsdao = new PrijsDAO();
				Prijs prijs = prijsdao.getPrijsByPrijsId(prijsId);

				abo = new Abonnement(abonnementId, klant, gebruikerId, route, startDatum, eindDatum, prijs, korting,
						actief);
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

	public Timestamp getEindDatum(Abonnement abonnement) {
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

	public int getIdByStartDatum(Timestamp startDatum) {
		String sql = "SELECT abonnement_id FROM abonnement WHERE start_datum = ?";
		PreparedStatement prep = null;
		ResultSet res = null;
		int id = 0;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setTimestamp(1, startDatum);
			res = prep.executeQuery();
			while (res.next()) {
				id = res.getInt("abonnement_id");
			}
			return id;
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

	public Abonnement getAbo_ByID(int id) {

		Abonnement abo = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM abonnement WHERE abonnement_id=?";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, id);
			res = prep.executeQuery();
			Prijs_abonnement prijsAbonnement = new Prijs_abonnement();
			AbonnementPrijsDAO apDao = new AbonnementPrijsDAO();
			while (res.next()) {
				int abonnementId = res.getInt("abonnement_id");
				int klantContactId = res.getInt("klant_contact_id");
				int gebruikerId = res.getInt("gebruiker_id");
				String route = res.getString("route");
				Timestamp startDatum = res.getTimestamp("start_datum");
				Timestamp eindDatum = res.getTimestamp("eind_datum");
				int prijsId = res.getInt("prijs_id");
				prijsAbonnement = apDao.getPrijs_ticketObjectOpPrijs_ticketId(prijsId);
				int kortingId = res.getInt("korting_id");
				boolean actief = res.getBoolean("actief");

				abo = new Abonnement(abonnementId, klantContactId, gebruikerId, route, startDatum,
								eindDatum, prijsAbonnement, kortingId, actief);
				System.out.println("---"+abo);
				
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
			
			Prijs_abonnement prijsAbonnement = new Prijs_abonnement();
			AbonnementPrijsDAO apDao = new AbonnementPrijsDAO();
			while (res.next()) {
				int abonnementId = res.getInt("abonnement_id");
				int klantContactId = res.getInt("klant_contact_id");
				int gebruikerId = res.getInt("gebruiker_id");
				String route = res.getString("route");
				Timestamp startDatum = res.getTimestamp("start_datum");
				Timestamp eindDatum = res.getTimestamp("eind_datum");
				int prijsId = res.getInt("prijs_id");
				prijsAbonnement = apDao.getPrijs_ticketObjectOpPrijs_ticketId(prijsId);
				int kortingId = res.getInt("korting_id");
				boolean actief = res.getBoolean("actief");

				Abonnement abonnement = new Abonnement(abonnementId, klantContactId, gebruikerId, route, startDatum,
						eindDatum, prijsAbonnement, kortingId, actief);

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

	// public int getAll_ByID(int id) {
	public int getID_ByID(int Id) {

		PreparedStatement prep = null;
		int verlengId = 0;
		ResultSet res = null;
		String sql = "SELECT abonnement_id FROM abonnement where abonnement_id=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, Id);
			res = prep.executeQuery();
			while (res.next()) {

				verlengId = res.getInt("abonnement_id");

			}
			return verlengId;
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
	
	public ArrayList<Abonnement> getAllBetweenDates(Timestamp date1, Timestamp date2){
		PreparedStatement prep = null;
		ResultSet res = null;
		Abonnement abo;
		ArrayList<Abonnement> list = new ArrayList<Abonnement>();
		String sql = "SELECT * FROM abonnement WHERE start_datum>=? AND start_datum<=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			//dit later veranderen naar getKlantContactId();
			prep.setTimestamp(1, date1);
			prep.setTimestamp(2, date2);
			Prijs_abonnement prijsAbonnement = new Prijs_abonnement();
			AbonnementPrijsDAO apDao = new AbonnementPrijsDAO();
			res = prep.executeQuery();
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
				
				KortingDAO kortingdao = new KortingDAO();
				Korting korting = kortingdao.getKorting(kortingId);
				KlantDAO klantdao = new KlantDAO();
				Klant klant = klantdao.getKlantById(klantContactId);
				BasisprijsAbonnementenDAO prijsdao = new BasisprijsAbonnementenDAO();
				Prijs prijs = new Prijs(prijsId);
				prijs.setPrijs(prijsdao.getPrijs_ById(prijsId));
				
				 abo = new Abonnement(abonnementId, klant, gebruikerId, route, startDatum, 
						 eindDatum, prijs, korting, actief);
				 list.add(abo);
			}
			return list;
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
	
	public String getAbonnementType(int id){
		int basisprijsId=0;
		int typeid=0;
		String result="";
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM abonnement WHERE abonnement_id=?";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, id);
			res = prep.executeQuery();
			Prijs_abonnement prijsAbonnement = new Prijs_abonnement();
			AbonnementPrijsDAO apDao = new AbonnementPrijsDAO();
			while (res.next()) {
				basisprijsId = res.getInt("prijs_id");
			}
			// get prijs column thingie
			PreparedStatement prep2 =null;
			ResultSet res2=null;
			String sql2 = "SELECT * FROM basisprijs_abonnement WHERE basisprijs_abonnementId =?";
			try{
				if (getConnection().isClosed()) {
					throw new IllegalStateException("Unexpected error!");
				}
				prep2 = getConnection().prepareStatement(sql2);
				prep2.setInt(1,basisprijsId);
				res2 = prep2.executeQuery();
				while (res2.next()) {
					typeid=res2.getInt("type_abonnementId");
				}
				// get type string
				PreparedStatement prep3=null;
				ResultSet res3=null;
				String sql3 ="SELECT * FROM type_abonnement WHERE type_abonnementId=?";
				try{
					if (getConnection().isClosed()) {
						throw new IllegalStateException("Unexpected error!");
					}
					prep3 = getConnection().prepareStatement(sql3);
					prep3.setInt(1,typeid);
					res3 = prep3.executeQuery();
					while (res3.next()) {
						result=res3.getString("type");
					}
					return result;
				}catch (SQLException e) {
					System.out.println(e.getMessage());
					throw new RuntimeException(e.getMessage());
				} finally {
					try {
						if (prep3 != null)
							prep3.close();
		
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
	
	public ArrayList<Abonnement> getAllOnDate(Timestamp date){
		PreparedStatement prep = null;
		ResultSet res = null;
		Abonnement abo;
		ArrayList<Abonnement> list= new ArrayList<Abonnement>();
		String sql = "SELECT * FROM abonnement WHERE start_datum=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			//dit later veranderen naar getKlantContactId();
			prep.setTimestamp(1, date);

			res = prep.executeQuery();
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
				
				KortingDAO kortingdao = new KortingDAO();
				Korting korting = kortingdao.getKorting(kortingId);
				KlantDAO klantdao = new KlantDAO();
				Klant klant = klantdao.getKlantById(klantContactId);
				BasisprijsAbonnementenDAO prijsdao = new BasisprijsAbonnementenDAO();
				Prijs prijs = new Prijs(prijsId);
				prijs.setPrijs(prijsdao.getPrijs_ById(prijsId));
				
				 abo = new Abonnement(abonnementId, klant, gebruikerId, route, startDatum, 
						 eindDatum, prijs, korting, actief);
				 list.add(abo);
			}
			return list;
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
