package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import be.nmbs.controllers.VerlorenVoorwerpController;
import be.nmbs.logic.VerlorenVoorwerp;
import be.nmbs.tablemodels.VerlorenVoorwerpTableModel;

public class VerlorenVoorwerpView {
	private final JPanel panel = new JPanel(new GridBagLayout());;
	
	private JLabel lblType;
	private final JTextField typeTextField = new JTextField();;
	private final JButton searchButton = new JButton("Zoeken");
	private final JButton returnButton = new JButton("Markeer als teruggegeven");	
	private final JButton nieuwVerlorenVoorwerpButton = new JButton("Nieuw voorwerp registreren");
	private final JButton backButton = new JButton("Terug");
	private final VerlorenVoorwerpController verlorenVoorwerpController = new VerlorenVoorwerpController();
	private final JTable verlorenVoorwerpTable = new JTable();
	 
	public JPanel initialize(View view) {		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// Add Type Text Field
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(typeTextField, c);
		
		// Add Search Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(searchButton, c);
		
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!typeTextField.getText().isEmpty()) {
			        String oms = typeTextField.getText();
			        
			        ArrayList<VerlorenVoorwerp> allVerlorenvoorwerp = verlorenVoorwerpController.getAllVerlorenVoorwerpenOnSoort(oms);
			        
			        VerlorenVoorwerpTableModel verlorenvoorwerpTableModel = new VerlorenVoorwerpTableModel();
			        verlorenvoorwerpTableModel.setVoorwerpen(allVerlorenvoorwerp);
			        
			     	verlorenVoorwerpTable.setModel(verlorenvoorwerpTableModel);
				} else {
					JOptionPane.showMessageDialog(null, "Geef een geldige waarde in.");
				}
			}
		});
		
		// Add Return Button
		returnButton.setEnabled(false);
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(returnButton, c);
		
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int row = verlorenVoorwerpTable.getSelectedRow();
				int voorwerpID = 0;
				try {
					voorwerpID = (int) verlorenVoorwerpTable.getModel().getValueAt(row, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Kies een voorwerp dat je wilt markeren als teruggegeven.");
				}
			
				verlorenVoorwerpController.changeActiefOnVoorwerp(voorwerpID);
				
				JOptionPane.showMessageDialog(null, "Voorwerp gemarkeerd als teruggegeven.");
				
				String oms = typeTextField.getText();
			        
		        ArrayList<VerlorenVoorwerp> allVerlorenVoorwerpen = verlorenVoorwerpController.getAllVerlorenVoorwerpenOnSoort(oms);
		        
		        VerlorenVoorwerpTableModel verlorenVoorwerpTableModel = new VerlorenVoorwerpTableModel();
		        verlorenVoorwerpTableModel.setVoorwerpen(allVerlorenVoorwerpen);
		     	verlorenVoorwerpTable.setModel(verlorenVoorwerpTableModel);
			}		
		});
		
		// Add Nieuw Voorwerp Toevoegen Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(nieuwVerlorenVoorwerpButton, c);
		
		nieuwVerlorenVoorwerpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NieuwVerlorenVoorwerpView newView = new NieuwVerlorenVoorwerpView();
				view.changeView(newView.initialize(view));
			}
		});

		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 4;
		panel.add(backButton, c);
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});
		
		// Add Verloren Voorwerp Table
		c.fill = GridBagConstraints.VERTICAL;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 5;
		
		JScrollPane scrollPane = new JScrollPane(verlorenVoorwerpTable);
				
		panel.add(scrollPane, c);
		
		verlorenVoorwerpTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (verlorenVoorwerpTable.getSelectedRow() > -1) {
					returnButton.setEnabled(true);
		        } else {
		        	returnButton.setEnabled(false);
		        }
			}
		});
		
		return panel;
	}
	
	public JButton getBtnTerugGegeven() {
		return returnButton;
	}

	public JButton getBtnNieuwVerlorenvoorwerp() {
		return nieuwVerlorenVoorwerpButton;
	}

	public JTable getTabel() {
		return verlorenVoorwerpTable;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JLabel getLblType() {
		return lblType;
	}

	public JTextField getTxtType() {
		return typeTextField;
	}

	public JButton getBtnZoekOmschrijving() {
		return searchButton;
	}
	
	public JButton getBtnVorigScherm() {
		return backButton;
	}
	
	public VerlorenVoorwerpController getVerlorenvoorwerpController() {
		return verlorenVoorwerpController;
	}
}
