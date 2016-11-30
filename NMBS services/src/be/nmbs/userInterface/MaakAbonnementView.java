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

import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.MaakAbonnementController;
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
public class MaakAbonnementView {
	private static JButton maakAbonnement3;
	private static JButton maakAbonnement6;
	private static JButton maakAbonnement9;
	private static JButton maakAbonnement12;
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
	private static MaakAbonnementController maakAbonnementController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		ArrayList<Klant> allKlanten = klantDao.getAll();
		klantenLijst = new JComboBox<>();
		for (Klant klant : allKlanten) {
			klantenLijst.addItem(klant);
		}
		
		
		lblKlant_Contact = new JLabel("Klanten");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lblKlant_Contact, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(klantenLijst, c);

		
		ArrayList<Gebruiker> alleGebruiker = gebruikerDao.getAll();
		gebruikerLijst = new JComboBox<>();
		for (Gebruiker gebruiker : alleGebruiker) {
			gebruikerLijst.addItem(gebruiker);
		}
		
		
		lblGebruiker = new JLabel("GebruikerID ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblGebruiker, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		panel.add(gebruikerLijst, c);

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
		maakAbonnement3 = new JButton("Drie maanden");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 7;
		panel.add(maakAbonnement3, c);
		
		
		maakAbonnement6 = new JButton("Zes maanden");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 8;
		panel.add(maakAbonnement6, c);
		maakAbonnement9 = new JButton("Negen maanden");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 9;
		panel.add(maakAbonnement9, c);
		maakAbonnement12 = new JButton("Twaalf maanden");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 10;
		panel.add(maakAbonnement12, c);
		
		goBackToHome = new JButton("Back");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 12;
		panel.add(goBackToHome, c);
		
	
		
		homeController = new HomeController(view);
		maakAbonnementController = new MaakAbonnementController(view);
		return panel;
	}

	

	public static JButton getMaakAbonnement3() {
		return maakAbonnement3;
	}



	public static void setMaakAbonnement3(JButton maakAbonnement3) {
		MaakAbonnementView.maakAbonnement3 = maakAbonnement3;
	}



	public static JButton getMaakAbonnement6() {
		return maakAbonnement6;
	}



	public static void setMaakAbonnement6(JButton maakAbonnement6) {
		MaakAbonnementView.maakAbonnement6 = maakAbonnement6;
	}



	public static JButton getMaakAbonnement9() {
		return maakAbonnement9;
	}



	public static void setMaakAbonnement9(JButton maakAbonnement9) {
		MaakAbonnementView.maakAbonnement9 = maakAbonnement9;
	}



	public static JButton getMaakAbonnement12() {
		return maakAbonnement12;
	}



	public static void setMaakAbonnement12(JButton maakAbonnement12) {
		MaakAbonnementView.maakAbonnement12 = maakAbonnement12;
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

	public static JComboBox getCbxKlant_Contact() {
		return cbxKlant_Contact;
	}

	public static void setCbxKlant_Contact(JComboBox cbxKlant_Contact) {
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

	public static JComboBox getCbxPrijs() {
		return cbxPrijs;
	}

	public static void setCbxPrijs(JComboBox cbxPrijs) {
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

	public static JComboBox getCbxKorting() {
		return cbxKorting;
	}

	public static void setCbxKorting(JComboBox cbxKorting) {
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

	public static JComboBox getCbxGebruiker() {
		return cbxGebruiker;
	}

	public static void setCbxGebruiker(JComboBox cbxGebruiker) {
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

	public static JLabel getLblRoute() {
		return lblRoute;
	}

	public static void setLblRoute(JLabel lblRoute) {
		MaakAbonnementView.lblRoute = lblRoute;
	}

	public static JTextField getTxtRoute() {
		return txtRoute;
	}

	public static void setTxtRoute(JTextField txtRoute) {
		MaakAbonnementView.txtRoute = txtRoute;
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


}
