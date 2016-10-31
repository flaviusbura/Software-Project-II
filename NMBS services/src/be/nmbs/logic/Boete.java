package be.nmbs.logic;

public class Boete {
	private int id;
	private double bedrag;
	private boolean status;
	private Klant klant;
	
	// Constructor
	public Boete(int id, double bedrag, boolean status, Klant klant) {
		this.id = id;
		this.bedrag = bedrag;
		this.status = status;
		this.klant = klant;
	}
	
	// Getters
	public int getId() { return id; }
	public double getBedrag() { return bedrag; }
	public boolean isStatus() { return status; }
	public Klant getKlant() { return klant; }
	
	// Setters
	public void setId(int id) { this.id = id; }
	public void setBedrag(double bedrag) { this.bedrag = bedrag; }
	public void setStatus(boolean status) { this.status = status; }
	public void setKlant(Klant klant) { this.klant = klant; }
}