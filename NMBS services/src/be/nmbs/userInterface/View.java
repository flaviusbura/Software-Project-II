package be.nmbs.userInterface;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import be.nmbs.database.DatabaseSingleton;
import be.nmbs.logic.Gebruiker;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static JPanel panel;
	private static Gebruiker ingelogdGebruiker;
	
	public View() {
		super("NMBS Services");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				try {
					DatabaseSingleton.getDatabaseSingleton().getConnection().close();
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println("Connectie met de database werd niet gesloten!");
				}
			}
		});
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		View.panel = panel;
	}

	public void setPanelToNull() {
		panel = null;
	}

	public static void setIngelogdGebruiker(Gebruiker ingelogdGebruiker) {
		View.ingelogdGebruiker = ingelogdGebruiker;
	}

	public static Gebruiker getIngelogdGebruiker() {
		return ingelogdGebruiker;
	}

	public void changeView(JPanel panel) {
		if (View.panel != null) {
			View.panel.removeAll();
			this.remove(View.panel);
			View.panel.setVisible(false);
			this.setPanelToNull();
			this.setPanel(panel);
			this.add(panel);
			this.setVisible(true);
		} else {
			this.setPanel(panel);
			this.add(panel);
			this.setVisible(true);
		}
	}
}
