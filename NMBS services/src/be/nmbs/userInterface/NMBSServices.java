package be.nmbs.userInterface;

import java.text.ParseException;

public class NMBSServices {
	public static void main(String[] args) throws ParseException {
		View view = new View();
		Application application = new Application(view);
		application.run();
	}
}
