import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Graph {

	private Collection<Edge> edges = new HashSet<Edge>();
	private Set<Vertex> vertices = new HashSet<Vertex>();
	private Map<Vertex, Map<Vertex, Integer>> adjacencies = new HashMap<Vertex, Map<Vertex, Integer>>();
	private String sourceVertex;

	public String getSourceVertex() {
		return sourceVertex;
	}

	public void setSourceVertex(String sourceVertex) {
		this.sourceVertex = sourceVertex;
	}

	public Graph(String input) {
		try {
			File file = new File(input);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				
				String[] arr = line.split(" ");	
				
				if (arr.length > 1) {
					Vertex u = new Vertex(arr[0]);
					Vertex v = new Vertex(arr[1]);
					sourceVertex = u.getVertexName();
					int weight = Integer.parseInt(arr[2]);					

					vertices.add(u);
					vertices.add(v);
					
					edges.add(new Edge(u, v, weight));
					edges.add(new Edge(v, u, weight));
				
					if (!adjacencies.containsKey(u)) {
						adjacencies.put(u, new HashMap<Vertex, Integer>());
					}
					adjacencies.get(u).put(v, weight);
					
					if (!adjacencies.containsKey(v)) {
						adjacencies.put(v, new HashMap<Vertex, Integer>());
					}
					adjacencies.get(v).put(u, weight);
				}
				
				else {
					sourceVertex = arr[0];
				}		
			}

			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Collection<Edge> getEdgeList() {
		return edges;
	}

	public Set<Vertex> getVertices() {
		return vertices;
	}
	
	public Map<Vertex, Integer> getAdjacencies(Vertex u) {
		return adjacencies.get(u);
	}
}