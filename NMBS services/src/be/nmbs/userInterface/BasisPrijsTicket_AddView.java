package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.BasisPrijsTicket_AddController;
import be.nmbs.controllers.CoefficientTicket_AddController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.TypeTicketDAO;
import be.nmbs.logic.TypeTicket;

public class BasisPrijsTicket_AddView {
	private static JButton addPrijs;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JLabel lblPrijs;
	private static JTextField txtPrijs;
	private static JLabel lblTypeId;
	
	private static JComboBox<TypeTicket> typeLijst;
	private static TypeTicketDAO typeTicketDao = new TypeTicketDAO();

	private static BasisPrijsTicket_AddController basisPrijsTicket_AddController;
	
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
		
		lblPrijs = new JLabel("Coefficient ");	
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lblPrijs, c);
		
		txtPrijs = new JTextField(10);
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

		basisPrijsTicket_AddController = new BasisPrijsTicket_AddController(view);
		
		return panel;

	}
	public static void setBasisPrijsTicket_AddControllerToNull()
	{
		basisPrijsTicket_AddController= null;
	}
	public static JButton getAddPrijs() {
		return addPrijs;
	}
	public static void setAddPrijs(JButton addPrijs) {
		BasisPrijsTicket_AddView.addPrijs = addPrijs;
	}
	public static JButton getGoBackToHome() {
		return goBackToHome;
	}
	public static void setGoBackToHome(JButton goBackToHome) {
		BasisPrijsTicket_AddView.goBackToHome = goBackToHome;
	}
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		BasisPrijsTicket_AddView.panel = panel;
	}
	public static JLabel getLblPrijs() {
		return lblPrijs;
	}
	public static void setLblPrijs(JLabel lblPrijs) {
		BasisPrijsTicket_AddView.lblPrijs = lblPrijs;
	}
	public static JTextField getTxtPrijs() {
		return txtPrijs;
	}
	public static void setTxtPrijs(JTextField txtPrijs) {
		BasisPrijsTicket_AddView.txtPrijs = txtPrijs;
	}
	public static JLabel getLblTypeId() {
		return lblTypeId;
	}
	public static void setLblTypeId(JLabel lblTypeId) {
		BasisPrijsTicket_AddView.lblTypeId = lblTypeId;
	}
	public static JComboBox<TypeTicket> getTypeLijst() {
		return typeLijst;
	}
	public static void setTypeLijst(JComboBox<TypeTicket> typeLijst) {
		BasisPrijsTicket_AddView.typeLijst = typeLijst;
	}
	public static TypeTicketDAO getTypeTicketDao() {
		return typeTicketDao;
	}
	public static void setTypeTicketDao(TypeTicketDAO typeTicketDao) {
		BasisPrijsTicket_AddView.typeTicketDao = typeTicketDao;
	}
	public static BasisPrijsTicket_AddController getBasisPrijsTicket_AddController() {
		return basisPrijsTicket_AddController;
	}
	public static void setBasisPrijsTicket_AddController(BasisPrijsTicket_AddController basisPrijsTicket_AddController) {
		BasisPrijsTicket_AddView.basisPrijsTicket_AddController = basisPrijsTicket_AddController;
	}
	
}
