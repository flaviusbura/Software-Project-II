package be.nmbs.controllers;

import java.util.ArrayList;
import java.util.Calendar;

import be.nmbs.database.BasisprijsTicketDAO;
import be.nmbs.database.CoefficientTicketDAO;
import be.nmbs.database.KortingDAO;
import be.nmbs.database.StationDAO;
import be.nmbs.database.TicketDAO;
import be.nmbs.database.TicketPrijsDAO;
import be.nmbs.database.TypeTicketDAO;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs_ticket;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.Ticket;
import be.nmbs.logic.TypeTicket;

public class TicketController {
	private final StationDAO stationDAO = new StationDAO();
	private final KortingDAO kortingDAO = new KortingDAO();
	private final TypeTicketDAO typeTicketDAO = new TypeTicketDAO();
	private final BasisprijsTicketDAO basisprijsTicketDAO = new BasisprijsTicketDAO();
	private final TicketDAO ticketDAO = new TicketDAO();
	private final TicketPrijsDAO ticketPrijsDAO = new TicketPrijsDAO();
	private final CoefficientTicketDAO coefficientTicketDAO = new CoefficientTicketDAO();
	
	public ArrayList<StationNMBS> getAllStations() {
		return stationDAO.getAll();
	}
	
	public ArrayList<Korting> getAllKortingen() {
		return kortingDAO.getAll();
	}
	
	public ArrayList<TypeTicket> getAllTicketTypes() {
		return typeTicketDAO.getAll();
	}
	
	public int getBasisPrijsId(int typeTicketId) {
		return basisprijsTicketDAO.getBasisPrijsIdbyTypeId(typeTicketId);
	}
	
	public double getBasisPrijs(int id) {
		return basisprijsTicketDAO.getPrijs_ById(id);
	}
	
	public boolean insertTicket(Ticket ticket) {
		return ticketDAO.insert(ticket);
	}
	
	public int insertTicketPrijs(Prijs_ticket prijs) {
		return ticketPrijsDAO.insert(prijs);
	}
	
	public int getCoefficientId(int typeTicketId) {
		return coefficientTicketDAO.getCoefficientIdByTypeId(typeTicketId);
	}
	
	public double getCoefficient(int id) {
		return coefficientTicketDAO.getCoefficient_ById(id);
	}
	
	public Calendar getCurrentDate() {
		return Calendar.getInstance();
	}
}