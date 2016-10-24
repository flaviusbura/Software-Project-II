package be.nmbs.logic;

public class Klant extends Persoon {
	int id;
	
	// Constructor
	public Klant(String voornaam, String achternaam, Adres adres, char geslacht, int id) {
		super(voornaam, achternaam, adres, geslacht);
		this.id = id;
	}
	
	// Getters
	public int getId() { return id; }
	
	// Setters
	public void setId(int id) { this.id = id; }
}