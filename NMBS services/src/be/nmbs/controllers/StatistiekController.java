package be.nmbs.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.logic.Abonnement;

public class StatistiekController {
	private final AbonnementDAO abonnementDAO = new AbonnementDAO();
	
	public ArrayList<Abonnement> getAbonnementen(Timestamp startStamp, Timestamp endStamp) {
		return abonnementDAO.getAllBetweenDates(startStamp, endStamp);
	}
	
	public ArrayList<Abonnement> getAbonnementenOnDate(Timestamp stamp) {
		return abonnementDAO.getAllOnDate(stamp);
	}
	
	public Calendar getCurrentDate() {
		return Calendar.getInstance();
	}
}