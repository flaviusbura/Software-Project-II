package be.nmbs.userInterface;

import java.util.ArrayList;

import be.nmbs.database.*;
import be.nmbs.logic.*;

public class Main {
	public static void main(String[] args) {
		/*Gebruiker gebruiker = new Gebruiker(1, "Flavius", "Bura", "password", 1, true);
		Gebruiker gebruiker2 = new Gebruiker(2, "User", "User", "User", 1, true);
	    gebruikerDAO.insert(gebruiker);
		gebruikerDAO.insert(gebruiker2);*/
		Gebruiker gebruiker = new Gebruiker(1, "Flavius", "Bura", "veranderd", 1, true);
		GebruikerDAO gebruikerDAO = new GebruikerDAO();
		Gebruiker gebruiker2 = new Gebruiker(2, "User", "User", "User", 1, true);
		gebruikerDAO.delete(gebruiker2);
		gebruikerDAO.updateWachtwoordById(gebruiker);
		ArrayList<Gebruiker> gebruikers = new ArrayList<>();
		gebruikers = gebruikerDAO.getAll();
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
		
		for (Gebruiker g : gebruikers) {
			System.out.println("Gebruikersnaam: " + g.getAchternaam());
		}
	}
}
