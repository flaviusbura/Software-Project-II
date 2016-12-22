package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import be.nmbs.controllers.KlantBeheerController;
import be.nmbs.logic.Klant;
import be.nmbs.tablemodels.KlantTableModel;

public class KlantBeheerView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JTextField searchTextField = new JTextField(10);
	
	private final JButton searchButton = new JButton("Zoeken");
	private final JButton editButton = new JButton("Klant wijzigen");
	private final JButton newKlantButton = new JButton("Nieuwe klant aanmaken");
	private final JButton backButton = new JButton("Terug");
	
	private final JTable klantTable = new JTable();
	
	private final KlantBeheerController klantBeheerController = new KlantBeheerController();

	public JPanel initialize(View view) {
		GridBagConstraints c = new GridBagConstraints();
		
		// Add Klant Table
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 6;
		klantTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JScrollPane scrollPane = new JScrollPane(klantTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				
		panel.add(scrollPane, c);
		
		klantTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (klantTable.getSelectedRow() > -1) {
					editButton.setEnabled(true);
		        } else {
		        	editButton.setEnabled(false);
		        }
			}
		});

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Add Search Text Field
		searchTextField.setToolTipText("Voer hier in de achternaam van de klant die u wilt opzoeken.");
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(searchTextField, c);
		
		// Add Search Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(searchButton, c);
		
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!searchTextField.getText().isEmpty()) {
			        String oms = searchTextField.getText();
			        
			        ArrayList<Klant> klanten = klantBeheerController.getAllKlantenByLike(oms);
			        
			        KlantTableModel klantTableModel = new KlantTableModel();
			        klantTableModel.setKlanten(klanten);
			        
			     	klantTable.setModel(klantTableModel);
				} else {
					JOptionPane.showMessageDialog(null, "Geef een geldige waarde in.");
				}
			}
		});
		
		// Add Edit Button
		editButton.setEnabled(false);
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(editButton, c);
		
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (klantTable.getSelectedRow() != -1) {
					int selectedRow = klantTable.getSelectedRow();
					int id = Integer.parseInt(klantTable.getValueAt(selectedRow, 0).toString());
					
					Klant klant = klantBeheerController.getKlant(id);
					if (klant != null) {
						KlantAanpassenView newView = new KlantAanpassenView();
						view.changeView(newView.initialize(view, klant));
					} else {
						JOptionPane.showMessageDialog(null , "Er is iets foutgelopen bij het ophalen van de klant, probeer opnieuw.");
					}
				}
			}
		});
		
		// Add New Klant Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 3;
		panel.add(newKlantButton, c);
		
		newKlantButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NieuweKlantAanmakenView newView = new NieuweKlantAanmakenView();
				view.changeView(newView.initialize(view));
			}
		});
		
		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 5;
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
