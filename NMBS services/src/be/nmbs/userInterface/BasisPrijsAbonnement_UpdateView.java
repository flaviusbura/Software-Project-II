package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.BasisPrijsAbonnement_UpdateController;
import be.nmbs.controllers.CoefficientAbonnement_UpdateController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.logic.TypeAbonnement;

public class BasisPrijsAbonnement_UpdateView {
	private static JButton updatePrijs;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JLabel lblPrijs;
	private static JTextField txtPrijs;
	private static JLabel lblTypeId;
	private static JComboBox<TypeAbonnement> typeLijst;
	private static TypeAbonnementDAO typeAboDao = new TypeAbonnementDAO();

	private static BasisPrijsAbonnement_UpdateController basisPrijsAbonnement_UpdateController;
	
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
		
		
		lblPrijs = new JLabel("Update naar: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblPrijs, c);
		
		txtPrijs= new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(txtPrijs, c);

		// buttons
		updatePrijs = new JButton("Prijs Updaten");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(updatePrijs, c);
		
		goBackToHome = new JButton("Home");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		panel.add(goBackToHome, c);

		basisPrijsAbonnement_UpdateController = new BasisPrijsAbonnement_UpdateController(view);
		return panel;

	}
	
	public static void setBasisPrijsAbonnement_UpdateControllerToNull()
	{
		basisPrijsAbonnement_UpdateController = null;
	}

	public static JButton getUpdatePrijs() {
		return updatePrijs;
	}

	public static void setUpdatePrijs(JButton updatePrijs) {
		BasisPrijsAbonnement_UpdateView.updatePrijs = updatePrijs;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		BasisPrijsAbonnement_UpdateView.goBackToHome = goBackToHome;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		BasisPrijsAbonnement_UpdateView.panel = panel;
	}

	public static JLabel getLblPrijs() {
		return lblPrijs;
	}

	public static void setLblPrijs(JLabel lblPrijs) {
		BasisPrijsAbonnement_UpdateView.lblPrijs = lblPrijs;
	}

	public static JTextField getTxtPrijs() {
		return txtPrijs;
	}

	public static void setTxtPrijs(JTextField txtPrijs) {
		BasisPrijsAbonnement_UpdateView.txtPrijs = txtPrijs;
	}

	public static JLabel getLblTypeId() {
		return lblTypeId;
	}

	public static void setLblTypeId(JLabel lblTypeId) {
		BasisPrijsAbonnement_UpdateView.lblTypeId = lblTypeId;
	}

	public static JComboBox<TypeAbonnement> getTypeLijst() {
		return typeLijst;
	}

	public static void setTypeLijst(JComboBox<TypeAbonnement> typeLijst) {
		BasisPrijsAbonnement_UpdateView.typeLijst = typeLijst;
	}

	public static TypeAbonnementDAO getTypeAboDao() {
		return typeAboDao;
	}

	public static void setTypeAboDao(TypeAbonnementDAO typeAboDao) {
		BasisPrijsAbonnement_UpdateView.typeAboDao = typeAboDao;
	}

	public static BasisPrijsAbonnement_UpdateController getBasisPrijsAbonnement_UpdateController() {
		return basisPrijsAbonnement_UpdateController;
	}

	public static void setBasisPrijsAbonnement_UpdateController(
			BasisPrijsAbonnement_UpdateController basisPrijsAbonnement_UpdateController) {
		BasisPrijsAbonnement_UpdateView.basisPrijsAbonnement_UpdateController = basisPrijsAbonnement_UpdateController;
	}

	
	
}
