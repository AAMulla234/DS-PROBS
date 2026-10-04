package com.DSProblems.sampleDSProblems;

/**
 * Find the largest sum of K consecutive entries, given array of size n.
 *  e.g 16,12,9,19,11,8 and k =3
 *  [16,12,9] [12, 9, 19] [9,19,11] [19, 11,8]
 *  Sum of first subarray
 *  then sum + first element of second sub array  - first element of first sub array.
 *  TC = O(n-k) and SC = O(1)
 * */
public class SlidingWindow {

	public static void main(String[] args) {
		    int k=3;
	        int[] arr={16, 12, 9, 19, 11, 8};
	        System.out.println(maxSum(arr,k));
	}

	public static int maxSum(int arr[], int k) {
		int n = arr.length;
		if (n < k) 
			throw new IllegalArgumentException();
		int sum = 0;
		for(int i =0; i < k; i++) { //----------- O(k)
			sum += arr[i];
		}
		int max_sum = sum;
		
		for (int i = k; i <n; i++) { // ----------------O(n-k)
			sum += (arr[i] - arr[i-k]);
			max_sum = Math.max(max_sum, sum);
		}
		return max_sum;
	}
}
