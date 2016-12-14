package be.nmbs.userInterface;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import be.nmbs.controllers.GebruikerWijzigenController;

public class GebruikerWijzigenView {
	private static JTextField searchField;
	private static JButton edit;
	private static JButton back;
	private static JPanel panel;
	private static JTable table;
	
	@SuppressWarnings("unused")
	private static boolean ALLOW_COLUMN_SELECTION = false;
	@SuppressWarnings("unused")
	private static boolean ALLOW_ROW_SELECTION = true;
	
	@SuppressWarnings("unused")
	private static GebruikerWijzigenController gebruikerWijzigenController;

	public static JPanel initialize(View view) {
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
		
		panel.add(scrollPane, c);

		searchField = new JTextField();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(searchField, c);
		
		edit = new JButton("Gebruiker aanpassen");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(edit, c);

		back = new JButton("Terug");
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(back, c);

		gebruikerWijzigenController = new GebruikerWijzigenController(view);
		return panel;
	}

	public static JTextField getSearchField() {
		return searchField;
	}

	public static JTable getTable() {
		return table;
	}

	public static void setBack(JButton back) {
		GebruikerWijzigenView.back = back;
	}

	public static JButton getBack() {
		return back;
	}
	
	public static JButton getEdit() {
		return edit;
	}

	public static void setGebruikerWijzigenControllerToNull() {
		gebruikerWijzigenController = null;
	}
}
