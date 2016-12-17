package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.CoefficientAbonnement_UpdateController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.logic.TypeAbonnement;

public class CoefficientAbonnement_UpdateView {
	private static JButton updateCoeff;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JPanel tPanel;
	private static JLabel lblCoeff;
	private static JLabel lblCoeff2;
	private static JLabel lblCoeff3;
	private static JTextField txtCoeff;
	private static JLabel lblTypeId;
	private static String coeff;
	private static JComboBox<TypeAbonnement> typeLijst;
	private static TypeAbonnementDAO typeAboDao = new TypeAbonnementDAO();

	private static HomeController homeController;
	private static CoefficientAbonnement_UpdateController coefficientAbonnement_UpdateController;
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	
		lblTypeId = new JLabel("Type Abonnement");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lblTypeId, c);
		
		ArrayList<TypeAbonnement> allType = typeAboDao.getAll();
		typeLijst = new JComboBox<>();
		for (TypeAbonnement ta : allType) {
			typeLijst.addItem(ta);
		}
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(typeLijst, c);
		
		
		lblCoeff3 = new JLabel("Update naar: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblCoeff3, c);
		
		txtCoeff = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(txtCoeff, c);

		

		// buttons
		updateCoeff = new JButton("Coefficient Updaten");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(updateCoeff, c);
		
		goBackToHome = new JButton("Home");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(goBackToHome, c);

		homeController = new HomeController(view);
		coefficientAbonnement_UpdateController = new CoefficientAbonnement_UpdateController(view);
		return panel;

	}
	
	public static void CoefficientAbonnement_UpdateController()
	{
		coefficientAbonnement_UpdateController = null;
	}
	public static void HomeControllerControllerToNull()
	{
		homeController= null;
	}

	public static JButton getUpdateCoeff() {
		return updateCoeff;
	}

	public static void setUpdateCoeff(JButton updateCoeff) {
		CoefficientAbonnement_UpdateView.updateCoeff = updateCoeff;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		CoefficientAbonnement_UpdateView.goBackToHome = goBackToHome;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		CoefficientAbonnement_UpdateView.panel = panel;
	}

	public static JPanel gettPanel() {
		return tPanel;
	}

	public static void settPanel(JPanel tPanel) {
		CoefficientAbonnement_UpdateView.tPanel = tPanel;
	}

	public static JLabel getLblCoeff() {
		return lblCoeff;
	}

	public static void setLblCoeff(JLabel lblCoeff) {
		CoefficientAbonnement_UpdateView.lblCoeff = lblCoeff;
	}

	public static JLabel getLblCoeff2() {
		return lblCoeff2;
	}

	public static void setLblCoeff2(JLabel lblCoeff2) {
		CoefficientAbonnement_UpdateView.lblCoeff2 = lblCoeff2;
	}

	public static JLabel getLblCoeff3() {
		return lblCoeff3;
	}

	public static void setLblCoeff3(JLabel lblCoeff3) {
		CoefficientAbonnement_UpdateView.lblCoeff3 = lblCoeff3;
	}

	public static JTextField getTxtCoeff() {
		return txtCoeff;
	}

	public static void setTxtCoeff(JTextField txtCoeff) {
		CoefficientAbonnement_UpdateView.txtCoeff = txtCoeff;
	}

	public static JLabel getLblTypeId() {
		return lblTypeId;
	}

	public static void setLblTypeId(JLabel lblTypeId) {
		CoefficientAbonnement_UpdateView.lblTypeId = lblTypeId;
	}

	public static String getCoeff() {
		return coeff;
	}

	public static void setCoeff(String coeff) {
		CoefficientAbonnement_UpdateView.coeff = coeff;
	}

	public static JComboBox<TypeAbonnement> getTypeLijst() {
		return typeLijst;
	}

	public static void setTypeLijst(JComboBox<TypeAbonnement> typeLijst) {
		CoefficientAbonnement_UpdateView.typeLijst = typeLijst;
	}

	public static TypeAbonnementDAO getTypeAboDao() {
		return typeAboDao;
	}

	public static void setTypeAboDao(TypeAbonnementDAO typeAboDao) {
		CoefficientAbonnement_UpdateView.typeAboDao = typeAboDao;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		CoefficientAbonnement_UpdateView.homeController = homeController;
	}

	public static CoefficientAbonnement_UpdateController getCoefficientAbonnement_UpdateController() {
		return coefficientAbonnement_UpdateController;
	}

	public static void setCoefficientAbonnement_UpdateController(
			CoefficientAbonnement_UpdateController coefficientAbonnement_UpdateController) {
		CoefficientAbonnement_UpdateView.coefficientAbonnement_UpdateController = coefficientAbonnement_UpdateController;
	}

}
