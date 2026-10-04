package com.DSProblems.SortAlgo;

public class SelectionSort {

	
	/**
	 * 
	 *  Time complexity  O(N^2)
	 */
	public void selectionSort(int arr[]) {
		int n = arr.length;
		
		for(int i=0; i < n; i++) { // ---------------------O(n)
			int minIndex = i;
			for(int j= i+1; j< n; j++) { // ----------------O(n) ==== O(n^2)
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				int tmp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = tmp;
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
