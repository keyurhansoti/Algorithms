public class Vertex {

	private String vertexName;
	
	public Vertex(String vertexName) {
		this.vertexName = vertexName;
	}
	

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Vertex) {
			return vertexName.equals(((Vertex) o).vertexName);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return vertexName.hashCode();
	}

	public String getVertexName() {
		return vertexName;
	}

}
