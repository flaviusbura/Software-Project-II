package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.KlantDAO;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.exceptions.EnkelCijfersException;
import be.nmbs.exceptions.EnkelLettersException;
import be.nmbs.exceptions.NietGeldigePostcodeException;
import be.nmbs.logic.Adres;
import be.nmbs.logic.Klant;
import be.nmbs.logic.VeiligeInvoer;
import be.nmbs.userInterface.KlantenBeheerView;
import be.nmbs.userInterface.NieuweKlantAanmakenView;
import be.nmbs.userInterface.View;

public class NieuweKlantAanmakenController {
	private Adres adres;
	private Klant klant;
	private Klant_adresDAO adresDAO;
	private KlantDAO klantDAO;
	private JOptionPane jOptionPane;

	public NieuweKlantAanmakenController(View view) {
		NieuweKlantAanmakenView.getKlantAanmaken().addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String straat = NieuweKlantAanmakenView.getStraatText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(straat) == false) {
						throw new EnkelLettersException();
					}
					int huisnummer = Integer.parseInt(NieuweKlantAanmakenView.getNrText().getText());
					String bus = NieuweKlantAanmakenView.getBusText().getText();
					if (VeiligeInvoer.checkForOnlyNumbers(bus) == false) {
						throw new EnkelCijfersException();
					}
					int postcode = Integer.parseInt(NieuweKlantAanmakenView.getPostcodeText().getText());
					if (postcode < 1000 || postcode > 9999) {
						throw new NietGeldigePostcodeException();
					}
					String stad = NieuweKlantAanmakenView.getStadText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(stad) == false) {
						throw new EnkelLettersException();
					}
					String land = NieuweKlantAanmakenView.getLandText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(land) == false) {
						throw new EnkelLettersException();
					}
					adres = new Adres(straat, huisnummer, postcode, bus, stad, land, true);
					adresDAO = new Klant_adresDAO();
					adresDAO.insert(adres);
					int adresId = adresDAO.getAdresIdOpStraatEnHuisnummer(adres);
					String voornaam = NieuweKlantAanmakenView.getVoornaamText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(voornaam) == false) {
						throw new EnkelLettersException();
					}
					String naam = NieuweKlantAanmakenView.getNaamText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(naam) == false) {
						throw new EnkelLettersException();
					}
					String telefoon = NieuweKlantAanmakenView.getTelefoonText().getText();
					if (VeiligeInvoer.checkForOnlyNumbers(telefoon) == false) {
						throw new EnkelCijfersException();
					}
					klant = new Klant(1, voornaam, naam, adresId, telefoon, true);
					klantDAO = new KlantDAO();
					klantDAO.insert(klant);
					JOptionPane optionPane = new JOptionPane();
					optionPane.showMessageDialog(null, "Nieuwe klant met succes aamgemaakt!");
					KlantenBeheerView.setKlantenBeheerControllerToNull();
					view.changeView(KlantenBeheerView.initialize(view));
				} catch (NumberFormatException e1) {
					jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null, "Gelieve alle velden correct in te vullen!");
				} catch (EnkelLettersException e2) {
					jOptionPane.showMessageDialog(null,
							"U mocht velden niet leeg laten of\n speciale karakters gebruiken als invoer.");
				} catch (NietGeldigePostcodeException e3) {
					jOptionPane.showMessageDialog(null, "Het ingevoerde postcode is ongeldig!");
				} catch (EnkelCijfersException e4) {
					jOptionPane.showMessageDialog(null, "Gelieve cijfers in te vullen waar cijfers verwacht worden.");
				}
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
