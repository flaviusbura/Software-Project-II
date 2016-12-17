package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import be.nmbs.controllers.HomeController;

public class HomeView {
	private static JButton btnAbonnement;
	private static JButton btnBoete;
	private static JButton btnTicket;
	private static JButton btnVerlorenvoorwerpen;
	private static JButton btnRoutes;
	private static JButton btnTrains;
	private static JButton logOut;
	private static JButton klantenBeheer;
	private static JButton gebruikersBeheer;
	private static JButton statistieken;
	private static JButton prijzenBeheer;
	private static JLabel admin;
	private static JPanel panel;

	@SuppressWarnings("unused")
	private static HomeController homeController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		if (View.getIngelogdGebruiker().getRol() == 2) {
			admin = new JLabel("Admin");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(20, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 2;
			panel.add(admin, c);
			
			gebruikersBeheer = new JButton("Gebruikersbeheer");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 3;
			panel.add(gebruikersBeheer, c);

			prijzenBeheer = new JButton("Prijzenbeheer");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 3;
			panel.add(prijzenBeheer, c);
			
			statistieken = new JButton("Statistieken");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 2;
			c.gridy = 3;
			panel.add(statistieken, c);
		}

		btnAbonnement = new JButton("Abonnementen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		panel.add(btnAbonnement, c);

		btnTicket = new JButton("Tickets");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(btnTicket, c);

		btnVerlorenvoorwerpen = new JButton("Verloren voorwerpen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 0;
		panel.add(btnVerlorenvoorwerpen, c);

		btnBoete = new JButton("Boetes");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 3;
		c.gridy = 0;
		panel.add(btnBoete, c);

		btnRoutes = new JButton("Routes zoeken");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(btnRoutes, c);
		
		klantenBeheer = new JButton("Klantenbeheer");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(klantenBeheer, c);
		
		setBtnTrains(new JButton("Treinen zoeken"));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 2;
		c.gridy = 1;
		panel.add(btnTrains, c);
		
		logOut = new JButton("Uitloggen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 3;
		c.gridy = 1;
		panel.add(logOut, c);
		
		homeController = new HomeController(view);
		return panel;
	}

	// Getters
	public static JButton getGebruikersBeheer() {
		return gebruikersBeheer;
	}
	
	public static JButton getKlantenBeheer() {
		return klantenBeheer;
	}

	public static JButton getBtnBoete() {
		return btnBoete;
	}

	public static JButton getBtnAbonnement() {
		return btnAbonnement;
	}

	public static JButton getLogOut() {
		return logOut;
	}

	public static JButton getBtnTicket() {
		return btnTicket;
	}

	public static JButton getBtnVerlorenvoorwerpen() {
		return btnVerlorenvoorwerpen;
	}
	
	public static JButton getBtnRoutes() {
		return btnRoutes;
	}

	public static JButton getStatistieken() {
		return statistieken;
	}

	public static JButton getPrijzenBeheer() {
		return prijzenBeheer;
	}

	public static JButton getBtnTrains() {
		return btnTrains;
	}

	// Setters
	public static void setBtnBoete(JButton btnBoete) {
		HomeView.btnBoete = btnBoete;
	}

	public static void setHomeControllerToNull() {
		homeController = null;
	}

	public static void setBtnTicket(JButton btnTicket) {
		HomeView.btnTicket = btnTicket;
	}

	public static void setBtnVerlorenvoorwerpen(JButton btnVerlorenvoorwerpen) {
		HomeView.btnVerlorenvoorwerpen = btnVerlorenvoorwerpen;
	}

	public static void setBtnRoutes(JButton btnRoutes) {
		HomeView.btnRoutes = btnRoutes;
	}

	public static void setBtnTrains(JButton btnTrains) {
		HomeView.btnTrains = btnTrains;
	}
}
