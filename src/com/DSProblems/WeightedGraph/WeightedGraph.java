package com.DSProblems.WeightedGraph;

import java.util.List;
import java.util.PriorityQueue;

public class WeightedGraph {
	List<WeightedNode> nodeList;

	public WeightedGraph(List<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void addDirectedEdge(int i, int j, int distance) {
		WeightedNode first = this.nodeList.get(i);
		WeightedNode second = this.nodeList.get(j);
		first.weightedMap.put(second, distance);
		first.neighbors.add(second);
	}
	
	// Now Big  O(V + E)
	public void dijkstra(WeightedNode node) {
		PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
		node.distance = 0;
		queue.addAll(nodeList);
		
		while(!queue.isEmpty()) { // --- O(v) all the vertix of graph
			WeightedNode currentNode = queue.remove();
			System.out.println(currentNode.name + ":: " + currentNode.index + " :: " + currentNode.distance);
			
			for(WeightedNode neighbor : currentNode.neighbors) {  // ...O(E) edges of each nodes
				System.out.println("neighbor::" + neighbor.name + ":: " + neighbor.index + " :: " + neighbor.distance);
					
				if(queue.contains(neighbor)) {
					if(neighbor.distance > currentNode.distance + currentNode.weightedMap.get(neighbor)) {
						neighbor.distance = currentNode.distance + currentNode.weightedMap.get(neighbor);
						System.out.println("Calculate distance::" + neighbor.distance);
						neighbor.parent = currentNode;
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}
		System.out.println("\n\n\n");
		 for (WeightedNode nodeToCheck : nodeList) {
		      System.out.print("Node " +nodeToCheck.name +", distance: "+nodeToCheck.distance+", Path: ");
		      pathPrint(nodeToCheck);
		      System.out.println();
		    }
	}
	
	
	public static void pathPrint(WeightedNode node) {
		if (node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
	}

}
