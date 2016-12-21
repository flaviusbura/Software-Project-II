package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import be.nmbs.controllers.LoginController;
import be.nmbs.logic.Gebruiker;

public class LoginView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JLabel userLabel = new JLabel("Gebruikersnaam");
	private final JLabel passwordLabel = new JLabel("Wachtwoord");
	
	private final JTextField gebruikerTextField = new JTextField(10);
	private final JPasswordField passwordTextField = new JPasswordField(10);
	
	private final JButton loginButton = new JButton("Inloggen");
	private final JButton closeButton = new JButton("Sluiten");

	private final LoginController loginController = new LoginController();
	
	private Gebruiker g;

	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// Add User Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(userLabel, c);

		// Add Gebuiker Text Field
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(gebruikerTextField, c);

		// Add Password Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(passwordLabel, c);

		// Add Password Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(passwordTextField, c);

		// Add Login Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(loginButton, c);
		
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {			
				g = loginController.getGebruiker(gebruikerTextField.getText());

				/*
				 * Nakijken of het ingegeven paswoord overeen komt met het
				 * paswoord van in de database
				 */
				try {
					if (Objects.equals(g.getWachtwoord(), loginController.hashPassword(String.valueOf(passwordTextField.getPassword()))) && g.isActief()) {
						JOptionPane.showMessageDialog(null, "Je bent met succes ingelogd!");
						View.setIngelogdGebruiker(g);
						
						HomeView newView = new HomeView();
						view.changeView(newView.initialize(view));
					} else {
						JOptionPane.showMessageDialog(null, "Foutieve gegevens, probeer opniew!");
						passwordTextField.setText("");
					}
				} catch (HeadlessException e1) {
					JOptionPane.showMessageDialog(null, "Foutieve gegevens, probeer opniew!");
					passwordTextField.setText("");
				} catch (NullPointerException e3) {
					JOptionPane.showMessageDialog(null, "Foutieve gegevens, probeer opniew!");
					passwordTextField.setText("");
				}
			}
		});

		// Add Close Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(closeButton, c);
		
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});
		
		//Dit zorgt ervoor dat de code die in de actionlistener staat wordt afgevuurd als enter ingeduwd wordt
		view.getRootPane().setDefaultButton(loginButton);
		
		return panel;
	}
}
