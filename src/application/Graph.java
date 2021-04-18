package application;

import java.util.ArrayList;

public class Graph {
	
	   private final ArrayList<Vertex> vertexes;
	    private final ArrayList<Edg> edges;

	    public Graph(ArrayList<Vertex> vertexes, ArrayList<Edg> edges) {
	        this.vertexes = vertexes;
	        this.edges = edges;
	    }

	    public ArrayList<Vertex> getVertexes() {
	        return vertexes;
	    }

	    public ArrayList<Edg> getEdges() {
	        return edges;
	    }

}
