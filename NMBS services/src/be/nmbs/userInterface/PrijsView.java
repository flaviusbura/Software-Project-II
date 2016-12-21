package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.AbonnementController;
import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.PrijsController;

public class PrijsView {
	private static JButton goBackToHome;
	private static JButton voorAbo;
	private static JButton voorTicket;
	private static JPanel panel;
	private static PrijsController prijsController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		

		voorTicket = new JButton("Voor Ticket");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(voorTicket, c);
		
		voorAbo = new JButton("Voor Abonnement");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(voorAbo, c);
		
		goBackToHome = new JButton("Home");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(goBackToHome, c);
		
		prijsController = new PrijsController(view);
		return panel;
	}

	public static JButton getVoorAbo() {
		return voorAbo;
	}

	public static void setVoorAbo(JButton abo) {
		PrijsView.voorAbo = abo;
	}

	public static JButton getVoorTicket() {
		return voorTicket;
	}

	public static void setVoorTicket(JButton ticket) {
		PrijsView.voorTicket = ticket;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		PrijsView.goBackToHome = goBackToHome;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		PrijsView.panel = panel;
	}

	public static void setPrijsControllerToNull() {
		prijsController = null;
	}
	public static PrijsController getPrijsController() {
		return prijsController;
	}

	public static void setPrijsController(PrijsController prijsController) {
		PrijsView.prijsController = prijsController;
	}
	
}
