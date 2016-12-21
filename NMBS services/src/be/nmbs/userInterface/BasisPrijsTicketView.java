package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.BasisPrijsAbonnementController;
import be.nmbs.controllers.BasisPrijsTicketController;
import be.nmbs.controllers.HomeController;

public class BasisPrijsTicketView {
	private static JButton update;
	private static JButton goBackToHome;
	private static JButton delete;
	private static JButton insert;
	private static JPanel panel;

	private static BasisPrijsTicketController basisPrijsTicketController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// buttons
		insert = new JButton("Prijs toevoegen");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(insert, c);

		delete = new JButton("Prijs verwijderen");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(delete, c);

		update = new JButton("Prijs updaten");
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

		basisPrijsTicketController = new BasisPrijsTicketController(view);
		return panel;
	}

	public static void setBasisPrijsTicketControllerToNull() {
		basisPrijsTicketController = null;
	}

	public static JButton getUpdate() {
		return update;
	}

	public static void setUpdate(JButton update) {
		BasisPrijsTicketView.update = update;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		BasisPrijsTicketView.goBackToHome = goBackToHome;
	}

	public static JButton getDelete() {
		return delete;
	}

	public static void setDelete(JButton delete) {
		BasisPrijsTicketView.delete = delete;
	}

	public static JButton getInsert() {
		return insert;
	}

	public static void setInsert(JButton insert) {
		BasisPrijsTicketView.insert = insert;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		BasisPrijsTicketView.panel = panel;
	}

	public static BasisPrijsTicketController getBasisPrijsTicketController() {
		return basisPrijsTicketController;
	}

	public static void setBasisPrijsTicketController(BasisPrijsTicketController basisPrijsTicketController) {
		BasisPrijsTicketView.basisPrijsTicketController = basisPrijsTicketController;
	}
	

}
