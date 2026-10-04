package com.DSProblems.recursive.more;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.print(0 + ", " + 1 +", ");
        fibonacci(0, 1, 10);   
        System.out.println();
        System.out.println(fibonacciSeq(6));
    }

    public static void fibonacci(int a, int b, int n) {
        if (n == 0 ) {
            return;
        }

        int c = a + b;
        System.out.print(c + ", ");
        fibonacci(b, c, n-1);
    }

    public static int fibonacciSeq(int n) {
            if (n < 0)
                throw new IllegalArgumentException();
            if (n == 0 || n == 1)
                return n;
            if(memo.containsKey(n))
                return memo.get(n);
            
            int result = fibonacciSeq(n-2) + (fibonacciSeq(n-1) * fibonacciSeq(n-1))  ;
            memo.put(n, result);
            return result;
    }

    public static int findNthTerm(int t1, int t2, int n) {
        // Base cases
        if (n == 1) return t1;
        if (n == 2) return t2;

        int current = 0; // Variable to store the current term
        for (int i = 3; i <= n; i++) {
            current = t1 + t2 * t2; // Calculate the next term
            t1 = t2;               // Move t1 to the next position
            t2 = current;          // Move t2 to the next position
        }
        return current;
    }
}