package be.nmbs.userInterface;

public class Application {
	private View view;
	
	public Application(View view) {
		this.view = view;
	}
	
	public void run() {
		LoginView newView = new LoginView();
		view.changeView(newView.initialize(view));
	}
}
