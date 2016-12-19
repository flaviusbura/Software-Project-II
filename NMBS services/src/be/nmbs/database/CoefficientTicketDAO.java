package be.nmbs.database;

import java.sql.SQLException;
import java.sql.ResultSet;
import be.nmbs.logic.CoefficientTicket;
import java.sql.PreparedStatement;

public class CoefficientTicketDAO extends BaseDAO {

	public int insert(CoefficientTicket coefficientTicket) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO coefficient_ticket VALUES(null,?,?)";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, coefficientTicket.getTypeTicketId());
			prep.setDouble(2, coefficientTicket.getCoefficient());
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

	public int delete(CoefficientTicket coefficientTicket) {
		String sql = "DELETE FROM coefficient_ticket WHERE coefficient_ticketId=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, coefficientTicket.getCoefficientTicketId());
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
	public int updateTypeTicket_ById(int typeTicketId, int id) {
		PreparedStatement prep = null;
		String sql = "UPDATE coefficient_ticket SET type_ticketId=? WHERE coefficient_ticketId=?";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, typeTicketId);
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

	public int updateCoefficient_ById(int id, double coef) {
		PreparedStatement prep = null;
		String sql = "UPDATE coefficient_ticket SET coefficient=? WHERE coefficient_ticketId=?";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setDouble(1, coef);
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

	public double getCoefficient_ById(int id) {
		PreparedStatement prep = null;
		ResultSet res = null;
		double coefficient = 0.00;
		String sql = "SELECT coefficient FROM coefficient_ticket WHERE type_ticketId=?";
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
}
