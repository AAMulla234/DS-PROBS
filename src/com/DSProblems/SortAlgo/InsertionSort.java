package com.DSProblems.SortAlgo;

public class InsertionSort {
	
	public void insertionSort(int[] arr) {
		
		for(int i =1; i < arr.length; i++) { // -----------------O(n)
			int temp = arr[i], j = i;
			
			while(j > 0 && arr[j-1] > temp) { // ----------------O(n) ...O(n^2)
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
	}
	
	
	public void print(int arr[]) {
		for(int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
