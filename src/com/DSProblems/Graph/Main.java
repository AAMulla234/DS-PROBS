package com.DSProblems.Graph;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
		nodeList.add(new GraphNode("A", 0));
		nodeList.add(new GraphNode("B", 1));
		nodeList.add(new GraphNode("C", 2));
		nodeList.add(new GraphNode("D", 3));
		nodeList.add(new GraphNode("E", 4));
		
		Graph g = new Graph(nodeList);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(0, 2);
		g.addUndirectedEdge(0, 3);
		g.addUndirectedEdge(1, 4);
		g.addUndirectedEdge(2, 3);
		g.addUndirectedEdge(3, 4);
		
	   System.out.println(g.toString());
	   
	//   g.bfs();
	   
	   g.dfs();
	   
	   System.out.println("\n\n Topoogical Sort Example");
	    ArrayList<GraphNode> tNodeList = new ArrayList<GraphNode>();
		tNodeList.add(new GraphNode("A", 0));
		tNodeList.add(new GraphNode("B", 1));
		tNodeList.add(new GraphNode("C", 2));
		tNodeList.add(new GraphNode("D", 3));
		tNodeList.add(new GraphNode("E", 4));
		tNodeList.add(new GraphNode("F", 5));
		tNodeList.add(new GraphNode("G", 6));
		tNodeList.add(new GraphNode("H", 7));
		
		
		Graph newG = new Graph(tNodeList);
		newG.addDirectedEdge(0, 6);
		newG.addDirectedEdge(7, 0);
		newG.addDirectedEdge(3, 0);
		newG.addDirectedEdge(7, 1);
		newG.addDirectedEdge(5, 1);
		newG.addDirectedEdge(3, 4);
		newG.addDirectedEdge(1, 6);
		newG.addDirectedEdge(1, 4);
		newG.addDirectedEdge(1, 2);
		System.out.println(newG.toString());
		
		newG.toplogicalSort();
		
	}

}
