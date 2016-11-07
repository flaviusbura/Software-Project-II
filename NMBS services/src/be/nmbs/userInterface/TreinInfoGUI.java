package be.nmbs.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TreinInfoGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newTreinInfo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreinInfoGUI window = new TreinInfoGUI();
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
	public TreinInfoGUI() {
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
		
		JLabel lblInfo = new JLabel("info");
		lblInfo.setBounds(26, 160, 46, 14);
		frame.getContentPane().add(lblInfo);
	}

}
