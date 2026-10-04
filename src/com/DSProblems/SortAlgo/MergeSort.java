package com.DSProblems.SortAlgo;

public class MergeSort {
	
	private void divide(int arr[], int si, int ei) {
		if ( si >= ei) {
			System.out.println("End of  Si:" + si + " Ei:" + ei);
			return;
		}
		
		int mid = si + (ei -si)/2;
		System.out.println("Mid is::" + mid + " Si:" + si + " Ei:" + ei);
		divide(arr, si, mid); // left sub array and divide ...................O(n)
		divide(arr, mid+1, ei); // right sub array and divide............. O(n)
		
	
		
		conquer(arr, si, mid, ei);
	}
	
	private void conquer(int arr[], int si, int mid, int ei) {
		int merger[] = new int[ei-si +1]; //..............space complexity O(n)
		
		int idx1 = si;
		int idx2 = mid+1;
		int x =0;
		
		while(idx1 <= mid && idx2 <= ei) {  // ................O(logn)
			if(arr[idx1] <= arr[idx2]) {
				merger[x++] = arr[idx1++];
			} else {
				merger[x++] = arr[idx2++];
			}
		}
	
		while(idx1 <= mid) {
			merger[x++] = arr[idx1++];
		}
		
		while(idx2 <= ei) {
			merger[x++] = arr[idx2++];
		}
		
		//Now copying to original array
		for(int i=0, j=si; i< merger.length; i++, j++) {
			arr[j] = merger[i];
		}
		
	}

	// Time Complexity is O(nlogn)
	public void mergeSort(int arr[], int si, int ei) {
		divide(arr, si, ei);
	}
	
	public void print(int arr[]) {
		for(int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
}
