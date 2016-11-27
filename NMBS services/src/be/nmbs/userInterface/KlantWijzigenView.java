package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.KlantWijzigenController;

public class KlantWijzigenView {
	private static JButton adresWijzigen;
	private static JButton telefoonWijzigen;
	private static JButton back;
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static KlantWijzigenController klantWijzigenController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());

			adresWijzigen = new JButton("Adres Wijzigen");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(adresWijzigen, c);

			telefoonWijzigen = new JButton("Telefoon wijzigen");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			panel.add(telefoonWijzigen, c);
			
			back = new JButton("Back");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 2;
			c.gridy = 0;
			panel.add(back, c);
			
			klantWijzigenController = new KlantWijzigenController(view);
			return panel;
	}

	public static JButton getBack() {
		return back;
	}

	public static JButton getAdresWijzigen() {
		return adresWijzigen;
	}

	public static JButton getTelefoonWijzigen() {
		return telefoonWijzigen;
	}
	
	public static void setKlantWijzigenControllerToNull() {
		klantWijzigenController = null;
	}
}
