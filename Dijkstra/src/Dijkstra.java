import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/***
 * Name : Keyurkumar Hansoti
 * Student ID: 801044954
 */


public class Dijkstra {

	public Graph graph;

	public Dijkstra() {
		graph = new Graph();
		loadGraph();
	}

	private void loadGraph() {
		loadEdges();
	}

	private void loadEdges() {

		try {
			File file = new File("src/inputFile.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				
				String[] arr = line.split(" ");
				
				if (arr.length > 1) {
					String startVertex = arr[0];
					String endVertex = arr[1];
					String weight = arr[2];
					graph.addEdge(startVertex, endVertex, Integer.parseInt(weight));
				} else {
					String sourceVertex = arr[0];
					graph.srcVertex = sourceVertex;
				}
			}
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void calculate(Vertex source) {

		source.minDistance = 0;
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		queue.add(source);

		while (!queue.isEmpty()) {
			Vertex u = queue.poll();

			for (Edge edge : u.incidentEdges) {
				Double newDist = u.minDistance + edge.weight;

				if (edge.target.minDistance > newDist) {
					queue.remove(edge.target);
					edge.target.minDistance = newDist;

					edge.target.path = new LinkedList<Vertex>(u.path);
					edge.target.path.add(u);

					queue.add(edge.target);
				}
			}
		}
	}

	public static void main(String[] arg) {

		Dijkstra obj = new Dijkstra();
		obj.calculate(obj.graph.getVertex(obj.graph.srcVertex));

		for (Vertex v : obj.graph.getVertices().values()) {
			System.out.print("Vertex - " + v + " , Dist - " + v.minDistance + " , Path - ");
			for (Vertex pathvert : v.path) {
				System.out.print(pathvert + " ");
			}
			System.out.println("" + v);
		}
	}

}
