package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.nmbs.logic.BasisprijsTicket;;

public class BasisprijsTicketDAO extends BaseDAO{


	public int insert(BasisprijsTicket basisprijsTicket) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO basisprijs_ticket VALUES(null,?,?)";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, basisprijsTicket.getTypeTicketId());
			prep.setDouble(2, basisprijsTicket.getPrijs());
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

	public int delete(BasisprijsTicket basisprijsTicket) {
		String sql = "DELETE FROM basisprijs_ticket WHERE basisprijs_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, basisprijsTicket.getBasisprijsId());
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

	public int updateTypeAbo_ById(int typeTicketId, int id) {
		PreparedStatement prep = null;
		String sql = "UPDATE basisprijs_ticket SET type_ticketId=? WHERE basisprijs_id=?";

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

	public int updatePrijs_ById(int id, double prijs) {
		PreparedStatement prep = null;
		String sql = "UPDATE basisprijs_ticket SET prijs=? WHERE basisprijs_id=?";

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
		String sql = "SELECT prijs FROM basisprijs_ticket WHERE basisprijs_id=?";
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
