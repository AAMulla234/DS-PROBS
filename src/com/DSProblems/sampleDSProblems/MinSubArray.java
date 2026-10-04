package com.DSProblems.sampleDSProblems;

public class MinSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9,5,1,1,6,3};
		System.out.println("Minimum sub array length::"+ minSubArrayLen(8, nums));
	}

	private static int minSubArrayLen(int target, int[] nums) {
	      int n = nums.length;
	      int l = 0, sum = 0;
	      int len = 0, minLen = n+1;
	      for (int r = 0; r < n; ++r) {
	          // do something when the right pointer moves one step ahead
	          // in this case, add the new element to the subarray sum
	          sum += nums[r];
	          while (sum >= target) {
	              // keep moving the left pointer ahead (shrinking the subarray) 
	              // while the subarray sum still meets the target
	              // update the subarray sum and length along the way
	              len = r - l + 1;
	              
	              if (len < minLen) minLen = len;
	              sum -= nums[l++];
	              System.out.println("minLen:" + minLen + " l:" + l + " r:" + r + " l:"+ l + " sum:" + sum);
	          }
	      }
	      if (minLen == n+1) return 0;
	      return minLen;                
	}
}
