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

import be.nmbs.controllers.GebruikerWijzigenController;
import be.nmbs.tablemodels.GebruikerTableModel;

public class GebruikerWijzigenView {
	private final JTextField searchField = new JTextField();
	private final JButton edit = new JButton("Gebruiker aanpassen");
	private final JButton back = new JButton("Terug");
	private final JPanel panel = new JPanel(new GridBagLayout());
	private JTable table;
	
	private final GebruikerWijzigenController controller = new GebruikerWijzigenController();
	
	public JPanel initialize(View view) {
		GridBagConstraints c;

		// Add User Table
		table = new JTable();
		GebruikerTableModel model = new GebruikerTableModel();
		model.setGebruikers(controller.getAllGebruikers());
		table.setModel(model);
     	
    	TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
     	table.setRowSorter(rowSorter);
     	
     	table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRow() > -1) {
		            edit.setEnabled(true);
		        } else {
		        	edit.setEnabled(false);
		        }
			}
		});
     	
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 4;
		
		JScrollPane scrollPane = new JScrollPane(table);
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
		edit.setEnabled(false);
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(edit, c);
		
     	edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					int selectedRow = table.getSelectedRow();
					String username = (String) table.getValueAt(selectedRow, 3);
					
					GebruikerAanpassenView newView = new GebruikerAanpassenView();
					view.changeView(newView.initialize(view, controller.getGebruiker(username)));
				}
			}
		});

		// Add Back Button
		c.insets = new Insets(5, 5, 0, 0);
		c.gridx = 1;
		c.gridy = 2;
		panel.add(back, c);
		
     	back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				GebruikerView newView = new GebruikerView();
				view.changeView(newView.initialize(view));
			}
		});

		return panel;
	}

	public JTextField getSearchField() {
		return searchField;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBack() {
		return back;
	}
	
	public JButton getEdit() {
		return edit;
	}
}
