package com.DSProblems.recursive;

/**
 *  a = 8 = 2*2*2 = common is 2*2 = 4
 *  b = 12 = 2*2*3 =  4 
 *  Euclidean Algo
 *   
 *   (a, a mod b)
 *  
 * */
public class GreatesDivisorNum {

	public static void main(String[] args) {
			GreatesDivisorNum g = new GreatesDivisorNum();
			int num1 = 128;
			int num2 = 64;
			System.out.println("Greated division of num1 " + num1 + " and num2 " + num2 + " is ::" + g.gcd(num1, num2));
	}

	public int gcd(int a, int b) {
		if (a < 0 || b < 0) {
			return -1;
		}
		if(b == 0)
			return a;
		
		return gcd(b, a%b);
	}
}
