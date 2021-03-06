package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.nmbs.logic.CoefficientAbonnement;

public class CoefficientAbonnementDAO extends BaseDAO {

	public boolean insert(CoefficientAbonnement coefficientAbonnement) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO coefficient_abonnement VALUES(null,?,?)";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, coefficientAbonnement.getTypeAbonnementId());
			prep.setDouble(2, coefficientAbonnement.getCoefficient());
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

	public boolean delete(int id) {
		String sql = "DELETE FROM coefficient_abonnement WHERE coefficient_abonnementId=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, id);
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

	public int updateTypeAbo_ById(int typeAboId, int id) {
		PreparedStatement prep = null;
		String sql = "UPDATE coefficient_abonnement SET type_abonnementId=? WHERE type_abonnementId=?";

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

	public boolean updateCoefficient_ById(int id, double coef) {
		PreparedStatement prep = null;
		String sql = "UPDATE coefficient_abonnement SET coefficient=? WHERE type_abonnementId=?";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setDouble(1, coef);
			prep.setInt(2, id);
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

	public double getCoefficient_ById(int id) {
		PreparedStatement prep = null;
		ResultSet res = null;
		double coefficient = 0.00;
		String sql = "SELECT Coefficient FROM coefficient_abonnement WHERE type_abonnementId=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, id);
			res = prep.executeQuery();

			while (res.next()) {
				coefficient = res.getDouble("coefficient");
			}
			return coefficient;
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
	public int getCoefficientIdByTypeId(int id) {
		PreparedStatement prep = null;
		ResultSet res = null;
		int coefficientId = 0;
		String sql = "SELECT coefficient_abonnementId FROM coefficient_abonnement WHERE type_abonnementId=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, id);
			res = prep.executeQuery();

			while (res.next()) {
				coefficientId = res.getInt("coefficient_abonnementId");
			}
			return coefficientId;
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
