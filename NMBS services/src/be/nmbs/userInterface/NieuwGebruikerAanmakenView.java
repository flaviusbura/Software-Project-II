package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import be.nmbs.controllers.NieuwGebruikerAanmakenController;
import be.nmbs.exceptions.EnkelLettersException;
import be.nmbs.exceptions.PasswordNotMatchException;
import be.nmbs.logic.Gebruiker;
import be.nmbs.logic.VeiligeInvoer;

public class NieuwGebruikerAanmakenView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final String[] labelTexts = { "Voornaam", "Achternaam", "Gebruikersnaam", "Wachtwoord", "Wachtwoord bevestigen", "Rol" };
	private JLabel infoLabel;
	
	private final JTextField firstNameTextField = new JTextField();
	private final JTextField lastNameTextField = new JTextField();
	private final JTextField usernameTextField = new JTextField();
	private final JPasswordField passwordField = new JPasswordField();
	private final JPasswordField passwordConfirmField = new JPasswordField();
	private final JComboBox<String> roleComboBox = new JComboBox<String>(new String[]{"Gebruiker", "Administrator"});
	private final JButton addButton = new JButton("Toevoegen");
	private final JButton backButton = new JButton("Terug");

	private final NieuwGebruikerAanmakenController nieuwGebruikerAanmakenController = new NieuwGebruikerAanmakenController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Alle labels adden
		infoLabel = new JLabel(labelTexts[0]);
		c.gridx = 0;
		c.gridy = 0;
		panel.add(infoLabel, c);
		
		infoLabel = new JLabel(labelTexts[1]);
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(infoLabel, c);
		
		infoLabel = new JLabel(labelTexts[2]);
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(infoLabel, c);

		infoLabel = new JLabel(labelTexts[3]);
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(infoLabel, c);

		infoLabel = new JLabel(labelTexts[4]);
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 4;
		panel.add(infoLabel, c);
		
		infoLabel = new JLabel(labelTexts[5]);
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 5;
		panel.add(infoLabel, c);
		
		// Add First Name Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(firstNameTextField, c);

		// Add Last Name Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(lastNameTextField, c);

		// Add Username Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(usernameTextField, c);
		
		// Add Password Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(passwordField, c);
		
		// Add Password Confirm Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 4;
		panel.add(passwordConfirmField, c);

		// Add Role Combobox
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 5;
		panel.add(roleComboBox, c);
		
		// Add Add Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 6;
		panel.add(addButton, c);
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int rol = 0;
				String secureWachtwoord = "", voornaam, achternaam, username, wachtwoord1, wachtwoord2;
				
				Gebruiker g = null;
				try {
					voornaam = firstNameTextField.getText();
					if (VeiligeInvoer.checkForOnlyLetters(voornaam) == false) {
						throw new EnkelLettersException();
					}
					
					achternaam = lastNameTextField.getText();
					if (VeiligeInvoer.checkForOnlyLetters(achternaam) == false) {
						throw new EnkelLettersException();
					}
					
					username = usernameTextField.getText();
					if (VeiligeInvoer.checkForOnlyLetters(username) == false) {
						throw new EnkelLettersException();
					}
					
					wachtwoord1 = String.valueOf(passwordField.getPassword());
					wachtwoord2 = String.valueOf(passwordConfirmField.getPassword());
					if (!(wachtwoord1.equals(wachtwoord2))) {
						throw new PasswordNotMatchException();
					} else {
						secureWachtwoord = nieuwGebruikerAanmakenController.hashPassword(wachtwoord1);
					}
					
					String selectedItem = roleComboBox.getSelectedItem().toString();
					if (selectedItem.equals("Administrator")) {
						rol = 2;
					} else {
						rol = 1;
					}
					
					g = new Gebruiker(1, voornaam, achternaam, username, secureWachtwoord, rol, true);
				} catch (EnkelLettersException ex) {
					JOptionPane.showMessageDialog(null,
							"De velden mogen niet leeg zijn en/of andere\nkarakters dan letters bevatten.");
				} catch (PasswordNotMatchException ex) {
					JOptionPane.showMessageDialog(null, "Wachtwoorden matchen niet, probeer opnieuw!");
				}
				
				if ( g == null || nieuwGebruikerAanmakenController.addUser(g)) {
					JOptionPane.showMessageDialog(null, "Er bestaat reeds een gebruiker met deze username!");
				} else {
					JOptionPane.showMessageDialog(null, "Uw gebruiker is toegevoegd geweest!");
					GebruikerBeheerView newView = new GebruikerBeheerView();
					view.changeView(newView.initialize(view));
				}
			}
		});
		
		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 6;
		panel.add(backButton, c);

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GebruikerBeheerView newView = new GebruikerBeheerView();
				view.changeView(newView.initialize(view));
			}
		});
		
		return panel;
	}
}