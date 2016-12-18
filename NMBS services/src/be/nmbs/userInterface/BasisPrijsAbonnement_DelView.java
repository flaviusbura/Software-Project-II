package be.nmbs.userInterface;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import be.nmbs.controllers.BasisPrijsAbonnement_DelController;
import be.nmbs.controllers.HomeController;

public class BasisPrijsAbonnement_DelView {
	private static JButton delPrijs;
	private static JButton goBackToHome;
	private static JPanel panel;
	private static JLabel lblPrijs;
	private static JTextField txtPrijs;
	private static HomeController homeController;
	private static BasisPrijsAbonnement_DelController basisPrijsAbonnement_DelController;

	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		lblPrijs = new JLabel("Geef de Basisprijs ID ");
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
		delPrijs = new JButton("Prijs deleten");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(delPrijs, c);

		goBackToHome = new JButton("Home");
		new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(goBackToHome, c);

		homeController = new HomeController(view);
		basisPrijsAbonnement_DelController = new BasisPrijsAbonnement_DelController(view);
		return panel;
	}

	public static void setHomeControllerToNull() {
		homeController = null;
	}

	public static void setBasisPrijsAbonnement_DelControllerToNull() {
		basisPrijsAbonnement_DelController = null;
	}

	public static JButton getDelPrijs() {
		return delPrijs;
	}

	public static void setDelPrijs(JButton delPrijs) {
		BasisPrijsAbonnement_DelView.delPrijs = delPrijs;
	}

	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		BasisPrijsAbonnement_DelView.goBackToHome = goBackToHome;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		BasisPrijsAbonnement_DelView.panel = panel;
	}

	public static JLabel getLblPrijs() {
		return lblPrijs;
	}

	public static void setLblPrijs(JLabel lblPrijs) {
		BasisPrijsAbonnement_DelView.lblPrijs = lblPrijs;
	}

	public static JTextField getTxtPrijs() {
		return txtPrijs;
	}

	public static void setTxtPrijs(JTextField txtPrijs) {
		BasisPrijsAbonnement_DelView.txtPrijs = txtPrijs;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		BasisPrijsAbonnement_DelView.homeController = homeController;
	}

	public static BasisPrijsAbonnement_DelController getBasisPrijsAbonnement_DelController() {
		return basisPrijsAbonnement_DelController;
	}

	public static void setBasisPrijsAbonnement_DelController(
			BasisPrijsAbonnement_DelController basisPrijsAbonnement_DelController) {
		BasisPrijsAbonnement_DelView.basisPrijsAbonnement_DelController = basisPrijsAbonnement_DelController;
	}
	
}
