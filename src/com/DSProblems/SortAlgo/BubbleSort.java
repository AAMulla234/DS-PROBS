package com.DSProblems.SortAlgo;

public class BubbleSort {

	/**
	 * 
	 *  Time complexity  O(N^2)
	 */
	public void bubbleSort(int arr[]) {
		int n = arr.length;
		
		for(int i=0; i < n-1; i++) { // ---------------------O(n)
			for(int j=0; j< n-i-1; j++) { // ----------------O(n) ==== O(n^2)
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	public void print(int arr[]) {
		for(int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
