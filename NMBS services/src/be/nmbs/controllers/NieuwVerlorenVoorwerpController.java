package be.nmbs.controllers;

import java.util.ArrayList;
import java.util.Calendar;

import be.nmbs.database.StationDAO;
import be.nmbs.database.VerlorenVoorwerpenDAO;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.VerlorenVoorwerp;

public class NieuwVerlorenVoorwerpController {
	 private final VerlorenVoorwerpenDAO verlorenvoorwerpdao = new VerlorenVoorwerpenDAO();
	 private final StationDAO stationDAO = new StationDAO();

	public ArrayList<StationNMBS> getAllStations() {
		return stationDAO.getAll();
	}
	
	public void insertVoorwerp(VerlorenVoorwerp voorwerp) {
		verlorenvoorwerpdao.insert(voorwerp);
	}
	
	public Calendar getCurrentDate() {
		return Calendar.getInstance();
	}
}
