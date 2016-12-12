package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import be.nmbs.controllers.HomeController;
import be.nmbs.controllers.StatistiekController;
public class StatistiekView {
	private static JButton goBackToHome;
	private static JPanel panel;
	private static HomeController homeController;
	private static StatistiekController statistiekController;
	public static JPanel initialize(View view) {
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		goBackToHome = new JButton("Back");
		c.fill = new GridBagConstraints().HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		panel.add(goBackToHome, c);
		
		homeController = new HomeController(view);
		statistiekController =new StatistiekController(view);
		return panel;
	}
	public static JButton getGoBackToHome() {
		return goBackToHome;
	}

	public static void setGoBackToHome(JButton goBackToHome) {
		StatistiekView.goBackToHome = goBackToHome;
	}
	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		StatistiekView.panel = panel;
	}

	public static HomeController getHomeController() {
		return homeController;
	}

	public static void setHomeController(HomeController homeController) {
		StatistiekView.homeController = homeController;
	}
	public static StatistiekController getStatistiekController() {
		return statistiekController;
	}

	public static void setStatistiekController(StatistiekController statistiekController) {
		StatistiekView.statistiekController = statistiekController;
	}
	public static void setStatistiekControllerToNull() {
		statistiekController = null;
		
	}
	
	public static void setHomeControllerToNull() {
		homeController = null;
	}
}
