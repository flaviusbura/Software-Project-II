package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.PrijsCoefficient_AbonnementController;

public class PrijsCoefficient_AbonnementView {
	
	private static JButton update;
	private static JButton goBackToHome;
	private static JButton delete;
	private static JButton insert;
	private static JPanel panel;
	private static HomeController homeController;
	private static PrijsCoefficient_AbonnementController prijsCoefficient_AbonnementController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		

		// buttons
		insert = new JButton("Coefficient toevoegen");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(insert, c);
		
		delete = new JButton("Coefficient verwijderen");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(delete, c);

		update = new JButton("Coefficient updaten");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(update, c);
		
		goBackToHome = new JButton("Back");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(goBackToHome, c);
		
	
		
		homeController = new HomeController(view);
		prijsCoefficient_AbonnementController = new PrijsCoefficient_AbonnementController(view);
		return panel;
	}

	public static JButton getUpdate() {
		return update;
	}

	public static void setUpdate(JButton update) {
		PrijsCoefficient_AbonnementView.update = update;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		PrijsCoefficient_AbonnementView.goBackToHome = goBackToHome;
	}

	public static JButton getDelete() {
		return delete;
	}

	public static void setDelete(JButton delete) {
		PrijsCoefficient_AbonnementView.delete = delete;
	}

	public static JButton getInsert() {
		return insert;
	}

	public static void setInsert(JButton insert) {
		PrijsCoefficient_AbonnementView.insert = insert;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		PrijsCoefficient_AbonnementView.panel = panel;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		PrijsCoefficient_AbonnementView.homeController = homeController;
	}

	public static PrijsCoefficient_AbonnementController getPrijsCoefficient_AbonnementController() {
		return prijsCoefficient_AbonnementController;
	}

	public static void setPrijsCoefficient_AbonnementController(
			PrijsCoefficient_AbonnementController prijsCoefficient_AbonnementController) {
		PrijsCoefficient_AbonnementView.prijsCoefficient_AbonnementController = prijsCoefficient_AbonnementController;
	}

	public static void setPrijsCoefficient_AbonnementControllerToNull()
	{
		prijsCoefficient_AbonnementController = null;
	}

	public static void setHomeControllerToNull() {
		homeController = null; 
		
	}
}
