package be.nmbs.logic;


public class Korting {
	private int korting_id;
	private double hoeveelheid;
	private String omschrijving;
	private boolean actief;
	private String typeKorting;
	
	public Korting(int korting_id,double hoeveelheid,String omschrijving,boolean actief,String type){
		this.korting_id=korting_id;
		this.hoeveelheid=hoeveelheid;
		this.omschrijving=omschrijving;
		this.actief=actief;
		this.typeKorting=type;
	}
	
	// getters
	public int getId(){return korting_id;}
	public double getHoeveelheid(){return hoeveelheid;}
	public String getOmschrijving(){return omschrijving;}
	public boolean getActief(){return actief;}
	public String getTypeKorting(){return typeKorting;}
	// setters
	public void setHoeveelheid(double hoeveelheid){this.hoeveelheid=hoeveelheid;}
	public void setOmschrijving(String omschrijving){this.omschrijving=omschrijving;}
	public void setActief(boolean actief){this.actief=actief;}
	public void setTypeKorting(String type){this.typeKorting=type;}
}
