package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import be.nmbs.controllers.KlantWijzigenController;

public class KlantWijzigenView {
	private static JTextField zoekText;
	private static JButton zoek;
	private static JButton edit;
	private static JButton back;
	private static JPanel panel;
	private static JTable table;
	
	@SuppressWarnings("unused")
	private static KlantWijzigenController klantWijzigenController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());

		table = new JTable();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 5;
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, c);

		zoekText = new JTextField(5);
		zoekText.setToolTipText("Voer hier in de achternaam van de klant die u wilt opzoeken.");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(zoekText, c);
		
		zoek = new JButton("Zoek");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(zoek, c);
		
		edit = new JButton("Voornaam wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(edit, c);

		back = new JButton("Terug");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		panel.add(back, c);

		klantWijzigenController = new KlantWijzigenController(view);
		return panel;
	}
	
	public static JButton getEdit() {
		return edit;
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
		KlantWijzigenView.back = back;
	}

	public static JButton getBack() {
		return back;
	}

	public static void setKlantWijzigenControllerToNull() {
		klantWijzigenController = null;
	}
}
