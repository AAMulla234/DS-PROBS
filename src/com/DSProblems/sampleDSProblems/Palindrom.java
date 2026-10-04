package com.DSProblems.sampleDSProblems;

public class Palindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(121));
	}
	
    public static boolean isPalindrome(int x) {
        int reverse = 0;
        int temp  = x;
        while (x > 0) {
            reverse = reverse * 10 + x%10;
            x = x/10;
        }
        System.out.println();
        if (reverse == temp)
            return true;
        else
            return false;
    }

}
