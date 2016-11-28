package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.AbonnementController;
import be.nmbs.controllers.BoeteController;
import be.nmbs.controllers.HomeController;

public class BoeteView {

	private static JButton back;
	private static JButton maakBoete;
	private static JButton betaalBoete;
	private static JPanel panel;
	private static JLabel lblBoeteId;
	private static JLabel lblKlantContactId;
	@SuppressWarnings("unused")
	private static HomeController homeController;
	@SuppressWarnings("unused")
	private static BoeteController abonnementController;
	private static JCheckBox cbBetaald;
	public static JLabel getLblBoeteId() {
		return lblBoeteId;
	}

	public static void setLblBoeteId(JLabel lblBoeteId) {
		BoeteView.lblBoeteId = lblBoeteId;
	}

	public static JLabel getLblKlantContactId() {
		return lblKlantContactId;
	}

	public static void setLblKlantContactId(JLabel lblKlantContactId) {
		BoeteView.lblKlantContactId = lblKlantContactId;
	}

	public static JTextField getTxtBoeteId() {
		return txtBoeteId;
	}

	public static void setTxtBoeteId(JTextField txtBoeteId) {
		BoeteView.txtBoeteId = txtBoeteId;
	}

	public static JTextField getTxtKlantContactId() {
		return txtKlantContactId;
	}

	public static void setTxtKlantContactId(JTextField txtKlantContactId) {
		BoeteView.txtKlantContactId = txtKlantContactId;
	}

	private static JLabel lblPrijs;
	private static JLabel lblDatum;
	private static JLabel lblBetaalDatum;
	private static JLabel lblBetaald;
	private static JTextField txtBoeteId;
	private static JTextField txtKlantContactId;
	private static JTextField txtPrijs;
	private static JTextField txtDatum;
	private static JTextField txtBetaalDatum;
	private static JTextField txtBetaald;
	static SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	static Date now = new Date();
	static String strDate = sdfDate.format(now);
	
	private static BoeteController boeteController;
	@SuppressWarnings("static-access")
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
				
		lblBetaalDatum = new JLabel("betaal datum");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblBetaalDatum, c);
		
		txtBetaalDatum = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		txtBetaalDatum.setText(strDate);
		panel.add(txtBetaalDatum, c);
		
		lblBoeteId = new JLabel("boete id");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblBoeteId, c);
		
		txtBoeteId = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(txtBoeteId, c);
			
		lblBetaald = new JLabel("betaald");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(lblBetaald, c);
		
		cbBetaald = new JCheckBox("Betaald", true);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(cbBetaald, c);
		
		
		betaalBoete = new JButton("betaal boete");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		panel.add(betaalBoete, c);
		
		back = new JButton("Back");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		panel.add(back, c);
		boeteController = new BoeteController(view);
		
		return panel;
	}

	public static JButton getBetaalBoete() {
		return betaalBoete;
	}

	public static void setMaakBoete(JButton maakBoete) {
		BoeteView.maakBoete = maakBoete;
	}

	public static JButton getMaakBoete() {
		return maakBoete;
	}

	public static void setBetaalBoete(JButton maakBoete) {
		BoeteView.maakBoete = maakBoete;
	}

	public static JCheckBox getCbBetaald() {
		return cbBetaald;
	}

	public static void setCbBetaald(JCheckBox cbBetaald) {
		BoeteView.cbBetaald = cbBetaald;
	}

	

	public static JButton getBack() {
		return back;
	}

	public static void setBack(JButton back) {
		BoeteView.back = back;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		BoeteView.panel = panel;
	}

	public static JLabel getLblPrijs() {
		return lblPrijs;
	}

	public static void setLblPrijs(JLabel lblPrijs) {
		BoeteView.lblPrijs = lblPrijs;
	}

	public static JLabel getLblDatum() {
		return lblDatum;
	}

	public static void setLblDatum(JLabel lblDatum) {
		BoeteView.lblDatum = lblDatum;
	}

	public static JLabel getLblBetaalDatum() {
		return lblBetaalDatum;
	}

	public static void setLblBetaalDatum(JLabel lblBetaalDatum) {
		BoeteView.lblBetaalDatum = lblBetaalDatum;
	}

	public static JLabel getLblBetaald() {
		return lblBetaald;
	}

	public static void setLblBetaald(JLabel lblBetaald) {
		BoeteView.lblBetaald = lblBetaald;
	}

	public static JTextField getTxtPrijs() {
		return txtPrijs;
	}

	public static void setTxtPrijs(JTextField txtPrijs) {
		BoeteView.txtPrijs = txtPrijs;
	}

	public static JTextField getTxtDatum() {
		return txtDatum;
	}

	public static void setTxtDatum(JTextField txtDatum) {
		BoeteView.txtDatum = txtDatum;
	}

	public static JTextField getTxtBetaalDatum() {
		return txtBetaalDatum;
	}

	public static void setTxtBetaalDatum(JTextField txtBetaalDatum) {
		BoeteView.txtBetaalDatum = txtBetaalDatum;
	}

	public static JTextField getTxtBetaald() {
		return txtBetaald;
	}

	public static void setTxtBetaald(JTextField txtBetaald) {
		BoeteView.txtBetaald = txtBetaald;
	}

	public static SimpleDateFormat getSdfDate() {
		return sdfDate;
	}

	public static void setSdfDate(SimpleDateFormat sdfDate) {
		BoeteView.sdfDate = sdfDate;
	}

	public static Date getNow() {
		return now;
	}

	public static void setNow(Date now) {
		BoeteView.now = now;
	}

	public static String getStrDate() {
		return strDate;
	}

	public static void setStrDate(String strDate) {
		BoeteView.strDate = strDate;
	}

	public static BoeteController getBoeteController() {
		return boeteController;
	}

	public static void setBoeteController(BoeteController boeteController) {
		BoeteView.boeteController = boeteController;
	}
	public static void setHomeControllerToNull() {
		homeController = null;
	}
	public static void setBoeteControllerToNull() {
		boeteController = null;
		
	}
	
}
