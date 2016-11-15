package be.nmbs.logic;

public class Overstap {
	private String station;
	private int stepOffPlatform, stepOnPlatform;
	
	// Constructor
	public Overstap(String station, int stepOffPlatform, int stepOnPlatform) {
		this.station = station;
		this.stepOffPlatform = stepOffPlatform;
		this.stepOnPlatform = stepOnPlatform;
	}
	
	// toString
	@Override
	public String toString() {
		return "Overstap [station=" + station + ", stepOffPlatform=" + stepOffPlatform + ", stepOnPlatform="
				+ stepOnPlatform + "]";
	}

	// Getters
	public String getStation() { return station; }
	public int getStepOffPlatform() { return stepOffPlatform; }
	public int getStepOnPlatform() { return stepOnPlatform; }

	// Setters
	public void setStation(String station) { this.station = station; }
	public void setStepOffPlatform(int stepOffPlatform) { this.stepOffPlatform = stepOffPlatform; }
	public void setStepOnPlatform(int stepOnPlatform) { this.stepOnPlatform = stepOnPlatform; }	
}