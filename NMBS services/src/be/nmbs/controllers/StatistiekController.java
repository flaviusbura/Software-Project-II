package be.nmbs.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.database.AbonnementTypeDAO;
import be.nmbs.logic.Abonnement;

public class StatistiekController {
	private final AbonnementDAO abonnementDAO = new AbonnementDAO();
	private final AbonnementTypeDAO abonnementTypeDAO = new AbonnementTypeDAO();
	
	public ArrayList<Abonnement> getAbonnementen(Timestamp startStamp, Timestamp endStamp) {
		return abonnementDAO.getAllBetweenDates(startStamp, endStamp);
	}
	
	public ArrayList<Abonnement> getAbonnementenOnDate(Timestamp stamp) {
		return abonnementDAO.getAllOnDate(stamp);
	}
	
	public String getAbonnementType(int id) {
		return abonnementTypeDAO.getTypeVanAbonnement(id);
	}
}