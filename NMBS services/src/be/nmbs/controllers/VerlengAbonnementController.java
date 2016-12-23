package be.nmbs.controllers;

import java.util.ArrayList;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.logic.Abonnement;

public class VerlengAbonnementController {
	private final AbonnementDAO abonnementDAO = new AbonnementDAO();

	public ArrayList<Abonnement> getAllAbonnementen() {
		return abonnementDAO.getAll();
	}
	
	public Abonnement getAbonnement(int id) {
		return abonnementDAO.getAbo_ByID(id);
	}
	
	public boolean verlengAbonnement(Abonnement abonnement, String keuze) {
		if (keuze == "3 maanden") {
			return abonnementDAO.verlengAbonnementMetDrieMaand(abonnement);
		} else if (keuze == "6 maanden") {
			return abonnementDAO.verlengAbonnementMetZesMaand(abonnement);
		} else if (keuze == "9 maanden") {
			return abonnementDAO.verlengAbonnementMetNegenMaand(abonnement);
		} else if (keuze == "12 maanden") {
			return abonnementDAO.verlengAbonnementMetEenJaar(abonnement);
		} else {
			return false;
		}
	}
}