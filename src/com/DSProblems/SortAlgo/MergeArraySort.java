package com.DSProblems.SortAlgo;

public class MergeArraySort {

	public static void main(String[] args) {
		int[] num1 = {4,0,0,0,0,0};
		int[] num2 = {1,2,3,5,6};
		int m = num1.length;
		int n = num2.length;
		merge(num1, m, num2, n);
		print(num1);
	}
	
   public static void merge(int[] num1, int m, int[] num2,  int n) {
	   int i=0, j=0, p = m-n;
	   while(i < m && j < n) {
		   if (num1[i] < num2[j]) {
			   i++;
		   } else {
			   moveOneStepRight(num1, i, p++);
			   num1[i++] = num2[j++];
		   }
	   }
	  while(j < n) {
		   num1[p++] = num2[j++]; 
	   }
   }
   
   private static void moveOneStepRight(int[] num1, int s, int p) {
	   for(int j=p; j> s; j--) {
		   num1[j] = num1[j-1];
	   }
	   print(num1);
   }
   
   private static void print(int num1[]) {
		for(int n : num1) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
}
