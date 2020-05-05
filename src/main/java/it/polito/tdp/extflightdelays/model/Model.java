package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	private Graph<Airport,DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao= new ExtFlightDelaysDAO();
	private Map<Integer, Airport> airportsIdMap= new HashMap<Integer, Airport>();
	public Model() {
		
	}
	public Graph<Airport, DefaultWeightedEdge> creaGrafo(Integer distanza) {
		grafo= new SimpleWeightedGraph<Airport, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		for(Airport a:dao.loadAllAirports()) {
			airportsIdMap.put(a.getId(), a);
		}
		//Aggiungo tutti i vertici, ovvero tutti gli aereoporti presenti nel DB
		Graphs.addAllVertices(this.grafo, airportsIdMap.values());
		//Aggiungo tutti gli archi che sono dati dalle coppie Aereoporto-Aereoporto 
		//che rispettano la richiesta 
		for(CoppieAereoporti c:dao.getCollegamenti(airportsIdMap)) {
			if(c.getDistanza()>distanza) {
				Graphs.addEdge(this.grafo, airportsIdMap.get(c.getA1()), airportsIdMap.get(c.getA2()),c.getDistanza());
			}
		}
		System.out.println("Grafo creato! #Vertici: "+this.grafo.vertexSet().size()+", #Archi: "+this.grafo.edgeSet().size());
		return this.grafo;
	}
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
}
