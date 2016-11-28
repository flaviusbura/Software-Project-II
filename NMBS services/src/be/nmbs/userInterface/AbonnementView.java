package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.AbonnementController;
import be.nmbs.controllers.HomeController;
/**
 * 
 * @author Abdel-Portable
 *
 */
public class AbonnementView {
	private static JButton maakAbonnement;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JLabel lblKlant_Contact;
	private static JTextField txtKlant_Contact;
	@SuppressWarnings("unused")
	private static HomeController homeController;
	@SuppressWarnings("unused")
	private static AbonnementController abonnementController;
	
	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		lblKlant_Contact = new JLabel("Klant");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lblKlant_Contact, c);
		
		txtKlant_Contact = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(txtKlant_Contact, c);
		
		maakAbonnement = new JButton("Abonnement aanmaken");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 9;
		c.gridy = 9;
		panel.add(maakAbonnement, c);

		goBackToHome = new JButton("Go Back To Home");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 9;
		c.gridy = 10;
		panel.add(goBackToHome, c);
			homeController = new HomeController(view);
			abonnementController = new AbonnementController(view);
		return panel;
	}

	public static JButton getMaakAbonnement() {
		return maakAbonnement;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}
	
	public static void setHomeControllerToNull() {
		homeController = null;
	}
	
	public static void setAbonnementControllerToNull() {
		abonnementController = null;
	}
}
