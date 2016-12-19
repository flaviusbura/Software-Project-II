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
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.database.TypeTicketDAO;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.TypeAbonnement;
import be.nmbs.logic.TypeTicket;

public class TicketView {
	private static JPanel panel;
	private static JLabel lblBeginStation;
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
	private static JComboBox stationlijst;
	private static JComboBox beginstationlijst;
	private static JComboBox eindstationlijst;
	private static TicketController ticketController;
	private static PrijsDAO prijsdao;
	private static KortingDAO kortingdao;
	private static StationDAO stationdao;
	static SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	static Date now = new Date();
	static String strDate = sdfDate.format(now);
	
	private static JLabel lblType;
	private static JComboBox<?> cbxType;
	private static JComboBox<TypeTicket> typeLijst;
	private static TypeTicketDAO typeDao = new TypeTicketDAO();
	
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());

		prijsdao = new PrijsDAO();
		kortingdao = new KortingDAO();
		stationdao = new StationDAO();
		GridBagConstraints c = new GridBagConstraints();
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		Date now = new Date();
		String strDate = sdfDate.format(now);
   
		
		ArrayList<StationNMBS> allStations = stationdao.getAll();

		String[] stationLijst = new String[allStations.size()];
		
		for(int i=0; i < allStations.size(); i++) {
			stationLijst[i] = "" + allStations.get(i).getNaam();
		}
		
		
		lblBeginStation = new JLabel("begin station");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lblBeginStation, c);

		beginstationlijst = new JComboBox(stationLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(beginstationlijst, c);

		lblEindStation = new JLabel("eind station");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblEindStation, c);

		
		eindstationlijst = new JComboBox(stationLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(eindstationlijst, c);
		
		lblSoort = new JLabel("soort ticket");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblSoort, c);
		
		txtSoort = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(txtSoort, c);

		lblDatum = new JLabel("datum");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(lblDatum, c);
		
		txtDatum = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		
		
		txtDatum.setText(strDate);
		panel.add(txtDatum, c);
		
		lblKlasse = new JLabel("klasse");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		panel.add(lblKlasse, c);
		
		txtKlasse = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		panel.add(txtKlasse, c);
		
		lblOmschrijving = new JLabel("omschrijving");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		panel.add(lblOmschrijving, c);
		
		txtOmschrijving = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		panel.add(txtOmschrijving, c);
		/*
		lblPrijs = new JLabel("prijs");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 7;
		panel.add(lblPrijs, c);
		

		ArrayList<Prijs> allPrijzen = prijsdao.getAll();

		prijzenLijst = new JComboBox<>();
		for(Prijs prijs : allPrijzen) {
			prijzenLijst.addItem(prijs);
		}
				
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 7;
		panel.add(prijzenLijst, c);
		
		*/
		ArrayList<Korting> allKorting = kortingdao.getAll();
		
		//String[] kortingenLijst = new String[allKorting.size()];
		kortingLijst = new JComboBox<>();
		
		for(Korting korting : allKorting) {
			kortingLijst.addItem(korting);
		}
		
		lblKorting = new JLabel("korting");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 8;
		panel.add(lblKorting, c);
		
		
		
		//kortinglijst = new JComboBox(kortingenLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 8;
		panel.add(kortingLijst, c);
		
		ArrayList<TypeTicket> allType = typeDao.getAll();
		typeLijst = new JComboBox<>();
		for (TypeTicket typeTicket : allType) {
			typeLijst.addItem(typeTicket);
		}

		lblType = new JLabel("Type ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 9;
		panel.add(lblType, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 9;
		panel.add(typeLijst, c);
		
		lblStation = new JLabel("station");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 10;
		panel.add(lblStation, c);
		
		stationlijst = new JComboBox(stationLijst);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 10;
		panel.add(stationlijst, c);
		
		btnKoopTicket = new JButton("koop ticket");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 11;
		panel.add(btnKoopTicket, c);
		
		btnVorigScherm = new JButton("vorig scherm");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 11;
		panel.add(btnVorigScherm, c);
		
		ticketController = new TicketController(view);
		return panel;
	}


	public static JLabel getLblBeginStation() {
		return lblBeginStation;
	}


	public static void setLblBeginStation(JLabel lblBeginStation) {
		TicketView.lblBeginStation = lblBeginStation;
	}


	public static JLabel getLblPrijs() {
		return lblPrijs;
	}


	public static void setLblPrijs(JLabel lblPrijs) {
		TicketView.lblPrijs = lblPrijs;
	}


	public static JLabel getLblOmschrijving() {
		return lblOmschrijving;
	}


	public static void setLblOmschrijving(JLabel lblOmschrijving) {
		TicketView.lblOmschrijving = lblOmschrijving;
	}


	public static JLabel getLblKlasse() {
		return lblKlasse;
	}


	public static void setLblKlasse(JLabel lblKlasse) {
		TicketView.lblKlasse = lblKlasse;
	}


	public static JLabel getLblSoort() {
		return lblSoort;
	}


	public static void setLblSoort(JLabel lblSoort) {
		TicketView.lblSoort = lblSoort;
	}


	public static JLabel getLblEindStation() {
		return lblEindStation;
	}


	public static void setLblEindStation(JLabel lblEindStation) {
		TicketView.lblEindStation = lblEindStation;
	}


	public static JLabel getLblDatum() {
		return lblDatum;
	}


	public static void setLblDatum(JLabel lblDatum) {
		TicketView.lblDatum = lblDatum;
	}


	public static JLabel getLblKorting() {
		return lblKorting;
	}


	public static void setLblKorting(JLabel lblKorting) {
		TicketView.lblKorting = lblKorting;
	}


	public static JLabel getLblStation() {
		return lblStation;
	}


	public static void setLblStation(JLabel lblStation) {
		TicketView.lblStation = lblStation;
	}


	public static JComboBox<Prijs> getPrijzenLijst() {
		return prijzenLijst;
	}


	public static void setPrijzenLijst(JComboBox<Prijs> prijzenLijst) {
		TicketView.prijzenLijst = prijzenLijst;
	}


	public static JComboBox<Korting> getKortingLijst() {
		return kortingLijst;
	}


	public static void setKortingLijst(JComboBox<Korting> kortingLijst) {
		TicketView.kortingLijst = kortingLijst;
	}


	public static PrijsDAO getPrijsdao() {
		return prijsdao;
	}


	public static void setPrijsdao(PrijsDAO prijsdao) {
		TicketView.prijsdao = prijsdao;
	}


	public static KortingDAO getKortingdao() {
		return kortingdao;
	}


	public static void setKortingdao(KortingDAO kortingdao) {
		TicketView.kortingdao = kortingdao;
	}


	public static StationDAO getStationdao() {
		return stationdao;
	}


	public static void setStationdao(StationDAO stationdao) {
		TicketView.stationdao = stationdao;
	}


	public static SimpleDateFormat getSdfDate() {
		return sdfDate;
	}


	public static void setSdfDate(SimpleDateFormat sdfDate) {
		TicketView.sdfDate = sdfDate;
	}


	public static Date getNow() {
		return now;
	}


	public static void setNow(Date now) {
		TicketView.now = now;
	}


	public static String getStrDate() {
		return strDate;
	}


	public static void setStrDate(String strDate) {
		TicketView.strDate = strDate;
	}


	public static JLabel getLblType() {
		return lblType;
	}


	public static void setLblType(JLabel lblType) {
		TicketView.lblType = lblType;
	}


	public static JComboBox<?> getCbxType() {
		return cbxType;
	}


	public static void setCbxType(JComboBox<?> cbxType) {
		TicketView.cbxType = cbxType;
	}


	public static JComboBox<TypeTicket> getTypeLijst() {
		return typeLijst;
	}


	public static void setTypeLijst(JComboBox<TypeTicket> typeLijst) {
		TicketView.typeLijst = typeLijst;
	}


	public static TypeTicketDAO getTypeDao() {
		return typeDao;
	}


	public static void setTypeDao(TypeTicketDAO typeDao) {
		TicketView.typeDao = typeDao;
	}


	public static JComboBox getBeginstationlijst() {
		return beginstationlijst;
	}


	public static void setBeginstationlijst(JComboBox beginstationlijst) {
		TicketView.beginstationlijst = beginstationlijst;
	}


	public static JComboBox getEindstationlijst() {
		return eindstationlijst;
	}


	public static void setEindstationlijst(JComboBox eindstationlijst) {
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
	
	


	public static JComboBox getPrijzenlijst() {
		return prijzenLijst;
	}


	public static void setPrijzenlijst(JComboBox<Prijs> prijzenLijst) {
		TicketView.prijzenLijst = prijzenLijst;
	}


	public static JComboBox getKortinglijst() {
		return kortingLijst;
	}


	public static void setKortinglijst(JComboBox kortinglijst) {
		TicketView.kortingLijst = kortinglijst;
	}


	public static JComboBox getStationlijst() {
		return stationlijst;
	}


	public static void setStationlijst(JComboBox stationlijst) {
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
		txtDatum.setText(strDate);
		
		
	}
	
}
