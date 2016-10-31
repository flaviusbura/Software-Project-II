package be.nmbs.userInterface;

import be.nmbs.logic.ApiCaller;

public class Main {
	
	  public static void main(String[] args) throws Exception {
		ApiCaller call = new ApiCaller();
		call.getTrainInfo("Mechelen", "Antwerpen-Centraal");
	  }
}
