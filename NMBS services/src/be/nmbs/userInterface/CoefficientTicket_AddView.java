package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.CoefficientTicket_AddController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.TypeAbonnementDAO;
import be.nmbs.database.TypeTicketDAO;
import be.nmbs.logic.TypeAbonnement;
import be.nmbs.logic.TypeTicket;

public class CoefficientTicket_AddView {
	private static JButton addCoeff;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JLabel lblCoeff;
	private static JTextField txtCoeff;
	private static JLabel lblTypeId;
	
	private static JComboBox<TypeTicket> typeLijst;
	private static TypeTicketDAO typeTicketDao = new TypeTicketDAO();

	private static HomeController homeController;
	private static CoefficientTicket_AddController coefficientTicket_AddController;
	
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
		coefficientTicket_AddController = new CoefficientTicket_AddController(view);
		return panel;

	}
	public static void setCoefficientTicket_AddControllerToNull()
	{
		coefficientTicket_AddController= null;
	}
	public static void setHomeControllerToNull()
	{
		homeController= null;
	}
	public static JButton getAddCoeff() {
		return addCoeff;
	}
	public static void setAddCoeff(JButton addCoeff) {
		CoefficientTicket_AddView.addCoeff = addCoeff;
	}
	public static JButton getGoBackToHome() {
		return goBackToHome;
	}
	public static void setGoBackToHome(JButton goBackToHome) {
		CoefficientTicket_AddView.goBackToHome = goBackToHome;
	}
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		CoefficientTicket_AddView.panel = panel;
	}
	public static JLabel getLblCoeff() {
		return lblCoeff;
	}
	public static void setLblCoeff(JLabel lblCoeff) {
		CoefficientTicket_AddView.lblCoeff = lblCoeff;
	}
	public static JTextField getTxtCoeff() {
		return txtCoeff;
	}
	public static void setTxtCoeff(JTextField txtCoeff) {
		CoefficientTicket_AddView.txtCoeff = txtCoeff;
	}
	public static JLabel getLblTypeId() {
		return lblTypeId;
	}
	public static void setLblTypeId(JLabel lblTypeId) {
		CoefficientTicket_AddView.lblTypeId = lblTypeId;
	}
	public static JComboBox<TypeTicket> getTypeLijst() {
		return typeLijst;
	}
	public static void setTypeLijst(JComboBox<TypeTicket> typeLijst) {
		CoefficientTicket_AddView.typeLijst = typeLijst;
	}
	public static TypeTicketDAO getTypeAboDao() {
		return typeTicketDao;
	}
	public static void setTypeAboDao(TypeTicketDAO typeTicketDao) {
		CoefficientTicket_AddView.typeTicketDao = typeTicketDao;
	}
	public static HomeController getHomeController() {
		return homeController;
	}
	public static void setHomeController(HomeController homeController) {
		CoefficientTicket_AddView.homeController = homeController;
	}
	public static CoefficientTicket_AddController getCoefficientTicket_AddController() {
		return coefficientTicket_AddController;
	}
	public static void setCoefficientTicket_AddController(CoefficientTicket_AddController coefficientTicket_AddController) {
		CoefficientTicket_AddView.coefficientTicket_AddController = coefficientTicket_AddController;
	}
	
}
