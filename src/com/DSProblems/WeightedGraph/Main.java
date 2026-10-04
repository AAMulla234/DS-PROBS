package com.DSProblems.WeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<WeightedNode> nodeList = new ArrayList<WeightedNode>();
		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));
		nodeList.add(new WeightedNode("E", 4));
		nodeList.add(new WeightedNode("F", 5));
		nodeList.add(new WeightedNode("G", 6));
		
		WeightedGraph graph = new WeightedGraph(nodeList);
		graph.addDirectedEdge(0, 1, 2);
		graph.addDirectedEdge(0, 2, 5);
		graph.addDirectedEdge(1, 4, 3);
		graph.addDirectedEdge(1, 3, 1);
		graph.addDirectedEdge(1, 2, 6);
		graph.addDirectedEdge(2, 5, 8);
		graph.addDirectedEdge(3, 4, 4);
		graph.addDirectedEdge(4, 6, 9);
		graph.addDirectedEdge(5, 6, 7);
		
		
		graph.dijkstra(nodeList.get(0));

	}

}
