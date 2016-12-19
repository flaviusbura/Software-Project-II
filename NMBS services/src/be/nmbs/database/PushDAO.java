package be.nmbs.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import be.nmbs.logic.Klant;
import be.nmbs.logic.VerlorenVoorwerp;

public class PushDAO {

VerlorenVoorwerpenDAO verlorenvoorwerpdao = new VerlorenVoorwerpenDAO();
public void Push() throws SQLException{
	
	//close remote connection
	DatabaseSingleton.getDatabaseSingleton().getConnection().close();
	
	// open local connection
	DatabaseSingleton.getDatabaseSingleton().getLocalConnection();
	
	//get local data
    ArrayList<VerlorenVoorwerp> verlorenvoorwerpAll = verlorenvoorwerpdao.getAllForDatabase();
    verlorenvoorwerpdao.deleteAlles();
    
    System.out.println(verlorenvoorwerpAll.get(0).getTimestampWithoutNonoSec());
    
    //close local connection
    DatabaseSingleton.getDatabaseSingleton().getLocalConnection().close();
    
    
    //open remote connection
	DatabaseSingleton.getDatabaseSingleton().getConnection();

	//update remote connection with local data
    for(VerlorenVoorwerp vv : verlorenvoorwerpAll)
    {
    	
    	verlorenvoorwerpdao.insert(vv);
    }
	
	
}
}
