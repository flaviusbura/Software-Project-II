package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class View extends JFrame {
	private JPanel panel;
	private JLabel userLabel;
	private JLabel passwordLabel;
	private JTextField gebruikerText;
	private JPasswordField passwordText;
	private JButton ok;
	private JButton secondButton;
	
	public JButton getCancel() {
		return cancel;
	}

	private JButton cancel;
	
	public View() {
		this.setTitle("LoginApp");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initialiseLoginPanel();
		
		//this.add(getPanel());
	}
	
	public JTextField getGebruikerText() {
		return gebruikerText;
	}

	public JPasswordField getPasswordText() {
		return passwordText;
	}

	public void initialiseLoginPanel() {
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
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public JButton getOk() {
		return ok;
	}
	
	@SuppressWarnings("static-access")
	public void initialiseSecondPanel() {
		panel = new JPanel();
		
		secondButton = new JButton("Second Button");
		GridBagConstraints c = new GridBagConstraints();
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(secondButton, c);
	}
	
	public void setPanelToNull() {
		panel = null;
	}
}
