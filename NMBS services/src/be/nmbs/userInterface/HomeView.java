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
	private static JButton btnStatistieken;
	private static JButton prijzenBeheer;
	private static JButton btnPush;
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
			
			btnStatistieken = new JButton("Statistieken");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 2;
			c.gridy = 3;
			panel.add(btnStatistieken, c);
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
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(btnTrains, c);
		
		btnPush = new JButton("Offline gegevens doorsturen");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(btnPush, c);
		
		logOut = new JButton("Log out");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(logOut, c);
		
		homeController = new HomeController(view);
		return panel;
	}

	public static JButton getBtnPush() {
		return btnPush;
	}

	public static void setBtnPush(JButton btnPush) {
		HomeView.btnPush = btnPush;
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

	public static JButton getBtnStatistieken() {
		return btnStatistieken;
	}

	public static JButton getPrijzenBeheer() {
		return prijzenBeheer;
	}

	public static JButton getBtnTrains() {
		return btnTrains;
	}

	public static void setBtnTrains(JButton btnTrains) {
		HomeView.btnTrains = btnTrains;
	}
}
