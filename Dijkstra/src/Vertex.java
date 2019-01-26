import java.util.*;
public class Vertex implements Comparable<Vertex>{

	public final String name;
	public ArrayList<Edge> incidentEdges;
	public LinkedList<Vertex> path;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;

	public int compareTo(Vertex other) {
		return Double.compare(minDistance,other.minDistance);		
	}

	public Vertex(String name) {
		this.name = name;
		incidentEdges = new ArrayList<Edge>();
		path = new LinkedList<Vertex>();
	}

	public String toString() {
		return name;
	}	
}
