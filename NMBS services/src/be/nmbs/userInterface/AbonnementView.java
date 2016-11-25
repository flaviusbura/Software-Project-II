package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.AbonnementController;
import be.nmbs.controllers.HomeController;

public class AbonnementView {
	private static JButton maakAbonnement;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static HomeController homeController;
	private static AbonnementController abonnementController;
	
	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());

		maakAbonnement = new JButton("Abonnement aanmaken");
		GridBagConstraints c = new GridBagConstraints();
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(maakAbonnement, c);

		goBackToHome = new JButton("Go Back To Home");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(goBackToHome, c);
			homeController = new HomeController(view);
			abonnementController = new AbonnementController(view);
		return panel;
	}

	public static JButton getMaakAbonnement() {
		return maakAbonnement;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}
	
	public static void setHomeControllerToNull() {
		homeController = null;
	}
	
	public static void setAbonnementControllerToNull() {
		abonnementController = null;
	}
}
