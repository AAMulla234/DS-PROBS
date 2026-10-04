package com.DSProblems.GraphLL;

import java.util.ArrayList;
import java.util.List;

public class BuildHotelInCity {

    private static int findWays(List<List<Integer>> graph, int centerCity){
        List<Integer> cities = graph.get(centerCity);
        int connectedCities = cities.size();
        if(connectedCities < 3){
            return 0;
        }
        
        return (connectedCities * (connectedCities-1) * (connectedCities-2))/6;
    }


    private static int buildHotel(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // build the graph
        for(int[] r: roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }

        // find center city
        int center = -1;
        int totalWays = 0;
        for (int i=0; i < n; i++) {
            if (graph.get(i).size() >= (n/2)) {
                center = i;
                totalWays += findWays(graph, center);
            } 
        }
       return totalWays;
    }


    public static void main(String[] args) {
        //int[][] roads = {{1, 2}, {1, 3}, {1, 4}, {1, 5}};
        //System.out.println(buildHotel(5, roads));

        int[][] roads = {{1, 2}, {2, 3}, {2, 4}, {2, 5}, {5,6},{5,7},{5,8}, {5,9}};
        System.out.println(buildHotel(9, roads));

    }

}
