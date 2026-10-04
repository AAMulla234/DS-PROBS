package com.DSProblems.sampleDSProblems;

/**
 *  Put the key at last element in array
 *  Search where is the match
 *  Put back the last element to it's place
 *  Make condition
 * */
public class SentialLinearSearch {

	public static void main(String[] args) {
		int arr[] = {30, 13, 14, 17,81, 9,65, 45};
		System.out.println("Sential Search element at position::" + sentialSearch(arr, 81));
	}
	
	public static int sentialSearch(int arr[], int key) {
		int n = arr.length;
		int last = arr[n-1];
		arr[n-1] = key;
		int i =0;
		while (arr[i] != key) //----------------O(n)
			i++;
		
		// Put the last element back
        arr[n - 1] = last;
		
		if ((i < n-1) || (arr[n-1]) == key) {
			return i;
		}
		return -1;
	}

}
