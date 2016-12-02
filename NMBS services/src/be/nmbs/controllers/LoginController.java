package be.nmbs.controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.swing.JOptionPane;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;
import be.nmbs.userInterface.HomeView;
import be.nmbs.userInterface.LoginView;
import be.nmbs.userInterface.View;
import be.nmbs.logic.Hashing;

public class LoginController {
	private Gebruiker gebruiker;
	private GebruikerDAO gebruikerDAO;

	public LoginController(View view) {
		LoginView.getOk().addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				gebruiker = new Gebruiker();
				gebruikerDAO = new GebruikerDAO();
				gebruiker = gebruikerDAO.getGebruikerOpUsername(LoginView.getGebruikerText().getText());
				JOptionPane optionPane = new JOptionPane(LoginView.getGebruikerText().getText());

				/*
				 * Nakijken of het ingegeven paswoord overeen komt met het
				 * paswoord van in de database
				 */

				Hashing hashing = new Hashing();
				try {
					if (Objects.equals(gebruiker.getWachtwoord(), new String(
							hashing.hashPaswoord(String.valueOf(LoginView.getPasswordText().getPassword()))))) {
						optionPane.showMessageDialog(null, "Je bent met succes ingelogd!");
						view.setIngelogdGebruiker(gebruiker);
						HomeView.setHomeControllerToNull();
						view.changeView(HomeView.initialize(view));
					} else {
						optionPane.showMessageDialog(null, "Foutieve gegevens, probeer opniew!");
						LoginView.getGebruikerText().setText("");
						LoginView.getPasswordText().setText("");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		LoginView.getCloseApp().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});
	}
}
