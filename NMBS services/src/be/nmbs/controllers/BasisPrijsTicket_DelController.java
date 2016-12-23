package be.nmbs.controllers;

import be.nmbs.database.BasisprijsTicketDAO;

public class BasisPrijsTicket_DelController {
	private final BasisprijsTicketDAO basisprijsTicketDAO = new BasisprijsTicketDAO();
	
	public boolean deletePrijs(int id) {
		return basisprijsTicketDAO.delete(id);
	}
}