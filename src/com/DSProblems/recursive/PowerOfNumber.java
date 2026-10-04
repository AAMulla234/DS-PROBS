package com.DSProblems.recursive;

public class PowerOfNumber {

	public static void main(String[] args) {
		PowerOfNumber p = new PowerOfNumber();
		System.out.println("Power of number ::" + p.power(5, 3));
	}

	public int power(int base, int exp) {
		if (exp == 0 || exp < 0) {
			return 1;
		}
		return base * power(base, exp-1);
	}
}
