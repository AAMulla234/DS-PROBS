package com.DSProblems.recursive;

public class DecimalToBinary {

	public static void main(String[] args) {
		DecimalToBinary d = new DecimalToBinary();
		int n =10;
		System.out.println("Convert decimal: " + n +" to Binary :" +d.covertDtoB(n));
	}
	
	public int covertDtoB(int n) {
		if (n < 0 || n == 0) {
			return 0;
		}
		return  n%2 + 10 * covertDtoB(n/2);
	}

}
