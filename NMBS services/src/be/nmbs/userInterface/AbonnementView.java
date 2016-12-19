package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.AbonnementController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.PrijsDAO;
import be.nmbs.logic.Prijs;

import be.nmbs.database.KlantDAO;
import be.nmbs.logic.Klant;

import be.nmbs.database.KortingDAO;
import be.nmbs.logic.Korting;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;

/**
 * 
 * @author Abdel-Portable
 *
 */
public class AbonnementView {
	private static JButton maakAbonnement;
	private static JButton goBackToHome;
	private static JButton verlengAbonnement;
	private static JPanel panel;
	private static HomeController homeController;
	private static AbonnementController abonnementController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		

		// buttons
		maakAbonnement = new JButton("Abonnement aanmaken");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(maakAbonnement, c);
		
		//verlengDrieMaanden
		verlengAbonnement = new JButton("Abonnement verlengen");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(verlengAbonnement, c);
		
		goBackToHome = new JButton("Back");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(goBackToHome, c);
		
	
		
		homeController = new HomeController(view);
		abonnementController = new AbonnementController(view);
		return panel;
	}

	public static void setVerlengAbonnement(JButton verlengAbonnement) {
		AbonnementView.verlengAbonnement = verlengAbonnement;
	}

	public static JButton getMaakAbonnement() {
		return maakAbonnement;
	}

	public static void setMaakAbonnement(JButton maakAbonnement) {
		AbonnementView.maakAbonnement = maakAbonnement;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		AbonnementView.goBackToHome = goBackToHome;
	}

	public static JButton getVerlengAbonnement() {
		return verlengAbonnement;
	}

	public static void setVerlengDrieMaanden(JButton verlengDrieMaanden) {
		AbonnementView.verlengAbonnement = verlengDrieMaanden;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		AbonnementView.panel = panel;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		AbonnementView.homeController = homeController;
	}

	public static AbonnementController getAbonnementController() {
		return abonnementController;
	}

	public static void setAbonnementController(AbonnementController abonnementController) {
		AbonnementView.abonnementController = abonnementController;
	}

	public static void setAbonnementControllerToNull() {
		abonnementController = null;
	}
	
	public static void setHomeControllerToNull() {
		homeController = null;
	}


}
