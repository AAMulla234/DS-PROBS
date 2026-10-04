package com.DSProblems.Graph;

import java.util.ArrayList;

import  java.util.LinkedList;
import java.util.Stack;


public class Graph {
	
	ArrayList<GraphNode> nodeList;
	int[][] adjucencyMatrix;
	public Graph(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		this.adjucencyMatrix = new int[nodeList.size()][nodeList.size()];
 	}
	
	public void addUndirectedEdge(int i, int j) {
		this.adjucencyMatrix[i][j] =1;
		this.adjucencyMatrix[j][i] =1;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("   ");
		for(int i=0; i< nodeList.size(); i ++) {
			s.append(nodeList.get(i).name + ": ");
		}
		s.append("\n");
		
		for(int i=0; i< nodeList.size(); i++) {
			s.append(nodeList.get(i).name + ": ");
			for(int j : adjucencyMatrix[i]) {
				s.append((j) + "  ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	//get neighbors
	public ArrayList<GraphNode> getNeighbor(GraphNode node) {
		ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
		int nodeIndex = node.index;
		
		for(int i=0; i< adjucencyMatrix.length; i++) {
			if(adjucencyMatrix[nodeIndex][i] == 1) {
				neighbors.add(nodeList.get(i));
			}
		}
		return neighbors;
	}
	
	//BFS -- level order traveral
	
	void bfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			GraphNode currentNode = queue.remove();
			currentNode.isVisited = true;
			ArrayList<GraphNode> neighbors = getNeighbor(currentNode);
			System.out.print(currentNode.name + "  ");
			for(GraphNode neighbor : neighbors) {
				if(!neighbor.isVisited) {
					neighbor.isVisited = true;
					queue.add(neighbor);
				}
			}
		}
	}
	
	public void bfs() {
		for (GraphNode node : nodeList) {
			if(!node.isVisited)
				bfsVisit(node);
		}
	}
	
	
	void dfsVisit(GraphNode node) {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(node);
		
		while(!stack.isEmpty()) {
			GraphNode currentNode = stack.pop();
			currentNode.isVisited = true;
			ArrayList<GraphNode> neighbors = getNeighbor(currentNode);
			System.out.print(currentNode.name + "  ");
			for(GraphNode neighbor: neighbors) {
				if(!neighbor.isVisited) {
					neighbor.isVisited = true;
					stack.push(neighbor);
				}
			}
			
		}
	}
	
	public void dfs() {
		for (GraphNode node : nodeList) {
			if(!node.isVisited)
				dfsVisit(node);
		}
	}
	
	// Topological sort
	public void addDirectedEdge(int i, int j) {
		this.adjucencyMatrix[i][j] =1;
	}
	
	void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		for (GraphNode neighbor: getNeighbor(node)) {
			if(!neighbor.isVisited) {
				topologicalVisit(neighbor, stack);
			}
		}
		node.isVisited = true;
		stack.push(node);
	}
	
	
	void toplogicalSort() {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		for (GraphNode node: nodeList) {
			if(!node.isVisited)
				topologicalVisit(node, stack);
		}
		while(!stack.isEmpty()) {
			 System.out.print(stack.pop().name + "  ");
		}
	}
}
