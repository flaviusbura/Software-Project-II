package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginSchermView {
	private static JLabel userLabel;
	private static JLabel passwordLabel;
	private static JTextField gebruikerText;
	private static JPasswordField passwordText;
	private static JButton ok;
	private static JButton cancel;
	
	
	public JLabel getUserLabel() {
		return userLabel;
	}


	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}


	public JLabel getPasswordLabel() {
		return passwordLabel;
	}


	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}


	public static JTextField getGebruikerText() {
		return gebruikerText;
	}


	public void setGebruikerText(JTextField gebruikerText) {
		this.gebruikerText = gebruikerText;
	}


	public static JPasswordField getPasswordText() {
		return passwordText;
	}


	public void setPasswordText(JPasswordField passwordText) {
		this.passwordText = passwordText;
	}


	public static JButton getOk() {
		return ok;
	}


	public void setOk(JButton ok) {
		this.ok = ok;
	}


	public static JButton getCancel() {
		return cancel;
	}


	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}


	public static JPanel initialiseView() {
		JPanel panel = new JPanel();
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
		return panel;
	}
}
