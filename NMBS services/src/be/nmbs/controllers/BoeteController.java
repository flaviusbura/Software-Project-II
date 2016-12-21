package be.nmbs.controllers;

import be.nmbs.database.BoeteDAO;

public class BoeteController {
	private final BoeteDAO boeteDAO = new BoeteDAO();
	
	public int getBoeteId(int id) {
		return boeteDAO.getBoeteIdBy_BoeteId(id);
	}
	
	public boolean updateBoete(int id, boolean betaald) {
		return boeteDAO.updateBetaaldByBoeteId(id, betaald);
	}
}