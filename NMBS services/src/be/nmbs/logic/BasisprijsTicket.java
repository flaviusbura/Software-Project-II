package be.nmbs.logic;

public class BasisprijsTicket {
	private int basisprijsId;
	private int typeTicketId;
	private double prijs;
	public BasisprijsTicket(int basisprijsId, int typeTicketId, double prijs) {
		super();
		this.basisprijsId = basisprijsId;
		this.typeTicketId = typeTicketId;
		this.prijs = prijs;
	}
	public BasisprijsTicket(int typeTicketId, double prijs) {
		this.typeTicketId = typeTicketId;
		this.prijs = prijs;
	}
	public BasisprijsTicket(Integer basisprijsId) {
		this.basisprijsId = basisprijsId;
		
	}
	public int getBasisprijsId() {
		return basisprijsId;
	}
	public void setBasisprijsId(int basisprijsId) {
		this.basisprijsId = basisprijsId;
	}
	public int getTypeTicketId() {
		return typeTicketId;
	}
	public void setTypeTicketId(int typeTicketId) {
		this.typeTicketId = typeTicketId;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	@Override
	public String toString() {
		return "BasisprijsTicket [basisprijsId=" + basisprijsId + ", typeTicketId=" + typeTicketId + ", prijs=" + prijs
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + basisprijsId;
		long temp;
		temp = Double.doubleToLongBits(prijs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + typeTicketId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasisprijsTicket other = (BasisprijsTicket) obj;
		if (basisprijsId != other.basisprijsId)
			return false;
		if (Double.doubleToLongBits(prijs) != Double.doubleToLongBits(other.prijs))
			return false;
		if (typeTicketId != other.typeTicketId)
			return false;
		return true;
	}
	
	

}
