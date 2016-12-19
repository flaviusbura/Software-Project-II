package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.PrijsCoefficient_TicketController;

public class PrijsCoefficient_TicketView {
	private static JButton update;
	private static JButton goBackToHome;
	private static JButton delete;
	private static JButton insert;
	private static JPanel panel;
	private static HomeController homeController;
	private static PrijsCoefficient_TicketController prijsCoefficient_TicketController;

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
		prijsCoefficient_TicketController = new PrijsCoefficient_TicketController(view);
		return panel;
	}
	public static void setHomeControllerToNull()
	{
		homeController = null;
	}
	public static void setPrijsCoefficient_TicketControllerToNull()
	{
		prijsCoefficient_TicketController = null;
	}
	public static JButton getUpdate() {
		return update;
	}
	public static void setUpdate(JButton update) {
		PrijsCoefficient_TicketView.update = update;
	}
	public static JButton getGoBackToHome() {
		return goBackToHome;
	}
	public static void setGoBackToHome(JButton goBackToHome) {
		PrijsCoefficient_TicketView.goBackToHome = goBackToHome;
	}
	public static JButton getDelete() {
		return delete;
	}
	public static void setDelete(JButton delete) {
		PrijsCoefficient_TicketView.delete = delete;
	}
	public static JButton getInsert() {
		return insert;
	}
	public static void setInsert(JButton insert) {
		PrijsCoefficient_TicketView.insert = insert;
	}
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		PrijsCoefficient_TicketView.panel = panel;
	}
	public static HomeController getHomeController() {
		return homeController;
	}
	public static void setHomeController(HomeController homeController) {
		PrijsCoefficient_TicketView.homeController = homeController;
	}
	public static PrijsCoefficient_TicketController getPrijsCoefficient_TicketController() {
		return prijsCoefficient_TicketController;
	}
	public static void setPrijsCoefficient_TicketController(
			PrijsCoefficient_TicketController prijsCoefficient_TicketController) {
		PrijsCoefficient_TicketView.prijsCoefficient_TicketController = prijsCoefficient_TicketController;
	}
	
}
