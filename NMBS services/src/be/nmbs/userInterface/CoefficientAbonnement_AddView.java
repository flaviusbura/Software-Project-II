package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.CoefficientAbonnement_AddController;
import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.MaakAbonnementController;
import be.nmbs.database.KlantDAO;
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.logic.TypeAbonnement;

public class CoefficientAbonnement_AddView {
	private static JButton addCoeff;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JPanel tPanel;
	private static JLabel lblCoeff;
	private static JTextField txtCoeff;
	private static JLabel lblTypeId;
	
	private static JComboBox<TypeAbonnement> typeLijst;
	private static TypeAbonnementDAO typeAboDao = new TypeAbonnementDAO();

	private static HomeController homeController;
	private static CoefficientAbonnement_AddController coefficientAbonnement_AddController;
	
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
		
		lblCoeff = new JLabel("Coefficient ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblCoeff, c);
		
		txtCoeff = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(txtCoeff, c);

		

		// buttons
		addCoeff = new JButton("Coefficient Toevoegen");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(addCoeff, c);
		
		goBackToHome = new JButton("Home");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(goBackToHome, c);

		homeController = new HomeController(view);
		coefficientAbonnement_AddController = new CoefficientAbonnement_AddController(view);
		return panel;

	}

	public static JButton getAddCoeff() {
		return addCoeff;
	}

	public static void setAddCoeff(JButton addCoeff) {
		CoefficientAbonnement_AddView.addCoeff = addCoeff;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		CoefficientAbonnement_AddView.goBackToHome = goBackToHome;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		CoefficientAbonnement_AddView.panel = panel;
	}

	public static JPanel gettPanel() {
		return tPanel;
	}

	public static void settPanel(JPanel tPanel) {
		CoefficientAbonnement_AddView.tPanel = tPanel;
	}

	public static JLabel getLblCoeff() {
		return lblCoeff;
	}

	public static void setLblCoeff(JLabel lblCoeff) {
		CoefficientAbonnement_AddView.lblCoeff = lblCoeff;
	}

	public static JTextField getTxtCoeff() {
		return txtCoeff;
	}

	public static void setTxtCoeff(JTextField txtCoeff) {
		CoefficientAbonnement_AddView.txtCoeff = txtCoeff;
	}

	public static JLabel getLblTypeId() {
		return lblTypeId;
	}

	public static void setLblTypeId(JLabel lblTypeId) {
		CoefficientAbonnement_AddView.lblTypeId = lblTypeId;
	}

	public static JComboBox<TypeAbonnement> getTypeLijst() {
		return typeLijst;
	}

	public static void setTypeLijst(JComboBox<TypeAbonnement> typeLijst) {
		CoefficientAbonnement_AddView.typeLijst = typeLijst;
	}

	public static TypeAbonnementDAO getTypeAboDao() {
		return typeAboDao;
	}

	public static void setTypeAboDao(TypeAbonnementDAO typeAboDao) {
		CoefficientAbonnement_AddView.typeAboDao = typeAboDao;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		CoefficientAbonnement_AddView.homeController = homeController;
	}

	public static CoefficientAbonnement_AddController getCoefficientAbonnement_AddController() {
		return coefficientAbonnement_AddController;
	}

	public static void setCoefficientAbonnement_AddController(
			CoefficientAbonnement_AddController coefficientAbonnement_AddController) {
		CoefficientAbonnement_AddView.coefficientAbonnement_AddController = coefficientAbonnement_AddController;
	}
	public static void CoefficientAbonnement_AddControllerToNull()
	{
		coefficientAbonnement_AddController = null;
	}
	public static void HomeControllerControllerToNull()
	{
		homeController= null;
	}
}
