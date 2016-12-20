package be.nmbs.controllers;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;

public class GebruikerAanpassenController {
	private final GebruikerDAO gebruikerDAO = new GebruikerDAO();
	
	public Gebruiker getGebruiker(String username) {
		return gebruikerDAO.getGebruikerOpUsername(username);
	}
	
	public boolean updateGebruiker(Gebruiker g) {
		return gebruikerDAO.update(g);
	}
}