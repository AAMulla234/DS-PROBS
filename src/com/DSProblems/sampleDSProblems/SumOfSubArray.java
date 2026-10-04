package com.DSProblems.sampleDSProblems;

import java.util.ArrayList;

/**
 * This program 
 * Find sum of subarrays is equal to target.
 * */
public class SumOfSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 7, 5};
		ArrayList<Integer> index = subarraySum(arr, 5, 15);
		for (Integer i : index) {
			System.out.print(i + " ");
		}

	}
	
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
	{
	       return sumOfSubArray(arr, 0, 0, n, s);
	}
	
	static ArrayList<Integer> sumOfSubArray(int[] arr, int start, int end, int n, int target) {
		 int sum = 0;
		 	if (start == n || arr.length != n) {
		 		throw new  IllegalArgumentException();
		 	}
		 	if (end >= n) { 
		 		System.out.println("------------:" + start);
		 		return sumOfSubArray(arr, start+1, start+1, n, target);
		 	}
		 	ArrayList<Integer> index = new ArrayList<Integer>();
			for (int i = start; i <= end; i++) {
				 sum += arr[i];
			}
			 System.out.println(sum);
			 if (sum == target) {
				 index.add(start);
				 index.add(end);
				 System.out.println("--------------------------");
				 return index;
			 }
			return sumOfSubArray(arr, start, end+1, n, target);
	}

}
