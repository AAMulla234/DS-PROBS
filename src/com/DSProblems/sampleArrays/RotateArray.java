package com.DSProblems.sampleArrays;
import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {
		int nums[] = {-1,-100,3,99};
		rotate(nums, 2);

	}

	  public static void rotate(int[] nums, int k) {
	        
		  if(nums.length < k) {
			  System.out.println("Array is not with sufficient length");
		  }
		  
		  int[] tempArray = new int[k];
		  
		  for(int i =0; i < k; i++) {
			  tempArray[i] = nums[nums.length-k + i];
		  }
		  int j = nums.length-k -1;
		  int s = nums.length-1;
		  while(j >= 0) {
			  nums[s] = nums[j];
			  j--;
			  s--;
		  }
		  
		  for(int i =0; i < k; i++) {
			  nums[i] = tempArray[i];
		  }
		  
		  System.out.println(Arrays.toString(nums));
	  }
	
}
