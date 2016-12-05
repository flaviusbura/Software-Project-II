package be.nmbs.database;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import be.nmbs.logic.StationNMBS;


	public class StationDAO extends BaseDAO {

		/**
		 * Default constructor.
		 */
		public StationDAO() {
		}

		/**
		 * Deze methode gaat aan de database alle gegevens vragen inde tabel station.
		 * 
		 * @return Een ArrayList met alle station-objecten in de tabel station
		 */
		public ArrayList<StationNMBS> getAll() {
			ArrayList<StationNMBS> lijst = null;
			PreparedStatement prep = null;
			ResultSet res = null;
			String sql = "SELECT * FROM station";
			try {
				if (getConnection().isClosed()) {
					throw new IllegalStateException("Unexpected error!");
				}
				prep = getConnection().prepareStatement(sql);
				res = prep.executeQuery();
				lijst = new ArrayList<StationNMBS>();

				while (res.next()) {

					String naam = res.getString("naam");
					
					StationNMBS sn = new StationNMBS(naam);
					lijst.add((sn));
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
}
