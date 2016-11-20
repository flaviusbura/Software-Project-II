package be.nmbs.controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.swing.JOptionPane;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;

import be.nmbs.userInterface.View;
import be.nmbs.logic.Hashing;

public class LoginController {
	private Gebruiker gebruiker;
	private View view;
	private GebruikerDAO gebruikerDAO;
	public LoginController() {
		view = new View();

		view.add(view.getPanel());
		view.setVisible(true);
		view.getOk().addActionListener(new ActionListener() {
			
			@SuppressWarnings({ "deprecation", "static-access" })
			@Override
			public void actionPerformed(ActionEvent e) {
				gebruiker = new Gebruiker();
				gebruikerDAO = new GebruikerDAO();
				gebruiker = gebruikerDAO.getGebruikerOpUsername(view.getGebruikerText().getText());
				JOptionPane optionPane = new JOptionPane(view.getGebruikerText().getText());
				
// Nakijken of het ingegeven paswoord overeen komt met het paswoord van in de database				
				try{
					Hashing hashing = new Hashing();
//					System.out.println(gebruiker2.getWachtwoord());
//					System.out.println(hashing.hashPaswoord(String.valueOf(view.getPasswordText().getPassword())));
					
				 if (Objects.equals(gebruiker.getWachtwoord(), new String(hashing.hashPaswoord(String.valueOf(view.getPasswordText().getPassword()))))) {
					optionPane.showMessageDialog(null, "Je bent met succes ingelogd!");
					view.getPanel().removeAll();
					view.setPanelToNull();
					view.initialiseSecondPanel();
					view.add(view.getPanel());
					view.setVisible(true);
				} else {
					optionPane.showMessageDialog(null, "Foutieve gegevens, probeer opniew!");
					view.getGebruikerText().setText("");
					view.getPasswordText().setText("");
				}
				}
				catch(NullPointerException x)
				{
					optionPane.showMessageDialog(null, "Foutieve gegevens, probeer opniew!");
					view.getGebruikerText().setText("");
					view.getPasswordText().setText("");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		view.getCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});
	}
}
