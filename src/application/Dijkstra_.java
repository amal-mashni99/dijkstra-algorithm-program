package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.scene.control.ComboBox;

public class Dijkstra_ {

	private double pathD;

int count;

private ArrayList vertex;
private Map<Vertex,Boolean> settledNodes;
	private Map<Vertex, Vertex> predecessors;
	private Map<Vertex, Double> distance;
	private HashMap <Vertex,LinkedList<Edg>> edges;

	public Dijkstra_ (HashMap <Vertex,LinkedList<Edg>> edges,ArrayList vertex)
	{
		this.edges=edges;
		this.vertex=vertex;
	}

	public void execute(Vertex source , Vertex target) {
count=0;
		settledNodes = new HashMap<Vertex,Boolean>();
		distance = new HashMap<Vertex, Double>();
		predecessors = new HashMap<Vertex, Vertex>();
		distance.put(source,(double) 0);
		settledNodes.put(source,false);
		count++;
		while (count > 0 ) {

			Vertex node = getMinimum(settledNodes);
			settledNodes.replace(node, true);
			count--;
			if (node.getName().equalsIgnoreCase(target.getName()))
				return;


			findMinimalDistances(node);
		}
	}

	void findMinimalDistances(Vertex node) {
		LinkedList<Edg> adjacentNodes = edges.get(node);
		if (adjacentNodes==null)
			return;
		for (int i=0;i<adjacentNodes.size();i++) {
			if(settledNodes.get(adjacentNodes.get(i).getDestination())==null||settledNodes.get(adjacentNodes.get(i).getDestination())==false )
			{
				if (getShortestDistance(adjacentNodes.get(i).getDestination()) > getShortestDistance(node) + getDistance(node, adjacentNodes.get(i).getDestination())) {
					if (distance.get(adjacentNodes.get(i).getDestination())==null)
						distance.put(adjacentNodes.get(i).getDestination(), getShortestDistance(node) + getDistance(node, adjacentNodes.get(i).getDestination()));
					else distance.replace(adjacentNodes.get(i).getDestination(), getShortestDistance(node) + getDistance(node, adjacentNodes.get(i).getDestination()));
					if (predecessors.get(adjacentNodes.get(i).getDestination())==null)
						predecessors.put(adjacentNodes.get(i).getDestination(), node);
					else predecessors.replace(adjacentNodes.get(i).getDestination(), node);
					{settledNodes.put(adjacentNodes.get(i).getDestination(),false);
					count++;
					}
					}
				}}
		}



	private Double getDistance(Vertex node, Vertex target) {
		double d= 0.0;
		try{

		LinkedList<Edg> list=  edges.get(node);

		for(int i=0;i<list.size();i++)
		{System.out.println(list.get(i).getDestination().getName() +"=="+target.getName());
			//if (list.get(i).getDestination().getName().equalsIgnoreCase(target.getName()))
			if (list.get(i).getDestination().getName().equalsIgnoreCase(target.getName()))

				d=list.get(i).getCost();
			//else System.out.println("no");
		}
		}
		catch(Exception e)
		{
			
		}
		return d;
	}


	private Vertex getMinimum(Map<Vertex ,Boolean> vertexes) {
		Vertex [] minimum = {null};
		vertexes.forEach((key, value) ->{
			if (minimum[0] ==null && value == false )
				minimum[0]=key;

			else 
			{
				if (getShortestDistance(key) < getShortestDistance(minimum[0]) && value ==false ) 
					minimum[0] = key;

			}

		});

		return minimum[0];
	}

	boolean isSettled(Vertex vertex) {
		for(int i=0;i<settledNodes.size();i++)
			if( settledNodes.get(i).equals(vertex.getName()))
				return true;
		return false;
	}

	private double getShortestDistance(Vertex destination) {
		/*Double []d = {Double.MAX_VALUE};

	    	distance.forEach((key, value) ->{
	    		   	 if (key.getName().equals(destination.getName()))

	    		   		 d[0]=distance.get(key);



	    		     });

	            return d[0];*/
		Double d = 	   distance.get(destination)  ;
		if (d==null)
			return Double.MAX_VALUE;
		else 
			return d;
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	/* public LinkedList<Vertex> getPath(Vertex target) {
	        LinkedList<Vertex> path = new LinkedList<Vertex>();
	        Vertex step = target;
	        // check if a path exists
	        if (predecessors.get(step) == null) {
	            return null;
	        }
	        path.add(step);

	        while (predecessors.get(step) != null) {

	        	step = predecessors.get(step);
	            path.add(step);
	        }
	        // Put it into the correct order
	        Collections.reverse(path);
	        return path;
	    }*/
	public LinkedList<Vertex> getPath(Vertex target ,Vertex s) {
		pathD=0.0;
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		if(predecessors.get(step).getName() .equalsIgnoreCase(s.getName()))
		pathD += distance.get(step);
		else 
			while (!predecessors.get(step).getName() .equalsIgnoreCase(s.getName())) {
			pathD += distance.get(step);
			step = predecessors.get(step);
			


			path.add(step);
		}
		path.add(s);
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}


	public Map<Vertex, Vertex> getPredecessors() {
		return predecessors;
	}


	public Map<Vertex, Double> getDistance() {
		return distance;
	}

	public double getPathD() {
		return pathD;
	}

}
