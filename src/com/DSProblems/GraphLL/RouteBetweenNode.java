package com.DSProblems.GraphLL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNode {

    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public RouteBetweenNode(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode start = nodeList.get(i);
        GraphNode end = nodeList.get(j);

        start.neighbors.add(end);
    }

    public boolean checkRouteAvailable(GraphNode start, GraphNode end) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            for (GraphNode  ne : currentNode.neighbors){
                if (ne.equals(end)) {
                    return true;
                }
                if(!ne.isVisited) {
                    queue.add(ne);
                }
            }
        }
        return false;
    }

}
