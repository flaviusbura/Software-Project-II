package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.KlantDAO;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.logic.Adres;
import be.nmbs.userInterface.AdresWijzigenView;
import be.nmbs.userInterface.KlantWijzigenView;
import be.nmbs.userInterface.View;

public class AdresWijzigenController {
	private int adresId;
	private Adres adres;
	private KlantDAO klantDAO;
	private Klant_adresDAO klant_adresDAO;
	
	public AdresWijzigenController(View view) {
		AdresWijzigenView.getKlantAdresWijzigen().addActionListener(new ActionListener() {
	
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				String voornaam = AdresWijzigenView.getVoornaamText().getText();
				String naam = AdresWijzigenView.getNaamText().getText();
				klantDAO = new KlantDAO();
				adresId = klantDAO.getAdresIdOpNaamEnVoornaam(voornaam, naam);
				String straat = AdresWijzigenView.getStraatText().getText();
				int huisnummer = Integer.parseInt(AdresWijzigenView.getNrText().getText());
				String bus = AdresWijzigenView.getBusText().getText();
				int postcode = Integer.parseInt(AdresWijzigenView.getPostcodeText().getText());
				String stad = AdresWijzigenView.getStadText().getText();
				String land = AdresWijzigenView.getLandText().getText();
				adres = new Adres(straat, huisnummer, postcode, bus, stad, land, true);
				adres.setAdresId(adresId);
				klant_adresDAO = new Klant_adresDAO();
				klant_adresDAO.updateAdresKlant(adres);
				JOptionPane optionPane = new JOptionPane();
				optionPane.showMessageDialog(null, "Adres geupdatet!");
				KlantWijzigenView.setKlantWijzigenControllerToNull();
				view.changeView(KlantWijzigenView.initialize(view));
			}
		});
		
		AdresWijzigenView.getActieannuleren().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KlantWijzigenView.setKlantWijzigenControllerToNull();
				view.changeView(KlantWijzigenView.initialize(view));
			}
		});
	}
}
