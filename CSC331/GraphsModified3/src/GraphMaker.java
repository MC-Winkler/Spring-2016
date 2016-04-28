
//Michael Winkler
//CSC331, 4/27/16
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphMaker {

	public void makeGraph() {
		Scanner forFileName = new Scanner(System.in);
		System.out.println("Enter the file name:");
		File file = new File(forFileName.next());

		AdjListGraph g = new AdjListGraph(Graph.UNDIRECTED);
		try {
			Scanner sc = new Scanner(file);
			int numOfVertices = sc.nextInt();
			for (int x = 0; x < numOfVertices; x++) {
				g.addVertex(new DijkstraVertex(sc.next()));
			}

			ArrayList<Vertex> allVertices = g.getVertices();
			for (int x = 0; x < numOfVertices; x++) {
				System.out.println("Current row: " + sc.next());
				for (int y = 0; y < numOfVertices; y++) {
					// avoid duplicates with this if-else
					if (y < x)
						sc.next();
					else
						g.addEdge(allVertices.get(x), allVertices.get(y), sc.nextDouble());

				}
			}

			System.out.println("the graph currently: " + g.getAdjacentVertices(allVertices.get(0)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Graph<Vertex> getDefaultGraph() {
		AdjListGraph graph = new AdjListGraph(Graph.UNDIRECTED);

		DijkstraVertex Takamatsu = (DijkstraVertex) graph.addVertex(new DijkstraVertex("Takamatsu"));
		DijkstraVertex Tokushima = (DijkstraVertex) graph.addVertex(new DijkstraVertex("Tokushima"));
		DijkstraVertex Ikeda = (DijkstraVertex) graph.addVertex(new DijkstraVertex("Ikeda"));
		DijkstraVertex Kawanoe = (DijkstraVertex) graph.addVertex(new DijkstraVertex("Kawanoe"));
		DijkstraVertex Kochi = (DijkstraVertex) graph.addVertex(new DijkstraVertex("Kochi"));
		DijkstraVertex Muroto = (DijkstraVertex) graph.addVertex(new DijkstraVertex("Muroto"));
		DijkstraVertex Matsuyama = (DijkstraVertex) graph.addVertex(new DijkstraVertex("Matsuyama"));
		DijkstraVertex Uwajima = (DijkstraVertex) graph.addVertex(new DijkstraVertex("Uwajima"));
		DijkstraVertex Nakamura = (DijkstraVertex) graph.addVertex(new DijkstraVertex("Nakamura"));

		graph.addEdge(Takamatsu, Takamatsu, 0);
		graph.addEdge(Takamatsu, Tokushima, 76);
		graph.addEdge(Takamatsu, Ikeda, 57);
		graph.addEdge(Takamatsu, Kawanoe, 73);
		graph.addEdge(Takamatsu, Kochi, 0);
		graph.addEdge(Takamatsu, Muroto, 0);
		graph.addEdge(Takamatsu, Matsuyama, 0);
		graph.addEdge(Takamatsu, Uwajima, 0);
		graph.addEdge(Takamatsu, Nakamura, 0);
		graph.addEdge(Tokushima, Tokushima, 0);
		graph.addEdge(Tokushima, Ikeda, 74);
		graph.addEdge(Tokushima, Kawanoe, 0);
		graph.addEdge(Tokushima, Kochi, 0);
		graph.addEdge(Tokushima, Muroto, 128);
		graph.addEdge(Tokushima, Matsuyama, 0);
		graph.addEdge(Tokushima, Uwajima, 0);
		graph.addEdge(Tokushima, Nakamura, 0);
		graph.addEdge(Ikeda, Ikeda, 0);
		graph.addEdge(Ikeda, Kawanoe, 26);
		graph.addEdge(Ikeda, Kochi, 82);
		graph.addEdge(Ikeda, Muroto, 0);
		graph.addEdge(Ikeda, Matsuyama, 0);
		graph.addEdge(Ikeda, Uwajima, 0);
		graph.addEdge(Ikeda, Nakamura, 0);
		graph.addEdge(Kawanoe, Kawanoe, 0);
		graph.addEdge(Kawanoe, Kochi, 87);
		graph.addEdge(Kawanoe, Muroto, 0);
		graph.addEdge(Kawanoe, Matsuyama, 95);
		graph.addEdge(Kawanoe, Uwajima, 0);
		graph.addEdge(Kawanoe, Nakamura, 0);
		graph.addEdge(Kochi, Kochi, 0);
		graph.addEdge(Kochi, Muroto, 83);
		graph.addEdge(Kochi, Matsuyama, 127);
		graph.addEdge(Kochi, Uwajima, 148);
		graph.addEdge(Kochi, Nakamura, 128);
		graph.addEdge(Muroto, Muroto, 0);
		graph.addEdge(Muroto, Matsuyama, 0);
		graph.addEdge(Muroto, Uwajima, 0);
		graph.addEdge(Muroto, Nakamura, 0);
		graph.addEdge(Matsuyama, Matsuyama, 0);
		graph.addEdge(Matsuyama, Uwajima, 92);
		graph.addEdge(Matsuyama, Nakamura, 0);
		graph.addEdge(Uwajima, Uwajima, 0);
		graph.addEdge(Uwajima, Nakamura, 87);
		graph.addEdge(Nakamura, Nakamura, 0);

		return graph;
	}

}
