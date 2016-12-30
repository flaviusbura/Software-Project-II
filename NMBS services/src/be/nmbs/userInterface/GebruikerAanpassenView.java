package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import be.nmbs.controllers.GebruikerAanpassenController;
import be.nmbs.logic.Gebruiker;

public class GebruikerAanpassenView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final String[] labelTexts = { "Voornaam", "Achternaam", "Gebruikersnaam", "Wachtwoord", "Rol", "Actief" };
	private JLabel infoLabel;
	
	private final JTextField firstNameTextField = new JTextField();
	private final JTextField lastNameTextField = new JTextField();
	private final JTextField usernameTextField = new JTextField();
	private final JPasswordField passwordField = new JPasswordField();
	private final JComboBox<String> roleComboBox = new JComboBox<String>();
	private final JCheckBox activeCheckBox = new JCheckBox();
	private final JButton saveButton = new JButton("Gebruiker opslaan");
	private final JButton backButton = new JButton("Terug");
	
	private GebruikerAanpassenController gebruikerAanpassenController = new GebruikerAanpassenController();

	public JPanel initialize(View view, Gebruiker gebruiker) {
		// Alle info inladen
		firstNameTextField.setText(gebruiker.getVoornaam());
		lastNameTextField.setText(gebruiker.getAchternaam());
		usernameTextField.setText(gebruiker.getUsername());
		
		// Vanaf RoleCombo alles nog toevoegen
		roleComboBox.addItem("Gebruiker");
		roleComboBox.addItem("Administrator");
		
		if (gebruiker.getRol() == 1) {
			roleComboBox.setSelectedIndex(0);
		} else {
			roleComboBox.setSelectedIndex(1);
		}
		
		if (gebruiker.isActief()) {
			activeCheckBox.setSelected(true);
		}
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// Info labels toevoegen
		infoLabel = new JLabel(labelTexts[0]);
		c.insets = new Insets(5, 0, 0, 0);
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

		// Add Role Combobox
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 4;
		panel.add(roleComboBox, c);

		// Add Active Checkbox
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 5;
		panel.add(activeCheckBox, c);
		
		// Add Save Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 6;
		panel.add(saveButton, c);
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Gebruiker g = gebruikerAanpassenController.getGebruiker(usernameTextField.getText());
				
				if (g != null && g.getId() != gebruiker.getId()) {
					JOptionPane.showMessageDialog(null, "FOUT: Gebruikersnaam al in gebruik.");
				} else {
					g = new Gebruiker();
					g.setId(gebruiker.getId());
					g.setVoornaam(firstNameTextField.getText());
					g.setAchternaam(lastNameTextField.getText());
					g.setUsername(usernameTextField.getText());
					
					if (!passwordField.getPassword().toString().isEmpty()) {
						g.setWachtwoord(gebruikerAanpassenController.hashPassword(String.valueOf(passwordField.getPassword())));
					} else {
						g.setWachtwoord(gebruiker.getWachtwoord());
					}
					
					if (roleComboBox.getSelectedIndex() == 0) {
						g.setRol(1);
					} else {
						g.setRol(2);
					}
					
					g.setActief(activeCheckBox.isSelected());
					
					if (gebruikerAanpassenController.updateGebruiker(g)) {
						JOptionPane.showMessageDialog(null, "Gebruiker is succesvol aangepast!");
						GebruikerBeheerView newView = new GebruikerBeheerView();
						view.changeView(newView.initialize(view));
					} else {
						JOptionPane.showMessageDialog(null, "Er is iets foutgegaan bij het opslaan van de gebruiker.");
					}
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
