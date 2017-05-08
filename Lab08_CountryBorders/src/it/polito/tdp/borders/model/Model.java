package it.polito.tdp.borders.model;

import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {

	private SimpleGraph<Country,Border> grafo ;
	
	public Model(){
		this.grafo = new SimpleGraph<Country,Border>(Border.class);
	}
	
	public String createGraph(int anno){
		BordersDAO dao = new BordersDAO();
		Graphs.addAllVertices(grafo, dao.loadAllCountries());
		for(Border b : dao.getCountryPairs(2000)){
//			grafo.addVertex(b.getC1());
//			grafo.addVertex(b.getC2());
			grafo.addEdge(b.getC1(), b.getC2(),b);
		}
		String s = "";
		for(Country c : grafo.vertexSet())
			s+=String.format("%s n° stati confinanti: %d \n", c.toString(), Graphs.neighborListOf(grafo, c).size());
		ConnectivityInspector ci = new ConnectivityInspector(grafo);
		s+= String.format("Il numero di componenti connesse è: %d", ci.connectedSets().size());
		return s ;
	}
	
	

}
