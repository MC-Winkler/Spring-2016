//Michael Winkler
//CSC331, 4/27/16
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Dijkstra {
	
	private Graph theGraph;
	private DijkstraVertex nodeExpanded;
	private HashMap<Vertex, Vertex> Parents;
	private ArrayList finalPath;
	
	public Dijkstra() {
		GraphMaker g = new GraphMaker();
		g.makeGraph();
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
		priorityQueue.remove(i);
		while (priorityQueue.size()> 0){
			ArrayList<>adjacentVertices = nodeExpanded.getAdjacentVertices().toArray(a);
			
			double smallestDistanceRemaining = 1000000000;
			DijkstraVertex smallestRemaining;
			
			for (Vertex v: adjacentVertices){
				System.out.println("Adjacent vertex = " + v.getName());
				DijkstraVertex x = (DijkstraVertex)v;
				if (x.getDistance() == 0 || x.getDistance() > theGraph.getWeight(nodeExpanded, x)){
					x.setDistance((int) theGraph.getWeight(nodeExpanded, x));
				}
				if (x.getDistance() < smallestDistanceRemaining){
					smallestDistanceRemaining = x.getDistance();
					smallestRemaining = x;
				}
			}
			nodeExpanded = smallestRemaining;
			priorityQueue.remove(smallestRemaining);
			
		}
		
	}
	
}
