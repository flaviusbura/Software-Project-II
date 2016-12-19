package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.CoefficientTicket_DelController;
import be.nmbs.controllers.HomeController;
import be.nmbs.database.TypeTicketDAO;
import be.nmbs.logic.TypeTicket;

public class CoefficientTicket_DelView {
	private static JButton delCoeff;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JLabel lblCoeff;
	private static JTextField txtCoeff;
	private static JLabel lblTypeId;
	
	private static JComboBox<TypeTicket> typeLijst;
	private static TypeTicketDAO typeTypeDao = new TypeTicketDAO();

	private static HomeController homeController;
	private static CoefficientTicket_DelController coefficientTicket_DelController;
	
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		lblCoeff = new JLabel("Geef de Coefficient ID");
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

		homeController = new HomeController(view);
		coefficientTicket_DelController = new CoefficientTicket_DelController(view);
		return panel;
	}
	public static void setHomeControllerToNull()
	{
		homeController= null;
	}
	
	public static void setPrijsCoefficient_TicketControllerToNull() {
		coefficientTicket_DelController= null;
		
	}
	
	public static JButton getDelCoeff() {
		return delCoeff;
	}
	public static void setDelCoeff(JButton delCoeff) {
		CoefficientTicket_DelView.delCoeff = delCoeff;
	}
	public static JButton getGoBackToHome() {
		return goBackToHome;
	}
	public static void setGoBackToHome(JButton goBackToHome) {
		CoefficientTicket_DelView.goBackToHome = goBackToHome;
	}
	public static JPanel getPanel() {
		return panel;
	}
	public static void setPanel(JPanel panel) {
		CoefficientTicket_DelView.panel = panel;
	}
	public static JLabel getLblCoeff() {
		return lblCoeff;
	}
	public static void setLblCoeff(JLabel lblCoeff) {
		CoefficientTicket_DelView.lblCoeff = lblCoeff;
	}
	public static JTextField getTxtCoeff() {
		return txtCoeff;
	}
	public static void setTxtCoeff(JTextField txtCoeff) {
		CoefficientTicket_DelView.txtCoeff = txtCoeff;
	}
	public static JLabel getLblTypeId() {
		return lblTypeId;
	}
	public static void setLblTypeId(JLabel lblTypeId) {
		CoefficientTicket_DelView.lblTypeId = lblTypeId;
	}
	public static JComboBox<TypeTicket> getTypeLijst() {
		return typeLijst;
	}
	public static void setTypeLijst(JComboBox<TypeTicket> typeLijst) {
		CoefficientTicket_DelView.typeLijst = typeLijst;
	}
	public static TypeTicketDAO getTypeTypeDao() {
		return typeTypeDao;
	}
	public static void setTypeTypeDao(TypeTicketDAO typeTypeDao) {
		CoefficientTicket_DelView.typeTypeDao = typeTypeDao;
	}
	public static HomeController getHomeController() {
		return homeController;
	}
	public static void setHomeController(HomeController homeController) {
		CoefficientTicket_DelView.homeController = homeController;
	}
	public static CoefficientTicket_DelController getCoefficientTicket_DelController() {
		return coefficientTicket_DelController;
	}
	public static void setCoefficientTicket_DelController(CoefficientTicket_DelController coefficientTicket_DelController) {
		CoefficientTicket_DelView.coefficientTicket_DelController = coefficientTicket_DelController;
	}
	

}
