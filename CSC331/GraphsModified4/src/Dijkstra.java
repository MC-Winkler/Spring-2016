
//Michael Winkler
//CSC331, 4/27/16
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Dijkstra {

	private Graph theGraph;
	private Vertex nodeExpanded;
	private HashMap<DijkstraVertex, DijkstraVertex> parents;
	private ArrayList finalPath;
	private ArrayList<Vertex> priorityQueue;
	private Collection<Vertex> allVertices;

	public Dijkstra() {
		GraphMaker g = new GraphMaker();
		theGraph = g.makeGraph();
		this.parents = new HashMap<DijkstraVertex, DijkstraVertex>();
		this.finalPath = new ArrayList();

		// Initialize priority queue and fill it with all vertices
		priorityQueue = new ArrayList<Vertex>();
		allVertices = theGraph.getVertices();
		for (Vertex v : allVertices) {
			priorityQueue.add(v);
		}
	}

	public void findPath(Vertex i, Vertex j) {

		// remove the starting node from the priority queue and
		// set it as nodeExpanded
		DijkstraVertex nodeExpanded = (DijkstraVertex) i;
		nodeExpanded.setDistance(0);
		priorityQueue.remove(i);

		// while there are still nodes in the priority queue
		while (priorityQueue.size() > 0) {

			// look at all vertices adjacent to the currently expanded node
			Collection<Vertex> adjacentVertices = nodeExpanded.getAdjacentVertices();
			double smallestDistanceRemaining = Double.POSITIVE_INFINITY;
			Vertex smallestRemaining = priorityQueue.get(0);

			for (Vertex v : adjacentVertices) {
				DijkstraVertex x = (DijkstraVertex) v;
				// if the distance between x and the expanded node is less than x's current distance value
				// and x is still in the priority queue, set the expanded node to be x's parent
				// and set x's new distance to be the distance between it and the expanded node +
				// the expanded node's distance
				if ((theGraph.getWeight(nodeExpanded, x) + nodeExpanded.getDistance()) < x.getDistance() 
						&& theGraph.getWeight(nodeExpanded, x) != 0
						&& priorityQueue.contains(x)) {
					parents.put(x, nodeExpanded);
					x.setDistance(theGraph.getWeight(nodeExpanded, x) + nodeExpanded.getDistance());
				}
			}

			for (Vertex v : priorityQueue) {
				DijkstraVertex x = (DijkstraVertex) v;
				if (x.getDistance() < smallestDistanceRemaining && priorityQueue.contains(x)) {
					smallestDistanceRemaining = x.getDistance();
					smallestRemaining = x;
				}
			}
			System.out.println("New Node Expanded = " + nodeExpanded.getName());
			nodeExpanded = (DijkstraVertex) smallestRemaining;
			priorityQueue.remove(smallestRemaining);
		}

		DijkstraVertex g = (DijkstraVertex) j;
		System.out.println("The shortest path is " + g.getDistance());
	}

	public void go() {
		Vertex startingVertex = new Vertex("default");
		Vertex endingVertex = new Vertex("default");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the starting vertex:");
		String startingVertexName = sc.next();
		System.out.println("Enter the ending vertex:");
		String endingVertexName = sc.next();
		for (Vertex v : allVertices) {
			if (v.getName().equals(startingVertexName))
				startingVertex = v;
			if (v.getName().equals(endingVertexName))
				endingVertex = v;
		}

		findPath(startingVertex, endingVertex);
	}

}
