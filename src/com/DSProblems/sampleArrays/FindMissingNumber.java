package com.DSProblems.sampleArrays;

public class FindMissingNumber {

	public static void main(String[] args) {
		int[] myArray = {1,2,3,4,5,7,8};
		int n =8;
		int sum = (n*(n+1))/2;
		for (int i=0; i< myArray.length; i++) {
			sum -= myArray[i];
		}
		System.out.print("Missing Number is:" + sum);
		
	}

}
