package be.nmbs.logic;

public class Overstap {
	private String station;
	private int stepOffPlatform, stepOnPlatform;
	
	// Constructor
	public Overstap(){}
	
	/**
	 * Deze constructor gaat een Overstap-object aanmaken met alle nodige parameters.
	 * @param Station is een Station-object van waar de overstap plaats vind
	 * @param stepOffPlatform is een int van het platform waar je afstapt
	 * @param stepOnPlatform is een int van het platform waar je opstapt

	 */
	public Overstap(String station, int stepOffPlatform, int stepOnPlatform) {
		this.station = station;
		this.stepOffPlatform = stepOffPlatform;
		this.stepOnPlatform = stepOnPlatform;
	}
	
	// toString

	/**
	 * Deze methode gaat de informatie over de overstap terugsturen
	 * @return een string om de informatie over de overstap weer te geven
	 */
	@Override
	public String toString() {
		return "Overstap [station=" + station + ", stepOffPlatform=" + stepOffPlatform + ", stepOnPlatform="
				+ stepOnPlatform + "]";
	}

	// Getters

	/**
	 * Deze methode gaat een station terugsturen.
	 * @return een string om het station weer te geven
	 */
	public String getStation() { return station; }

	/**
	 * Deze methode gaat een StepOffPlatform terugsturen.
	 * @return een int om het stapOffPlatform weer te geven
	 */
	public int getStepOffPlatform() { return stepOffPlatform; }

	/**
	 * Deze methode gaat een StepOnPlatform terugsturen.
	 * @return een int om het stapOnPlatform weer te geven
	 */
	public int getStepOnPlatform() { return stepOnPlatform; }

	// Setters
	/**
	 * Deze methode sets het station.
	 * @param station
	 */
	public void setStation(String station) { this.station = station; }
	/**
	 * Deze methode sets het stepOffPlatform.
	 * @param stepOffPlatform
	 */
	public void setStepOffPlatform(int stepOffPlatform) { this.stepOffPlatform = stepOffPlatform; }
	/**
	 * Deze methode sets het stepOnPlatform.
	 * @param stepOnPlatform
	 */
	public void setStepOnPlatform(int stepOnPlatform) { this.stepOnPlatform = stepOnPlatform; }	
	
	/**
	 * Deze methode overrides de Object.hashcode() methode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((station == null) ? 0 : station.hashCode());
		result = prime * result + stepOffPlatform;
		result = prime * result + stepOnPlatform;
		return result;
	}
	/**
	 * Deze methode overrides de Object.equals() methode.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Overstap other = (Overstap) obj;
		if (station == null) {
			if (other.station != null)
				return false;
		} else if (!station.equals(other.station))
			return false;
		if (stepOffPlatform != other.stepOffPlatform)
			return false;
		if (stepOnPlatform != other.stepOnPlatform)
			return false;
		return true;
	}
}