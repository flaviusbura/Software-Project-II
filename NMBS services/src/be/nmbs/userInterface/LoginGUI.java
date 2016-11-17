package be.nmbs.userInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;

public class LoginGUI {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
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
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(0, 191, 255));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("D:\\SamL\\Pictures\\nmbsoranje2.jpg"));
		lblLogo.setBounds(0, 0, 408, 206);
		frame.getContentPane().add(lblLogo);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setOpaque(true);
		lblHeader.setBackground(new Color(252, 172, 53));
		lblHeader.setBounds(0, 0, 2097, 206);
		frame.getContentPane().add(lblHeader);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(751, 319, 175, 32);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(442, 319, 175, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(353, 322, 66, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(664, 322, 66, 26);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setBackground(new Color(252, 172, 53));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HoofdmenuGUI ns = new HoofdmenuGUI();
				ns.newScreen();
				frame.setVisible(false);
			}
		});
		btnLogin.setBounds(958, 319, 152, 28);
		frame.getContentPane().add(btnLogin);
	}
}
