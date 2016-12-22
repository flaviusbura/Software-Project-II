package be.nmbs.controllers;

import be.nmbs.logic.Trein;

public class TrainSearchController {
	public Trein searchTrain(String trainString) {
		if (!trainString.isEmpty()) {
			return ApiCaller.getTreinInfo(trainString);
		} else {
			return null;
		}
	}
}