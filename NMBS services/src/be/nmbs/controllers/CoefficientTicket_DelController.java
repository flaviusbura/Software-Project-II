package be.nmbs.controllers;

import be.nmbs.database.CoefficientTicketDAO;

public class CoefficientTicket_DelController {
	CoefficientTicketDAO coefficientTicketDAO = new CoefficientTicketDAO();
	
	public boolean deleteCoefficient(int id) {
		return coefficientTicketDAO.delete(id);
	}
}