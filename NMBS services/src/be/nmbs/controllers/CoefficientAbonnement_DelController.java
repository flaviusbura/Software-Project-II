package be.nmbs.controllers;

import be.nmbs.database.CoefficientAbonnementDAO;

public class CoefficientAbonnement_DelController {
	private final CoefficientAbonnementDAO coefficientAbonnementDAO = new CoefficientAbonnementDAO();
	
	public boolean deleteCoefficient(int id) {
		return coefficientAbonnementDAO.delete(id);
	}
}