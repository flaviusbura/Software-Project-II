package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.exceptions.EnkelLettersException;
import be.nmbs.exceptions.PasswordNotMatchException;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.Hashing;
import be.nmbs.logic.VeiligeInvoer;
import be.nmbs.userInterface.GebruikerView;
import be.nmbs.userInterface.NieuwGebruikerAanmakenView;
import be.nmbs.userInterface.View;

public class NieuwGebruikerAanmakenController {
	private Gebruiker gebruiker;
	private GebruikerDAO gebruikerDAO;

	public NieuwGebruikerAanmakenController(View view) {
		NieuwGebruikerAanmakenView.getToevoegen().addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				int rol = 0;
				String secureWachtwoord = "", voornaam, achternaam, username, wachtwoord1, wachtwoord2;
				JOptionPane jOptionPane = new JOptionPane();
				try {
					voornaam = NieuwGebruikerAanmakenView.getVoornaamText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(voornaam) == false) {
						throw new EnkelLettersException();
					}
					achternaam = NieuwGebruikerAanmakenView.getAchternaamText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(achternaam) == false) {
						throw new EnkelLettersException();
					}
					username = NieuwGebruikerAanmakenView.getUsernameText().getText();
					if (VeiligeInvoer.checkForOnlyLetters(username) == false) {
						throw new EnkelLettersException();
					}
					wachtwoord1 = String.valueOf(NieuwGebruikerAanmakenView.getWachtwoordText().getPassword());
					wachtwoord2 = String.valueOf(NieuwGebruikerAanmakenView.getWachtwoordTextConfirm().getPassword());
					if (!(wachtwoord1.equals(wachtwoord2))) {
						throw new PasswordNotMatchException();
					} else {
						try {
							secureWachtwoord = Hashing.hashPaswoord(wachtwoord1);
						} catch (NoSuchAlgorithmException e1) {
							e1.printStackTrace();
						}
					}
					String selectedItem = (String) NieuwGebruikerAanmakenView.getRolCombo().getSelectedItem();
					if (selectedItem.equals("Administrator")) {
						rol = 2;
					} else {
						rol = 1;
					}
					gebruiker = new Gebruiker(1, voornaam, achternaam, username, secureWachtwoord, rol, true);
					gebruikerDAO = new GebruikerDAO();
					gebruikerDAO.insert(gebruiker);
				} catch (EnkelLettersException ex) {
					jOptionPane.showMessageDialog(null,
							"De veldjes mogen niet leeg zijn en/of andere\nkarakters dan letters bevatten.");
				} catch (PasswordNotMatchException ex) {
					jOptionPane.showMessageDialog(null, "Wachtwoorden matchen niet, probeer opnieuw!");
				}
				jOptionPane.showMessageDialog(null, "Uw gebruiker is toegevoegd geweest!");
				GebruikerView.setGebruikerControllerToNull();
				view.changeView(GebruikerView.initialize(view));
			}
		});

		NieuwGebruikerAanmakenView.getAnnuleren().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GebruikerView.setGebruikerControllerToNull();
				view.changeView(GebruikerView.initialize(view));
			}
		});
	}
}
