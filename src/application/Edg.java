package application;

public class Edg {
	private Vertex source;
	private Vertex destination;
	private double cost;
	
	
	
	
	public Edg(Vertex source, Vertex destination, double cost) {
		super();
		this.source = source;
		this.destination = destination;
		this.cost = cost;
	}
	
	
	public Edg(Vertex destination, double cost) {
		super();
		this.destination = destination;
		this.cost = cost;
	}


	public Vertex getSource() {
		return source;
	}
	public void setSource(Vertex source) {
		this.source = source;
	}
	public Vertex getDestination() {
		return destination;
	}
	public void setDestination(Vertex destination) {
		this.destination = destination;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "Edge [source=" + source + ", destination=" + destination + ", cost=" + cost + "]";
	}
	
	
	
}
