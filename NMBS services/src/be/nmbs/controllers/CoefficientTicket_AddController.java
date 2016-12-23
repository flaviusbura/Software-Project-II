package be.nmbs.controllers;

import java.util.ArrayList;

import be.nmbs.database.CoefficientTicketDAO;
import be.nmbs.database.TypeTicketDAO;
import be.nmbs.logic.CoefficientTicket;
import be.nmbs.logic.TypeTicket;

//CoefficientTicket_AddView
public class CoefficientTicket_AddController {
	private final TypeTicketDAO typeTicketDAO = new TypeTicketDAO();
	private final CoefficientTicketDAO coefficientTicketDAO = new CoefficientTicketDAO();
	
	public ArrayList<TypeTicket> getAllTicketTypes() {
		return typeTicketDAO.getAll();
	}
	
	public boolean insertCoefficient(CoefficientTicket ct) {
		return coefficientTicketDAO.insert(ct);
	}
}
