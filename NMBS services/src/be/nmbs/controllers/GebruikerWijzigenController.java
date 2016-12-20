package be.nmbs.controllers;

import java.util.ArrayList;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;

public class GebruikerWijzigenController {
	private final GebruikerDAO dao = new GebruikerDAO();
	
	public ArrayList<Gebruiker> getAllGebruikers() {
        return dao.getAll();
	}
	
	public Gebruiker getGebruiker(String username) {
		return dao.getGebruikerOpUsername(username);
	}
}