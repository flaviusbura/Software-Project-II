package be.nmbs.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import be.nmbs.logic.Klant;
import be.nmbs.logic.Prijs_ticket;
import be.nmbs.logic.Ticket;
import be.nmbs.logic.VerlorenVoorwerp;

public class PushDAO {

VerlorenVoorwerpenDAO verlorenvoorwerpdao = new VerlorenVoorwerpenDAO();
TicketDAO ticketdao = new TicketDAO();
TicketPrijsDAO prijsticketdao = new TicketPrijsDAO();
public void Push() throws SQLException{
	
	//close remote connection
	DatabaseSingleton.getDatabaseSingleton().getConnection().close();
	
	// open local connection
	DatabaseSingleton.getDatabaseSingleton().getLocalConnection();
	
	//get local data
    ArrayList<VerlorenVoorwerp> verlorenvoorwerpAll = verlorenvoorwerpdao.getAllForDatabase();
    verlorenvoorwerpdao.deleteAlles();
    
    ArrayList<Ticket> ticketAll = ticketdao.getAllForDatabase();
    ticketdao.deleteAlles();
    
    ArrayList<Prijs_ticket> prijsticketAll = prijsticketdao.getAllForDatabase();
    prijsticketdao.deleteAlles();
    
    //close local connection
    DatabaseSingleton.getDatabaseSingleton().getLocalConnection().close();
    
    
    //open remote connection
	DatabaseSingleton.getDatabaseSingleton().getConnection();

	//update remote connection with local data
    for(VerlorenVoorwerp vv : verlorenvoorwerpAll)
    {
    	
    	verlorenvoorwerpdao.insert(vv);
    }
	
    for(Ticket t : ticketAll)
    {
    	
    	ticketdao.insert(t);
    }
    
    for(Prijs_ticket pt : prijsticketAll)
    {
    	
    	prijsticketdao.insert(pt);
    }
	
}
}
