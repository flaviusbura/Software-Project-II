package be.nmbs.userInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class View extends JFrame {

	private JPanel panel;
	LoginSchermView lsv = new LoginSchermView();
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public View view;
	
	public View getView() {
		return view;
	}

	public void setView(View view) {
		view = view;
	}


	
	public View() {
		this.setTitle("LoginApp");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//	LoginSchermView.initialiseLoginPanel();
		
		//this.add(getPanel());
	}
	

	
	public void maakFrameAan()
	{
		view = new View();
	}
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPanelToNull() {
		panel = null;
	}

}
