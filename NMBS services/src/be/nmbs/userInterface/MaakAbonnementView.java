package be.nmbs.userInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.MaakAbonnementController;
import be.nmbs.database.PrijsDAO;
import be.nmbs.database.StationDAO;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.StationNMBS;
import be.nmbs.database.KlantDAO;
import be.nmbs.database.Klant_adresDAO;
import be.nmbs.logic.Klant;

import be.nmbs.database.KortingDAO;
import be.nmbs.logic.Korting;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.logic.Gebruiker;

/**
 * 
 * @author Abdel-Portable
 *
 */
public class MaakAbonnementView {
	private static JButton maakAbonnement;

	private static JButton goBackToHome;
	private static JButton verlengDrieMaanden;
	private static JPanel panel;
	private static JPanel tPanel;
	private static JLabel lblKlant_Contact;
	private static JComboBox<?> cbxKlant_Contact;
	private static JComboBox<Klant> klantenLijst;
	static KlantDAO klantDao = new KlantDAO();

	private static JLabel lblPrijs;
	private static JComboBox<?> cbxPrijs;
	private static JComboBox<Prijs> prijzenLijst;
	private static PrijsDAO prijsDao = new PrijsDAO();

	private static JLabel lblKorting;
	private static JComboBox<?> cbxKorting;
	private static KortingDAO kortingDao = new KortingDAO();
	private static JComboBox<Korting> kortingLijst;

	private static JLabel lblGebruiker;
	private static JComboBox<?> cbxGebruiker;
	private static GebruikerDAO gebruikerDao = new GebruikerDAO();
	private static JComboBox<Gebruiker> gebruikerLijst;

	private static JLabel lblZoek;
	private static JTextField txtZoek;
	private static JButton btnZoek;

	private static JLabel lblStartDatum;
	private static JTextField txtStartDatum;
	private static JLabel lblEindDatum;
	private static JTextField txtEindDatum;
	static SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	static Date now = new Date();
	static String strDate = sdfDate.format(now);

	private static HomeController homeController;
	private static MaakAbonnementController maakAbonnementController;
	private static JTable table;
	private static JLabel lblMaanden;
	static String[] tab = { "3 maanden", "6 maanden", "9 maanden", "12 maanden" };
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox combo = new JComboBox(tab);

