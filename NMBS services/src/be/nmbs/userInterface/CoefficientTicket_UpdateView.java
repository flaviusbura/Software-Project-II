package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.CoefficientTicket_UpdateController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.TypeTicketDAO;
import be.nmbs.logic.TypeTicket;

public class CoefficientTicket_UpdateView {
	private static JButton updateCoeff;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JLabel lblCoeff;
	private static JTextField txtCoeff;
	private static JLabel lblTypeId;
	private static JComboBox<TypeTicket> typeLijst;
	private static TypeTicketDAO typeTicketDao = new TypeTicketDAO();

	private static CoefficientTicket_UpdateController coefficientTicket_UpdateController;
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
	
		lblTypeId = new JLabel("Type Ticket");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lblTypeId, c);
		
		ArrayList<TypeTicket> allType = typeTicketDao.getAll();
		typeLijst = new JComboBox<>();
		for (TypeTicket tt : allType) {
			typeLijst.addItem(tt);
		}
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(typeLijst, c);
		
		
		lblCoeff = new JLabel("Update naar: ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lblCoeff, c);
		
		txtCoeff = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(txtCoeff, c);

		// buttons
		updateCoeff = new JButton("Coefficient Updaten");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(updateCoeff, c);
		
		goBackToHome = new JButton("Home");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		panel.add(goBackToHome, c);

		coefficientTicket_UpdateController = new CoefficientTicket_UpdateController(view);
		return panel;

	}
	public static void setPrijsCoefficient_TicketControllerToNull() {
		coefficientTicket_UpdateController = null;
		
	}

	public static JButton getUpdateCoeff() {
		return updateCoeff;
	}

	public static void setUpdateCoeff(JButton updateCoeff) {
		CoefficientTicket_UpdateView.updateCoeff = updateCoeff;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		CoefficientTicket_UpdateView.goBackToHome = goBackToHome;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		CoefficientTicket_UpdateView.panel = panel;
	}

	public static JLabel getLblCoeff() {
		return lblCoeff;
	}

	public static void setLblCoeff(JLabel lblCoeff) {
		CoefficientTicket_UpdateView.lblCoeff = lblCoeff;
	}

	public static JTextField getTxtCoeff() {
		return txtCoeff;
	}

	public static void setTxtCoeff(JTextField txtCoeff) {
		CoefficientTicket_UpdateView.txtCoeff = txtCoeff;
	}

	public static JLabel getLblTypeId() {
		return lblTypeId;
	}

	public static void setLblTypeId(JLabel lblTypeId) {
		CoefficientTicket_UpdateView.lblTypeId = lblTypeId;
	}

	public static JComboBox<TypeTicket> getTypeLijst() {
		return typeLijst;
	}

	public static void setTypeLijst(JComboBox<TypeTicket> typeLijst) {
		CoefficientTicket_UpdateView.typeLijst = typeLijst;
	}

	public static TypeTicketDAO getTypeTicketDao() {
		return typeTicketDao;
	}

	public static void setTypeTicketDao(TypeTicketDAO typeTicketDao) {
		CoefficientTicket_UpdateView.typeTicketDao = typeTicketDao;
	}

	public static CoefficientTicket_UpdateController getCoefficientTicket_UpdateController() {
		return coefficientTicket_UpdateController;
	}

	public static void setCoefficientTicket_UpdateController(
			CoefficientTicket_UpdateController coefficientTicket_UpdateController) {
		CoefficientTicket_UpdateView.coefficientTicket_UpdateController = coefficientTicket_UpdateController;
	}
}