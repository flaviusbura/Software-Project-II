package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.CoefficientAbonnement_UpdateController;
import be.nmbs.logic.TypeAbonnement;

public class CoefficientAbonnement_UpdateView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JLabel typeLabel = new JLabel("Type Abonnement");
	private final JLabel coefficientLabel = new JLabel("Update naar");
	
	private final JTextField coefficientTextField = new JTextField(10);
	
	private JComboBox<TypeAbonnement> typeComboBox;
	
	private final JButton updateButton = new JButton("Coefficient aanpassen");
	private final JButton backButton = new JButton("Terug");

	private final CoefficientAbonnement_UpdateController coefficientAbonnement_UpdateController = new CoefficientAbonnement_UpdateController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	
		// Add Type Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(typeLabel, c);
		
		// Add Type Combobox
		ArrayList<TypeAbonnement> allType = coefficientAbonnement_UpdateController.getAllAbonnementTypes();
		typeComboBox = new JComboBox<>();
		for (TypeAbonnement ta : allType) {
			typeComboBox.addItem(ta);
		}
		
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(typeComboBox, c);
		
		// Add Coefficient Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(coefficientLabel, c);
		
		// Add Coefficient Text Field
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(coefficientTextField, c);

		// Add Update Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(updateButton, c);
		
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TypeAbonnement typeAboId = (TypeAbonnement) typeComboBox.getSelectedItem();

				try {
					double coef = Double.parseDouble(coefficientTextField.getText());
				
					if (coefficientAbonnement_UpdateController.updateCoefficient(typeAboId.getId(), coef)) {
						JOptionPane.showMessageDialog(panel, "Coefficient aangepast.");
					} else {
						JOptionPane.showMessageDialog(panel, "Er is iets foutgelopen bij het aanpassen van de coefficient, probeer opnieuw.");
					}
				} catch (NumberFormatException e1) {
					
				}
			}
		});
		
		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(backButton, c);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CoefficientAbonnementView newView = new CoefficientAbonnementView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}
}