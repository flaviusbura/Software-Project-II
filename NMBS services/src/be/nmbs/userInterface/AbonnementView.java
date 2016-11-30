package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.AbonnementController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.PrijsDAO;
import be.nmbs.logic.Prijs;

import be.nmbs.database.KlantDAO;
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
public class AbonnementView {
	private static JButton maakAbonnement;
	private static JButton goBackToHome;
	private static JButton verlengDrieMaanden;
	private static JPanel panel;

	private static JLabel lblKlant_Contact;
	private static JComboBox cbxKlant_Contact;
	private static JComboBox<Klant> klantenLijst;
	static KlantDAO klantDao = new KlantDAO();

	private static JLabel lblPrijs;
	private static JComboBox cbxPrijs;
	private static JComboBox<Prijs> prijzenLijst;
	private static PrijsDAO prijsDao = new PrijsDAO();

	private static JLabel lblKorting;
	private static JComboBox cbxKorting;
	private static KortingDAO kortingDao = new KortingDAO();
	private static JComboBox<Korting> kortingLijst;

	private static JLabel lblGebruiker;
	private static JComboBox cbxGebruiker;
	private static GebruikerDAO gebruikerDao = new GebruikerDAO();
	private static JComboBox<Gebruiker> gebruikerLijst;

	private static JLabel lblRoute;
	private static JTextField txtRoute;

	private static JLabel lblStartDatum;
	private static JTextField txtStartDatum;
	private static JLabel lblEindDatum;
	private static JTextField txtEindDatum;
	static SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	static Date now = new Date();
	static String strDate = sdfDate.format(now);

	private static HomeController homeController;
	private static AbonnementController abonnementController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		ArrayList<Klant> allKlanten = klantDao.getAll();

		String[] klantLijst = new String[allKlanten.size()];
		
