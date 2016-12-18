package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.BasisPrijsAbonnement_AddController;
import be.nmbs.controllers.CoefficientAbonnement_AddController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.logic.TypeAbonnement;

public class BasisPrijsAbonnement_AddView {
	private static JButton addPrijs;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JLabel lblPrijs;
	private static JTextField txtPrijs;
	private static JLabel lblTypeId;

	private static JComboBox<TypeAbonnement> typeLijst;
	private static TypeAbonnementDAO typeAboDao = new TypeAbonnementDAO();

	private static HomeController homeController;
	private static BasisPrijsAbonnement_AddController basisPrijsAbonnement_AddController;

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

		lblPrijs = new JLabel("Prijs ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblPrijs, c);

		txtPrijs= new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		panel.add(txtPrijs, c);

		// buttons
		addPrijs = new JButton("Prijs Toevoegen");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(addPrijs, c);

		goBackToHome = new JButton("Home");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(goBackToHome, c);

		homeController = new HomeController(view);
		basisPrijsAbonnement_AddController = new BasisPrijsAbonnement_AddController(view);
		return panel;

	}
	public static void setHomeControllerToNull()
	{	
		homeController = null; 
	}
	public static void setBasisPrijsAbonnement_AddControllerToNull() {
		basisPrijsAbonnement_AddController = null;
	}
	public static JButton getAddPrijs() {
		return addPrijs;
	}
	public static void setAddPrijs(JButton addPrijs) {
		BasisPrijsAbonnement_AddView.addPrijs = addPrijs;
	}
	public static JButton getGoBackToHome() {
		return goBackToHome;
	}
	public static void setGoBackToHome(JButton goBackToHome) {
		BasisPrijsAbonnement_AddView.goBackToHome = goBackToHome;
	}
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		BasisPrijsAbonnement_AddView.panel = panel;
	}
	public static JLabel getLblPrijs() {
		return lblPrijs;
	}
	public static void setLblPrijs(JLabel lblPrijs) {
		BasisPrijsAbonnement_AddView.lblPrijs = lblPrijs;
	}
	public static JTextField getTxtPrijs() {
		return txtPrijs;
	}
	public static void setTxtPrijs(JTextField txtPrijs) {
		BasisPrijsAbonnement_AddView.txtPrijs = txtPrijs;
	}
	public static JLabel getLblTypeId() {
		return lblTypeId;
	}
	public static void setLblTypeId(JLabel lblTypeId) {
		BasisPrijsAbonnement_AddView.lblTypeId = lblTypeId;
	}
	public static JComboBox<TypeAbonnement> getTypeLijst() {
		return typeLijst;
	}
	public static void setTypeLijst(JComboBox<TypeAbonnement> typeLijst) {
		BasisPrijsAbonnement_AddView.typeLijst = typeLijst;
	}
	public static TypeAbonnementDAO getTypeAboDao() {
		return typeAboDao;
	}
	public static void setTypeAboDao(TypeAbonnementDAO typeAboDao) {
		BasisPrijsAbonnement_AddView.typeAboDao = typeAboDao;
	}
	public static HomeController getHomeController() {
		return homeController;
	}
	public static void setHomeController(HomeController homeController) {
		BasisPrijsAbonnement_AddView.homeController = homeController;
	}
	public static BasisPrijsAbonnement_AddController getBasisPrijsAbonnement_AddController() {
		return basisPrijsAbonnement_AddController;
	}
	public static void setBasisPrijsAbonnement_AddController(
			BasisPrijsAbonnement_AddController basisPrijsAbonnement_AddController) {
		BasisPrijsAbonnement_AddView.basisPrijsAbonnement_AddController = basisPrijsAbonnement_AddController;
	}
	
}










