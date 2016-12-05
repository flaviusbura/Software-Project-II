package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.*;
import be.nmbs.database.AbonnementDAO;
import be.nmbs.logic.Abonnement;
import be.nmbs.logic.Korting;

/**
 * 
 * @author Abdel-Portable
 *
 */
public class VerlengAbonnementView {
	private static JButton goBackToHome;
	private static JButton verlengMaanden;
	private static JButton verleng3Maanden;
	private static JButton verleng6Maanden;
	private static JButton verleng9Maanden;
	private static JButton verleng12Maanden;
	private static JPanel panel;
	private static JLabel lblAbonnementID;
	private static JTextField txtId;
	private static JComboBox<?> cbxAbonnement;
	private static JComboBox<Abonnement> AbonnementLijst;
	static AbonnementDAO abonnementDao = new AbonnementDAO();
	private static HomeController homeController;
	private static VerlengAbonnementController verlengAbonnementController;
	private static JLabel lblMaanden;
	static String[] tab = {"3 maanden", "6 maanden", "9 maanden", "12 maanden"};
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox combo = new JComboBox(tab);
	
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		ArrayList<Abonnement> allAbonnement = abonnementDao.getAll();
		AbonnementLijst = new JComboBox<>();
		for (Abonnement abo : allAbonnement) {
			AbonnementLijst.addItem(abo);
		}
		
		lblAbonnementID = new JLabel("Abonnement ID ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblAbonnementID, c);

		
		txtId = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(txtId, c);
		
		lblMaanden = new JLabel("Verleng ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblMaanden, c);

		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(combo, c);
		
		verlengMaanden = new JButton("Verlengen");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 5;
		panel.add(verlengMaanden, c);
		
		goBackToHome = new JButton("Back");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 6;
		panel.add(goBackToHome, c);
		
	
		
		homeController = new HomeController(view);
		verlengAbonnementController = new VerlengAbonnementController(view);
		return panel;
	}

	
	public static JTextField getTxtId() {
		return txtId;
	}


	public static void setTxtId(JTextField txtId) {
		VerlengAbonnementView.txtId = txtId;
	}


	public static JButton getVerlengMaanden() {
		return verlengMaanden;
	}


	public static void setVerlengMaanden(JButton verlengMaanden) {
		VerlengAbonnementView.verlengMaanden = verlengMaanden;
	}


	public static JLabel getLblMaanden() {
		return lblMaanden;
	}


	public static void setLblMaanden(JLabel lblMaanden) {
		VerlengAbonnementView.lblMaanden = lblMaanden;
	}


	public static String[] getTab() {
		return tab;
	}


	public static void setTab(String[] tab) {
		VerlengAbonnementView.tab = tab;
	}


	public static JComboBox getCombo() {
		return combo;
	}


	public static void setCombo(JComboBox combo) {
		VerlengAbonnementView.combo = combo;
	}


	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		VerlengAbonnementView.goBackToHome = goBackToHome;
	}

	public static JButton getVerleng3Maanden() {
		return verleng3Maanden;
	}

	public static void setVerleng3Maanden(JButton verleng3Maanden) {
		VerlengAbonnementView.verleng3Maanden = verleng3Maanden;
	}

	public static JButton getVerleng6Maanden() {
		return verleng6Maanden;
	}

	public static void setVerleng6Maanden(JButton verleng6Maanden) {
		VerlengAbonnementView.verleng6Maanden = verleng6Maanden;
	}

	public static JButton getVerleng9Maanden() {
		return verleng9Maanden;
	}

	public static void setVerleng9Maanden(JButton verleng9Maanden) {
		VerlengAbonnementView.verleng9Maanden = verleng9Maanden;
	}

	public static JButton getVerleng12Maanden() {
		return verleng12Maanden;
	}

	public static void setVerleng12Maanden(JButton verleng12Maanden) {
		VerlengAbonnementView.verleng12Maanden = verleng12Maanden;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		VerlengAbonnementView.panel = panel;
	}

	public static JLabel getLblAbonnementID() {
		return lblAbonnementID;
	}

	public static void setLblAbonnementID(JLabel lblAbonnementID) {
		VerlengAbonnementView.lblAbonnementID = lblAbonnementID;
	}

	public static JComboBox<?> getCbxAbonnement() {
		return cbxAbonnement;
	}

	public static void setCbxAbonnement(JComboBox<?> cbxAbonnement) {
		VerlengAbonnementView.cbxAbonnement = cbxAbonnement;
	}


	public static JComboBox<Abonnement> getAbonnementLijst() {
		return AbonnementLijst;
	}


	public static void setAbonnementLijst(JComboBox<Abonnement> abonnementLijst) {
		AbonnementLijst = abonnementLijst;
	}


	public static AbonnementDAO getAbonnementDao() {
		return abonnementDao;
	}

	public static void setAbonnementDao(AbonnementDAO abonnementDao) {
		VerlengAbonnementView.abonnementDao = abonnementDao;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		VerlengAbonnementView.homeController = homeController;
	}

	public static VerlengAbonnementController getVerlengAbonnementController() {
		return verlengAbonnementController;
	}

	public static void setVerlengAbonnementController(VerlengAbonnementController verlengAbonnementController) {
		VerlengAbonnementView.verlengAbonnementController = verlengAbonnementController;
	}
	
	public static void setVerlengAbonnementControllerToNull() {
		verlengAbonnementController = null;
	}
	
	public static void setHomeControllerToNull() {
		homeController = null;
	}

}