		for(int i=0; i < allKlanten.size(); i++) {
			klantLijst[i] = "" + allKlanten.get(i).getAchternaam();
		}
		
		
		lblKlant_Contact = new JLabel("Klanten");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lblKlant_Contact, c);

		cbxKlant_Contact = new JComboBox(klantLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(cbxKlant_Contact, c);

		/*
		ArrayList<Gebruiker> alleGebruiker = gebruikerDao.getAll();
		gebruikerLijst = new JComboBox<>();
		for (Gebruiker gebruiker : alleGebruiker) {
			gebruikerLijst.addItem(gebruiker);
		}
		*/
		ArrayList<Gebruiker> alleGebruiker = gebruikerDao.getAll();

		String[] gebruikerLijst = new String[alleGebruiker.size()];
		
		for(int i=0; i < alleGebruiker.size(); i++) {
			gebruikerLijst[i] = "" + alleGebruiker.get(i).getId();
		}
		lblGebruiker = new JLabel("GebruikerID ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblGebruiker, c);
		
		cbxGebruiker = new JComboBox(gebruikerLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		panel.add(cbxGebruiker, c);

		lblRoute = new JLabel("Route");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblRoute, c);

		txtRoute = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		panel.add(txtRoute, c);

		lblStartDatum = new JLabel("Start datum ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(lblStartDatum, c);

		txtStartDatum = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		txtStartDatum.setText(strDate);
		panel.add(txtStartDatum, c);

		lblEindDatum = new JLabel("Eind datum ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(lblEindDatum, c);

		txtEindDatum = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		txtEindDatum.setText(strDate);
		panel.add(txtEindDatum, c);

		ArrayList<Prijs> allPrijzen = prijsDao.getAll();
		prijzenLijst = new JComboBox<>();
		for (Prijs prijs : allPrijzen) {
			prijzenLijst.addItem(prijs);
		}

		lblPrijs = new JLabel("Prijs ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(lblPrijs, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 5;
		panel.add(prijzenLijst, c);

		lblKorting = new JLabel("Korting ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		panel.add(lblKorting, c);

		ArrayList<Korting> allKorting = kortingDao.getAll();
		kortingLijst = new JComboBox<>();

		for (Korting korting : allKorting) {
			kortingLijst.addItem(korting);
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 6;
		panel.add(kortingLijst, c);

		// buttons
		maakAbonnement = new JButton("Abonnement aanmaken");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 7;
		panel.add(maakAbonnement, c);
		
		//verlengDrieMaanden
		verlengDrieMaanden = new JButton("Verleng drie maanden");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 7;
		panel.add(verlengDrieMaanden, c);
		goBackToHome = new JButton("Back");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 8;
		panel.add(goBackToHome, c);
		
	
		
		homeController = new HomeController(view);
		abonnementController = new AbonnementController(view);
		return panel;
	}

	public static JButton getVerlengDrieMaanden() {
		return verlengDrieMaanden;
	}

	public static void setVerlengDrieMaanden(JButton verlengDrieMaanden) {
		AbonnementView.verlengDrieMaanden = verlengDrieMaanden;
	}

	public static JComboBox<Gebruiker> getGebruikerLijst() {
		return gebruikerLijst;
	}

	public static void setGebruikerLijst(JComboBox<Gebruiker> gebruikerLijst) {
		AbonnementView.gebruikerLijst = gebruikerLijst;
	}

	public static JComboBox<Klant> getKlantenLijst() {
		return klantenLijst;
	}

	public static void setKlantenLijst(JComboBox<Klant> klantenLijst) {
		AbonnementView.klantenLijst = klantenLijst;
	}

	public static JComboBox<Prijs> getPrijzenLijst() {
		return prijzenLijst;
	}

	public static void setPrijzenLijst(JComboBox<Prijs> prijzenLijst) {
		AbonnementView.prijzenLijst = prijzenLijst;
	}

	public static JComboBox<Korting> getKortingLijst() {
		return kortingLijst;
	}

	public static void setKortingLijst(JComboBox<Korting> kortingLijst) {
		AbonnementView.kortingLijst = kortingLijst;
	}

	public static JComboBox getKortinglijst() {
		return kortingLijst;
	}

	public static void setKortinglijst(JComboBox<Korting> kortingLijst) {
		AbonnementView.kortingLijst = kortingLijst;
	}

	public static JComboBox getPrijzenlijst() {
		return prijzenLijst;
	}

	public static void setPrijzenlijst(JComboBox<Prijs> prijzenLijst) {
		AbonnementView.prijzenLijst = prijzenLijst;
	}

	public static JButton getMaakAbonnement() {
		return maakAbonnement;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setHomeControllerToNull() {
		homeController = null;
	}

	public static void setAbonnementControllerToNull() {
		abonnementController = null;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		AbonnementView.panel = panel;
	}

	public static JLabel getLblKlant_Contact() {
		return lblKlant_Contact;
	}

	public static void setLblKlant_Contact(JLabel lblKlant_Contact) {
		AbonnementView.lblKlant_Contact = lblKlant_Contact;
	}

	public static JComboBox getCbxKlant_Contact() {
		return cbxKlant_Contact;
	}

	public static void setCbxKlant_Contact(JComboBox cbxKlant_Contact) {
		AbonnementView.cbxKlant_Contact = cbxKlant_Contact;
	}

	public static KlantDAO getKlantDao() {
		return klantDao;
	}

	public static void setKlantDao(KlantDAO klantDao) {
		AbonnementView.klantDao = klantDao;
	}

	public static JLabel getLblPrijs() {
		return lblPrijs;
	}

	public static void setLblPrijs(JLabel lblPrijs) {
		AbonnementView.lblPrijs = lblPrijs;
	}

	public static JComboBox getCbxPrijs() {
		return cbxPrijs;
	}

	public static void setCbxPrijs(JComboBox cbxPrijs) {
		AbonnementView.cbxPrijs = cbxPrijs;
	}

	public static PrijsDAO getPrijsDao() {
		return prijsDao;
	}

	public static void setPrijsDao(PrijsDAO prijsDao) {
		AbonnementView.prijsDao = prijsDao;
	}

	public static JLabel getLblKorting() {
		return lblKorting;
	}

	public static void setLblKorting(JLabel lblKorting) {
		AbonnementView.lblKorting = lblKorting;
	}

	public static JComboBox getCbxKorting() {
		return cbxKorting;
	}

	public static void setCbxKorting(JComboBox cbxKorting) {
		AbonnementView.cbxKorting = cbxKorting;
	}

	public static KortingDAO getKortingDao() {
		return kortingDao;
	}

	public static void setKortingDao(KortingDAO kortingDao) {
		AbonnementView.kortingDao = kortingDao;
	}

	public static JLabel getLblGebruiker() {
		return lblGebruiker;
	}

	public static void setLblGebruiker(JLabel lblGebruiker) {
		AbonnementView.lblGebruiker = lblGebruiker;
	}

	public static JComboBox getCbxGebruiker() {
		return cbxGebruiker;
	}

	public static void setCbxGebruiker(JComboBox cbxGebruiker) {
		AbonnementView.cbxGebruiker = cbxGebruiker;
	}

	public static GebruikerDAO getGebruikerDao() {
		return gebruikerDao;
	}

	public static void setGebruikerDao(GebruikerDAO gebruikerDao) {
		AbonnementView.gebruikerDao = gebruikerDao;
	}

	public static JLabel getLblRoute() {
		return lblRoute;
	}

	public static void setLblRoute(JLabel lblRoute) {
		AbonnementView.lblRoute = lblRoute;
	}

	public static JTextField getTxtRoute() {
		return txtRoute;
	}

	public static void setTxtRoute(JTextField txtRoute) {
		AbonnementView.txtRoute = txtRoute;
	}

	public static JLabel getLblStartDatum() {
		return lblStartDatum;
	}

	public static void setLblStartDatum(JLabel lblStartDatum) {
		AbonnementView.lblStartDatum = lblStartDatum;
	}

	public static JTextField getTxtStartDatum() {
		return txtStartDatum;
	}

	public static void setTxtStartDatum(JTextField txtStartDatum) {
		AbonnementView.txtStartDatum = txtStartDatum;
	}

	public static JLabel getLblEindDatum() {
		return lblEindDatum;
	}

	public static void setLblEindDatum(JLabel lblEindDatum) {
		AbonnementView.lblEindDatum = lblEindDatum;
	}

	public static JTextField getTxtEindDatum() {
		return txtEindDatum;
	}

	public static void setTxtEindDatum(JTextField txtEindDatum) {
		AbonnementView.txtEindDatum = txtEindDatum;
	}

	public static SimpleDateFormat getSdfDate() {
		return sdfDate;
	}

	public static void setSdfDate(SimpleDateFormat sdfDate) {
		AbonnementView.sdfDate = sdfDate;
	}

	public static Date getNow() {
		return now;
	}

	public static void setNow(Date now) {
		AbonnementView.now = now;
	}

	public static String getStrDate() {
		return strDate;
	}

	public static void setStrDate(String strDate) {
		AbonnementView.strDate = strDate;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		AbonnementView.homeController = homeController;
	}

	public static AbonnementController getAbonnementController() {
		return abonnementController;
	}

	public static void setAbonnementController(AbonnementController abonnementController) {
		AbonnementView.abonnementController = abonnementController;
	}

	public static void setMaakAbonnement(JButton maakAbonnement) {
		AbonnementView.maakAbonnement = maakAbonnement;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		AbonnementView.goBackToHome = goBackToHome;
	}

}
