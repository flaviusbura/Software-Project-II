package be.nmbs.userInterface;

import java.text.ParseException;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class NMBSServices {
	public static void main(String[] args) throws ParseException {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       
	    }
	    catch (ClassNotFoundException e) {
	       
	    }
	    catch (InstantiationException e) {
	       
	    }
	    catch (IllegalAccessException e) {
	       
	    }
		View view = new View();
		Application application = new Application(view);
		application.run();
	}
}
