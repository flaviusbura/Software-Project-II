package be.nmbs.controllers;

import java.util.ArrayList;

import be.nmbs.database.CoefficientAbonnementDAO;
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.logic.TypeAbonnement;

public class CoefficientAbonnement_UpdateController {
	private final TypeAbonnementDAO typeAbonnementDAO = new TypeAbonnementDAO();
	private final CoefficientAbonnementDAO coefficientAbonnementDAO = new CoefficientAbonnementDAO();

	public ArrayList<TypeAbonnement> getAllAbonnementTypes() {
		return typeAbonnementDAO.getAll();
	}
	
	public boolean updateCoefficient(int id, double coef) {
		return coefficientAbonnementDAO.updateCoefficient_ById(id, coef);
	}
}