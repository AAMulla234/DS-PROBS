package com.DSProblems.sampleArrays;

import java.util.Arrays;

public class FindDuplicate2 {

	public static void main(String[] args) {
		int[] myArray = {1,3,3,3,3,3,4};
		System.out.println(removeDuplicates(myArray));
		System.out.println(Arrays.toString(myArray));

	}
	
	
	 public static int removeDuplicates(int[] nums) {
	        if (nums.length == 0) {
	            return 0;
	        }
	        int i = 0;
	        for (int j = 1; j < nums.length; j++) {
	            if (nums[j] != nums[i]) {
	                i++;
	                nums[i] = nums[j];
	            }
	        }
	 
	        return i + 1;
	    }
	 
	 public static int removeDuplicates3(int[] nums) {
	        if (nums.length == 0) {
	            return 0;
	        }
	        int i = 0;
	        for (int j = 1; j < nums.length; j++) {
	            	if(nums[i] != nums[j]) {
		        	    i += 2;
		                nums[i] = nums[j];
		                
		                if (j-i >= 2) {
		                	for(int k= i+1; k < j; k++) {
		                		nums[k] = nums[j+1];
		                	}
		                }
		        	}
	        }
	 
	        return i + 1;
	    }
	 
	 public static int removeDuplicates2(int[] nums) {
		 if (nums.length == 0) {
			 return 0;
		 }
		 
		 int p =0, i=1, u = 1;
		 int max = Integer.MAX_VALUE;
		 
		 while(i < nums.length) {
			 if (nums[p] == nums[i]) {
				 nums[i] = max;
			 } else {
				p = i;
				u++;
			 }
			 i++;
		 }
		 Arrays.sort(nums);
		 return u;
	 }
}
