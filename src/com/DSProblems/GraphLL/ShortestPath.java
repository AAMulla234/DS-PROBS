package com.DSProblems.GraphLL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Edge {
    String target;
    int distance;

    Edge(String target, int distance) {
        this.target = target;
        this.distance = distance;
    }
}

public class ShortestPath {


    public static int findShortPath(Map<String, List<Edge>> graph, String start, String end) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Map<String, Integer> distances= new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        pq.add(new int[]{0, start.hashCode()});

        while(!pq.isEmpty()) {
            int[] current = pq.remove();
            int currentDist = current[0];
            String currentCity = String.valueOf((char)current[1]);

            if(visited.contains(currentCity)) continue;
            visited.add(currentCity);

            System.out.println("Current:" + currentCity + "Dist:" + currentDist);

            for(Edge edge : graph.get(currentCity)) {
                if(visited.contains(edge.target)) continue;

                int newDist = currentDist + edge.distance;

                if(newDist < distances.get(edge.target)){
                    distances.put(edge.target, newDist);
                    pq.add(new int[]{newDist, edge.target.hashCode()});
                }
            }
        }
System.out.println("\n\n\n\n -------------------------");

        for(String s : distances.keySet()) {
            System.out.println("Key:" + s + " Distance:" + distances.get(s));
        }

        return distances.get(end) == Integer.MAX_VALUE ? -1 : distances.get(end);
    }

    public static void main(String[] args) {
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Edge("B", 2), new Edge("C", 4)));
         graph.put("B", Arrays.asList(new Edge("E", 3), new Edge("D", 3)));
        graph.put("C", Arrays.asList(new Edge("D", 2), new Edge("F", 3)));
        graph.put("D", new ArrayList<>());
        graph.put("E", Arrays.asList(new Edge("G", 5)));
        graph.put("F", Arrays.asList(new Edge("G", 7)));
        graph.put("G", new ArrayList<>());
        
        String start = "A";
        String end = "G";

        System.out.println("Shortest path from A to G::::::" +findShortPath(graph, start, end));
    }

}
