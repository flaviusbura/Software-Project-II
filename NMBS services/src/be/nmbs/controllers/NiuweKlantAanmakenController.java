package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.KlantDAO;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.logic.Adres;
import be.nmbs.logic.Klant;
import be.nmbs.userInterface.KlantenBeheerView;
import be.nmbs.userInterface.NieuweKlantAanmakenView;
import be.nmbs.userInterface.View;

public class NiuweKlantAanmakenController {
	private Adres adres;
	private Klant klant;
	private Klant_adresDAO adresDAO;
	private KlantDAO klantDAO;
	
	public NiuweKlantAanmakenController(View view) {
		NieuweKlantAanmakenView.getKlantAanmaken().addActionListener(new ActionListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				String straat = NieuweKlantAanmakenView.getStraatText().getText();
				int huisnummer = Integer.parseInt(NieuweKlantAanmakenView.getNrText().getText());
				String bus = NieuweKlantAanmakenView.getBusText().getText();
				int postcode = Integer.parseInt(NieuweKlantAanmakenView.getPostcodeText().getText());
				String stad = NieuweKlantAanmakenView.getStadText().getText();
				String land = NieuweKlantAanmakenView.getLandText().getText();
				adres = new Adres(straat, huisnummer, postcode, bus, stad, land, true);
				adresDAO = new Klant_adresDAO();
				adresDAO.insert(adres);
				int adresId = adresDAO.getAdresIdOpStraatEnHuisnummer(adres);
				String voornaam = NieuweKlantAanmakenView.getVoornaamText().getText();
				String naam = NieuweKlantAanmakenView.getNaamText().getText();
				String telefoon = NieuweKlantAanmakenView.getTelefoonText().getText();
				klant = new Klant(1, voornaam, naam, adresId, telefoon, true);
				klantDAO = new KlantDAO();
				klantDAO.insert(klant);
				JOptionPane optionPane = new JOptionPane();
				optionPane.showMessageDialog(null, "Nieuwe Klant met succes aamgemaakt!");
				KlantenBeheerView.setKlantenBeheerControllerToNull();
				view.changeView(KlantenBeheerView.initialize(view));
			}
		});
		
		NieuweKlantAanmakenView.getActieannuleren().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KlantenBeheerView.setKlantenBeheerControllerToNull();
				view.changeView(KlantenBeheerView.initialize(view));
			}
		});
	}
}
