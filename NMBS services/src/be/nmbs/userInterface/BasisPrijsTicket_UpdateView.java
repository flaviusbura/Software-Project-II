package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.BasisPrijsTicket_UpdateController;
import be.nmbs.controllers.CoefficientTicket_UpdateController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.TypeTicketDAO;
import be.nmbs.logic.TypeTicket;

public class BasisPrijsTicket_UpdateView {
	private static JButton updatePrijs;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JLabel lblPrijs;
	private static JTextField txtPrijs;
	private static JLabel lblTypeId;
	private static JComboBox<TypeTicket> typeLijst;
	private static TypeTicketDAO typeTicketDao = new TypeTicketDAO();

	private static BasisPrijsTicket_UpdateController basisPrijsTicket_UpdateController;
	
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
		updatePrijs = new JButton("Coefficient Updaten");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(updatePrijs, c);
		
		goBackToHome = new JButton("Home");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		panel.add(goBackToHome, c);

		basisPrijsTicket_UpdateController = new BasisPrijsTicket_UpdateController(view);
		return panel;

	}
	public static void setBasisPrijsTicket_UpdateControllerToNull() {
		basisPrijsTicket_UpdateController = null;
		
	}
	public static JButton getUpdatePrijs() {
		return updatePrijs;
	}
	public static void setUpdatePrijs(JButton updatePrijs) {
		BasisPrijsTicket_UpdateView.updatePrijs = updatePrijs;
	}
	public static JButton getGoBackToHome() {
		return goBackToHome;
	}
	public static void setGoBackToHome(JButton goBackToHome) {
		BasisPrijsTicket_UpdateView.goBackToHome = goBackToHome;
	}
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		BasisPrijsTicket_UpdateView.panel = panel;
	}
	public static JLabel getLblPrijs() {
		return lblPrijs;
	}
	public static void setLblPrijs(JLabel lblPrijs) {
		BasisPrijsTicket_UpdateView.lblPrijs = lblPrijs;
	}
	public static JTextField getTxtPrijs() {
		return txtPrijs;
	}
	public static void setTxtPrijs(JTextField txtPrijs) {
		BasisPrijsTicket_UpdateView.txtPrijs = txtPrijs;
	}
	public static JLabel getLblTypeId() {
		return lblTypeId;
	}
	public static void setLblTypeId(JLabel lblTypeId) {
		BasisPrijsTicket_UpdateView.lblTypeId = lblTypeId;
	}
	public static JComboBox<TypeTicket> getTypeLijst() {
		return typeLijst;
	}
	public static void setTypeLijst(JComboBox<TypeTicket> typeLijst) {
		BasisPrijsTicket_UpdateView.typeLijst = typeLijst;
	}
	public static TypeTicketDAO getTypeTicketDao() {
		return typeTicketDao;
	}
	public static void setTypeTicketDao(TypeTicketDAO typeTicketDao) {
		BasisPrijsTicket_UpdateView.typeTicketDao = typeTicketDao;
	}
	public static BasisPrijsTicket_UpdateController getBasisPrijsTicket_UpdateController() {
		return basisPrijsTicket_UpdateController;
	}
	public static void setBasisPrijsTicket_UpdateController(
			BasisPrijsTicket_UpdateController basisPrijsTicket_UpdateController) {
		BasisPrijsTicket_UpdateView.basisPrijsTicket_UpdateController = basisPrijsTicket_UpdateController;
	}
	
}
