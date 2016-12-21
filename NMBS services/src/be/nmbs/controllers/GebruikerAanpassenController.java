package be.nmbs.controllers;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Hashing;

public class GebruikerAanpassenController {
	private final GebruikerDAO gebruikerDAO = new GebruikerDAO();
	
	public Gebruiker getGebruiker(String username) {
		return gebruikerDAO.getGebruikerOpUsername(username);
	}
	
	public boolean updateGebruiker(Gebruiker g) {
		return gebruikerDAO.update(g);
	}
	
	public String hashPassword(String password) {
		return Hashing.hashPaswoord(password);
	}
}