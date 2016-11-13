package be.nmbs.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Adres;
import be.nmbs.logic.Korting;
import be.nmbs.database.KortingDAO;

public class AbonnementDAO extends BaseDAO{
	
	public int insert(Abonnement abonnement) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO abonnement VALUES(null,?,?,?,?,?,?)";
		
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, abonnement.getKlantContactId());
			prep.setString(2, abonnement.getRoute());
			prep.setDate(3, Date.valueOf(abonnement.getEindDatum()));
//			prep.setInt(4, abonnement.getPrijsID());
			prep.setInt(5,abonnement.getKortingID());
			prep.setBoolean(6, abonnement.isActief());
		
		
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
	
	
	public int deleteAbo(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET actief=0 WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1,abonnement.getId());
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
	
	public int verlengAbo(Abonnement abonnement) {
		String sql = "UPDATE abonnement SET einddatum=? WHERE abonnement_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setDate(1,Date.valueOf(abonnement.getEindDatum()));
			prep.setInt(2,abonnement.getId());
			
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
	
	public Abonnement zoekAbo(Abonnement abonnement) {
		String sql = "select * from abonnement where klant_contact_id=?";
		PreparedStatement prep = null;
		Abonnement abo = null;
		ResultSet res = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			
			prep.setInt(1,abonnement.getKlantID());

			res = prep.executeQuery();
			while (res.next()) {
				int abbonement_id=res.getInt("abbonement_id");
				int klant_contact_id=res.getInt("klant_contact_id");
				String route=res.getString("route");
				String einddatum=res.getString("einddatum");
				int prijs_id=res.getInt("prijs_id");
				int korting_id =res.getInt("korting_id");
				boolean actief=res.getBoolean("actief");
				
				KortingDAO kortingdao = new KortingDAO();
				Korting korting = kortingdao.getKorting(korting_id);
				Klant_contact_IdDAO klantdao = new Klant_contact_IdDAO();
				Klant klant = klantdao.getKlant(klant_contact_id);
				PrijsDAO prijsdao = new PrijsDAO();
				Prijs prijs = prijsdao.getPrijs(prijs_id);
				
				 abo =new Abonnement(abbonement_id,klant,route,einddatum,prijs,korting,actief);
				
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
	

}
