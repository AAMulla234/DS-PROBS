package com.DSProblems.sampleArrays;

public class PermulationOfInt {

	public static void main(String[] args) {
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {5,4,6,2,1};
		System.out.println(permulation(array1, array2));
	}
	
	public static boolean permulation(int[] array1, int[] array2) {
		if (array1.length != array2.length)
			return false;
		
		int sum1 = 0, sum2 = 0;
		int prod1 = 1, prod2 = 1;
		
		for(int i=0; i < array1.length; i++) {
			sum1 += array1[i];
			sum2 += array2[i];
			prod1 *= array1[i];
			prod2 *= array2[i];
		}
		
		if (sum1 == sum2 && prod1 == prod2)
			return true;

		return false;
	}

}
