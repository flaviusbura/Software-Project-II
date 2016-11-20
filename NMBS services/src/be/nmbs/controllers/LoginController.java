package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;

import be.nmbs.userInterface.View;


public class LoginController {
	private Gebruiker gebruiker;
	private View view;
	private GebruikerDAO gebruikerDAO;
	private Gebruiker gebruiker2;
	public LoginController() {
		view = new View();

		view.add(view.getPanel());
		view.setVisible(true);
		view.getOk().addActionListener(new ActionListener() {
			
			@SuppressWarnings({ "deprecation", "static-access" })
			@Override
			public void actionPerformed(ActionEvent e) {
				gebruiker = new Gebruiker();
				gebruiker.setVoornaam(view.getGebruikerText().getText());
				gebruiker.setWachtwoord(String.valueOf(view.getPasswordText().getPassword()));
				gebruiker2 = new Gebruiker();
				gebruikerDAO = new GebruikerDAO();
				gebruiker2 = gebruikerDAO.getGebruikerOpUsername(view.getGebruikerText().getText());
				
				if(gebruiker == null)
				{
					System.out.println("gebruiker");
					
				}
				if(gebruiker2 == null)
				{
					System.out.println("gebruiker2");
					
				}
				JOptionPane optionPane = new JOptionPane(view.getGebruikerText().getText());
				try{
				
				 if (gebruiker2.getWachtwoord().equals(String.valueOf(view.getPasswordText().getPassword()))) {
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
