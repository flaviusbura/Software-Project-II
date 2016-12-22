package be.nmbs.controllers;

import java.util.ArrayList;

import be.nmbs.database.VerlorenVoorwerpenDAO;
import be.nmbs.logic.VerlorenVoorwerp;

public class VerlorenVoorwerpController {	
	private final VerlorenVoorwerpenDAO verlorenVoorwerpenDAO = new VerlorenVoorwerpenDAO();
	
	public ArrayList<VerlorenVoorwerp> getAllVerlorenVoorwerpenOnSoort(String soort) {
		return verlorenVoorwerpenDAO.getAllOpLike(soort);
	}
	
	public void changeActiefOnVoorwerp(int voorwerpID) {
		verlorenVoorwerpenDAO.updateActief(voorwerpID);
	}
}
