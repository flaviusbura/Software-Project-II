package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.PrijsCoefficientController;

public class PrijsCoefficientView {
	
	private static JButton goBackToHome;
	private static JPanel panel;
	private static HomeController homeController;
	private static PrijsCoefficientController prijsCoefficientController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	
		goBackToHome = new JButton("Back");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(goBackToHome, c);
		
		homeController = new HomeController(view);
		prijsCoefficientController = new PrijsCoefficientController(view);
		return panel;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		PrijsCoefficientView.goBackToHome = goBackToHome;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		PrijsCoefficientView.panel = panel;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		PrijsCoefficientView.homeController = homeController;
	}

	public static PrijsCoefficientController getPrijsCoefficientController() {
		return prijsCoefficientController;
	}

	public static void setPrijsCoefficientController(PrijsCoefficientController prijsCoefficientController) {
		PrijsCoefficientView.prijsCoefficientController = prijsCoefficientController;
	}
	
	public static void setPrijsCoefficientControllerToNull() {
		prijsCoefficientController = null;
	}

	public static void setHomeControllerToNull() {
		homeController = null;
		
	}
}

