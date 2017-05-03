package it.polito.tdp.borders.model;

import org.jgrapht.graph.SimpleGraph;

public class Model {

	private SimpleGraph<Country,Border> grafo ;
	
	public Model(){
		this.grafo = new SimpleGraph<>(Border.class);
	}
	
	

}
