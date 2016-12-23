package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.CoefficientTicket_DelController;

public class CoefficientTicket_DelView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JLabel coefficientLabel = new JLabel("Geef het Coëfficient ID");
	
	private final JTextField coefficientTextField = new JTextField(10);
	
	private final JButton deleteButton = new JButton("Coëfficient verwijderen");
	private final JButton backButton = new JButton("Terug");

	private final CoefficientTicket_DelController coefficientTicket_DelController = new CoefficientTicket_DelController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add Coefficient Label
		c.gridx = 0;
		c.gridy = 1;
		panel.add(coefficientLabel, c);
		
		// Add Coefficient Text Field
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(coefficientTextField, c);

		// Add Delete Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(deleteButton, c);
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Integer id = Integer.parseInt(coefficientTextField.getText());
					
					if (coefficientTicket_DelController.deleteCoefficient(id)) {
						JOptionPane.showMessageDialog(panel, "Coëfficient verwijderd.");
					} else {
						JOptionPane.showMessageDialog(panel, "Er is iets foutgelopen bij het verwijderen van de coëfficient, probeer opnieuw.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(panel, "Geef een geldig ID in.");
				}
			}
		});
		
		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
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