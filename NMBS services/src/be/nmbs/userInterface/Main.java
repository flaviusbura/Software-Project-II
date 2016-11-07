package be.nmbs.userInterface;

import java.util.List;

import be.nmbs.logic.ApiCaller;
import be.nmbs.logic.Route;

public class Main {
	
	  public static void main(String[] args) throws Exception {
		ApiCaller call = new ApiCaller();
		List<Route> routes = call.getTreinInfo("Eppegem", "Halle");
		System.out.println(routes.get(0).toString());
	  }
}