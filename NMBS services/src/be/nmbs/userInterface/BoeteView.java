package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import be.nmbs.controllers.BoeteController;
import be.nmbs.controllers.HomeController;

public class BoeteView {
	private static JButton maakBoete;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JFrame gui;
	@SuppressWarnings("unused")
	private static HomeController homeController;
	@SuppressWarnings("unused")
	private static BoeteController boeteController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		
		maakBoete = new JButton("Boete aanmaken");
		GridBagConstraints c = new GridBagConstraints();
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		

		goBackToHome = new JButton("Go Back To Home");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(goBackToHome, c);
		homeController = new HomeController(view);
		boeteController = new BoeteController(view);
		return panel;
	}

	public static JButton getMaakBoete() {
		return maakBoete;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setHomeControllerToNull() {
		homeController = null;
	}

	public static void setBoeteControllerToNull() {
		boeteController = null;
	}
	
}
