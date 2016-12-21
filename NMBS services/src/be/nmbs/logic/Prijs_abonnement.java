package be.nmbs.logic;

import be.nmbs.database.BasisprijsAbonnementenDAO;
import be.nmbs.database.CoefficientAbonnementDAO;

public class Prijs_abonnement {
	
	private int prijs_abonnementid;
	private int type_abonnementid;
	private int coefficient_abonnementid;
	private int basisprijs_abonnementid;
	private double totaal;
	
	public Prijs_abonnement() {}
	
	public Prijs_abonnement(int prijs_abonnementid, int type_abonnementid, int coefficient_abonnementid,
			int basisprijs_abonnementid, double totaal) {
		super();
		this.prijs_abonnementid = prijs_abonnementid;
		this.type_abonnementid = type_abonnementid;
		this.coefficient_abonnementid = coefficient_abonnementid;
		this.basisprijs_abonnementid = basisprijs_abonnementid;
		this.totaal = totaal;
	}

	public Prijs_abonnement(int type_abonnementid, int coefficient_abonnementid,
			int basisprijs_abonnementid, double totaal) {
		super();
		this.type_abonnementid = type_abonnementid;
		this.coefficient_abonnementid = coefficient_abonnementid;
		this.basisprijs_abonnementid = basisprijs_abonnementid;
		this.totaal = totaal;
	}
	
	public double berekenPrijs(int coefficient_abonnementid , int basisprijs_abonnementid) {
		CoefficientAbonnementDAO coef = new CoefficientAbonnementDAO();
		BasisprijsAbonnementenDAO basis = new BasisprijsAbonnementenDAO();
		
		double coefi = coef.getCoefficient_ById(coefficient_abonnementid);
		double basisprijs = basis.getPrijs_ById(basisprijs_abonnementid);
		double totaal = coefi * basisprijs;
		return totaal;
	}
	
	public int getPrijs_abonnementid() {
		return prijs_abonnementid;
	}
	public void setPrijs_abonnementid(int prijs_abonnementid) {
		this.prijs_abonnementid = prijs_abonnementid;
	}
	public int getType_abonnementid() {
		return type_abonnementid;
	}
	public void setType_abonnementid(int type_abonnementid) {
		this.type_abonnementid = type_abonnementid;
	}
	public int getCoefficient_abonnementid() {
		return coefficient_abonnementid;
	}
	public void setCoefficient_abonnementid(int coefficient_abonnementid) {
		this.coefficient_abonnementid = coefficient_abonnementid;
	}
	public int getBasisprijs_abonnementid() {
		return basisprijs_abonnementid;
	}
	public void setBasisprijs_abonnementid(int basisprijs_abonnementid) {
		this.basisprijs_abonnementid = basisprijs_abonnementid;
	}
	public double getTotaal() {
		return totaal;
	}
	public void setTotaal(double totaal) {
		this.totaal = totaal;
	}
	
	

}
