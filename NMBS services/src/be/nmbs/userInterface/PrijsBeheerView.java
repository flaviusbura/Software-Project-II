package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.PrijsBeheerController;

public class PrijsBeheerView {

	private static JButton prijs;
	private static JButton goBackToHome;
	private static JButton coefficient;
	private static JPanel panel;
	private static HomeController homeController;
	private static PrijsBeheerController prijsBeheerController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		

		// buttons
		prijs = new JButton("Prijzen");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(prijs, c);
		
		coefficient = new JButton("Coefficient");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(coefficient, c);
		
		goBackToHome = new JButton("Back");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(goBackToHome, c);
		
	
		
		homeController = new HomeController(view);
		prijsBeheerController = new PrijsBeheerController(view);
		return panel;
	}

	public static JButton getPrijs() {
		return prijs;
	}

	public static void setPrijs(JButton prijs) {
		PrijsBeheerView.prijs = prijs;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		PrijsBeheerView.goBackToHome = goBackToHome;
	}

	public static JButton getCoefficient() {
		return coefficient;
	}

	public static void setCoefficient(JButton coefficient) {
		PrijsBeheerView.coefficient = coefficient;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		PrijsBeheerView.panel = panel;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		PrijsBeheerView.homeController = homeController;
	}

	public static PrijsBeheerController getPrijsBeheerController() {
		return prijsBeheerController;
	}

	public static void setPrijsBeheerController(PrijsBeheerController prijsBeheerController) {
		PrijsBeheerView.prijsBeheerController = prijsBeheerController;
	}
	
	public static void setPrijsBeheerControllerToNull() {
		prijsBeheerController = null;
	}
}
