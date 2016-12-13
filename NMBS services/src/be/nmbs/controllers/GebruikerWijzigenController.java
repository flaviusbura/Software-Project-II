package be.nmbs.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import be.nmbs.database.GebruikerDAO;
import be.nmbs.tablemodels.GebruikerTableModel;
import be.nmbs.userInterface.GebruikerAanpassenView;
import be.nmbs.userInterface.GebruikerView;
import be.nmbs.userInterface.GebruikerWijzigenView;
import be.nmbs.userInterface.View;

public class GebruikerWijzigenController {
	private static GebruikerDAO dao;
	private TableRowSorter<TableModel> rowSorter;
	
	public GebruikerWijzigenController(View view) {
		dao = new GebruikerDAO();
		GebruikerTableModel gebruikerModel = new GebruikerTableModel();
        gebruikerModel.setGebruikers(dao.getAll());
        
     	GebruikerWijzigenView.getTable().setModel(gebruikerModel);
     	GebruikerWijzigenView.getTable().setEnabled(true);
     	GebruikerWijzigenView.getTable().setVisible(true);
     	
     	rowSorter = new TableRowSorter<>(GebruikerWijzigenView.getTable().getModel());
     	
     	GebruikerWijzigenView.getTable().setRowSorter(rowSorter);
		
     	GebruikerWijzigenView.getBack().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GebruikerWijzigenView.getTable().setVisible(false);
				GebruikerView.setGebruikerControllerToNull();
				view.changeView(GebruikerView.initialize(view));
			}
		});
     	
     	GebruikerWijzigenView.getEdit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (GebruikerWijzigenView.getTable().getSelectedRow() != -1) {
					int selectedRow = GebruikerWijzigenView.getTable().getSelectedRow();
					String username = (String) GebruikerWijzigenView.getTable().getValueAt(selectedRow, 3);
					
					GebruikerWijzigenView.getTable().setVisible(false);
					GebruikerAanpassenView.setGebruikerAanpassenControllerToNull();
					view.changeView(GebruikerAanpassenView.initialize(view, dao.getGebruikerOpUsername(username)));
				}
			}
		});
     	
     	GebruikerWijzigenView.getSearchField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = GebruikerWijzigenView.getSearchField().getText();

                if (text.trim().length() == 0)
                    rowSorter.setRowFilter(null);
                else
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = GebruikerWijzigenView.getSearchField().getText();

                if (text.trim().length() == 0)
                    rowSorter.setRowFilter(null);
                else
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
	}
}