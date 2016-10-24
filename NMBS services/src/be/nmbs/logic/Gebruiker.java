package be.nmbs.logic;

public class Gebruiker extends Persoon {
	private int id;
	private String wachtwoord;
	private String email;
	private Rol rol;
	public enum Rol { USER, ADMIN };
	
	// Constructor
	public Gebruiker(String voornaam, String achternaam, Adres adres, char geslacht, int id, String wachtwoord,
			String email) {
		super(voornaam, achternaam, adres, geslacht);
		this.id = id;
		this.wachtwoord = wachtwoord;
		this.email = email;
	}
	
	// Getters
	public int getId() { return id; }
	public String getWachtwoord() { return wachtwoord; }
	public String getEmail() { return email; }
	public Rol getRol() { return rol; }

	// Setters
	public void setId(int id) { this.id = id; }
	public void setWachtwoord(String wachtwoord) { this.wachtwoord = wachtwoord; }
	public void setEmail(String email) { this.email = email; }
	public void setRol(Rol rol) { this.rol = rol; }
}