package be.nmbs.controllers;

import be.nmbs.database.KlantDAO;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.logic.Adres;
import be.nmbs.logic.Klant;

public class KlantAanpassenController {
	private final Klant_adresDAO adresDAO = new Klant_adresDAO();
	private final KlantDAO klantDAO = new KlantDAO();
	
	public boolean insertKlant(Klant klant) {
		return klantDAO.insert(klant);
	}
	
	public int getAdresId(Adres adres) {
		return adresDAO.getAdresIdOpStraatEnHuisnummer(adres);
	}
	
	public Adres getAdres(int id) {
		return adresDAO.getAdres(id);
	}
	
	public boolean updateAdres(Adres adres) {
		return adresDAO.updateAdresKlant(adres);
	}
	
	public boolean updateKlant(Klant klant) {
		return klantDAO.update(klant);
	}
}