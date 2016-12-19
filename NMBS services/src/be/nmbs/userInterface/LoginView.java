package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import be.nmbs.controllers.LoginController;

public class LoginView {
	private static JLabel userLabel;
	private static JLabel passwordLabel;
	private static JTextField gebruikerText;
	private static JPasswordField passwordText;
	private static JButton login;
	private static JButton closeApp;
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static LoginController loginController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		userLabel = new JLabel("Gebruikersnaam");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(userLabel, c);

		gebruikerText = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(gebruikerText, c);

		passwordLabel = new JLabel("Wachtwoord");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(passwordLabel, c);

		passwordText = new JPasswordField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(passwordText, c);

		login = new JButton("Inloggen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(login, c);

		closeApp = new JButton("Sluiten");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(closeApp, c);
		loginController = new LoginController(view);
		
		//Dit zorgt ervoor dat de code die in de actionlistener staat wordt afgevuurd als enter ingeduwd wordt
		View.frame.getRootPane().setDefaultButton(login);
		
		return panel;
	}

	public JLabel getUserLabel() {
		return userLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public static JTextField getGebruikerText() {
		return gebruikerText;
	}

	public static JPasswordField getPasswordText() {
		return passwordText;
	}

	public static JButton getLogin() {
		return login;
	}

	public static JButton getCloseApp() {
		return closeApp;
	}
	
	public static void setLoginControllerToNull() {
		loginController = null;
	}
}
