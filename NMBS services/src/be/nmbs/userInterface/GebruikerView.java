package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.GebruikerController;

public class GebruikerView {
	private static JButton nieuweGebruiker;
	private static JButton gebruikerAanpassen;
	private static JButton home;
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static GebruikerController gebruikerController;
	
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		
		nieuweGebruiker = new JButton("Gebruiker toevoegen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(nieuweGebruiker, c);
		
		gebruikerAanpassen = new JButton("Gebruikers wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(gebruikerAanpassen, c);
		
		home = new JButton("Terug");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(home, c);
		
		gebruikerController = new GebruikerController(view);
		
		return panel;
	}
	
	public static void setGebruikerControllerToNull() {
		gebruikerController = null;
	}
	
	public static JButton getNieuweGebruiker() {
		return nieuweGebruiker;
	}

	public static JButton getGebruikerAanpassen() {
		return gebruikerAanpassen;
	}

	public static JButton getHome() {
		return home;
	}
	
}
