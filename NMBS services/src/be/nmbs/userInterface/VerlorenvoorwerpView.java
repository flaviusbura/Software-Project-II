package be.nmbs.userInterface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import be.nmbs.controllers.TicketController;
import be.nmbs.controllers.VerlorenvoorwerpController;
import be.nmbs.database.KortingDAO;
import be.nmbs.database.PrijsDAO;
import be.nmbs.database.StationDAO;
import be.nmbs.database.VerlorenVoorwerpenDAO;
import be.nmbs.logic.Korting;
import be.nmbs.logic.Prijs;
import be.nmbs.logic.StationNMBS;
import be.nmbs.logic.VerlorenVoorwerp;

public class VerlorenvoorwerpView {
	private static JPanel panel;
	private static JLabel lblType;
	private static JTextField txtType;
	private static JButton btnZoekOmschrijving;
	private static JButton btnVorigScherm;
	private static VerlorenvoorwerpController verlorenvoorwerpController;
	 private static  boolean ALLOW_COLUMN_SELECTION = false;
	 private static boolean ALLOW_ROW_SELECTION = true;
	 private static VerlorenVoorwerpenDAO verlorenvoorwerpdao;
	 
	 
	public static JPanel initialize(View view) {
		
	 verlorenvoorwerpdao = new VerlorenVoorwerpenDAO();
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		lblType = new JLabel("type");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lblType, c);

		
		txtType = new JTextField(10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panel.add(txtType, c);

		btnZoekOmschrijving = new JButton("zoek");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		panel.add(btnZoekOmschrijving, c);
		
		btnVorigScherm = new JButton("vorig scherm");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(btnVorigScherm, c);
		
		

        final String[] columnNames = {"Voorwerp ID",
                                      "station",
                                      "omschrijving",
                                      "datum"};
 
        
        String oms = txtType.getText();
        ArrayList<VerlorenVoorwerp> allVerlorenvoorwerp = verlorenvoorwerpdao.getAll();
        
        final Object[][] data = new Object[allVerlorenvoorwerp.size()][4];
        
        for(int i = 0;i<allVerlorenvoorwerp.size();i++) {
        	
        data[i][0] = allVerlorenvoorwerp.get(i).getId();
        data[i][1] = allVerlorenvoorwerp.get(i).getStation().getNaam();
        data[i][2] = allVerlorenvoorwerp.get(i).getOmschrijving();
        data[i][3] = allVerlorenvoorwerp.get(i).getTimestamp();
			
		}
        
 
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
 
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (ALLOW_ROW_SELECTION) { // true by default
            ListSelectionModel rowSM = table.getSelectionModel();
            rowSM.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;
 
                    ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        System.out.println("No rows are selected.");
                    } else {
                        int selectedRow = lsm.getMinSelectionIndex();
                        System.out.println("Row " + selectedRow
                                           + " is now selected.");
                    }
                }
            });
        } else {
            table.setRowSelectionAllowed(false);
        }
        
        panel.add(table);
		verlorenvoorwerpController = new VerlorenvoorwerpController(view);
		return panel;
	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		VerlorenvoorwerpView.panel = panel;
	}

	public static JLabel getLblType() {
		return lblType;
	}

	public static void setLblType(JLabel lblType) {
		VerlorenvoorwerpView.lblType = lblType;
	}

	public static JTextField getTxtType() {
		return txtType;
	}

	public static void setTxtType(JTextField txtType) {
		VerlorenvoorwerpView.txtType = txtType;
	}

	public static JButton getBtnZoekOmschrijving() {
		return btnZoekOmschrijving;
	}
	public static void setBtnZoekOmschrijving(JButton btnZoekOmschrijving) {
		VerlorenvoorwerpView.btnZoekOmschrijving = btnZoekOmschrijving;
	}
	public static JButton getBtnVorigScherm() {
		return btnVorigScherm;
	}
	public static void setBtnVorigScherm(JButton btnVorigScherm) {
		VerlorenvoorwerpView.btnVorigScherm = btnVorigScherm;
	}
	public static VerlorenvoorwerpController getVerlorenvoorwerpController() {
		return verlorenvoorwerpController;
	}
	public static void setVerlorenvoorwerpController(VerlorenvoorwerpController verlorenvoorwerpController) {
		VerlorenvoorwerpView.verlorenvoorwerpController = verlorenvoorwerpController;
	}
	public static void setVerlorenvoorwerpControllerToNull() {
		verlorenvoorwerpController = null;
	}


	public static void clearFields() {
		txtType.setText("");
		
		
	}
	

}
