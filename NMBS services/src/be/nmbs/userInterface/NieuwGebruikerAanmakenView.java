package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import be.nmbs.controllers.NieuwGebruikerAanmakenController;

public class NieuwGebruikerAanmakenView {
	private static JLabel voornaam, achternaam, username, wachtwoord, wachtwoordConfirm, rol;
	private static JTextField voornaamText, achternaamText, usernameText;
	private static JPasswordField wachtwoordText, wachtwoordTextConfirm;
	@SuppressWarnings("rawtypes")
	private static JComboBox rolCombo;
	private static JButton toevoegen, annuleren;
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static NieuwGebruikerAanmakenController nieuwgebruikerAanmakenController;
	@SuppressWarnings({ "static-access", "unchecked" })
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		voornaam = new JLabel("Voornaam");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(voornaam, c);
		
		voornaamText = new JTextField(20);
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(voornaamText, c);
		
		achternaam = new JLabel("Achternaam");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(achternaam, c);
		
		achternaamText = new JTextField(20);
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(achternaamText, c);
		
		username = new JLabel("Username");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(username, c);
		
		usernameText = new JTextField(20);
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(usernameText, c);
		
		wachtwoord = new JLabel("Wachtwoord");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(wachtwoord, c);
		
		wachtwoordText = new JPasswordField(20);
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(wachtwoordText, c);
		
		wachtwoordConfirm = new JLabel("Wachtwoord bevestigen");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(wachtwoordConfirm, c);
		
		wachtwoordTextConfirm = new JPasswordField(20);
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		panel.add(wachtwoordTextConfirm, c);
		
		rol = new JLabel("Rol");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(rol, c);
		
		rolCombo = new JComboBox<>();
		rolCombo.addItem("Administrator");
		rolCombo.addItem("Gebruiker");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		panel.add(rolCombo, c);
		
		toevoegen = new JButton("Toevoegen");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		panel.add(toevoegen, c);
		
		annuleren = new JButton("Actie annuleren");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		panel.add(annuleren, c);
		
		nieuwgebruikerAanmakenController = new NieuwGebruikerAanmakenController(view);
		
		return panel;
	}

	public static void setNieuwGebruikerAanmakenControllerToNull() {
		nieuwgebruikerAanmakenController = null;
	}
	
	public static JLabel getVoornaam() {
		return voornaam;
	}

	public static JLabel getAchternaam() {
		return achternaam;
	}

	@SuppressWarnings("rawtypes")
	public static JComboBox getRolCombo() {
		return rolCombo;
	}

	public static JLabel getUsername() {
		return username;
	}

	public static JLabel getWachtwoord() {
		return wachtwoord;
	}

	public static JLabel getRol() {
		return rol;
	}

	public static JTextField getVoornaamText() {
		return voornaamText;
	}

	public static JTextField getAchternaamText() {
		return achternaamText;
	}

	public static JTextField getUsernameText() {
		return usernameText;
	}

	public static JPasswordField getWachtwoordText() {
		return wachtwoordText;
	}

	public static JPasswordField getWachtwoordTextConfirm() {
		return wachtwoordTextConfirm;
	}

	public static JLabel getWachtwoordConfirm() {
		return wachtwoordConfirm;
	}

	public static JButton getToevoegen() {
		return toevoegen;
	}

	public static JButton getAnnuleren() {
		return annuleren;
	}
}
