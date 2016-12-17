package be.nmbs.logic;

public class CoefficientAbonnement {
	private int coefficientAbonnementId;
	private int typeAbonnementId;
	private double coefficient;
	public CoefficientAbonnement(int coefficientAbonnementId, int typeAbonnementId, double coefficient) {
		super();
		this.coefficientAbonnementId = coefficientAbonnementId;
		this.typeAbonnementId = typeAbonnementId;
		this.coefficient = coefficient;
	}
	public CoefficientAbonnement(int typeAbonnementId, double coefficient) {
		this.typeAbonnementId = typeAbonnementId;
		this.coefficient = coefficient;
	}
	public int getCoefficientAbonnementId() {
		return coefficientAbonnementId;
	}
	public void setCoefficientAbonnementId(int coefficientAbonnementId) {
		this.coefficientAbonnementId = coefficientAbonnementId;
	}
	public int getTypeAbonnementId() {
		return typeAbonnementId;
	}
	public void setTypeAbonnementId(int typeAbonnementId) {
		this.typeAbonnementId = typeAbonnementId;
	}
	public double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	@Override
	public String toString() {
		return "CoefficientAbonnement [coefficientAbonnementId=" + coefficientAbonnementId + ", typeAbonnementId="
				+ typeAbonnementId + ", coefficient=" + coefficient + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coefficient);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + coefficientAbonnementId;
		result = prime * result + typeAbonnementId;
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
		CoefficientAbonnement other = (CoefficientAbonnement) obj;
		if (Double.doubleToLongBits(coefficient) != Double.doubleToLongBits(other.coefficient))
			return false;
		if (coefficientAbonnementId != other.coefficientAbonnementId)
			return false;
		if (typeAbonnementId != other.typeAbonnementId)
			return false;
		return true;
	}
	
	
}
