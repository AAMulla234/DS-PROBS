package com.DSProblems.sampleDSProblems;


public class StringExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("Akhtar"));
	}
	
	public static String reverse(String value) {
		char[] val = value.toCharArray();
		int n = value.length() -1;
		for (int j = (n-1) >> 1; j >= 0; j--) {// --------O(log n)
			 int k = n - j;
			 System.out.println(k + " : " + j);
		 
			 char cj = val[j];
             val[j] = val[k];
             val[k] = cj;
            
		}
		
		return "";
	}

}
