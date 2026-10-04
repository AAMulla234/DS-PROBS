package com.DSProblems.sampleArrays;

import java.util.HashMap;
import java.util.Map;

public class MajorElement {

	public static void main(String[] args) {
		int[] myArray = {2,2,1,1,1,2,2};
		
		int majorEle = (int) Math.ceil(myArray.length/2);
		
		
		System.out.println(majorityElement(myArray, majorEle));
	}

	 public static int majorityElement(int[] nums, int majorEle) {
	        Map<Integer, Integer> elements = new HashMap<Integer, Integer>();
	        for(int e : nums){
	            int count = 0;
	            if(elements.containsKey(e)) {
	                 count = elements.get(e);
	                if (++count > majorEle) {
	                    return e;
	                } 
	            }
	            elements.put(e, count);
	        }
	        return -1;
	    }
	
}
