package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.AbonnementController;

public class AbonnementView {
	private static JButton nieuwAboMaken;
	private static JButton aboVerlengen;
	private static JButton aboZoeken;
	private static JButton home;
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static AbonnementController abonnementController;
	
	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());

		nieuwAboMaken = new JButton("Nieuw abonnement maken");
		GridBagConstraints c = new GridBagConstraints();
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(nieuwAboMaken, c);
		
		aboVerlengen = new JButton("Abonnement Verlengen");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(aboVerlengen, c);
		
		aboZoeken = new JButton("Abonnement zoeken");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(aboZoeken, c);

		home = new JButton("Home");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(home, c);
			abonnementController = new AbonnementController(view);
		return panel;
	}
	
	public static JButton getNieuwAboMaken() {
		return nieuwAboMaken;
	}

	public static JButton getAboVerlengen() {
		return aboVerlengen;
	}

	public static JButton getAboZoeken() {
		return aboZoeken;
	}

	public static JButton getHome() {
		return home;
	}
	
	public static void setAbonnementControllerToNull() {
		abonnementController = null;
	}
}
