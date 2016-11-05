package be.nmbs.logic;

/**
 * 
 * @author Abdel-Portable
 *
 */

public class Prijs {
	private int prijs_id;
	private String omschrijving;
	private int prijs;
	private String type;
	private boolean actief;
	
	
	public Prijs(int prijs_id, String omschrijving, int prijs, String type, boolean actief)
	{
		this.prijs_id=prijs_id;
		this.omschrijving=omschrijving;
		this.prijs=prijs;
		this.type=type;
		this.actief=actief;
	}
	public int getPrijs_id()
	{
		return prijs_id;
	}
	
	public void setPrijs_id(int id) {
		this.prijs_id = id;
	}
	
	public String getOmschrijving()
	{
		return omschrijving;
	}
	
	public void setOmschrijving(String omsc)
	{
		this.omschrijving=omsc;
	}
	
	public int getPrijs()
	{
		return prijs;
	}
	public void setPrijs(int prijs)
	{
		this.prijs=prijs;
	}
	
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type=type;
	}
	public boolean getActief()
	{
		return actief;
	}
	
	public void boolean setActief(boolean act)
	{
		this.actief=act;
	}
}
