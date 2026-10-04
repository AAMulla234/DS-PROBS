package com.DSProblems.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibonnaci {

	public static void main(String[] args) {
		System.out.println("Fibonacci using Top to bottom using memo::" + fib(8, new HashMap<Integer, Integer>()));
		System.out.println("Fibonacci using bottom up using memo::" + fib(8));

	}

	/***
	 * Top to bottom using memorization
	 * @param n
	 * @param memo
	 * @return
	 */
	public static int fib(int n, Map<Integer, Integer> memo) {
		if (n < 0)
			throw new IllegalArgumentException();
		if (n == 1)
			return 0;
		if (n == 2)
			return 1;
		
		if(!memo.containsKey(n)) {
			memo.put(n, fib(n-1, memo) + fib(n-2, memo));
		}
		
		return memo.get(n);
	}
	
	/**
	 * Bottom to top... solve small prob first and then go big
	 * @param n
	 * @return
	 */
	public static int fib(int n) {
		List<Integer> memo = new ArrayList<Integer>();
		memo.add(0);
		memo.add(1);
		
		for(int i= 2; i <= n-1; i++) {
			 int m1 = memo.get(i-1);
			 int m2 = memo.get(i-2);
			 memo.add(m1+m2);
		}
		return memo.get(n-1);
	}
}
