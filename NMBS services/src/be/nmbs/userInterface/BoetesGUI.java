package be.nmbs.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BoetesGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newBoetesGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoetesGUI window = new BoetesGUI();
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
	public BoetesGUI() {
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
		
		JLabel lblBoetes = new JLabel("boetes");
		lblBoetes.setBounds(88, 149, 46, 14);
		frame.getContentPane().add(lblBoetes);
	}

}
