package be.nmbs.logic;

import java.util.ArrayList;
import java.util.List;

public class Route {
	private String stepOn, stepOff;
	private ArrayList<Trein> treinen;
	private ArrayList<Overstap> overstappen;
	
	// Constructor
	public Route(String stepOn, String stepOff, ArrayList<Trein> treinen, ArrayList<Overstap> overstappen) {
		this.stepOn = stepOn;
		this.stepOff = stepOff;
		this.treinen = new ArrayList<Trein>(treinen);
		this.overstappen = new ArrayList<Overstap>(overstappen);
	}
	
	@Override
	public String toString() {
		String t = "", o = "";
		
		for (int i = 0; i < treinen.size(); i++)
			t += treinen.get(i).toString() + "\n";
		
		for (int i = 0; i < overstappen.size(); i++)
			o += overstappen.get(i).toString() + "\n";
		
		return "Route:\nstepOn=" + stepOn + ", stepOff=" + stepOff + ", treinen=" + t + ", overstappen="
				+ o + "\n";
	}

	// Getters
	public String getStepOn() { return stepOn; }
	public String getStepOff() { return stepOff; }
	public ArrayList<Trein> getTreinen() { return treinen; }
	public ArrayList<Overstap> getOverstappen() { return overstappen; }
	
	// Setters
	public void setStepOn(String stepOn) { this.stepOn = stepOn; }
	public void setStepOff(String stepOff) { this.stepOff = stepOff; }
	public void setTreinen(ArrayList<Trein> treinen) { this.treinen = treinen; }
	public void setOverstappen(ArrayList<Overstap> overstappen) { this.overstappen = overstappen; }
}