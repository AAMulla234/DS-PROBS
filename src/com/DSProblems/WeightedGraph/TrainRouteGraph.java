package com.DSProblems.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TrainRouteGraph {
	
	List<WeightedNode> nodeList = new ArrayList<>();
	
	public TrainRouteGraph(List<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void addDirectedWeighted(int i, int j, int distance) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		
		first.neighbors.add(second);
		first.weightedMap.put(second, distance); // assigned the distance given in the input
		
	}
	
	public void calculateRouteDistancePath(WeightedNode node) {
		PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
		node.distance =0;
		queue.addAll(nodeList);
		
		while(!queue.isEmpty()) {
			WeightedNode currNode = queue.remove();
			
			for(WeightedNode neighbor : currNode.neighbors) {
				if(queue.contains(neighbor)) {
					if(neighbor.distance > currNode.distance + currNode.weightedMap.get(neighbor)) {
						neighbor.distance = currNode.distance + currNode.weightedMap.get(neighbor);
						queue.remove(neighbor);
						queue.add(neighbor);
						neighbor.parent = currNode;
					}
				}
			}
		}
		
	}
	
	public void findRoute(WeightedNode source, WeightedNode dest, String path) {
		if (source.neighbors == null)
			return;
		
		for(WeightedNode neighbor : source.neighbors) {
			 System.out.print( neighbor.name + "->"); 
			if (neighbor.name.equals(dest.name)) {
				return;
			}
			findRoute(neighbor, dest, path);
		}
	}
	
	public void displayPathDistance() {
		for(WeightedNode node : nodeList) {
			System.out.print("For a Node:" + node.name + " Distance is:" + node.distance + " For the path:");
			pathPrint(node);
			System.out.println("\n\n");
		}
	}
	
	public static void pathPrint(WeightedNode node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

}
