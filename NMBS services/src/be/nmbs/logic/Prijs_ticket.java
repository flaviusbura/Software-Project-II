package be.nmbs.logic;

import be.nmbs.database.BasisprijsTicketDAO;
import be.nmbs.database.CoefficientTicketDAO;

public class Prijs_ticket {
	
	private int prijs_ticketid;
	private int type_ticketid;
	private int coefficient_ticketid;
	private int basisprijs_ticketid;
	private double totaal;
	
	public Prijs_ticket() {}
	
	public Prijs_ticket(int prijs_ticketid, int type_ticketid, int coefficient_ticketid, int basisprijs_ticketid,
			double totaal) {
		super();
		this.prijs_ticketid = prijs_ticketid;
		this.type_ticketid = type_ticketid;
		this.coefficient_ticketid = coefficient_ticketid;
		this.basisprijs_ticketid = basisprijs_ticketid;
		this.totaal = totaal;
	}




	public Prijs_ticket(int type_ticketid, int coefficient_ticketid, int basisprijs_ticketid, double totaal) {
		super();
		this.type_ticketid = type_ticketid;
		this.coefficient_ticketid = coefficient_ticketid;
		this.basisprijs_ticketid = basisprijs_ticketid;
		this.totaal = totaal;
	}

	public int getPrijs_ticketid() {
		return prijs_ticketid;
	}


	public void setPrijs_ticketid(int prijs_ticketid) {
		this.prijs_ticketid = prijs_ticketid;
	}


	public int getType_ticketid() {
		return type_ticketid;
	}


	public void setType_ticketid(int type_ticketid) {
		this.type_ticketid = type_ticketid;
	}


	public int getCoefficient_ticketid() {
		return coefficient_ticketid;
	}


	public void setCoefficient_ticketid(int coefficient_ticketid) {
		this.coefficient_ticketid = coefficient_ticketid;
	}


	public int getBasisprijs_ticketid() {
		return basisprijs_ticketid;
	}


	public void setBasisprijs_ticketid(int basisprijs_ticketid) {
		this.basisprijs_ticketid = basisprijs_ticketid;
	}


	public double getTotaal() {
		return totaal;
	}


	public void setTotaal(double totaal) {
		this.totaal = totaal;
	}


	public double berekenPrijs(int coefficient_ticketid , int basisprijs_ticketid) {
		CoefficientTicketDAO coef = new CoefficientTicketDAO();
		BasisprijsTicketDAO basis = new BasisprijsTicketDAO();
		
		double coefi = coef.getCoefficient_ById(coefficient_ticketid);
		double basisprijs = basis.getPrijs_ById(basisprijs_ticketid);
		double totaal = coefi * basisprijs;
		return totaal;
	}


}
