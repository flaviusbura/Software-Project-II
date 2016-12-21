package be.nmbs.controllers;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Hashing;

public class LoginController {
	private final GebruikerDAO gebruikerDAO = new GebruikerDAO();
	
	public Gebruiker getGebruiker(String username) {
		return gebruikerDAO.getGebruikerOpUsername(username);
	}
	
	public String hashPassword(String password) {
		return Hashing.hashPaswoord(password);
	}
}