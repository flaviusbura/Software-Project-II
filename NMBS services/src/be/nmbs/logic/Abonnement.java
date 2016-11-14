package be.nmbs.logic;

public class Abonnement {
	private int id;
	private Klant klant;
	private String route;
	private String eindDatum;
	private Korting korting;
	private boolean actief;
	private Prijs prijs;
	// Constructor
	public Abonnement(int id,Korting korting, boolean actief,Klant klant, String route, String eindDatum, Prijs prijs) {
		this.klant = klant;
		this.route = route;
		this.eindDatum = eindDatum;
		this.id = id;
		this.korting = korting;
		this.actief = actief;
		this.prijs = prijs;
	}
	
	// Getters
	public Klant getKlant() { return klant; }
	public String getRoute(){	return route;}
	public String getEindDatum() { return eindDatum; }
	public int getId() {return id;}
	public Korting getKorting() {return korting;}
	public boolean isActief() {return actief;}


	// Setters
	public void setKlant(Klant klant) { this.klant = klant; }
	public void setRoute(String route) { this.route = route; }
	public void setEindDatum(String eindDatum) { this.eindDatum = eindDatum; }	
	public void setKorting(Korting korting) {this.korting = korting;}
	public void setId(int id) {this.id = id;}
	public void setActief(boolean actief) {this.actief = actief;}
	
	
	//

	public int getKlantContactId()
	{
		return klant.getContactId();
	}
	
	public int getKortingID()
	{
		
		return korting.getId();
	}
	public int getPrijsId()
	{
		
		return prijs.getPrijsId();
	}
}