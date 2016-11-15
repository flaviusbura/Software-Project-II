package be.nmbs.userInterface;

import java.util.ArrayList;

import be.nmbs.database.BoeteDAO;
import be.nmbs.logic.Boete;

public class Main {
	public static void main(String[] args) {
		Boete boete = new Boete(1, 1, 20.40, false);
		Boete boete2 = new Boete(1, 2, 50.40, false);
		
		BoeteDAO dao = new BoeteDAO();
		dao.insert(boete);
		dao.insert(boete2);
		
		ArrayList<Boete> lijst = new ArrayList<>();
		lijst = dao.getAll();
		
		for (Boete b : lijst) {
			System.out.println("Datum: " + b.getDatumWithoutNonoSec());
			System.out.println("Betaaldatum: " + b.getBetaalDatumWithoutNonoSec());
			System.out.println();
		}
	}
}
