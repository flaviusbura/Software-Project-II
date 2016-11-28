package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.experimental.theories.Theories;

import be.nmbs.controllers.KlantenBeheerController;
import be.nmbs.controllers.NieuwAbonnementAanmakenController;
import be.nmbs.database.KortingDAO;
import be.nmbs.database.PrijsDAO;
import be.nmbs.database.StationDAO;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.StationNMBS;

public class NieuwAbonnementAanmakenView {
	private static JButton aboMaken;
	private static JButton actieAnnuleren;
	private static JLabel voornaam;
	private static JTextField voornaamText;
	private static JLabel naam;
	private static JTextField naamText;
	private static JLabel vanlbl;
	private static JComboBox van;
	private static JComboBox naar;
	private static JLabel naarlbl;
	private static JLabel lengtelbl;
	private static JComboBox lengte;
	private static JLabel prijslbl;
	private static JLabel kortinglbl;
	private static JComboBox<Prijs> prijsCombo;
	private static JComboBox<Korting> kortingCombo;
	private static JPanel panel;
	@SuppressWarnings("unused")
	private static NieuwAbonnementAanmakenController nieuwAbonnementAanmakenController;

	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());

			voornaam = new JLabel("Voornaam");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(voornaam, c);

			voornaamText = new JTextField(30);
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			panel.add(voornaamText, c);
			
			naam = new JLabel("Naam");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 1;
			panel.add(naam, c);
			
			naamText = new JTextField(30);
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			panel.add(naamText, c);
			
			StationDAO stationdao = new StationDAO();
			ArrayList<StationNMBS> allStations = stationdao.getAll();

			String[] stationLijst = new String[allStations.size()];
			
			for(int i=0; i < allStations.size(); i++) {
				stationLijst[i] = "" + allStations.get(i).getNaam();
			}

			vanlbl = new JLabel("Van");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 2;
			panel.add(vanlbl, c);
			
			van = new JComboBox(stationLijst);
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			panel.add(van, c);
			
			naarlbl = new JLabel("Naar");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 3;
			panel.add(naarlbl, c);
			
			naar = new JComboBox(stationLijst);
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			panel.add(naar, c);
			
			String[] lengteAbo = {"3 Maand", "6 Maand", "9 Maand", "1 Jaar"};
			
			lengtelbl = new JLabel("Lengte");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 4;
			panel.add(lengtelbl, c);
			
			lengte = new JComboBox(lengteAbo);
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 4;
			panel.add(lengte, c);
			
			prijslbl = new JLabel("Prijs");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 5;
			panel.add(prijslbl, c);
			
			PrijsDAO prijsdao = new PrijsDAO();
			ArrayList<Prijs> allPrijzen = prijsdao.getAll();

			prijsCombo = new JComboBox<>();
			for(Prijs prijs : allPrijzen) {
				prijsCombo.addItem(prijs);
			}
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 5;
			panel.add(prijsCombo, c);
			
			kortinglbl = new JLabel("Korting");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 6;
			panel.add(kortinglbl, c);
			
			KortingDAO kortingdao = new KortingDAO();
			ArrayList<Korting> allKorting = kortingdao.getAll();
			
			kortingCombo = new JComboBox<>();
			
			for(Korting korting : allKorting) {
				kortingCombo.addItem(korting);
			}
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 6;
			panel.add(kortingCombo, c);
			
			aboMaken = new JButton("Abonnement maken");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 0;
			c.gridy = 7;
			panel.add(aboMaken, c);
			
			actieAnnuleren = new JButton("Actie annuleren");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 7;
			panel.add(actieAnnuleren, c);
			
			nieuwAbonnementAanmakenController = new NieuwAbonnementAanmakenController(view);
			return panel;
	}
	
	public static JButton getAboMaken() {
		return aboMaken;
	}

	public static JButton getActieAnnuleren() {
		return actieAnnuleren;
	}

	public static JLabel getVoornaam() {
		return voornaam;
	}

	public static JTextField getVoornaamText() {
		return voornaamText;
	}

	public static JLabel getNaam() {
		return naam;
	}

	public static JTextField getNaamText() {
		return naamText;
	}

	public static JComboBox getVan() {
		return van;
	}

	public static JComboBox getNaar() {
		return naar;
	}

	public static JLabel getVanlbl() {
		return vanlbl;
	}

	public static JLabel getNaarlbl() {
		return naarlbl;
	}

	public static JLabel getLengtelbl() {
		return lengtelbl;
	}

	public static JLabel getPrijslbl() {
		return prijslbl;
	}

	public static JLabel getKortinglbl() {
		return kortinglbl;
	}

	public static JComboBox<Prijs> getPrijsCombo() {
		return prijsCombo;
	}

	public static JComboBox<Korting> getKortingCombo() {
		return kortingCombo;
	}
	
	public static void setNieuwAbonnementAanmakenControllerToNull() {
		nieuwAbonnementAanmakenController = null;
	}
}
