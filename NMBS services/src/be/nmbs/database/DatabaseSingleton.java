package be.nmbs.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
	private static DatabaseSingleton databaseSingleton;
	
	private Connection connection;
    /**
     * Default constructor.
     */
    private DatabaseSingleton() {}
    
    /**
     * Deze methode gaat indien mijn datamember databaseSingleton initialiseren als deze null is anders
     * stuurt hij de databaseSingleton terug
     * @return
     */	
    public static DatabaseSingleton getDatabaseSingleton() {
    	if (databaseSingleton == null) {
    		databaseSingleton = new DatabaseSingleton();
    	}
		return databaseSingleton;
    }
    
    /**
     * Deze methode gaat de connectie met de databank maken en stuurt deze terug.
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        }
        else {
            try {
                String url = "jdbc:mysql://dt5.ehb.be/SP2G8";
                String username = "SP2G8";
                String password = "Groep8";

                connection = DriverManager.getConnection(url, username, password);
              
        
                
                	
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("SQLVendorError: " + e.getErrorCode());
              	 // db parameters
                String url1 = "jdbc:sqlite:C:/Users/leire_000/Desktop/NMBSServices.db";
                // create a connection to the local database
                connection = DriverManager.getConnection(url1);
                
            }            
        }
		return connection;
    }
    
    /**
     * Deze methode sluit de connectie met de databank.
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new SQLException(e);
            } finally {
                connection = null;                
            }
        }
    }
}
