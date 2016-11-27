package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import be.nmbs.controllers.TelefoonWijzigenController;

public class TelefoonWijzigenView {
	private static JButton telefoonWijzigen;
	private static JButton actieAnnuleren;
	private static JLabel voornaam;
	private static JTextField voornaamText;
	private static JLabel naam;
	private static JTextField naamText;
	private static JLabel nieuweTelefoon;
	private static JTextField nieuweTelefoonText;
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static TelefoonWijzigenController telefoonWijzigenController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());
			
			voornaam = new JLabel("Voornaam");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(voornaam, c);
			
			voornaamText = new JTextField(30);
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			panel.add(voornaamText, c);
			
			naam = new JLabel("Naam");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(naam, c);

			naamText = new JTextField(30);
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			panel.add(naamText, c);
			
			nieuweTelefoon = new JLabel("Nieuwe telefoon");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			panel.add(nieuweTelefoon, c);
			
			nieuweTelefoonText = new JTextField(20);
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			panel.add(nieuweTelefoonText, c);
			
			telefoonWijzigen = new JButton("Telefoon wijzigen");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			panel.add(telefoonWijzigen, c);
			
			actieAnnuleren = new JButton("Actie annuleren");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			panel.add(actieAnnuleren, c);
			
			telefoonWijzigenController = new TelefoonWijzigenController(view);
			return panel;
	}

	public static JButton getTelefoonWijzigen() {
		return telefoonWijzigen;
	}

	public static JButton getActieAnnuleren() {
		return actieAnnuleren;
	}

	public static JLabel getVoornaam() {
		return voornaam;
	}

	public static JTextField getVoornaamText() {
		return voornaamText;
	}

	public static JLabel getNaam() {
		return naam;
	}

	public static JTextField getNaamText() {
		return naamText;
	}

	public static JLabel getNieuweTelefoon() {
		return nieuweTelefoon;
	}

	public static JTextField getNieuweTelefoonText() {
		return nieuweTelefoonText;
	}
	
	public static void setTelefoonWijzigenControllerToNull() {
		telefoonWijzigenController = null;
	}
}
