package be.nmbs.logic;

import java.text.NumberFormat;
import java.text.ParsePosition;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 * 
 * @author Abdel-PC
 *
 */
public class VeiligeInvoer    {

	
	
	
	public static String checkString(JTextField textfield,String text)
	{
		
		
		while ( !(isAlpha(text))  ) {
			
			javax.swing.JOptionPane.showMessageDialog(null,"Please enter only text");
			JFrame frame = new JFrame("InputDialog Example #1");
			text = JOptionPane.showInputDialog(frame, "Try again");
		}
		return text;
	
	}
	/**
	 * Bron = http://stackoverflow.com/questions/5238491/check-if-string-contains-only-letters
	 * @param name
	 * @return
	 */
	public static boolean isAlpha(String name) {
	    char[] chars = name.toCharArray();

	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            return false;
	        }
	    }

	    return true;
	}

	
	

}
