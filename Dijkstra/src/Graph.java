import java.util.*;

public class Graph {

	private Map<String, Vertex> vertices = null;
	String srcVertex=null;

	public Graph() {
		vertices = new HashMap<String, Vertex>();
	}

	public Vertex checkVertex(String vertex) {
		
		Vertex s=null;
		if (!vertices.containsKey(vertex)) {
			s= new Vertex(vertex);
			
			if(vertices.size()==0) {
				srcVertex = vertex;
			}
			
			vertices.put(vertex,s);
		}else {
			s= vertices.get(vertex); 
		}
		return s;
	}

	public void addEdge(String src, String dest, int weight) {

		
		Vertex s=checkVertex(src);
		Vertex d=checkVertex(dest);
		
		Edge new_edge = new Edge(d, weight);
		s.incidentEdges.add(new_edge);
		Edge reverse_edge = new Edge(s, weight);
		d.incidentEdges.add(reverse_edge);
	}

	public Map<String, Vertex> getVertices() {
		return vertices;
	}

	public Vertex getVertex(String vert) {
		return vertices.get(vert);
	}
}
