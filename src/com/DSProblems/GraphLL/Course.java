package com.DSProblems.GraphLL;

import java.util.ArrayList;

/**
 * Topological Sort is applied here
 */

public class Course {
	
	public static void main(String[] args) {
		int[][] prerequisites =  {{1,0}};
		System.out.println(canFinish(2, prerequisites));
	}
	
	public static boolean canFinish(int numCourse, int[][] prerequisites) {
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
		for (int i=0; i < numCourse; i++) {
			nodeList.add(new GraphNode("C" + i, i));
		}
		
		for (int i=0; i < prerequisites.length; i++) {
			int[] edge = prerequisites[i];
			addDirectedEdge(nodeList, edge[0], edge[1]);
		}
		System.out.println(toString(nodeList));
		System.out.println("\n\n\n");
		return checkCourse(nodeList);
	}

	
	  private static String toString(ArrayList<GraphNode> nodeList) {
		    StringBuilder s = new StringBuilder();
		    for (int i = 0; i < nodeList.size(); i++) {
		      s.append(nodeList.get(i).name + ": ");
		      for (int j =0; j < nodeList.get(i).neighbors.size(); j++) {
		        if (j == nodeList.get(i).neighbors.size()-1 ) {
		          s.append((nodeList.get(i).neighbors.get(j).name) );
		        } else {
		          s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
		        }
		      }
		      s.append("\n");
		    }
		    return s.toString();
	  }
	
	private static boolean checkCourse(ArrayList<GraphNode> nodeList) {
		int[] visited = new int[nodeList.size()];
		for(int i=0; i < nodeList.size(); i++) {
			if(!nodeList.get(i).isVisited) {
				if(canDoCourse(nodeList.get(i), i, visited) == false)
					return false;
			}
		}
		
		return true;
	}
	
	
	private static boolean canDoCourse(GraphNode node, int v, int[] visited) {
		node.isVisited = true;
		visited[v] = 1;
		
		for(GraphNode neighbor: node.neighbors) {
			if(!neighbor.isVisited) {
				if(canDoCourse(neighbor, neighbor.index, visited) == false)
					return false;
			}else if(visited[neighbor.index] == 1) {
				return false;
			}
		}
		visited[v] = 0;
		return true;
	}


	public static void addDirectedEdge(ArrayList<GraphNode> nodeList, int i, int j) {
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);
		first.neighbors.add(second);
	}
}
