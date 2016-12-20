package be.nmbs.controllers;

import java.util.ArrayList;
import java.util.Calendar;

import be.nmbs.database.StationDAO;
import be.nmbs.logic.Route;
import be.nmbs.logic.StationNMBS;

public class RouteSearchController {	
	private final StationDAO stationdao = new StationDAO();
	
	public ArrayList<StationNMBS> getAllStations() {
		return stationdao.getAll();
	}
	
	public Calendar getCurrentDate() {
		return Calendar.getInstance();
	}
	
	public ArrayList<Route> getRouteInfo(String departure, String arrival, Calendar cal) {
		return ApiCaller.getTimedRouteInfo(departure, arrival, cal.getTime());
	}
}