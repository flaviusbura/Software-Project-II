package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.NieuweKlantAanmakenController;

public class NieuweKlantAanmakenView {
	private static JButton klantAanmaken;
	private static JButton actieannuleren;
	private static JLabel voornaam;
	private static JTextField voornaamText;
	private static JLabel naam;
	private static JTextField naamText;
	private static JLabel telefoon;
	private static JTextField telefoonText;
	private static JLabel straat;
	private static JTextField straatText;
	private static JLabel nr;
	private static JTextField nrText;
	private static JLabel bus;
	private static JTextField busText;
	private static JLabel postcode;
	private static JTextField postcodeText;
	private static JLabel stad;
	private static JTextField stadText;
	private static JLabel land;
	private static JTextField landText;
	
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static NieuweKlantAanmakenController niuweKlantAanmakenController;
	
	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());
			
			voornaam = new JLabel("Voornaam");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(voornaam, c);
			
			voornaamText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			panel.add(voornaamText, c);
			
			naam = new JLabel("Naam");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(naam, c);
			
			naamText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			panel.add(naamText, c);
			
			telefoon = new JLabel("Telefoon");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			panel.add(telefoon, c);
			
			telefoonText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			panel.add(telefoonText, c);
			
			straat = new JLabel("Straat");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			panel.add(straat, c);
			
			straatText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			panel.add(straatText, c);
			
			nr = new JLabel("Huisnummer");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 4;
			panel.add(nr, c);
			
			nrText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			panel.add(nrText, c);
			
			bus = new JLabel("bus");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 5;
			panel.add(bus, c);
			
			busText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 5;
			panel.add(busText, c);
			
			postcode = new JLabel("Postcode");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 6;
			panel.add(postcode, c);
			
			postcodeText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 6;
			panel.add(postcodeText, c);
			
			stad = new JLabel("Stad");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 7;
			panel.add(stad, c);
			
			stadText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 7;
			panel.add(stadText, c);
			
			land = new JLabel("Land");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 8;
			panel.add(land, c);
			
			landText = new JTextField(20);
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 8;
			panel.add(landText, c);
			
			klantAanmaken = new JButton("Klant Aanmaken");
			c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 9;
			panel.add(klantAanmaken, c);

			actieannuleren = new JButton("Actie annuleren");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 9;
			panel.add(actieannuleren, c);
			
			niuweKlantAanmakenController = new NieuweKlantAanmakenController(view);
			return panel;
	}
	
	public static JButton getKlantAanmaken() {
		return klantAanmaken;
	}

	public static JButton getActieannuleren() {
		return actieannuleren;
	}
	
	public static void setNieuweKlantAanmakenControllerToNull() {
		niuweKlantAanmakenController = null;
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
