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

import be.nmbs.controllers.CoefficientTicket_UpdateController;
import be.nmbs.logic.TypeTicket;

public class CoefficientTicket_UpdateView {
	private final JPanel panel = new JPanel(new GridBagLayout());

	private final JLabel typeLabel = new JLabel("Type ticket");
	private final JLabel coefficientLabel = new JLabel("Update naar");
	
	private final JTextField coefficientTextField = new JTextField(10);
	
	private JComboBox<TypeTicket> typeComboBox;
	
	private final JButton updateButton = new JButton("Coëfficient Updaten");
	private final JButton backButton = new JButton("Terug");

	private final CoefficientTicket_UpdateController coefficientTicket_UpdateController = new CoefficientTicket_UpdateController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	
		// Add Type Label
		c.gridx = 0;
		c.gridy = 0;
		panel.add(typeLabel, c);
		
		ArrayList<TypeTicket> allType = coefficientTicket_UpdateController.getAllTicketTypes();
		typeComboBox = new JComboBox<>();
		for (TypeTicket tt : allType) {
			typeComboBox.addItem(tt);
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
				TypeTicket typeAboId = (TypeTicket) typeComboBox.getSelectedItem();

				try {
					double coef = Double.parseDouble(coefficientTextField.getText());
	
					if (coefficientTicket_UpdateController.updateCoefficient(typeAboId.getId(), coef)) {
						JOptionPane.showMessageDialog(view.getPanel(), "Coëfficient aangepast.");
					} else {
						JOptionPane.showMessageDialog(view.getPanel(), "Er is iets foutgelopen tijdens het aanpassen van de coëfficient, probeer opnieuw.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(view.getPanel(), "Geen een geldige coëfficient in.");
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
				CoefficientTicketView newView = new CoefficientTicketView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}
}