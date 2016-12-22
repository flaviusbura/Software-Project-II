package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.BoeteController;

public class BoeteView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JLabel idLabel = new JLabel("Boete ID");
	private final JLabel paidLabel = new JLabel("Betaald");
	
	private final JCheckBox paidCheckBox = new JCheckBox("Betaald", true);
	
	private final JTextField idTextField = new JTextField(10);
	
	private final JButton backButton = new JButton("Terug");
	private final JButton payButton = new JButton("Boete betalen");
	
	private final BoeteController boeteController = new BoeteController();

	public JPanel initialize(View view) {		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add ID Label
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		panel.add(idLabel, c);
		
		// Add ID Text Field
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(idTextField, c);
			
		// Add Paid Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(paidLabel, c);
		
		// Add Paid Checkbox
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(paidCheckBox, c);
		
		// Add Pay Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(payButton, c);
		
		payButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int boeteId = 0;
				if (!idTextField.getText().isEmpty()) {
					try {
						boeteId = Integer.parseInt(idTextField.getText());
					} catch (NumberFormatException e1) {
						boeteId = 0;
					}
				}
					
				boolean betaald = paidCheckBox.isSelected();
				
				if (boeteController.updateBoete(boeteId, betaald)) {
					javax.swing.JOptionPane.showMessageDialog(null, "Geef aub een bestaand ID in.");
				} else {
					JOptionPane.showMessageDialog(null, "Boete betaald.");
					
					HomeView newView = new HomeView();
					view.changeView(newView.initialize(view));
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
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
		
		return panel;
	}
}