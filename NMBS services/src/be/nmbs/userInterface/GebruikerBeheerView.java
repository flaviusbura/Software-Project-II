package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import be.nmbs.controllers.GebruikerBeheerController;
import be.nmbs.tablemodels.GebruikerTableModel;

public class GebruikerBeheerView {
	private final JPanel panel = new JPanel(new GridBagLayout());
	
	private final JTextField searchField = new JTextField();
	
	private final JButton editButton = new JButton("Gebruiker aanpassen");
	private final JButton addUserButton = new JButton("Gebruiker toevoegen");
	private final JButton backButton = new JButton("Terug");
	
	private final JTable userTable = new JTable();
	
	private final GebruikerBeheerController controller = new GebruikerBeheerController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c;

		// Add User Table
		GebruikerTableModel model = new GebruikerTableModel();
		model.setGebruikers(controller.getAllGebruikers());
		userTable.setModel(model);
     	
    	TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(userTable.getModel());
     	userTable.setRowSorter(rowSorter);
     	
     	userTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (userTable.getSelectedRow() > -1) {
		            editButton.setEnabled(true);
		        } else {
		        	editButton.setEnabled(false);
		        }
			}
		});
     	
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 4;
		
		JScrollPane scrollPane = new JScrollPane(userTable);
		panel.add(scrollPane, c);
		
		// Add Search Field
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(searchField, c);
		
		searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchField.getText();

                if (text.trim().length() == 0)
                    rowSorter.setRowFilter(null);
                else
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchField.getText();

                if (text.trim().length() == 0)
                    rowSorter.setRowFilter(null);
                else
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
		
		// Add Edit Button
		editButton.setEnabled(false);
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(editButton, c);
		
     	editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (userTable.getSelectedRow() != -1) {
					int selectedRow = userTable.getSelectedRow();
					String username = userTable.getValueAt(selectedRow, 3).toString();
					
					GebruikerAanpassenView newView = new GebruikerAanpassenView();
					view.changeView(newView.initialize(view, controller.getGebruiker(username)));
				}
			}
		});

     	// Add AddGebruiker Button
 		c.gridx = 1;
 		c.gridy = 2;
 		panel.add(addUserButton, c);
 		
 		addUserButton.addActionListener(new ActionListener() {
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				NieuwGebruikerAanmakenView newView = new NieuwGebruikerAanmakenView();
 				view.changeView(newView.initialize(view));
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
				HomeView newView = new HomeView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public JTable getTable() {
		return userTable;
	}

	public JButton getBack() {
		return backButton;
	}
	
	public JButton getEdit() {
		return editButton;
	}
}
