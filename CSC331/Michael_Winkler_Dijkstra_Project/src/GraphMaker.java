
//Michael Winkler
//CSC331, 4/27/16
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphMaker {

	public Graph<Vertex> makeGraph() {
		Scanner forFileName = new Scanner(System.in);
		System.out.println("Enter the file name:");
		File file = new File(forFileName.next());

		AdjListGraph g = new AdjListGraph(Graph.DIRECTED);
		try {
			Scanner sc = new Scanner(file);
			int numOfVertices = sc.nextInt();
			for (int x = 0; x < numOfVertices; x++) {
				g.addVertex(new DijkstraVertex(sc.next()));
			}

			ArrayList<Vertex> allVertices = g.getVertices();
			for (int x = 0; x < numOfVertices; x++) {
				sc.next();
				for (int y = 0; y < numOfVertices; y++) {
					g.addEdge(allVertices.get(x), allVertices.get(y), sc.nextDouble());
				}
			}	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return g;
	}



}
