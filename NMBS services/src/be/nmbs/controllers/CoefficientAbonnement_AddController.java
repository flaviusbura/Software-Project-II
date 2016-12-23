package be.nmbs.controllers;

import java.util.ArrayList;

import be.nmbs.database.CoefficientAbonnementDAO;
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.logic.CoefficientAbonnement;
import be.nmbs.logic.TypeAbonnement;

public class CoefficientAbonnement_AddController {
	private final TypeAbonnementDAO typeAbonnementDAO = new TypeAbonnementDAO();
	private final CoefficientAbonnementDAO coefficientAbonnementDAO = new CoefficientAbonnementDAO();	
	
	public ArrayList<TypeAbonnement> getAllAbonnementTypes() {
		return typeAbonnementDAO.getAll();
	}
	
	public boolean insertAbbonementCoefficient(CoefficientAbonnement ca) {
		return coefficientAbonnementDAO.insert(ca);
	}
}
