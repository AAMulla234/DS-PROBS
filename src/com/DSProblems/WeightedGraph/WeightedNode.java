package com.DSProblems.WeightedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeightedNode implements Comparable<WeightedNode> {
	
	String name;
	int index;
	int distance;
	boolean isVisited;
	WeightedNode parent;
	List<WeightedNode> neighbors = new ArrayList<>();
	
	HashMap<WeightedNode, Integer> weightedMap = new HashMap<WeightedNode, Integer>(); // Maintain the distance of each node.
	
	public WeightedNode(String name, int index) {
		this.name = name;
		this.index = index;
		this.distance = Integer.MAX_VALUE;
	}

	@Override
	public int compareTo(WeightedNode o) {
		 return this.distance - o.distance;
	}
	

}
