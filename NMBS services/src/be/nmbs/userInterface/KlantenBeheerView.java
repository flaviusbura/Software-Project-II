package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.KlantenBeheerController;

public class KlantenBeheerView {
	private static JButton nieuweKlantaanmaken;
	private static JButton klantWijzigen;
	private static JButton home;
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static KlantenBeheerController klantenBeheerController;

	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());

			nieuweKlantaanmaken = new JButton("Nieuwe klant aanmaken");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(nieuweKlantaanmaken, c);

			klantWijzigen = new JButton("Bestaande klant wijzigen");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 1;
			panel.add(klantWijzigen, c);
			
			home = new JButton("Home");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 2;
			panel.add(home, c);
			
			klantenBeheerController = new KlantenBeheerController(view);
			return panel;
	}

	public static JButton getHome() {
		return home;
	}

	public static JButton getNieuweKlantaanmaken() {
		return nieuweKlantaanmaken;
	}

	public static JButton getKlantWijzigen() {
		return klantWijzigen;
	}
	
	public static void setKlantenBeheerControllerToNull() {
		klantenBeheerController = null;
	}
}
