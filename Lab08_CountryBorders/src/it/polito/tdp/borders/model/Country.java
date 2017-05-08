package it.polito.tdp.borders.model;

public class Country {
	private String nazione ;
	private String id ;
	
	public Country(String nazione, String id) {
		this.nazione = nazione;
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("%s (%s) ", nazione,id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Country))
			return false;
		Country other = (Country) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
}
