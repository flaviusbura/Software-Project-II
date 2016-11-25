package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.HomeController;

public class HomeView {
	private static JButton btnAbonnement;
	private static JButton btnBoete;
	private static JButton btnTicket;
	private static JButton btnVerlorenvoorwerpen;
	private static JButton btnOpzoeken;
	private static JPanel panel;
	private static HomeController homeController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());

			btnAbonnement = new JButton("Abonnementen");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(btnAbonnement, c);

			btnTicket = new JButton("Tickets");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			panel.add(btnTicket, c);

			btnVerlorenvoorwerpen = new JButton("Verlorenvoorwerpen");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(btnVerlorenvoorwerpen, c);

			btnBoete = new JButton("Boetes");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			panel.add(btnBoete, c);

			btnOpzoeken = new JButton("Trein opzoeken");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			panel.add(btnOpzoeken, c);
			homeController = new HomeController(view);
			return panel;
	}

	public static void setHomeControllerToNull() {
		homeController = null;
	}

	public static JButton getBtnAbonnement() {
		return btnAbonnement;
	}
}
