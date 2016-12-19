package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
	
	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		
		nieuweGebruiker = new JButton("Gebruiker toevoegen");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(nieuweGebruiker, c);
		
		gebruikerAanpassen = new JButton("Gebruikers wijzigen");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(gebruikerAanpassen, c);
		
		home = new JButton("Home");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
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
