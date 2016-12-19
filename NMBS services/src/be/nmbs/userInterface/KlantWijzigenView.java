package be.nmbs.userInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import be.nmbs.controllers.KlantWijzigenController;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.logic.Adres;
import be.nmbs.logic.Klant;

public class KlantWijzigenView {
	private static JTextField zoekText;
	private static JButton zoek;
	private static JButton voornaam;
	private static JButton naam;
	private static JButton telefoon;
	private static JButton adresButton;
	private static JButton straat;
	private static JButton huisnummer;
	private static JButton postcode;
	private static JButton woonplaats;
	private static JButton land;
	private static JButton bus;
	private static JButton back;
	private static JPanel panel;
	private static ArrayList<Klant> lijst = new ArrayList<>();
	
	@SuppressWarnings("unused")
	private static KlantWijzigenController klantWijzigenController;
	private static JTable table;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());

		String[] kolommen = { "ContactID", "Voornaam", "Achternaam", "Telefoon", "Land", "Straat",
				"Huisnummer", "Postcode", "Woonplaats", "Bus", "Actief" };
		String[][] klantData = new String[lijst.size()][12];
		Klant_adresDAO klant_adresDAO = new Klant_adresDAO();
		Adres adres;
		int i = 0;
		while (i < lijst.size()) {
			adres = klant_adresDAO.getAdres(lijst.get(i).getAdresId());
			klantData[i][0] = String.valueOf(lijst.get(i).getContactId());
			klantData[i][1] = String.valueOf(lijst.get(i).getAdresId());
			klantData[i][2] = lijst.get(i).getVoornaam();
			klantData[i][3] = lijst.get(i).getAchternaam();
			klantData[i][4] = lijst.get(i).getTelefoon();
			klantData[i][5] = adres.getLand();
			klantData[i][6] = adres.getStraat();
			klantData[i][7] = String.valueOf(adres.getHuisnummer());
			klantData[i][8] = String.valueOf(adres.getPostcode());
			klantData[i][9] = adres.getWoonplaats();
			klantData[i][10] = adres.getBus();
			if (lijst.get(i).isActief() == true) {
				klantData[i][11] = "actief";
			} else {
				klantData[i][11] = "niet actief";
			}
			i++;
		}
		table = new JTable(klantData, kolommen) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int data, int kolommen) {
				return false;
			}

			public Component prepareRenderer(TableCellRenderer r, int data, int kolommen) {
				Component c = super.prepareRenderer(r, data, kolommen);

				if (data % 2 == 0)
					c.setBackground(Color.ORANGE);
				else
					c.setBackground(Color.GRAY);
				return c;
			}
		};

		table.setPreferredScrollableViewportSize(new Dimension(600, 400));
		table.setFillsViewportHeight(true);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(table, c);
		KlantWijzigenView.resizeColumnWidth(table);
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel.add(jScrollPane);

		JPanel jPanel = new JPanel(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(jPanel, c);

		zoekText = new JTextField(5);
		zoekText.setToolTipText("Voer hier in de achternaam van de klant die u wilt opzoeken.");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		jPanel.add(zoekText, c);
		
		zoek = new JButton("Zoek");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		jPanel.add(zoek, c);
		
		voornaam = new JButton("Voornaam wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		jPanel.add(voornaam, c);

		naam = new JButton("Achternaam wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		jPanel.add(naam, c);

		telefoon = new JButton("Telefoon wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		jPanel.add(telefoon, c);

		adresButton = new JButton("Nieuw adres");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		jPanel.add(adresButton, c);

		land = new JButton("Land wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		jPanel.add(land, c);

		straat = new JButton("Straat wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		jPanel.add(straat, c);

		huisnummer = new JButton("Huisnummer wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		jPanel.add(huisnummer, c);

		postcode = new JButton("Postcode wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		jPanel.add(postcode, c);

		woonplaats = new JButton("Woonplaats wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		jPanel.add(woonplaats, c);

		bus = new JButton("Bus wijzigen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		jPanel.add(bus, c);

		back = new JButton("Back");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		jPanel.add(back, c);

		klantWijzigenController = new KlantWijzigenController(view);
		return panel;
	}

	public static void setLijst(ArrayList<Klant> lijst) {
		KlantWijzigenView.lijst = lijst;
	}

	public static void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 75;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 300)
				width = 300;
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
	
	public static JButton getVoornaam() {
		return voornaam;
	}

	public static JButton getNaam() {
		return naam;
	}

	public static JButton getTelefoon() {
		return telefoon;
	}

	public static JButton getAdresButton() {
		return adresButton;
	}

	public static JButton getStraat() {
		return straat;
	}

	public static JButton getHuisnummer() {
		return huisnummer;
	}

	public static JButton getPostcode() {
		return postcode;
	}

	public static JButton getWoonplaats() {
		return woonplaats;
	}

	public static JButton getLand() {
		return land;
	}

	public static JButton getBus() {
		return bus;
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

	public static ArrayList<Klant> getLijst() {
		return lijst;
	}

	public static void setKlantWijzigenControllerToNull() {
		klantWijzigenController = null;
	}
}
