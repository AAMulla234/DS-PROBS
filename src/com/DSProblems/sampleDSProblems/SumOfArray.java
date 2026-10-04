package com.DSProblems.sampleDSProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * This program will work for only 2 number sum.
 * Find those 2 number sum which is equal to target number
 * */
public class SumOfArray {

	public static void main(String[] args) {
		SumOfArray obj = new SumOfArray();
		int nums[] = {3,5,9,4,8,7};
		int result[] = obj.twoSum(nums, 10);
		for (int r : result) {
			System.out.println(r);
		}
	}
	
	public int[] twoSum(int nums[], int target) {
		Map<Integer, Integer> numToIndex = new HashMap<> ();
		
		for(int i =0; i < nums.length; ++i) { //---------O(n)
			if(numToIndex.containsKey(target - nums[i])) {
				return new int[] {numToIndex.get(target - nums[i]), i};
			}
			numToIndex.put(nums[i],i);
		}
		throw new IllegalArgumentException();
	}

}
