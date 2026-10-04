package com.DSProblems.GraphLL;

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

		System.out.println("-----------------------BFS Algo--------------------------------\n\n");
		
		g.bfs();
		
		System.out.println("\n\n-----------------------Arrival and Departure time vertex--------------------------------\n\n");
		ArrayList<GraphNode> tNodeList = new ArrayList<GraphNode>();
		tNodeList.add(new GraphNode("A", 0));
		tNodeList.add(new GraphNode("B", 1));
		tNodeList.add(new GraphNode("C", 2));
		tNodeList.add(new GraphNode("D", 3));
		tNodeList.add(new GraphNode("E", 4));
		tNodeList.add(new GraphNode("F", 5));
		tNodeList.add(new GraphNode("G", 6));
		tNodeList.add(new GraphNode("H", 7));
		
		
		Graph g1 = new Graph(tNodeList);
		g1.addDirectedEdge(0, 1);
		g1.addDirectedEdge(0, 2);
		g1.addDirectedEdge(2, 3);
		g1.addDirectedEdge(2, 4);
		g1.addDirectedEdge(3, 1);
		g1.addDirectedEdge(3, 5);
		g1.addDirectedEdge(4, 5);
		g1.addDirectedEdge(6, 7);
		
		System.out.println(g1.toString());
		g1.timeOfVertex();
		
		System.out.println("\n\n..........................Topological sort...............................................\n\n");
		ArrayList<GraphNode> nodeList2 = new ArrayList<GraphNode>();
		nodeList2.add(new GraphNode("A", 0));
		nodeList2.add(new GraphNode("B", 1));
		nodeList2.add(new GraphNode("C", 2));
		nodeList2.add(new GraphNode("D", 3));
		nodeList2.add(new GraphNode("E", 4));
		
		Graph g2 = new Graph(nodeList2);
		g2.addDirectedEdge(0, 1);
		g2.addDirectedEdge(0, 2);
		g2.addDirectedEdge(0, 3);
		g2.addDirectedEdge(1, 4);
		g2.addDirectedEdge(2, 3);
		g2.addDirectedEdge(3, 4);
		
		g2.toplogicalSort();
		
		System.out.println("\n\n............................DFS Alogo.............................................\n\n");
		
		ArrayList<GraphNode> nodeList3 = new ArrayList<GraphNode>();
		nodeList3.add(new GraphNode("A", 0));
		nodeList3.add(new GraphNode("B", 1));
		nodeList3.add(new GraphNode("C", 2));
		nodeList3.add(new GraphNode("D", 3));
		nodeList3.add(new GraphNode("E", 4));
		
		Graph g3 = new Graph(nodeList3);
		
		g3.addDirectedEdge(0, 1);
		g3.addDirectedEdge(0, 2);
		g3.addDirectedEdge(0, 3);
		g3.addDirectedEdge(1, 4);
		g3.addDirectedEdge(2, 3);
		g3.addDirectedEdge(3, 4);
		System.out.println(g3.toString());
		g3.dfs();
	
		System.out.println("\n\n.............................check cycle............................................\n\n");
		ArrayList<GraphNode> nodeList4 = new ArrayList<GraphNode>();
		nodeList4.add(new GraphNode("A", 0));
		nodeList4.add(new GraphNode("B", 1));
		nodeList4.add(new GraphNode("C", 2));
		nodeList4.add(new GraphNode("D", 3));
		nodeList4.add(new GraphNode("E", 4));
		nodeList4.add(new GraphNode("f", 4));
		
		Graph g4 = new Graph(nodeList4);
		g4.addDirectedEdge(0, 1);
		g4.addDirectedEdge(0, 2);
		g4.addDirectedEdge(1, 2);
		g4.addDirectedEdge(2, 0);
		g4.addDirectedEdge(2, 3);
		g4.addDirectedEdge(3, 3);
		
		System.out.println(g4.toString());
		
		System.out.println(g4.isCyclic());
		System.out.println("\n\n.........................................................................\n\n");
	
	

	}

}
