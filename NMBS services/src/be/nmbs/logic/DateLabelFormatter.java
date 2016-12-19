package be.nmbs.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class DateLabelFormatter extends AbstractFormatter {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1426519591399870721L;
	private String datePattern = "dd/MM/yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    
    /**
     * Deze methode gaat een Stringobject parsen naar een SimpleDateFormat aangegeven door de datePattern
     */
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    /**
     * Deze methode gaat een Stringobject terugsturen. De methode gaat een datum parsen naar een Stringobject.
     */
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }
}