package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
	private static JButton ok;
	private static JButton cancel;
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static LoginController loginController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		userLabel = new JLabel("username");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(userLabel, c);

		gebruikerText = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(gebruikerText, c);

		passwordLabel = new JLabel("password");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(passwordLabel, c);

		passwordText = new JPasswordField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(passwordText, c);

		ok = new JButton("Ok");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(ok, c);

		cancel = new JButton("cancel");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(cancel, c);
		loginController = new LoginController(view);
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

	public static JButton getOk() {
		return ok;
	}

	public static JButton getCancel() {
		return cancel;
	}
	
	public static void setLoginControllerToNull() {
		loginController = null;
	}
}
