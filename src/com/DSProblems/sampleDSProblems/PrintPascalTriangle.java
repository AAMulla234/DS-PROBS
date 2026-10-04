package com.DSProblems.sampleDSProblems;

public class PrintPascalTriangle {

	public static void main(String[] args) {
		printPascal(6);
	}
	
	public static void printPascal(int n) {
		for (int row = 1; row <= n; row++) {  //-----------------O(n)
			for(int space = 1; space <= n-row; space++) // ---------- O(s^(n-r))
				System.out.print(" ");
			int coef = 1;
			for(int col = 1; col <= row; col++) { //------------O(c^r)
				System.out.print(" " + coef);
				coef = coef * (row - col) / col;
			}
			System.out.println("");
		}
	}
}
