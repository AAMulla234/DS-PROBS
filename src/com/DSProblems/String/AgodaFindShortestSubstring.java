package com.DSProblems.String;

import java.util.HashSet;
import java.util.Set;

/**
 * This is asked in agoda interview
 * 
 * string has some charaters
 * find shortest substring that contains all the character of string
 * 
 * e.g dabbcabcd   [a,b,c,d]
 * 
 * substrings are dabbc, abcd
 * here shortest is abcd -> length is 4
 */

public class AgodaFindShortestSubstring {

    private static Set<Character> uniqueChars = new HashSet<>();
    

    private static void setupCharMap(String s) {
       for(char c : s.toCharArray()) {
        uniqueChars.add(c);
       }
    }

    private static boolean isAllPresent(String s) {
        for(char c : uniqueChars) {
            if(s.indexOf(c) == -1){
                return false;
            }
        }
        return true;
    }

    public static int findShortestSubstring(String s) {
        setupCharMap(s);

        int left =0;
        int right=0;

        StringBuffer subString = new StringBuffer();
        int shortestLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            subString.append(s.charAt(right));
            
            if(isAllPresent(subString.toString())){
                shortestLength = Math.min(shortestLength, subString.length());
                System.out.println(subString.toString());
                left++;
                subString = new StringBuffer();
                right = left;
            } else {
                right++;
            }
        }
        return shortestLength;
    }



    public static void main(String[] args) {
        System.out.println("shortest substing is::" + findShortestSubstring("hellohellohoo"));
    }

}
