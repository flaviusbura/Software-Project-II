package be.nmbs.logic;

public class CoefficientTicket {
	private int coefficientTicketId;
	private int typeTicketId;
	private double coefficient;
	
	public CoefficientTicket(int coefficientTicketId, int typeTicketId, double coefficient) {
		super();
		this.coefficientTicketId = coefficientTicketId;
		this.typeTicketId = typeTicketId;
		this.coefficient = coefficient;
	}
	public CoefficientTicket(int typeTicketId, double coefficient) {
		this.typeTicketId = typeTicketId;
		this.coefficient = coefficient;
	}
	public CoefficientTicket(int coefficientTicketId) {
		this.coefficientTicketId = coefficientTicketId;
	}
	public int getCoefficientTicketId() {
		return coefficientTicketId;
	}
	public void setCoefficientTicketId(int coefficientTicketId) {
		this.coefficientTicketId = coefficientTicketId;
	}
	public int getTypeTicketId() {
		return typeTicketId;
	}
	public void setTypeTicketId(int typeTicketId) {
		this.typeTicketId = typeTicketId;
	}
	public double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	@Override
	public String toString() {
		return "CoefficientTicket [coefficientTicketId=" + coefficientTicketId + ", typeTicketId=" + typeTicketId
				+ ", coefficient=" + coefficient + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coefficient);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + coefficientTicketId;
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
		CoefficientTicket other = (CoefficientTicket) obj;
		if (Double.doubleToLongBits(coefficient) != Double.doubleToLongBits(other.coefficient))
			return false;
		if (coefficientTicketId != other.coefficientTicketId)
			return false;
		if (typeTicketId != other.typeTicketId)
			return false;
		return true;
	}
	
	

}
