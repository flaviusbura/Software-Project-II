package be.nmbs.logic;

import java.util.Date;

public class Station {
	private String name;
	private String arrivalPlatform, departurePlatform;
	private Date arrival, arrivalDelay, departure, departureDelay;
	
	// Constructor
	public Station(String name, String arrivalPlatform, String departurePlatform, Date arrival, Date arrivalDelay, Date departure, Date departureDelay) {
		this.name = name;
		this.setArrivalPlatform(arrivalPlatform);
		this.setDeparturePlatform(departurePlatform);
		this.arrival = arrival;
		this.arrivalDelay = arrivalDelay;
		this.setDeparture(departure);
		this.setDepartureDelay(departureDelay);
	}
	
	// toString
	@Override
	public String toString() {
		return "Naam: " + name + ", arrivalPlatform: " + arrivalPlatform + ", departurePlatform: "
				+ departurePlatform + ", arrival: " + arrival + ", arrivalDelay: " + arrivalDelay + ", departure: "
				+ departure + ", departureDelay: " + departureDelay;
	}

	// Getters
	public String getName() { return name; }
	public String getArrivalPlatform() { return arrivalPlatform; }
	public String getDeparturePlatform() { return departurePlatform; }
	public Date getArrival() { return arrival; }
	public Date getArrivalDelay() { return arrivalDelay; }
	public Date getDeparture() { return departure; }
	public Date getDepartureDelay() { return departureDelay; }
	
	// Setters
	public void setName(String name) { this.name = name; }
	public void setDeparturePlatform(String departurePlatform) { this.departurePlatform = departurePlatform; }
	public void setArrivalPlatform(String arrivalPlatform) { this.arrivalPlatform = arrivalPlatform; }
	public void setArrival(Date arrival) { this.arrival = arrival; }
	public void setArrivalDelay(Date arrivalDelay) { this.arrivalDelay = arrivalDelay; }
	public void setDeparture(Date departure) { this.departure = departure; }
	public void setDepartureDelay(Date departureDelay) { this.departureDelay = departureDelay; }
}