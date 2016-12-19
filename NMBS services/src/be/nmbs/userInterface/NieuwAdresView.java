package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.NieuwAdresController;

public class NieuwAdresView {
	private static JButton klantAdresWijzigen;
	private static JButton actieannuleren;
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
	private static NieuwAdresController nieuwAdresController;
	
	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());

			GridBagConstraints c = new GridBagConstraints();
			straat = new JLabel("Straat");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			panel.add(straat, c);
			
			straatText = new JTextField(10);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			panel.add(straatText, c);
			
			nr = new JLabel("Huisnummer");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			panel.add(nr, c);
			
			nrText = new JTextField(10);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			panel.add(nrText, c);
			
			bus = new JLabel("bus");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 4;
			panel.add(bus, c);
			
			busText = new JTextField(10);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			panel.add(busText, c);
			
			postcode = new JLabel("Postcode");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 5;
			panel.add(postcode, c);
			
			postcodeText = new JTextField(4);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 5;
			panel.add(postcodeText, c);
			
			stad = new JLabel("Stad");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 6;
			panel.add(stad, c);
			
			stadText = new JTextField(30);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 6;
			panel.add(stadText, c);
			
			land = new JLabel("Land");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 7;
			panel.add(land, c);
			
			landText = new JTextField(30);
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 7;
			panel.add(landText, c);
			
			klantAdresWijzigen = new JButton("Klant Adres Wijzigen");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 8;
			panel.add(klantAdresWijzigen, c);

			actieannuleren = new JButton("Actie annuleren");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 8;
			panel.add(actieannuleren, c);
			
			nieuwAdresController = new NieuwAdresController(view);
			return panel;
	}
	
	public static JButton getKlantAdresWijzigen() {
		return klantAdresWijzigen;
	}

	public static JButton getActieannuleren() {
		return actieannuleren;
	}
	
	public static void setNieuwAdresControllerToNull() {
		nieuwAdresController = null;
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
