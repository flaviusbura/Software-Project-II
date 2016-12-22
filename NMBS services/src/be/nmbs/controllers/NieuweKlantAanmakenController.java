package be.nmbs.controllers;

import be.nmbs.database.KlantDAO;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.logic.Adres;
import be.nmbs.logic.Klant;

public class NieuweKlantAanmakenController {
	private final Klant_adresDAO adresDAO = new Klant_adresDAO();
	private final KlantDAO klantDAO = new KlantDAO();
	
	public boolean insertKlant(Klant klant) {
		return klantDAO.insert(klant);
	}
	
	public boolean insertAdres(Adres adres) {
		return adresDAO.insert(adres);
	}
	
	public int getAdresId(Adres adres) {
		return adresDAO.getAdresIdOpStraatEnHuisnummer(adres);
	}
}