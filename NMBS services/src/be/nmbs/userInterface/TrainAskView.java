package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.TrainAskController;

public class TrainAskView {
	private static JButton home;
	private static JButton btnZoeken;
	private static JPanel panel;
	private static JLabel trainLabel;
	private static JTextField trainField;
	
	private static TrainAskController trainAskController;

	public static JPanel initialize(View view) {
			panel = new JPanel(new GridBagLayout());
			
			trainLabel = new JLabel("Trein");
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			panel.add(trainLabel, c);
			
			trainField = new JTextField();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(0, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 0;
			panel.add(trainField, c);

			btnZoeken = new JButton("Trein zoeken");
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 0, 0, 0);
			c.gridx = 0;
			c.gridy = 1;
			panel.add(btnZoeken, c);	
			
			home = new JButton("Terug naar menu");
			c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.insets = new Insets(5, 5, 0, 0);
			c.gridx = 1;
			c.gridy = 1;
			panel.add(home, c);
		
			trainAskController = new TrainAskController(view);
			return panel;
	}

	public static void setTrainAskControllerToNull() {
		trainAskController = null;
	}

	// Getters
	public static JButton getHome() {
		return home;
	}

	public static JButton getBtnZoeken() {
		return btnZoeken;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static JLabel getTrainLabel() {
		return trainLabel;
	}

	public static JTextField getTrainField() {
		return trainField;
	}

	public static TrainAskController getTrainAskController() {
		return trainAskController;
	}
	
	// Setters
	public static void setHome(JButton home) {
		TrainAskView.home = home;
	}

	public static void setBtnZoeken(JButton btnZoeken) {
		TrainAskView.btnZoeken = btnZoeken;
	}

	public static void setPanel(JPanel panel) {
		TrainAskView.panel = panel;
	}

	public static void setTrainLabel(JLabel trainLabel) {
		TrainAskView.trainLabel = trainLabel;
	}

	public static void setTrainField(JTextField trainField) {
		TrainAskView.trainField = trainField;
	}

	public static void setTrainAskController(TrainAskController trainAskController) {
		TrainAskView.trainAskController = trainAskController;
	}
}