	private static JLabel departureLabel;
	private static JComboBox departureField;
	private static JLabel arrivalLabel;
	private static JComboBox arrivalField;
	private static ArrayList<Klant> lijst = new ArrayList<>();

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());

		// TABLE TEST START
		String[] kolommen = { "ContactID", "Achternaam", "Voornaam" };
		KlantDAO klantDAO = new KlantDAO();
		ArrayList<Klant> lijst = new ArrayList<>();
		lijst = klantDAO.getAll();
		String[][] klantData = new String[lijst.size()][3];
		new Klant_adresDAO();
		int i = 0;
		while (i < lijst.size()) {
			klantData[i][0] = String.valueOf(lijst.get(i).getContactId());
			klantData[i][1] = lijst.get(i).getAchternaam();
			klantData[i][2] = lijst.get(i).getVoornaam();
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
					c.setBackground(Color.YELLOW);
				return c;
			}

			public long getSerialversionuid() {
				return serialVersionUID;
			}
		};
		
		table.setPreferredScrollableViewportSize(new Dimension(200, 200));
		table.setFillsViewportHeight(true);

		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(table, c);
		MaakAbonnementView.resizeColumnWidth(table);
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel.add(jScrollPane);
		// TABLE TEST END

		StationDAO stationdao = new StationDAO();
		ArrayList<StationNMBS> allStations = stationdao.getAll();

		String[] stationLijst = new String[allStations.size()];

		for (int i1 = 0; i1 < allStations.size(); i1++) {
			stationLijst[i1] = "" + allStations.get(i1).getNaam();
		}

		tPanel = new JPanel(new GridBagLayout());
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(tPanel, c);
		btnZoek = new JButton("Zoek Abonnement");
		
		txtZoek = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		tPanel.add(txtZoek, c);


		btnZoek = new JButton("Zoek Abonnement");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		tPanel.add(btnZoek, c);
		
		
		departureLabel = new JLabel("Vertrekstation ");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		tPanel.add(departureLabel, c);

		departureField = new JComboBox(stationLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		tPanel.add(departureField, c);

		arrivalLabel = new JLabel("Bestemming");
		c = new GridBagConstraints();
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		tPanel.add(arrivalLabel, c);

		arrivalField = new JComboBox(stationLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		tPanel.add(arrivalField, c);

		lblEindDatum = new JLabel("Eind datum ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		tPanel.add(lblEindDatum, c);

		txtEindDatum = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		txtEindDatum.setText(strDate);
		tPanel.add(txtEindDatum, c);

		ArrayList<Prijs> allPrijzen = prijsDao.getAll();
		prijzenLijst = new JComboBox<>();
		for (Prijs prijs : allPrijzen) {
			prijzenLijst.addItem(prijs);
		}

		lblPrijs = new JLabel("Prijs ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		tPanel.add(lblPrijs, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 5;
		tPanel.add(prijzenLijst, c);

		lblKorting = new JLabel("Korting ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		tPanel.add(lblKorting, c);

		ArrayList<Korting> allKorting = kortingDao.getAll();
		kortingLijst = new JComboBox<>();
		for (Korting korting : allKorting) {
			kortingLijst.addItem(korting);
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 6;
		tPanel.add(kortingLijst, c);

		lblMaanden = new JLabel("Geldig ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 7;
		tPanel.add(lblMaanden, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 7;
		tPanel.add(combo, c);

		// buttons
		goBackToHome = new JButton("Back");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 8;
		tPanel.add(goBackToHome, c);
		maakAbonnement = new JButton("Maak Abonnement");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 8;
		tPanel.add(maakAbonnement, c);

		homeController = new HomeController(view);
		maakAbonnementController = new MaakAbonnementController(view);
		return panel;

	}

	public static JLabel getDepartureLabel() {
		return departureLabel;
	}

	public static void setDepartureLabel(JLabel departureLabel) {
		MaakAbonnementView.departureLabel = departureLabel;
	}

	public static JComboBox getDepartureField() {
		return departureField;
	}

	public static void setDepartureField(JComboBox departureField) {
		MaakAbonnementView.departureField = departureField;
	}

	public static JLabel getArrivalLabel() {
		return arrivalLabel;
	}

	public static void setArrivalLabel(JLabel arrivalLabel) {
		MaakAbonnementView.arrivalLabel = arrivalLabel;
	}

	public static JComboBox getArrivalField() {
		return arrivalField;
	}

	public static void setArrivalField(JComboBox arrivalField) {
		MaakAbonnementView.arrivalField = arrivalField;
	}

	public static JLabel getLblMaanden() {
		return lblMaanden;
	}

	public static void setLblMaanden(JLabel lblMaanden) {
		MaakAbonnementView.lblMaanden = lblMaanden;
	}

	public static JButton getMaakAbonnement() {
		return maakAbonnement;
	}

	public static void setMaakAbonnement(JButton maakAbonnement) {
		MaakAbonnementView.maakAbonnement = maakAbonnement;
	}

	public static String[] getTab() {
		return tab;
	}

	public static void setTab(String[] tab) {
		MaakAbonnementView.tab = tab;
	}

	public static JComboBox getCombo() {
		return combo;
	}

	public static void setCombo(JComboBox combo) {
		MaakAbonnementView.combo = combo;
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		MaakAbonnementView.table = table;
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

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		MaakAbonnementView.goBackToHome = goBackToHome;
	}

	public static JButton getVerlengDrieMaanden() {
		return verlengDrieMaanden;
	}

	public static void setVerlengDrieMaanden(JButton verlengDrieMaanden) {
		MaakAbonnementView.verlengDrieMaanden = verlengDrieMaanden;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		MaakAbonnementView.panel = panel;
	}

	public static JLabel getLblKlant_Contact() {
		return lblKlant_Contact;
	}

	public static void setLblKlant_Contact(JLabel lblKlant_Contact) {
		MaakAbonnementView.lblKlant_Contact = lblKlant_Contact;
	}

	public static JComboBox<?> getCbxKlant_Contact() {
		return cbxKlant_Contact;
	}

	public static void setCbxKlant_Contact(JComboBox<?> cbxKlant_Contact) {
		MaakAbonnementView.cbxKlant_Contact = cbxKlant_Contact;
	}

	public static JComboBox<Klant> getKlantenLijst() {
		return klantenLijst;
	}

	public static void setKlantenLijst(JComboBox<Klant> klantenLijst) {
		MaakAbonnementView.klantenLijst = klantenLijst;
	}

	public static KlantDAO getKlantDao() {
		return klantDao;
	}

	public static void setKlantDao(KlantDAO klantDao) {
		MaakAbonnementView.klantDao = klantDao;
	}

	public static JLabel getLblPrijs() {
		return lblPrijs;
	}

	public static void setLblPrijs(JLabel lblPrijs) {
		MaakAbonnementView.lblPrijs = lblPrijs;
	}

	public static JComboBox<?> getCbxPrijs() {
		return cbxPrijs;
	}

	public static void setCbxPrijs(JComboBox<?> cbxPrijs) {
		MaakAbonnementView.cbxPrijs = cbxPrijs;
	}

	public static JComboBox<Prijs> getPrijzenLijst() {
		return prijzenLijst;
	}

	public static void setPrijzenLijst(JComboBox<Prijs> prijzenLijst) {
		MaakAbonnementView.prijzenLijst = prijzenLijst;
	}

	public static PrijsDAO getPrijsDao() {
		return prijsDao;
	}

	public static void setPrijsDao(PrijsDAO prijsDao) {
		MaakAbonnementView.prijsDao = prijsDao;
	}

	public static JLabel getLblKorting() {
		return lblKorting;
	}

	public static void setLblKorting(JLabel lblKorting) {
		MaakAbonnementView.lblKorting = lblKorting;
	}

	public static JComboBox<?> getCbxKorting() {
		return cbxKorting;
	}

	public static void setCbxKorting(JComboBox<?> cbxKorting) {
		MaakAbonnementView.cbxKorting = cbxKorting;
	}

	public static KortingDAO getKortingDao() {
		return kortingDao;
	}

	public static void setKortingDao(KortingDAO kortingDao) {
		MaakAbonnementView.kortingDao = kortingDao;
	}

	public static JComboBox<Korting> getKortingLijst() {
		return kortingLijst;
	}

	public static void setKortingLijst(JComboBox<Korting> kortingLijst) {
		MaakAbonnementView.kortingLijst = kortingLijst;
	}

	public static JLabel getLblGebruiker() {
		return lblGebruiker;
	}

	public static void setLblGebruiker(JLabel lblGebruiker) {
		MaakAbonnementView.lblGebruiker = lblGebruiker;
	}

	public static JComboBox<?> getCbxGebruiker() {
		return cbxGebruiker;
	}

	public static void setCbxGebruiker(JComboBox<?> cbxGebruiker) {
		MaakAbonnementView.cbxGebruiker = cbxGebruiker;
	}

	public static GebruikerDAO getGebruikerDao() {
		return gebruikerDao;
	}

	public static void setGebruikerDao(GebruikerDAO gebruikerDao) {
		MaakAbonnementView.gebruikerDao = gebruikerDao;
	}

	public static JComboBox<Gebruiker> getGebruikerLijst() {
		return gebruikerLijst;
	}

	public static void setGebruikerLijst(JComboBox<Gebruiker> gebruikerLijst) {
		MaakAbonnementView.gebruikerLijst = gebruikerLijst;
	}

	public static JLabel getLblStartDatum() {
		return lblStartDatum;
	}

	public static void setLblStartDatum(JLabel lblStartDatum) {
		MaakAbonnementView.lblStartDatum = lblStartDatum;
	}

	public static JTextField getTxtStartDatum() {
		return txtStartDatum;
	}

	public static void setTxtStartDatum(JTextField txtStartDatum) {
		MaakAbonnementView.txtStartDatum = txtStartDatum;
	}

	public static JLabel getLblEindDatum() {
		return lblEindDatum;
	}

	public static void setLblEindDatum(JLabel lblEindDatum) {
		MaakAbonnementView.lblEindDatum = lblEindDatum;
	}

	public static JTextField getTxtEindDatum() {
		return txtEindDatum;
	}

	public static void setTxtEindDatum(JTextField txtEindDatum) {
		MaakAbonnementView.txtEindDatum = txtEindDatum;
	}

	public static SimpleDateFormat getSdfDate() {
		return sdfDate;
	}

	public static void setSdfDate(SimpleDateFormat sdfDate) {
		MaakAbonnementView.sdfDate = sdfDate;
	}

	public static Date getNow() {
		return now;
	}

	public static void setNow(Date now) {
		MaakAbonnementView.now = now;
	}

	public static String getStrDate() {
		return strDate;
	}

	public static void setStrDate(String strDate) {
		MaakAbonnementView.strDate = strDate;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		MaakAbonnementView.homeController = homeController;
	}

	public static MaakAbonnementController getMaakAbonnementController() {
		return maakAbonnementController;
	}

	public static void setMaakAbonnementController(MaakAbonnementController maakAbonnementController) {
		MaakAbonnementView.maakAbonnementController = maakAbonnementController;
	}

	public static MaakAbonnementController getTicketController() {
		return maakAbonnementController;
	}

	public static void setMaakAbonnementControllerToNull() {
		maakAbonnementController = null;
	}

	public static void setHomeControllerToNull() {
		homeController = null;
	}

	public static JPanel gettPanel() {
		return tPanel;
	}

	public static void settPanel(JPanel tPanel) {
		MaakAbonnementView.tPanel = tPanel;
	}

	public static JTextField getTxtZoek() {
		return txtZoek;
	}

	public static void setTxtZoek(JTextField txtZoek) {
		MaakAbonnementView.txtZoek = txtZoek;
	}

	public static ArrayList<Klant> getLijst() {
		return lijst;
	}

	public static void setLijst(ArrayList<Klant> lijst) {
		MaakAbonnementView.lijst = lijst;
	}

	public static JButton getBtnzoek() {
		return btnZoek;
	}

	public static void setBtnzoek(JButton btnzoek) {
		MaakAbonnementView.btnZoek = btnzoek;
	}

}
