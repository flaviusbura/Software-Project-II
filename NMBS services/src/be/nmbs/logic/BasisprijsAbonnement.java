package be.nmbs.logic;

public class BasisprijsAbonnement {
	private int id;
	private int typeAbonnementId;
	private double prijs;
	public BasisprijsAbonnement(int id, int typeAbonnementId, double prijs) {
		super();
		this.id = id;
		this.typeAbonnementId = typeAbonnementId;
		this.prijs = prijs;
	}
	public BasisprijsAbonnement(int typeAbonnementId, double prijs) {
		
		this.typeAbonnementId = typeAbonnementId;
		this.prijs = prijs;
	}
	public BasisprijsAbonnement(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeAbonnementId() {
		return typeAbonnementId;
	}
	public void setTypeAbonnementId(int typeAbonnementId) {
		this.typeAbonnementId = typeAbonnementId;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	@Override
	public String toString() {
		return "BasisprijsAbonnement [id=" + id + ", typeAbonnementId=" + typeAbonnementId + ", prijs=" + prijs + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(prijs);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BasisprijsAbonnement other = (BasisprijsAbonnement) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(prijs) != Double.doubleToLongBits(other.prijs))
			return false;
		if (typeAbonnementId != other.typeAbonnementId)
			return false;
		return true;
	}
	

}
