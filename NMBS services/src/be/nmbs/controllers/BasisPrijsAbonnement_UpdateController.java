package be.nmbs.controllers;

import java.util.ArrayList;

import be.nmbs.database.BasisprijsAbonnementenDAO;
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.logic.TypeAbonnement;

public class BasisPrijsAbonnement_UpdateController {
	private final TypeAbonnementDAO typeAbonnementDAO = new TypeAbonnementDAO();
	private final BasisprijsAbonnementenDAO basisprijsAbonnementenDAO = new BasisprijsAbonnementenDAO();
	
	public ArrayList<TypeAbonnement> getAllAbonnementTypes() {
		return typeAbonnementDAO.getAll();
	}
	
	public boolean updatePrijs(int id, double prijs) {
		return basisprijsAbonnementenDAO.updatePrijs_ById(id, prijs);
	}
}