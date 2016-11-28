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
	private static JPanel panel;
	
	private static JLabel lblKlant_Contact;
	private static JComboBox cbxKlant_Contact;
	static KlantDAO klantDao = new KlantDAO();

	private static JLabel lblPrijs;
	private static JComboBox cbxPrijs;
	private static PrijsDAO prijsDao = new PrijsDAO();
	
	private static JLabel lblKorting;
	private static JComboBox cbxKorting;
	private static KortingDAO kortingDao = new KortingDAO();
	
	private static JLabel lblGebruiker;
	private static JComboBox cbxGebruiker;
	private static GebruikerDAO gebruikerDao = new GebruikerDAO();
	
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
	
		ArrayList<Klant> alleKlanten = klantDao.getAll();
		String[] klantLijst = new String[alleKlanten.size()];
		for(int i=0; i < alleKlanten.size(); i++) {
			klantLijst[i] = "" + alleKlanten.get(i).getAchternaam() + alleKlanten.get(i).getVoornaam();
		}
		
		lblKlant_Contact = new JLabel("Klant ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lblKlant_Contact, c);
		
		cbxKlant_Contact = new JComboBox(klantLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		panel.add(cbxKlant_Contact, c);
		
		lblRoute = new JLabel("Route");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblRoute, c);
		
		txtRoute = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		panel.add(txtRoute, c);
		
		lblStartDatum = new JLabel("Start datum ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblStartDatum, c);
		
		txtStartDatum= new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 2;
		txtStartDatum.setText(strDate);
		panel.add(txtStartDatum, c);
		
		lblEindDatum = new JLabel("Eind datum ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(lblEindDatum, c);
		
		txtEindDatum= new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		txtEindDatum.setText(strDate);
		panel.add(txtEindDatum, c);
		
		ArrayList<Prijs> allePrijzen = prijsDao.getAll();
		String[] prijzenLijst = new String[allePrijzen.size()];
		for(int i=0; i < allePrijzen.size(); i++) {
			prijzenLijst[i] = "" + allePrijzen.get(i).getPrijs();
		}
		
		lblPrijs = new JLabel("Prijs ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(lblPrijs, c);
		
		cbxPrijs = new JComboBox(prijzenLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		panel.add(cbxPrijs, c);
		
		ArrayList<Korting> alleKortingen = kortingDao.getAll();
		String[] kortingLijst = new String[alleKortingen.size()];
		for(int i=0; i < alleKortingen.size(); i++) {
			kortingLijst[i] = "" + alleKortingen.get(i).getOmschrijving();
		}
		
		lblKorting = new JLabel("Korting ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(lblKorting, c);
		
		cbxKorting= new JComboBox(kortingLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 5;
		panel.add(cbxKorting, c);
		
		//buttons
		maakAbonnement = new JButton("Abonnement aanmaken");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 6;
		panel.add(maakAbonnement, c);

		goBackToHome = new JButton("Back");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 7;
		panel.add(goBackToHome, c);
			homeController = new HomeController(view);
			abonnementController = new AbonnementController(view);
		return panel;
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
}
