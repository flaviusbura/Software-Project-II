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
import be.nmbs.controllers.CoefficientAbonnement_DelController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.logic.TypeAbonnement;

public class CoefficientAbonnement_DelView {
	
	private static JButton delCoeff;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JLabel lblCoeff;
	private static JTextField txtCoeff;
	private static CoefficientAbonnement_DelController coefficientAbonnement_DelController;
	
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	
		lblCoeff = new JLabel("Geef de Coefficient ID ");
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
		delCoeff = new JButton("Coefficient deleten");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(delCoeff, c);
		
		goBackToHome = new JButton("Home");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(goBackToHome, c);

		coefficientAbonnement_DelController = new CoefficientAbonnement_DelController(view);
		return panel;
	}
	
	public static void setCoefficientAbonnement_DelControllerToNull()
	{
		coefficientAbonnement_DelController= null;
	}
	public static JButton getDelCoeff() {
		return delCoeff;
	}
	public static void setDelCoeff(JButton delCoeff) {
		CoefficientAbonnement_DelView.delCoeff = delCoeff;
	}
	public static JButton getGoBackToHome() {
		return goBackToHome;
	}
	public static void setGoBackToHome(JButton goBackToHome) {
		CoefficientAbonnement_DelView.goBackToHome = goBackToHome;
	}
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		CoefficientAbonnement_DelView.panel = panel;
	}
	public static JLabel getLblCoeff() {
		return lblCoeff;
	}
	public static void setLblCoeff(JLabel lblCoeff) {
		CoefficientAbonnement_DelView.lblCoeff = lblCoeff;
	}
	public static JTextField getTxtCoeff() {
		return txtCoeff;
	}
	public static void setTxtCoeff(JTextField txtCoeff) {
		CoefficientAbonnement_DelView.txtCoeff = txtCoeff;
	}
	public static CoefficientAbonnement_DelController getCoefficientAbonnement_DelController() {
		return coefficientAbonnement_DelController;
	}
	public static void setCoefficientAbonnement_DelController(
			CoefficientAbonnement_DelController coefficientAbonnement_DelController) {
		CoefficientAbonnement_DelView.coefficientAbonnement_DelController = coefficientAbonnement_DelController;
	}


}
