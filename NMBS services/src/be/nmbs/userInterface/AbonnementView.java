package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.AbonnementController;
import be.nmbs.controllers.HomeController;

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
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(maakAbonnement, c);
		
		//verlengDrieMaanden
		verlengAbonnement = new JButton("Abonnement verlengen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(verlengAbonnement, c);
		
		goBackToHome = new JButton("Back");
		c.fill = GridBagConstraints.HORIZONTAL;
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
