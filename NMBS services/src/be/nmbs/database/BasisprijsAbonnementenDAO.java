package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import be.nmbs.logic.BasisprijsAbonnement;
import be.nmbs.logic.Prijs;


public class BasisprijsAbonnementenDAO extends BaseDAO{
	
	public ArrayList<BasisprijsAbonnement> getAll() {
		ArrayList<BasisprijsAbonnement> lijst = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM basisprijs_abonnement";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			res = prep.executeQuery();
			lijst = new ArrayList<BasisprijsAbonnement>();

			while (res.next()) {
				
				int id= res.getInt("basisprijs_abonnementId");
				int aboId= res.getInt("basisprijs_abonnementId");
				double prijs=res.getDouble("Prijs");
				BasisprijsAbonnement bpa = new BasisprijsAbonnement(id,aboId,prijs);
				
				lijst.add((bpa));
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
	public int insert(BasisprijsAbonnement basisprijsAbonnement) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO basisprijs_abonnement VALUES(null,?,?)";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, basisprijsAbonnement.getTypeAbonnementId());
			prep.setDouble(2, basisprijsAbonnement.getPrijs());
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

	public int delete(BasisprijsAbonnement basisprijsAbonnement) {
		String sql = "DELETE FROM basisprijs_abonnement WHERE basisprijs_abonnementId=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, basisprijsAbonnement.getId());
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

	public int updateTypeAbo_ById(int typeAboId, int id) {
		PreparedStatement prep = null;
		String sql = "UPDATE basisprijs_abonnement SET type_abonnementId=? WHERE basisprijs_abonnementId=?";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, typeAboId);
			prep.setInt(2, id);
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

	public int updatePrijs_ById(int id, double prijs) {
		PreparedStatement prep = null;
		String sql = "UPDATE basisprijs_abonnement SET prijs=? WHERE basisprijs_abonnementId=?";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setDouble(1, prijs);
			prep.setInt(2, id);
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

	public double getPrijs_ById(int id) {
		PreparedStatement prep = null;
		ResultSet res = null;
		double prijs = 0.00;
		String sql = "SELECT prijs FROM basisprijs_abonnement WHERE type_abonnementId=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, id);
			res = prep.executeQuery();

			while (res.next()) {

				prijs = res.getDouble("prijs");

			}
			return prijs;
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
