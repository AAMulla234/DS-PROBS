package com.DSProblems.sampleDSProblems;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent 
 * houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * nums = [1,2,3,1]
 * out: 4
 * TC = O(n-2) SP = O(1)
 * Big O(n-2)
 * Simply sum of odd index and sum of even index and find which one is Maximum
 * */
public class HouseRobber {

	public static void main(String[] args) {
		int nums[] = {2,4,1,4,5,7,1};
		System.out.println("Maximum Rob money::" + rob(nums));
	}
	
	public static int rob(int[] nums) {
		  if (nums.length == 1)
			  return nums[0];
		  if (nums.length == 2)
			  return Math.max(nums[0], nums[1]);
		  int prev1 = Math.max(nums[0], nums[1]);
		  int prev2 = nums[0];
		  int curr = prev1;
		  
		  for(int i = 2; i < nums.length; i++) {
			  curr = Math.max(nums[i] + prev2, prev1);
			  prev2 = prev1;
			  prev1 = curr;
		  }
		  return curr;
	  }

}
