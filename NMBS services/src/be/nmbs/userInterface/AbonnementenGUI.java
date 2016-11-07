package be.nmbs.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AbonnementenGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newAbo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbonnementenGUI window = new AbonnementenGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AbonnementenGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAbo = new JLabel("abo");
		lblAbo.setBounds(68, 127, 46, 14);
		frame.getContentPane().add(lblAbo);
	}

}
