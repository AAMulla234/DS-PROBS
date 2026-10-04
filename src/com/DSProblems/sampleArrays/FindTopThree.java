package com.DSProblems.sampleArrays;

import java.util.Arrays;

public class FindTopThree {

	public static void main(String[] args) {
		int[] myArray = {90,87,86,87,85,90,85,83,23,45,86,1,2,0};
		System.out.println(Arrays.toString(findTopThreeScores(myArray)));
	}
	
	 public static int[] findTopThreeScores(int[] array){
	        int n = array.length;
	        
	        if (n <= 0)
	            return array;
	        
	        int topThree[] = {0, 0, 0};
	        
	        for(int i = 0; i < array.length; i++) {
	            if (array[i] > topThree[0]) {
	            	topThree[2] = topThree[1];
	            	topThree[1] = topThree[0];
	            	topThree[0] = array[i];
	            }
	            else
	            	if(array[i] > topThree[1] && array[i] != topThree[0]) {
	            		topThree[2] = topThree[1];
	            		topThree[1] = array[i];
	            	}
	            else
	            	if (array[i] > topThree[2] && array[i] != topThree[0] && array[i] != topThree[1]) {
	            		topThree[2] = array[i];
	            	}
	        } 
	        return topThree;
	  }

}
