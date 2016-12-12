package be.nmbs.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
	private static DatabaseSingleton databaseSingleton;
	
	private static Connection connection;
	private static Connection connectionLocal;
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
        if (connection != null && !connection.isClosed()) {
            return connection;
        }
        else {
            try {
                String url = "jdbc:mysql://dt5.ehb.be/SP2G8";
                String username = "SP2G8";
                String password = "Groep8";

                connection = DriverManager.getConnection(url, username, password);
            
        
                
                	
            } catch (SQLException e) {
             //   System.out.println("SQLException: " + e.getMessage());
             //   System.out.println("SQLState: " + e.getSQLState());
             //	  System.out.println("SQLVendorError: " + e.getErrorCode());
            	// geen internet/connecties dus ga naar lokale db
              	 // db parameters
                String urlLocal = "jdbc:sqlite:db/NMBSServices.db";
                // create a connection to the local database
                connection = DriverManager.getConnection(urlLocal);
                
            }            
        }
		return connection;
    }
    
    /**
     * Deze methode gaat de connectie met de local databank maken en stuurt deze terug.
     * @return
     * @throws SQLException
     */
    public Connection getLocalConnection() throws SQLException {
        if (connectionLocal != null && !connectionLocal.isClosed()) {
            return connectionLocal;
        }
        else {
           

             //   System.out.println("SQLException: " + e.getMessage());
             //   System.out.println("SQLState: " + e.getSQLState());
             //	  System.out.println("SQLVendorError: " + e.getErrorCode());
            	// geen internet/connecties dus ga naar lokale db
              	 // db parameters
                String url1 = "jdbc:sqlite:db/NMBSServices.db";
                // create a connection to the local database
                connectionLocal = DriverManager.getConnection(url1);
                
                     
        }
		return connectionLocal;
    }
    
    public static void setConnection(Connection connection) {
		DatabaseSingleton.connection = connection;
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
    
	/**
     * Deze methode sluit de connectie met de databank.
     * @throws SQLException
     */
    public void closeLocalConnection() throws SQLException {
        if (connectionLocal != null) {
            try {
            	connectionLocal.close();
            } catch (SQLException e) {
                throw new SQLException(e);
            } finally {
            	connectionLocal = null;                
            }
        }
    }
}
