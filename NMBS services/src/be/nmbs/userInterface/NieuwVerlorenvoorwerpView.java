package be.nmbs.userInterface;

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

import be.nmbs.controllers.NieuwVerlorenvoorwerpController;
import be.nmbs.controllers.VerlorenvoorwerpController;
import be.nmbs.database.StationDAO;
import be.nmbs.database.VerlorenVoorwerpenDAO;
import be.nmbs.logic.StationNMBS;

public class NieuwVerlorenvoorwerpView {
	
	private static JPanel panel;
	private static JLabel lblType;
	private static JTextField txtType;
	private static JButton btnToevoegen;
	private static JLabel lblStation;
	private static JComboBox cbStation;
	private static JLabel lblOmschrijving;
	private static JTextField txtOmschrijving;
	private static JLabel lblDatum;
	private static JTextField txtDatum;
	private static NieuwVerlorenvoorwerpController nieuwVerlorenvoorwerpController;
	private static JButton btnTerug;
	
	
	public static JPanel initialize(View view) {
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			Date now = new Date();
			String strDate = sdfDate.format(now);
		
			panel = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			
			StationDAO stationdao = new StationDAO();
			ArrayList<StationNMBS> allStations = stationdao.getAll();

			String[] stationLijst = new String[allStations.size()];
			
			for(int i=0; i < allStations.size(); i++) {
				stationLijst[i] = "" + allStations.get(i).getNaam();
			}

			lblStation = new JLabel("Station");
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 1;
			c.gridy = 0;
			panel.add(lblStation, c);
			
			cbStation = new JComboBox(stationLijst);
			c.fill = new GridBagConstraints().HORIZONTAL;
			c.gridx = 2;
			c.gridy = 0;
			panel.add(cbStation, c);
			
			lblOmschrijving = new JLabel("omschrijving");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 1;
			panel.add(lblOmschrijving, c);

			
			txtOmschrijving = new JTextField(10);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 2;
			c.gridy = 1;
			panel.add(txtOmschrijving, c);

			lblType = new JLabel("type");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 2;
			panel.add(lblType, c);

			
			txtType = new JTextField(10);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 2;
			c.gridy = 2;
			panel.add(txtType, c);
			
			lblDatum = new JLabel("datum");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 1;
			c.gridy = 3;
			panel.add(lblDatum, c);
			
			txtDatum = new JTextField(10);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 2;
			c.gridy = 3;
			
			
			txtDatum.setText(strDate);
			panel.add(txtDatum, c);

	
			
			btnToevoegen = new JButton("toevoegen");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 2;
			c.gridy = 4;
			panel.add(btnToevoegen, c);
			
			btnTerug = new JButton("terug");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 3;
			c.gridy = 4;
			panel.add(btnTerug, c);
			
			
			
			nieuwVerlorenvoorwerpController = new NieuwVerlorenvoorwerpController(view);
			return panel;
		}
	
	public static JButton getBtnTerug() {
		return btnTerug;
	}

	public static void setBtnTerug(JButton btnTerug) {
		NieuwVerlorenvoorwerpView.btnTerug = btnTerug;
	}

	public static JLabel getLblType() {
		return lblType;
	}

	public static void setLblType(JLabel lblType) {
		NieuwVerlorenvoorwerpView.lblType = lblType;
	}

	public static JTextField getTxtType() {
		return txtType;
	}

	public static void setTxtType(JTextField txtType) {
		NieuwVerlorenvoorwerpView.txtType = txtType;
	}

	public static JButton getBtnToevoegen() {
		return btnToevoegen;
	}

	public static void setBtnToevoegen(JButton btnToevoegen) {
		NieuwVerlorenvoorwerpView.btnToevoegen = btnToevoegen;
	}

	public static JLabel getLblStation() {
		return lblStation;
	}

	public static void setLblStation(JLabel lblStation) {
		NieuwVerlorenvoorwerpView.lblStation = lblStation;
	}

	public static JComboBox getCbStation() {
		return cbStation;
	}

	public static void setCbStation(JComboBox cbStation) {
		NieuwVerlorenvoorwerpView.cbStation = cbStation;
	}

	public static JLabel getLblOmschrijving() {
		return lblOmschrijving;
	}

	public static void setLblOmschrijving(JLabel lblOmschrijving) {
		NieuwVerlorenvoorwerpView.lblOmschrijving = lblOmschrijving;
	}

	public static JTextField getTxtOmschrijving() {
		return txtOmschrijving;
	}

	public static void setTxtOmschrijving(JTextField txtOmschrijving) {
		NieuwVerlorenvoorwerpView.txtOmschrijving = txtOmschrijving;
	}

	public static JLabel getLblDatum() {
		return lblDatum;
	}

	public static void setLblDatum(JLabel lblDatum) {
		NieuwVerlorenvoorwerpView.lblDatum = lblDatum;
	}

	public static JTextField getTxtDatum() {
		return txtDatum;
	}

	public static void setTxtDatum(JTextField txtDatum) {
		NieuwVerlorenvoorwerpView.txtDatum = txtDatum;
	}

	public static void setNieuwVerlorenvoorwerpControllerToNull() {
		nieuwVerlorenvoorwerpController = null;
	}


	public static void clearFields() {
		txtType.setText("");
		txtOmschrijving.setText("");
		
		
	}

}
