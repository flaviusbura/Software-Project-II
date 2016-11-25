package be.nmbs.userInterface;

public class Application {
	private View view;
	
	public Application(View view) {
		this.view = view;
	}
	
	public void run() {
		view.changeView(LoginView.initialize(view));
	}
}
