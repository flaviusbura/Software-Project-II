package be.nmbs.controllers;

import java.util.ArrayList;

import be.nmbs.database.KlantDAO;
import be.nmbs.logic.Klant;

public class KlantBeheerController {
	private final KlantDAO klantDAO = new KlantDAO();
	
	public ArrayList<Klant> getAllKlantenByLike(String klant) {
		return klantDAO.getAllByLike(klant);
	}
	
	public Klant getKlant(int id) {
		return klantDAO.getKlantById(id);
	}
}