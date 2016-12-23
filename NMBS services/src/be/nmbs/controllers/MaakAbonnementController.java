package be.nmbs.controllers;

import be.nmbs.database.AbonnementDAO;
import be.nmbs.database.AbonnementPrijsDAO;
import be.nmbs.database.BasisprijsAbonnementenDAO;
import be.nmbs.database.CoefficientAbonnementDAO;
import be.nmbs.database.KlantDAO;
import be.nmbs.database.KortingDAO;
import be.nmbs.database.PrijsDAO;
import be.nmbs.database.StationDAO;
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Klant;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.Prijs_abonnement;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.TypeAbonnement;

import java.util.ArrayList;
import java.util.Calendar;

public class MaakAbonnementController {
	private final StationDAO stationDAO = new StationDAO();
	private final KlantDAO klantDAO = new KlantDAO();
	private final KortingDAO kortingDAO = new KortingDAO();
	private final AbonnementDAO abonnementDAO = new AbonnementDAO();
	private final PrijsDAO prijsDAO = new PrijsDAO();
	private final TypeAbonnementDAO typeAbonnementDAO = new TypeAbonnementDAO();
	private final BasisprijsAbonnementenDAO basisprijsAbonnementenDAO = new BasisprijsAbonnementenDAO();
	private final CoefficientAbonnementDAO coefficientAbonnementDAO = new CoefficientAbonnementDAO();
	private final AbonnementPrijsDAO abonnementPrijsDAO = new AbonnementPrijsDAO();

	public ArrayList<StationNMBS> getAllStations() {
		return stationDAO.getAll();
	}
	
	public ArrayList<Klant> getAllKlantenByLike(String klant) {
		return klantDAO.getAllByLike(klant);
	}
	
	public ArrayList<Korting> getAllKortingen() {
		return kortingDAO.getAll();
	}
	
	public boolean insertAbonnement(String keuze, Abonnement abonnement) {
		if (keuze == "3 maanden") {
			return abonnementDAO.insertDrieMaandAbonnement(abonnement);
		} else if (keuze == "6 maanden") {
			return abonnementDAO.insertZesMaandAbonnement(abonnement);
		} else if (keuze == "9 maanden") {
			return abonnementDAO.insertNegenMaandAbonnement(abonnement);
		} else if (keuze == "12 maanden") {
			return abonnementDAO.insertEenJaarAbonnement(abonnement);
		} else {
			return false;
		}
	}

	public Calendar getCurrentDate() {
		return Calendar.getInstance();
	}
	
	public ArrayList<Prijs> getAllPrijzen() {
		return prijsDAO.getAll();
	}
	
	public ArrayList<TypeAbonnement> getAllAbonnementTypes() {
		return typeAbonnementDAO.getAll();
	}
	
	public int getBasisPrijsId(int id) {
		return basisprijsAbonnementenDAO.getBasisPrijsIdbyTypeId(id);
	}
	
	public double getPrijs(int id) {
		return basisprijsAbonnementenDAO.getPrijs_ById(id);
	}
	
	public int getCoefficientId(int id) {
		return coefficientAbonnementDAO.getCoefficientIdByTypeId(id);
	}
	
	public double getCoefficient(int id) {
		return coefficientAbonnementDAO.getCoefficient_ById(id);
	}
	
	public int insertAbonnementPrijs(Prijs_abonnement pa) {
		return abonnementPrijsDAO.insert(pa);
	}
}