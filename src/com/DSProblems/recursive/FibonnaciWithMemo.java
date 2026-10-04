package com.DSProblems.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://www.interviewcake.com/concept/java/memoization
 * 
 */
public class FibonnaciWithMemo {
	
	private Map<Integer, Integer> memo = new HashMap<>();
	
	public static void main(String[] args) {
		int n = 6;
		FibonnaciWithMemo f = new FibonnaciWithMemo();
		System.out.println("Fibonnacii of n:" + n + " is :" + f.fib(n));
	}
	
	public int fib(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		if (n == 0 || n == 1)
			return n;
		if(memo.containsKey(n))
			return memo.get(n);
		
		int result = fib(n-1) + fib(n-2);
		memo.put(n, result);
		return result;
	}
}
