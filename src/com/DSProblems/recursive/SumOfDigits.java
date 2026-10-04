package com.DSProblems.recursive;
public class SumOfDigits {

	public static void main(String[] args) {
		SumOfDigits s = new SumOfDigits();
		System.out.println("Sum Of Digits::" + s.sumOfDigits(1));
	}

	public int sumOfDigits(int n) {
		if(n < 0 || n == 0)
			return 0;
		return n%10 + sumOfDigits(n/10);
	}
}
