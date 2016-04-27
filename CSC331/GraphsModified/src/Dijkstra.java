import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Dijkstra {
	
	private Graph theGraph;
	private DijkstraVertex nodeExpanded;
	private HashMap<Vertex, Integer> Distance;
	private HashMap<Vertex, Vertex> Parents;
	private ArrayList finalPath;
	
	public Dijkstra() {
		GraphMaker g = new GraphMaker();
		this.theGraph = g.getDefaultGraph();
		this.Distance = new HashMap<Vertex, Integer>();
		this.Parents = new HashMap<Vertex, Vertex>();
		this.finalPath = new ArrayList();
	}
	
	public void findPath(DijkstraVertex i, DijkstraVertex j){
		ArrayList<Vertex> priorityQueue = new ArrayList<Vertex>();
		Collection<Vertex> c = theGraph.getVertices();
		for (Vertex v: c){
			priorityQueue.add(v);
		}
		nodeExpanded = i;
		while (priorityQueue.size()> 0){
			
		}
		
	}
	
}
