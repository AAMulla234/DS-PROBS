package com.DSProblems.recursive.more;

public class PalindromString {

    public static boolean isPalindrom(String str, int ind, int n) {
        if (ind >= (n/2)) {
            return true;
        }
        if (str.charAt(ind) != str.charAt(n - ind -1)) {
            return false;
        }
        return isPalindrom(str, ind+1, n);
    }

    public static void possiblePalindrom(String str, int start, int[] count) {
        if (start == str.length()) {
            return;
        }

        for(int end = start; end < str.length(); end++) {
            String substring = str.substring(start, end+1);
            if(isPalindrom(substring, 0, substring.length())) {
                count[0]++;
            }
        }
        possiblePalindrom(str, start+1, count);
    }


    public static void main(String[] args) {
        System.out.println("is palindrom string::::::" + isPalindrom("madadfdsm", 0, 5));

        int[] count = new int[1]; // To store the result
        possiblePalindrom("racecar", 0, count);
        System.out.println("possible........." + count[0]);
    }
}
