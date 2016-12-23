package be.nmbs.controllers;

import java.util.ArrayList;

import be.nmbs.database.BasisprijsTicketDAO;
import be.nmbs.database.TypeTicketDAO;
import be.nmbs.logic.TypeTicket;

public class BasisPrijsTicket_UpdateController {
	private final TypeTicketDAO typeTicketDAO = new TypeTicketDAO();
	private final BasisprijsTicketDAO basisprijsTicketDAO = new BasisprijsTicketDAO();

	public ArrayList<TypeTicket> getAllTicketTypes() {
		return typeTicketDAO.getAll();
	}
	
	public boolean updatePrijs(int id, double prijs) {
		return basisprijsTicketDAO.updatePrijs_ById(id, prijs);
	}
}