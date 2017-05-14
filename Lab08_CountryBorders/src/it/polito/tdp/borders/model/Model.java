package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {

	private SimpleGraph<Country,Border> grafo ;
	private Map<String,Country> countries ;
	
	public Model(){
		this.grafo = new SimpleGraph<Country,Border>(Border.class);
		this.countries = new HashMap<>() ;
	}
	
	public String createGraph(int anno){
		BordersDAO dao = new BordersDAO();
		for(Country c : dao.loadAllCountries()){
			countries.put(c.getId(), c);
			grafo.addVertex(c);
		}
		for(Border b : dao.getCountryPairs(2000,countries)){
			if(grafo.vertexSet().contains(b.getC1())&& grafo.vertexSet().contains(b.getC2()))
				grafo.addEdge(b.getC1(), b.getC2());
		}
		String s = "";
		for(Country c : grafo.vertexSet())
			s+=String.format("%s n° stati confinanti: %d \n", c.toString(), Graphs.neighborListOf(grafo, c).size());
		ConnectivityInspector<Country,Border> ci = new ConnectivityInspector<>(grafo);
		s+= String.format("Il numero di componenti connesse è: %d", ci.connectedSets().size());
		return s ;
	}
	
	

}
