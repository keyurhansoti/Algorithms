import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/***
 * Name : Keyurkumar Hansoti
 * Student ID: 801044954
 */


public class MinimumSpanningTree {

	public Graph graph;

    public static Collection<Edge> prims(Graph g, String start) {
    	Vertex startVertex = new Vertex(start);
    	Vertex currVertex = startVertex;
    	Collection<Edge> finalEdges = new ArrayList<Edge>();
    	Collection<Edge> edgeList = g.getEdgeList();
    	List<Vertex> visited = new ArrayList<Vertex>();
    	visited.add(startVertex);
    	PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
    	Map<Vertex, Integer> vertexMap = g.getAdjacencies(startVertex);
    	Set<Vertex> vertices = vertexMap.keySet();
    	for(Vertex v : vertices) {
    		queue.add(new Edge(startVertex, v, vertexMap.get(v)));
    	}
    	while(visited.size()!= g.getVertices().size() && !queue.isEmpty()) {
    		Edge min = queue.poll();
    		if(!visited.contains(min.getU()) || !visited.contains(min.getV())) {
    			finalEdges.add(min);
    			if(!visited.contains(min.getU())) {
    				currVertex = min.getU();
    			}
    			else if(!visited.contains(min.getV())) {
    				currVertex = min.getV();
    			}
    			vertexMap.putAll(g.getAdjacencies(currVertex));
    			visited.add(currVertex);
    			vertices = vertexMap.keySet();
    			for(Vertex v : vertices) {
    				if(edgeList.contains(new Edge(currVertex,v, vertexMap.get(v)))) {
    					queue.add(new Edge(currVertex,v, vertexMap.get(v)));
    				}
                }
    		}
    	}
    	if(queue.isEmpty()) {
    		return null;
    	}
    	return finalEdges;
    }

    
    public static void main(String[] args) throws Exception {
    	String filePath = "src/inputFile.txt";
    	int totalWeight = 0;
    	MinimumSpanningTree mst = new MinimumSpanningTree();
    	mst.graph=new Graph(filePath);
    	Collection<Edge> edges = MinimumSpanningTree.prims(mst.graph,mst.graph.getSourceVertex());

    	for(Edge e : edges) {
    		System.out.println("Edge " + e.getU().getVertexName() + " " + e.getV().getVertexName() + ", Weight " + e.getWeight());
    		totalWeight += e.getWeight();		
    	}
    	System.out.print("\n");
    	System.out.print("Total Weight - " + totalWeight);
    }
}
    	
