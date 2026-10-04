package com.DSProblems.String;

import java.util.HashMap;
import java.util.Map;

public class RomanProblem {

	public static void main(String[] args) {
		System.out.println("sum of roman to int is::" + romanToInt("IV"));
		// TODO Auto-generated method stub

	}
	
	public static int romanToInt(String s) {
	        Map<Character, Integer> value = new HashMap<Character, Integer>();
	        value.put('I', 1);
			value.put('V', 5);
			value.put('X', 10);
			value.put('L', 50);
			value.put('C', 100);
			value.put('D', 500);
			value.put('M', 1000);
	        
			int sum = 0;
	        int prevValue = 0;
	        
	        for(Character c : s.toCharArray()) {
	            int currentValue = value.get(c) != null ? value.get(c) : 0;
	            sum += (currentValue > prevValue) ? (currentValue - 2 * prevValue) : currentValue;
	            prevValue = currentValue;
	        }
	        return sum;
	    }
	

}
