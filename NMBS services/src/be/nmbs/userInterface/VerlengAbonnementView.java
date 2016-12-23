package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.nmbs.controllers.*;
import be.nmbs.logic.Abonnement;

/**
 * 
 * @author Abdel-Portable
 *
 */
public class VerlengAbonnementView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JLabel idLabel = new JLabel("Abonnement ID");
	private final JLabel maandenLabel = new JLabel("Verleng");
	
	private final JTextField idTextField = new JTextField(10);
	
	private final String[] tab = { "3 maanden", "6 maanden", "9 maanden", "12 maanden" };
	private final JComboBox<String> maandenComboBox = new JComboBox<String>(tab);
	
	private final JButton verlengButton = new JButton("Verlengen");
	private final JButton backButton = new JButton("Terug");
	
	private final VerlengAbonnementController verlengAbonnementController = new VerlengAbonnementController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add ID Label
		c.gridx = 0;
		c.gridy = 1;
		panel.add(idLabel, c);

		// Add ID Text Field
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(idTextField, c);
		
		// Add Maanden Label
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel.add(maandenLabel, c);

		// Add Maanden Combobox
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(maandenComboBox, c);
		
		// Add Verleng Button
		c.insets = new Insets(5, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel.add(verlengButton, c);
		
		verlengButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				int aboId = Integer.parseInt(idTextField.getText());
				
				Abonnement abonnement = verlengAbonnementController.getAbonnement(aboId);
				
				String keuze = maandenComboBox.getSelectedItem().toString();
				
				if (verlengAbonnementController.verlengAbonnement(abonnement, keuze)) {
					JOptionPane.showMessageDialog(null, "Abonnement met succes verlengd voor " + keuze + "!");
					
					AbonnementView newView = new AbonnementView();
					view.changeView(newView.initialize(view));
				} else {
					JOptionPane.showMessageDialog(null, "Er is iets foutgelopen bij het verlengen van het abonnement, probeer opnieuw.");
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
				AbonnementView newView = new AbonnementView();
				view.changeView(newView.initialize(view));
			}
		});
		
		return panel;
	}
}
