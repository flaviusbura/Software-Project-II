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

import be.nmbs.controllers.TicketController;
import be.nmbs.database.KortingDAO;
import be.nmbs.database.PrijsDAO;
import be.nmbs.database.StationDAO;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.StationNMBS;

public class TicketView {
	private static JPanel panel;

	private static JTextField txtSoort;
	private static JTextField txtDatum;
	private static JTextField txtKlasse;
	private static JTextField txtOmschrijving;
	private static JLabel lblPrijs;
	private static JLabel lblOmschrijving;
	private static JLabel lblKlasse;
	private static JLabel lblSoort;
	private static JLabel lblEindStation;
	private static JLabel lblDatum;
	private static JLabel lblKorting;
	private static JLabel lblStation;
	private static JButton btnKoopTicket;
	private static JButton btnVorigScherm;
	private static JComboBox<Prijs> prijzenLijst;
	private static JComboBox<Korting> kortingLijst;
	private static JComboBox<String> stationlijst;
	private static JComboBox<String> beginstationlijst;
	private static JComboBox<String> eindstationlijst;
	private static TicketController ticketController;
	private static PrijsDAO prijsdao;
	private static KortingDAO kortingdao;
	private static StationDAO stationdao;
	private static JLabel lblBeginStation;
	
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		prijsdao = new PrijsDAO();
		kortingdao = new KortingDAO();
		stationdao = new StationDAO();
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		
		ArrayList<StationNMBS> allStations = stationdao.getAll();

		String[] stationLijst = new String[allStations.size()];
		
		for(int i=0; i < allStations.size(); i++) {
			stationLijst[i] = "" + allStations.get(i).getNaam();
		}
		
		lblBeginStation = new JLabel("begin station");
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lblBeginStation, c);

		beginstationlijst = new JComboBox<String>(stationLijst);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(beginstationlijst, c);

		lblEindStation = new JLabel("eind station");
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblEindStation, c);
		
		eindstationlijst = new JComboBox<String>(stationLijst);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(eindstationlijst, c);
		
		lblSoort = new JLabel("soort ticket");
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblSoort, c);
		
		txtSoort = new JTextField(10);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(txtSoort, c);

		lblDatum = new JLabel("datum");
		c.gridx = 0;
		c.gridy = 3;
		panel.add(lblDatum, c);
		
		txtDatum = new JTextField(10);
		c.gridx = 1;
		c.gridy = 3;
		txtDatum.setText(strDate);
		panel.add(txtDatum, c);
		
		lblKlasse = new JLabel("klasse");
		c.gridx = 0;
		c.gridy = 5;
		panel.add(lblKlasse, c);
		
		txtKlasse = new JTextField(10);
		c.gridx = 1;
		c.gridy = 5;
		panel.add(txtKlasse, c);
		
		lblOmschrijving = new JLabel("omschrijving");
		c.gridx = 0;
		c.gridy = 6;
		panel.add(lblOmschrijving, c);
		
		txtOmschrijving = new JTextField(10);
		c.gridx = 1;
		c.gridy = 6;
		panel.add(txtOmschrijving, c);
		
		lblPrijs = new JLabel("prijs");
		c.gridx = 0;
		c.gridy = 7;
		panel.add(lblPrijs, c);
		
		ArrayList<Prijs> allPrijzen = prijsdao.getAll();

		prijzenLijst = new JComboBox<Prijs>();
		for(Prijs prijs : allPrijzen) {
			prijzenLijst.addItem(prijs);
		}
				
		c.gridx = 1;
		c.gridy = 7;
		panel.add(prijzenLijst, c);
		
		lblKorting = new JLabel("korting");
		c.gridx = 0;
		c.gridy = 8;
		panel.add(lblKorting, c);
			
		ArrayList<Korting> allKorting = kortingdao.getAll();
		kortingLijst = new JComboBox<Korting>();
		
		for(Korting korting : allKorting) {
			kortingLijst.addItem(korting);
		}
		
		c.gridx = 1;
		c.gridy = 8;
		panel.add(kortingLijst, c);
		
		lblStation = new JLabel("station");
		c.gridx = 0;
		c.gridy = 9;
		panel.add(lblStation, c);
		
		stationlijst = new JComboBox<String>(stationLijst);
		c.gridx = 1;
		c.gridy = 9;
		panel.add(stationlijst, c);
		
		btnKoopTicket = new JButton("Koop ticket");
		c.gridx = 0;
		c.gridy = 10;
		panel.add(btnKoopTicket, c);
		
		btnVorigScherm = new JButton("Vorig scherm");
		c.gridx = 1;
		c.gridy = 10;
		panel.add(btnVorigScherm, c);
		
		ticketController = new TicketController(view);
		return panel;
	}

	public static JComboBox<String> getBeginstationlijst() {
		return beginstationlijst;
	}

	public static void setBeginstationlijst(JComboBox<String> beginstationlijst) {
		TicketView.beginstationlijst = beginstationlijst;
	}

	public static JComboBox<String> getEindstationlijst() {
		return eindstationlijst;
	}

	public static void setEindstationlijst(JComboBox<String> eindstationlijst) {
		TicketView.eindstationlijst = eindstationlijst;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		TicketView.panel = panel;
	}

	public static JButton getBtnKoopTicket() {
		return btnKoopTicket;
	}

	public static JComboBox<Prijs> getPrijzenlijst() {
		return prijzenLijst;
	}

	public static void setPrijzenlijst(JComboBox<Prijs> prijzenLijst) {
		TicketView.prijzenLijst = prijzenLijst;
	}

	public static JComboBox<Korting> getKortinglijst() {
		return kortingLijst;
	}

	public static void setKortinglijst(JComboBox<Korting> kortinglijst) {
		TicketView.kortingLijst = kortinglijst;
	}

	public static JComboBox<String> getStationlijst() {
		return stationlijst;
	}

	public static void setStationlijst(JComboBox<String> stationlijst) {
		TicketView.stationlijst = stationlijst;
	}

	public static void setBtnKoopTicket(JButton btnKoopTicket) {
		TicketView.btnKoopTicket = btnKoopTicket;
	}

	public static JButton getBtnVorigScherm() {
		return btnVorigScherm;
	}

	public static void setBtnVorigScherm(JButton btnVorigScherm) {
		TicketView.btnVorigScherm = btnVorigScherm;
	}

	public static TicketController getTicketController() {
		return ticketController;
	}

	public static void setTicketController(TicketController ticketController) {
		TicketView.ticketController = ticketController;
	}
	
	public static void setTicketControllerToNull() {
		ticketController = null;
	}
	
	public static void setHomeControllerToNull() {
		ticketController = null;
	}

	public static void clearFields() {
		txtSoort.setText("");
		txtOmschrijving.setText("");
		txtKlasse.setText("");
	}
	
	public static JTextField getTxtSoort() {
		return txtSoort;
	}

	public static void setTxtSoort(JTextField txtSoort) {
		TicketView.txtSoort = txtSoort;
	}

	public static JTextField getTxtDatum() {
		return txtDatum;
	}

	public static void setTxtDatum(JTextField txtDatum) {
		TicketView.txtDatum = txtDatum;
	}

	public static JTextField getTxtKlasse() {
		return txtKlasse;
	}

	public static void setTxtKlasse(JTextField txtKlasse) {
		TicketView.txtKlasse = txtKlasse;
	}

	public static JTextField getTxtOmschrijving() {
		return txtOmschrijving;
	}

	public static void setTxtOmschrijving(JTextField txtOmschrijving) {
		TicketView.txtOmschrijving = txtOmschrijving;
	}
}
