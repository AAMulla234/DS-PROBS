package com.DSProblems.sampleDSProblems;

/**
 * Divide and conque algo
 * Time complexity = O(log n) 
 *  n = 8, iteration take 3 and divide section is 2
 *  2^8 = 3 
 */
 
public class BasicBinarySearch {

	public static void main(String[] args) {
		int arr[] = {5,6,7,10,11,23,45,67};
		
		System.out.println("Element at ::" + binarySearch(arr, 24));
	}

	public static int binarySearch(int arr[], int element) {
		 int low = 0;
	     int high = arr.length - 1;
	     
	     while (low <= high) {
	    	 int mid = (low + high) / 2;
	    	 int mid_ele = arr[mid];
	    	   if (element == mid_ele){
	                return mid;
	            }
	            if (element < mid_ele){
	                high = mid - 1;
	            }
	            if (element > mid_ele){
	                low = mid + 1;
	            }
	     }
	     return -1;
	}
}
