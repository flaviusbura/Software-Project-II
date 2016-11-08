package be.nmbs.logic;

import java.util.List;

public class Trein {
	private String id, departureStation, terminusStation;
	private List<Station> stops;
	private boolean cancelled;
	
	// Constructor
	public Trein(String id, String departureStation, String terminusStation, List<Station> stops, boolean cancelled) {
		this.id = id;
		this.departureStation = departureStation;
		this.terminusStation = terminusStation;
		this.stops = stops;
		this.cancelled = cancelled;
	}

	// toString
	@Override
	public String toString() {
		return "Trein [id=" + id + ", departureStation=" + departureStation + ", terminusStation=" + terminusStation
				+ ", stops=" + stops + ", cancelled=" + cancelled + "]";
	}

	// Getters
	public String getId() { return id; }
	public String getDepartureStation() { return departureStation; }
	public String getTerminusStation() { return terminusStation; }
	public List<Station> getStops() { return stops; }
	public boolean isCancelled() { return cancelled; }

	// Setters
	public void setId(String id) { this.id = id; }
	public void setDepartureStation(String departureStation) { this.departureStation = departureStation; }
	public void setTerminusStation(String terminusStation) { this.terminusStation = terminusStation; }
	public void setStops(List<Station> stops) { this.stops = stops; }
	public void setCancelled(boolean cancelled) { this.cancelled = cancelled; }
}