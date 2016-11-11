package be.nmbs.userInterface;

import java.util.ArrayList;
import java.util.Date;

import be.nmbs.database.TicketDAO;
import be.nmbs.logic.Station;
import be.nmbs.logic.Ticket;

public class Main {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Station station = new Station();
		Station startStation = new Station();
		Station eindStation = new Station();
		Date date = new Date("10/10/1010");
		startStation.setName("Midi");
		eindStation.setName("Noord");
		station.setName("Gent");
		
		TicketDAO dao = new TicketDAO();
		@SuppressWarnings("unused")
		Ticket ticket = new Ticket(1, startStation, "ongewoon", date , 1, 
				true, eindStation, "Gewone ticket",1, 1, station);
		@SuppressWarnings("unused")
		Ticket ticket2 = new Ticket(2, startStation, "gewoon", date, 1, 
				true, eindStation, "Iets", 1, 1, station);
		
		//dao.insert(ticket);
		//dao.insert(ticket2);
		
		ArrayList<Ticket> lijst = new ArrayList<Ticket>();
		lijst = dao.getAll();
		
		for (Ticket t : lijst) {
			System.out.println(t);
		}
	}
}
