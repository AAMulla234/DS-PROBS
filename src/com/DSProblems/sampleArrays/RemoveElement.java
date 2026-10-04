package com.DSProblems.sampleArrays;


public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,2,2,3};
		System.out.println(removeElement(nums, 3));
		for(int n : nums) {
			System.out.print(n  + "  ");
		}
	}
	
	public static int removeElement(int nums[], int val) {
		 int i = 0;
	        for (int j = 0; j < nums.length; j++) {
	            if (nums[j] != val) {
	                int temp = nums[i];
	                nums[i] = nums[j];
	                nums[j] = temp;
	                i++;
	            }
	        }
	        return i;
	}

}
