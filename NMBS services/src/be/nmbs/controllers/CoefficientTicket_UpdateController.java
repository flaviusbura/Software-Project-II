package be.nmbs.controllers;

import java.util.ArrayList;

import be.nmbs.database.CoefficientTicketDAO;
import be.nmbs.database.TypeTicketDAO;
import be.nmbs.logic.TypeTicket;

public class CoefficientTicket_UpdateController {
	private final TypeTicketDAO typeTicketDAO = new TypeTicketDAO();
	private final CoefficientTicketDAO coefficientTicketDAO = new CoefficientTicketDAO();

	public ArrayList<TypeTicket> getAllTicketTypes() {
		return typeTicketDAO.getAll();
	}
	
	public boolean updateCoefficient(int id, double coef) {
		return coefficientTicketDAO.updateCoefficient_ById(id, coef);
	}
}
