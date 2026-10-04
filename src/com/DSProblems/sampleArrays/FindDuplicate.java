package com.DSProblems.sampleArrays;

import java.util.Arrays;

public class FindDuplicate {

	public static void main(String[] args) {
		int[] myArray = {1,1,2,3,1,4,5,7,3,8,6,5};
		System.out.println(Arrays.toString(removeDuplicates(myArray)));
	}
	
	public static int[] removeDuplicates(int[] arr) {
		int totalDup = 0;
		for (int i = 1; i < arr.length; i++) { // O(n-1)
			int num = arr[i];
			for (int j = i - 1; j >= 0; j--) { // O(j^(i-1)
				if (num == arr[j]) {
					num = -1;
					break;
				}
			}
			if (num == -1) {
				totalDup++;
				arr[i] = -1;
			}
		}
		int[] newArray = new int[arr.length - totalDup];
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1) {
				newArray[k++] = arr[i];
			}
		}

		return newArray;

	}

}
