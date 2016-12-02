package be.nmbs.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.nmbs.logic.Adres;


public class Klant_adresDAO extends BaseDAO {
	/**
	 * Default constructor
	 */
	public Klant_adresDAO() {
	}

	/**
	 * @return
	 */
	public Adres getAdres(int adres_id) {
		Adres adres = null;
		PreparedStatement prep = null;
		ResultSet res = null;
		String sql = "SELECT * FROM klant_adres where adres_id=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setInt(1, adres_id);
			res = prep.executeQuery();
			while (res.next()) {
				String straat = res.getString("straat");
				int huisnummer = res.getInt("nr");
				int postcode = res.getInt("postcode");
				String bus = res.getString("bus");
				String woonplaats = res.getString("stad");
				int adresId = res.getInt("adres_id");
				String land = res.getString("land");
				boolean actief = res.getBoolean("actief");

				adres = new Adres(straat, huisnummer, postcode, bus, woonplaats, adresId, land, actief);

			}
			return adres;
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

	/**
	 * Deze methode gaat een insert statement uitvoeren
	 * 
	 * @param gebruiker
	 * @return
	 */
	public int insert(Adres adres) {
		PreparedStatement prep = null;
		String sql = "INSERT INTO klant_adres VALUES(null,?,?,?,?,?,?,?)";

		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setString(1, adres.getLand());
			prep.setString(2, adres.getWoonplaats());
			prep.setInt(3, adres.getPostcode());
			prep.setString(4, adres.getStraat());
			prep.setInt(5, adres.getHuisnummer());
			prep.setString(6, adres.getBus());
			prep.setBoolean(7, adres.getActief());
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

	/**
	 * Deze methode gaat een adres verwijderen
	 * 
	 * @param adres
	 * @return
	 */
	public int delete(Adres adres) {
		String sql = "UPDATE klant_adres SET actief=0 WHERE adres_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, adres.getId());
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

	public int update(Adres adres) {
		String sql = "UPDATE klant_adres SET actief=0 WHERE adres_id=?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setInt(1, adres.getId());
			prep.executeUpdate();
			PreparedStatement prep2 = null;
			String sql2 = "INSERT INTO klant_adres VALUES(?,?,?,?,?,?,?,?)";

			try {
				if (getConnection().isClosed()) {
					throw new IllegalStateException("Unexpected error!");
				}
				prep2 = getConnection().prepareStatement(sql2);

				prep2.setInt(1, adres.getId());
				prep2.setString(2, adres.getLand());
				prep2.setString(3, adres.getWoonplaats());
				prep2.setInt(4, adres.getPostcode());
				prep2.setString(5, adres.getStraat());
				prep2.setInt(6, adres.getHuisnummer());
				prep2.setString(7, adres.getBus());
				prep2.setBoolean(8, adres.getActief());
				return prep2.executeUpdate();
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

	public int getAdresIdOpStraatEnHuisnummer(Adres adres) {
		PreparedStatement prep = null;
		ResultSet res = null;
		int adresId = 0;
		String sql = "SELECT adres_id FROM klant_adres where straat=? and nr=?";
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);
			prep.setString(1, adres.getStraat());
			prep.setInt(2, adres.getHuisnummer());
			res = prep.executeQuery();
			while (res.next()) {
				adresId = res.getInt("adres_id");
			}
			return adresId;
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
	
	public int updateAdresKlant(Adres adres) {
		String sql = "UPDATE klant_adres SET land = ?, stad = ?, postcode = ?, straat = ?, nr = ?, bus = ?, actief = ? WHERE adres_id = ?";
		PreparedStatement prep = null;
		try {
			if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
			prep = getConnection().prepareStatement(sql);

			prep.setString(1, adres.getLand());
			prep.setString(2, adres.getWoonplaats());
			prep.setInt(3, adres.getPostcode());
			prep.setString(4, adres.getStraat());
			prep.setInt(5, adres.getHuisnummer());
			prep.setString(6, adres.getBus());
			prep.setBoolean(7, true);
			prep.setInt(8, adres.getAdresId());
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
	
	public int updateLandByAdresId(int adresID, String land) {
        String sql = "UPDATE klant_adres SET land = ? WHERE adres_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setString(1, land);
            prep.setInt(2, adresID);
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
	
	public int updateStraatByAdresId(int adresID, String straat) {
        String sql = "UPDATE klant_adres SET straat = ? WHERE adres_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setString(1, straat);
            prep.setInt(2, adresID);
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
	
	public int updateNrByAdresId(int adresID, int huisnummer) {
        String sql = "UPDATE klant_adres SET nr = ? WHERE adres_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setInt(1, huisnummer);
            prep.setInt(2, adresID);
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
	
	public int updatePostcodeByAdresId(int adresID, int postcode) {
        String sql = "UPDATE klant_adres SET postcode = ? WHERE adres_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setInt(1, postcode);
            prep.setInt(2, adresID);
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
	
	public int updateWoonplaatsByAdresId(int adresID, String woonplaats) {
        String sql = "UPDATE klant_adres SET stad = ? WHERE adres_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setString(1, woonplaats);
            prep.setInt(2, adresID);
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
	
	public int updateBusByAdresId(int adresID, String bus) {
        String sql = "UPDATE klant_adres SET bus = ? WHERE adres_id = ?";
        PreparedStatement prep = null;
        try {
        	if (getConnection().isClosed()) {
				throw new IllegalStateException("Unexpected error!");
			}
        	prep = getConnection().prepareStatement(sql);
        	
            prep.setString(1, bus);
            prep.setInt(2, adresID);
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
}
