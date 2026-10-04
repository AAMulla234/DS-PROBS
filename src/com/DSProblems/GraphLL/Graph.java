package com.DSProblems.GraphLL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class Graph {
	
	  ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	  public Graph(ArrayList<GraphNode> nodeList) {
	    this.nodeList = nodeList;
	  }

	  public void addUndirectedEdge(int i, int j) {
	    GraphNode first = nodeList.get(i);
	    GraphNode second = nodeList.get(j);
	    first.neighbors.add(second);
	    second.neighbors.add(first);
	  }
	  
	  public String toString() {
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
	  
	//BFS
		
		void bfsVisit(GraphNode node) {
			LinkedList<GraphNode> queue = new LinkedList();
			queue.add(node);
			
			while(!queue.isEmpty()) {
				GraphNode currentNode = queue.remove();
				currentNode.isVisited = true;
				System.out.print(currentNode.name + "  ");
				for(GraphNode neighbor : currentNode.neighbors) {
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
		//DFS	
		public void dfs() {
			for (GraphNode node : nodeList) {
				if(!node.isVisited)
					dfsVisit(node);
			}
		}

		
		void  dfsVisit(GraphNode node) {
			Stack<GraphNode> stack = new Stack();
			stack.push(node);
						
			while(!stack.isEmpty()) {
				GraphNode currentNode = stack.pop();
				currentNode.isVisited = true;
				System.out.print(currentNode.name + "  ");
				for(GraphNode neighbor : currentNode.neighbors) {
					if(!neighbor.isVisited) {
						neighbor.isVisited = true;
						stack.push(neighbor);
					}
				}
			}
		}
		
		public boolean isCyclic() {
			int dfsVis[] = new int[nodeList.size()];
			
			for(int i=0; i < nodeList.size(); i++) {
				if(!nodeList.get(i).isVisited) {
					if(checkCycle(i, nodeList.get(i), dfsVis) == true)
						return true;
				}
			}
			return false;
		}
		
		private boolean checkCycle(int v, GraphNode node, int[] dfsVis) {
			node.isVisited = true;
			dfsVis[v] = 1;
			
			for(GraphNode neighbor: node.neighbors) {
				if(!neighbor.isVisited) {
					if(checkCycle(neighbor.index, neighbor, dfsVis) == true)
						return true;
				}else if(dfsVis[neighbor.index] == 1) {
					return true;
				}
			}
			dfsVis[v] = 0;
			return false;
		}
		
		
		
		// Topological sort
		public void addDirectedEdge(int i, int j) {
			GraphNode first = nodeList.get(i);
			GraphNode second = nodeList.get(j);
			first.neighbors.add(second);
		}
		
		void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		
			for (GraphNode neighbor : node.neighbors) {
				if(!neighbor.isVisited) {
					topologicalVisit(neighbor, stack);
				}
			}
			node.isVisited = true;
			stack.push(node);
		}
		
		
		void toplogicalSort() {
			Stack<GraphNode> stack = new Stack<GraphNode>();
			
			for (GraphNode node : nodeList) {
				if(!node.isVisited)
					topologicalVisit(node, stack);
			}
			
			while(!stack.isEmpty()) {
				 System.out.print(stack.pop().name + "  ");
			}
		}
		
		
		void timeOfVertex() {
			 int[] arrival = new int[nodeList.size()];
			 
		        // array to store the departure time of vertex
		     int[] departure = new int[nodeList.size()];
		     int time = -1;
		    			
			for (int i=0; i < nodeList.size(); i++) {
				GraphNode node = nodeList.get(i);
				if(!node.isVisited)
					time= totalTime(node, i, arrival, departure, time);
			}
			
			 for (int i = 0; i < nodeList.size(); i++)
		        {
		            System.out.println("Vertex " + i + " (" + arrival[i] + ", " +
		                departure[i] + ")");
		        } 
			
		}
		
		int totalTime(GraphNode node, int v, int[] arrival, int[] departure, int time) {
			arrival[v] = ++time;
			//System.out.println("   Arrival["+ v + "]" + arrival[v]);
			node.isVisited = true;
			for (GraphNode neighbor : node.neighbors) {
				if(!neighbor.isVisited) {
					time = totalTime(neighbor, neighbor.index, arrival, departure, time);
				}
			}
			departure[v] = ++time;
			//System.out.println(" Departure["+ v + "]" + departure[v]);
			return time;
		}
}
