package be.nmbs.logic;

public class Type {
	private int type_id;
	private String type;

	public Type(String type) {
		super();
		this.type = type;
	}

	public Type(int type_id, String type) {
		super();
		this.type_id = type_id;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Type [type=" + type + "]";
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Type other = (Type) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
