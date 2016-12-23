package be.nmbs.controllers;

import be.nmbs.database.BasisprijsAbonnementenDAO;

public class BasisPrijsAbonnement_DelController {
	BasisprijsAbonnementenDAO basisprijsAbonnementenDAO = new BasisprijsAbonnementenDAO();
	
	public boolean deletePrijs(int id) {
		return basisprijsAbonnementenDAO.delete(id);
	}
}