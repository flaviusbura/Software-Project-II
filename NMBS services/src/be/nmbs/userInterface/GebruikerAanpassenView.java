package be.nmbs.userInterface;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.GebruikerAanpassenController;
import be.nmbs.logic.Gebruiker;

public class GebruikerAanpassenView {
	private static JLabel info;
	private static JTextField firstName;
	private static JTextField lastName;
	private static JTextField username;
	private static JTextField password;
	private static JComboBox<String> roleCombo;
	private static JCheckBox active;
	private static JButton save;

	private static JButton back;
	private static JPanel panel;
	
	@SuppressWarnings("unused")
	private static boolean ALLOW_COLUMN_SELECTION = false;
	@SuppressWarnings("unused")
	private static boolean ALLOW_ROW_SELECTION = true;
	
	@SuppressWarnings("unused")
	private static GebruikerAanpassenController gebruikerAanpassenController;

	public static JPanel initialize(View view, Gebruiker gebruiker) {
		panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c;

		// Info labels toevoegen
		info = new JLabel("Voornaam");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(info, c);
		
		info = new JLabel("Achternaam");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(info, c);
		
		info = new JLabel("Gebruikersnaam");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(info, c);
		
		info = new JLabel("Wachtwoord");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(info, c);
		
		info = new JLabel("Rol");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(info, c);
		
		info = new JLabel("Actief");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(info, c);
		
		// Velden toevoegen
		firstName = new JTextField();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(firstName, c);

		lastName = new JTextField();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(lastName, c);

		username = new JTextField();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(username, c);
		
		password = new JTextField();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(password, c);

		roleCombo = new JComboBox<String>();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		panel.add(roleCombo, c);

		active = new JCheckBox();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		panel.add(active, c);
		
		save = new JButton("Gebruiker opslaan");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		panel.add(save, c);

		back = new JButton("Terug");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		panel.add(back, c);

		gebruikerAanpassenController = new GebruikerAanpassenController(view, gebruiker);
		return panel;
	}

	public static JButton getSave() {
		return save;
	}

	public static void setBack(JButton back) {
		GebruikerAanpassenView.back = back;
	}

	public static JButton getBack() {
		return back;
	}

	public static void setGebruikerAanpassenControllerToNull() {
		gebruikerAanpassenController = null;
	}

	public static void setInfo(JLabel info) {
		GebruikerAanpassenView.info = info;
	}

	public static void setFirstName(JTextField firstName) {
		GebruikerAanpassenView.firstName = firstName;
	}

	public static void setLastName(JTextField lastName) {
		GebruikerAanpassenView.lastName = lastName;
	}

	public static void setUsername(JTextField username) {
		GebruikerAanpassenView.username = username;
	}

	public static void setPassword(JTextField password) {
		GebruikerAanpassenView.password = password;
	}

	public static void setRoleCombo(JComboBox<String> roleCombo) {
		GebruikerAanpassenView.roleCombo = roleCombo;
	}

	public static void setActive(JCheckBox active) {
		GebruikerAanpassenView.active = active;
	}

	public static void setSave(JButton save) {
		GebruikerAanpassenView.save = save;
	}

	public static void setPanel(JPanel panel) {
		GebruikerAanpassenView.panel = panel;
	}

	public static void setGebruikerAanpassenController(GebruikerAanpassenController gebruikerAanpassenController) {
		GebruikerAanpassenView.gebruikerAanpassenController = gebruikerAanpassenController;
	}

	public static JLabel getInfo() {
		return info;
	}

	public static JTextField getFirstName() {
		return firstName;
	}

	public static JTextField getLastName() {
		return lastName;
	}

	public static JTextField getUsername() {
		return username;
	}

	public static JTextField getPassword() {
		return password;
	}

	public static JComboBox<String> getRoleCombo() {
		return roleCombo;
	}

	public static JCheckBox getActive() {
		return active;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static GebruikerAanpassenController getGebruikerAanpassenController() {
		return gebruikerAanpassenController;
	}
}
