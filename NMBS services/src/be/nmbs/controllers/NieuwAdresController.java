package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.exceptions.EnkelCijfersException;
import be.nmbs.exceptions.EnkelLettersException;
import be.nmbs.exceptions.NietGeldigePostcodeException;
import be.nmbs.logic.Adres;
import be.nmbs.logic.VeiligeInvoer;
import be.nmbs.userInterface.NieuwAdresView;
import be.nmbs.userInterface.KlantAanpassenView;
import be.nmbs.userInterface.View;

public class NieuwAdresController {
	private int adresId;
	private Adres adres;
	private Klant_adresDAO klant_adresDAO;
	private JOptionPane jOptionPane;

	public NieuwAdresController(View view) {
		NieuwAdresView.getKlantAdresWijzigen().addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int row = KlantAanpassenView.getTable().getSelectedRow();
					adresId = Integer.valueOf((String) KlantAanpassenView.getTable().getModel().getValueAt(row, 1));
					String straat = NieuwAdresView.getStraatText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(straat) == false) {
						throw new EnkelLettersException();
					}
					int huisnummer = Integer.parseInt(NieuwAdresView.getNrText().getText());
					String bus = NieuwAdresView.getBusText().getText();
					if (VeiligeInvoer.checkForOnlyNumbers(bus) == false) {
						throw new EnkelCijfersException();
					}
					int postcode = Integer.parseInt(NieuwAdresView.getPostcodeText().getText());
					if (postcode < 1000 || postcode > 9999) {
						throw new NietGeldigePostcodeException();
					}
					String stad = NieuwAdresView.getStadText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(stad) == false) {
						throw new EnkelLettersException();
					}
					String land = NieuwAdresView.getLandText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(land) == false) {
						throw new EnkelLettersException();
					}
					adres = new Adres(straat, huisnummer, postcode, bus, stad, land, true);
					adres.setAdresId(adresId);
					klant_adresDAO = new Klant_adresDAO();
					klant_adresDAO.updateAdresKlant(adres);
					JOptionPane optionPane = new JOptionPane();
					optionPane.showMessageDialog(null, "Adres geupdatet!");
					KlantAanpassenView.setKlantWijzigenControllerToNull();
					view.changeView(KlantAanpassenView.initialize(view));
				} catch (ArrayIndexOutOfBoundsException indexE) {
					jOptionPane = new JOptionPane();
					jOptionPane.showMessageDialog(null,
							"U heeft geen rij geselecteerd!\nSelecteer een rij die u wenst te wijzigen.");
					KlantAanpassenView.setKlantWijzigenControllerToNull();
					view.changeView(KlantAanpassenView.initialize(view));
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

		NieuwAdresView.getActieannuleren().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				KlantAanpassenView.setKlantWijzigenControllerToNull();
				view.changeView(KlantAanpassenView.initialize(view));
			}
		});
	}
}
