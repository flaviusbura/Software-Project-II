package be.nmbs.controllers;

import java.util.ArrayList;
import java.util.Calendar;

import be.nmbs.database.KortingDAO;
import be.nmbs.database.PrijsDAO;
import be.nmbs.database.StationDAO;
import be.nmbs.database.TicketDAO;
import be.nmbs.logic.Korting;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;

public class TicketController {
	private final PrijsDAO prijsDAO = new PrijsDAO();
	private final KortingDAO kortingDAO = new KortingDAO();
	private final StationDAO stationDAO = new StationDAO();
	private final TicketDAO ticketDAO = new TicketDAO();
	
	public ArrayList<StationNMBS> getAllStations() {
		return stationDAO.getAll();
	}
	
	public ArrayList<Korting> getAllKortingen() {
		return kortingDAO.getAll();
	}
	
	public Calendar getCurrentDate() {
		return Calendar.getInstance();
	}
	
	public boolean insertTicket(Ticket ticket) {
		return ticketDAO.insert(ticket);
	}
}
