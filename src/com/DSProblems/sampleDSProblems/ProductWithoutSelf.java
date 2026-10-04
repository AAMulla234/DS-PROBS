package com.DSProblems.sampleDSProblems;


import java.util.Arrays;

public class ProductWithoutSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		int[] ans =productExceptSelf(nums);
		System.out.println(Arrays.toString(ans));
	}
	
	 public static int[] productExceptSelf(int[] nums) {
		 	int n = nums.length;
	        int[] prefix = new int[n];
	        int[] postfix = new int[n];
	        int[] ans = new int[n];
	        
	        for(int i=0; i<n; i++) {
	        	prefix[i] = 1;
	        	postfix[i] = 1;
	        }
	        
	        for(int i=0; i<n; i++) {
	        	if (i == 0) {
	        		prefix[i] = nums[i];
	        	} else {
	        		prefix[i] = prefix[i-1] * nums[i];
	        	}
	        }
	        
	        for(int i=n-1; i>=0; i--) {
	        	if(i == n-1) {
	        		postfix[i] =  nums[i];
	        	} else {
	        		postfix[i] = postfix[i+1] * nums[i];
	        	}
	        }
	        System.out.println(Arrays.toString(prefix));
	        System.out.println(Arrays.toString(postfix));
	        
	        for(int i=0; i<n; i++) {
	        	if (i == 0) {
	        		ans[i] = postfix[i+1];
	        	} else if(i == n-1) {
	        		ans[i] = prefix[i-1];
	        	} else {
	        		ans[i] = prefix[i-1] * postfix[i+1];
	        	}
	        }
	        return ans;
	 }

}
