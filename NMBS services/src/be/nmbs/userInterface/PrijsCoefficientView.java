package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.PrijsCoefficientController;

public class PrijsCoefficientView {

	private static JButton goBackToHome;
	private static JButton voorTicket;
	private static JButton voorAbo;
	private static JPanel panel;
	private static PrijsCoefficientController prijsCoefficientController;

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
		
		goBackToHome = new JButton("Back");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(goBackToHome, c);

		prijsCoefficientController = new PrijsCoefficientController(view);
		return panel;
	}

	public static JButton getVoorTicket() {
		return voorTicket;
	}

	public static void setVoorTicket(JButton voorTicket) {
		PrijsCoefficientView.voorTicket = voorTicket;
	}

	public static JButton getVoorAbo() {
		return voorAbo;
	}

	public static void setVoorAbo(JButton voorAbo) {
		PrijsCoefficientView.voorAbo = voorAbo;
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

	public static PrijsCoefficientController getPrijsCoefficientController() {
		return prijsCoefficientController;
	}

	public static void setPrijsCoefficientController(PrijsCoefficientController prijsCoefficientController) {
		PrijsCoefficientView.prijsCoefficientController = prijsCoefficientController;
	}

	public static void setPrijsCoefficientControllerToNull() {
		prijsCoefficientController = null;
	}
}
