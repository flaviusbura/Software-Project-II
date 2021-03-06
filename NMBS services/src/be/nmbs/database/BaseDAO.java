package be.nmbs.database;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * Deze klasse heeft de connectie met de databank
 * @author flaviusb
 *
 */
public abstract class BaseDAO {
	private Connection connection;
	
	/**
	 * Deze methode stuurt mijn connectie terug
	 * @return
	 */
	protected Connection getConnection() {
		try {
			if(connection.isClosed()) {
				refreshConnection();
			}
		} catch (SQLException e) {
			//TODO: LOG couldn't access sql db 
			
			e.printStackTrace();
		}
			
		return connection;
	}
	
	private void refreshConnection() {
		try {
			connection = DatabaseSingleton.getDatabaseSingleton().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Deze methode sets mijn connectie
	 * @param connection
	 */
	protected void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Deze constructor vraagt de connectie aan de DatabaseSigleton en initialiseert mijn
	 * datamember connection van deze klasse 
	 */
	public BaseDAO() {
		try {
			setConnection(DatabaseSingleton.getDatabaseSingleton().getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
