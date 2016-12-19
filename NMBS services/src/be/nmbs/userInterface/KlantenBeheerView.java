package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());

			nieuweKlantaanmaken = new JButton("Nieuwe klant aanmaken");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(nieuweKlantaanmaken, c);

			klantWijzigen = new JButton("Bestaande klant wijzigen");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			panel.add(klantWijzigen, c);
			
			home = new JButton("Home");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 2;
			c.gridy = 0;
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
