package com.DSProblems.WeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class TrainMain {

	public static void main(String[] args) {
		List<WeightedNode> nodeList = new ArrayList<WeightedNode>();
		nodeList.add(new WeightedNode("A", 0));
		nodeList.add(new WeightedNode("B", 1));
		nodeList.add(new WeightedNode("C", 2));
		nodeList.add(new WeightedNode("D", 3));
		nodeList.add(new WeightedNode("E", 4));
		
		TrainRouteGraph graph= new TrainRouteGraph(nodeList);
		graph.addDirectedWeighted(0, 1, 5);
		graph.addDirectedWeighted(1, 2, 4);
		graph.addDirectedWeighted(2, 3, 8);
		graph.addDirectedWeighted(3, 2, 8);
		graph.addDirectedWeighted(3, 4, 6);
		graph.addDirectedWeighted(0, 3, 5);
		graph.addDirectedWeighted(2, 4, 2);
		graph.addDirectedWeighted(4, 1, 3);
		graph.addDirectedWeighted(0, 4, 7);

		graph.calculateRouteDistancePath(nodeList.get(0));
		
		graph.displayPathDistance();
		
		String path = nodeList.get(0).name + "->";
		graph.findRoute(nodeList.get(0), nodeList.get(3), path);
		
	}

}
