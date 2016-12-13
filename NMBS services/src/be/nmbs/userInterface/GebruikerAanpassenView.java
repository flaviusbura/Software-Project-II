package be.nmbs.userInterface;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import be.nmbs.controllers.GebruikerAanpassenController;
import be.nmbs.logic.Gebruiker;

public class GebruikerAanpassenView {
	private static JTextField zoekText;
	private static JButton zoek;
	private static JButton edit;

	private static JButton back;
	private static JPanel panel;
	private static JTable table;
	
	@SuppressWarnings("unused")
	private static boolean ALLOW_COLUMN_SELECTION = false;
	@SuppressWarnings("unused")
	private static boolean ALLOW_ROW_SELECTION = true;
	
	@SuppressWarnings("unused")
	private static GebruikerAanpassenController gebruikerAanpassenController;

	public static JPanel initialize(View view, Gebruiker gebruiker) {
		panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints c;

		table = new JTable();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 4;
		
		table.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		panel.add(scrollPane);

		zoekText = new JTextField();
		zoekText.setToolTipText("Voer username in van gebruiker");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(zoekText, c);

		zoek = new JButton("Zoeken");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(zoek, c);
		
		edit = new JButton("Klant wijzigen");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(edit, c);

		back = new JButton("Terug");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(back, c);

		gebruikerAanpassenController = new GebruikerAanpassenController(view);
		return panel;
	}

	public static JTextField getZoekText() {
		return zoekText;
	}

	public static JButton getZoek() {
		return zoek;
	}

	public static JTable getTable() {
		return table;
	}

	public static void setBack(JButton back) {
		GebruikerAanpassenView.back = back;
	}

	public static JButton getBack() {
		return back;
	}

	public static void setGebruikerAanpassenControllerToNull() {
		gebruikerAanpassenController = null;
	}
}
