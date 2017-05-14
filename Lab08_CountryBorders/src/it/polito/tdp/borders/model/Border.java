package it.polito.tdp.borders.model;

import org.jgrapht.graph.DefaultEdge;

public class Border extends DefaultEdge {
	
	private Country c1 ;
	private Country c2 ;
	
	public Border(Country c1, Country c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public Country getC1(){
		return this.c1;
	}
	
	public Country getC2(){
		return this.c2;
	}

	@Override
	public String toString() {
		return String.format("Confine %s e %s ", c1 ,c2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c1 == null) ? 0 : c1.hashCode());
		result = prime * result + ((c2 == null) ? 0 : c2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Border))
			return false;
		Border other = (Border) obj;
		if (c1 == null) {
			if (other.c1 != null)
				return false;
		} else if (!c1.equals(other.c1))
			return false;
		if (c2 == null) {
			if (other.c2 != null)
				return false;
		} else if (!c2.equals(other.c2))
			return false;
		return true;
	}
	
	
	
}
