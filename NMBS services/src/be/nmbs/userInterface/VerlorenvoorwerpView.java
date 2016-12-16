package be.nmbs.userInterface;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import be.nmbs.controllers.VerlorenvoorwerpController;

public class VerlorenvoorwerpView {
	private static JPanel panel;
	private static JLabel lblType;
	private static JTextField txtType;
	private static JButton btnZoekOmschrijving;
	private static JButton btnVorigScherm;
	private static JButton btnNieuwVerlorenvoorwerp;
	private static VerlorenvoorwerpController verlorenvoorwerpController;
	private static JTable tabel;
	private static JButton btnTerugGegeven;
	
	@SuppressWarnings("unused")
	private static boolean ALLOW_COLUMN_SELECTION = false;
	@SuppressWarnings("unused")
	private static boolean ALLOW_ROW_SELECTION = true;
	 
	 
	public static JPanel initialize(View view) {
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
		c.gridx = 1;
		c.gridy = 1;
		panel.add(btnZoekOmschrijving, c);
		
		btnTerugGegeven = new JButton("terug gegeven");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(btnTerugGegeven, c);
		
		btnNieuwVerlorenvoorwerp = new JButton("nieuw verlorenvoorwerp");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		panel.add(btnNieuwVerlorenvoorwerp, c);

		btnVorigScherm = new JButton("vorig scherm");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		panel.add(btnVorigScherm, c);
		
		tabel = new JTable();
		tabel.setPreferredScrollableViewportSize(new Dimension(500, 200));
    
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 2;
		c.gridheight = 3;
		
		tabel.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane(tabel);
				
		panel.add(scrollPane);
		
		verlorenvoorwerpController = new VerlorenvoorwerpController(view);
		return panel;
	}
	
	public static JButton getBtnTerugGegeven() {
		return btnTerugGegeven;
	}

	public static void setBtnTerugGegeven(JButton btnTerugGegeven) {
		VerlorenvoorwerpView.btnTerugGegeven = btnTerugGegeven;
	}

	public static JButton getBtnNieuwVerlorenvoorwerp() {
		return btnNieuwVerlorenvoorwerp;
	}

	public static void setBtnNieuwVerlorenvoorwerp(JButton btnNieuwVerlorenvoorwerp) {
		VerlorenvoorwerpView.btnNieuwVerlorenvoorwerp = btnNieuwVerlorenvoorwerp;
	}

	public static JTable getTabel() {
		return tabel;
	}

	public static void setTabel(JTable tabel) {
		VerlorenvoorwerpView.tabel = tabel;
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
