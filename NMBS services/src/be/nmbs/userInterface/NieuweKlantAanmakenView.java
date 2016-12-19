package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.NieuweKlantAanmakenController;

public class NieuweKlantAanmakenView {
	private static JLabel info;
	private static JButton klantAanmaken;
	private static JButton actieannuleren;
	private static JTextField voornaamText;
	private static JTextField naamText;
	private static JTextField telefoonText;
	private static JTextField straatText;
	private static JTextField nrText;
	private static JTextField busText;
	private static JTextField postcodeText;
	private static JTextField stadText;
	private static JTextField landText;
	
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static NieuweKlantAanmakenController nieuweKlantAanmakenController;
	
	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());
			
			info = new JLabel("Voornaam");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(info, c);
			
			voornaamText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(0, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 0;
			panel.add(voornaamText, c);
			
			info = new JLabel("Naam");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 1;
			panel.add(info, c);
			
			naamText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 1;
			panel.add(naamText, c);
			
			info = new JLabel("Telefoon");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 2;
			panel.add(info, c);
			
			telefoonText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 2;
			panel.add(telefoonText, c);
			
			info = new JLabel("Straat");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 3;
			panel.add(info, c);
			
			straatText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 3;
			panel.add(straatText, c);
			
			info = new JLabel("Huisnummer");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 4;
			panel.add(info, c);
			
			nrText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 4;
			panel.add(nrText, c);
			
			info = new JLabel("Bus");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 5;
			panel.add(info, c);
			
			busText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 5;
			panel.add(busText, c);
			
			info = new JLabel("Postcode");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 6;
			panel.add(info, c);
			
			postcodeText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 6;
			panel.add(postcodeText, c);
			
			info = new JLabel("Stad");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 7;
			panel.add(info, c);
			
			stadText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 7;
			panel.add(stadText, c);
			
			info = new JLabel("Land");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 8;
			panel.add(info, c);
			
			landText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 8;
			panel.add(landText, c);
			
			klantAanmaken = new JButton("Klant aanmaken");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 9;
			panel.add(klantAanmaken, c);

			actieannuleren = new JButton("Actie annuleren");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 9;
			panel.add(actieannuleren, c);
			
			nieuweKlantAanmakenController = new NieuweKlantAanmakenController(view);
			return panel;
	}
	
	public static JButton getKlantAanmaken() {
		return klantAanmaken;
	}

	public static JButton getActieannuleren() {
		return actieannuleren;
	}
	
	public static void setNieuweKlantAanmakenControllerToNull() {
		nieuweKlantAanmakenController = null;
	}
	
	public static JTextField getVoornaamText() {
		return voornaamText;
	}

	public static JTextField getNaamText() {
		return naamText;
	}

	public static JTextField getTelefoonText() {
		return telefoonText;
	}

	public static JTextField getStraatText() {
		return straatText;
	}

	public static JTextField getNrText() {
		return nrText;
	}

	public static JTextField getBusText() {
		return busText;
	}

	public static JTextField getPostcodeText() {
		return postcodeText;
	}

	public static JTextField getStadText() {
		return stadText;
	}

	public static JTextField getLandText() {
		return landText;
	}
}
