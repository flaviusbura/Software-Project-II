package be.nmbs.userInterface;

import be.nmbs.controllers.LoginController;

public class Application {
	private View view;
	
	public Application(View view) {
		this.view = view;
	}
	
	public void run() {
		@SuppressWarnings("unused")
		LoginController lc = new LoginController(view);
	}
}
