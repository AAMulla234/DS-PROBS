package com.DSProblems.String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestSubString("abcabcbb"));
	}
	
	public static int longestSubString(String s) {
		Set<Character> set = new HashSet<Character>();
		int maxLength = 0;
		int l =0;
		
		for (int r=0; r < s.length(); r++) {
			if(!set.contains(s.charAt(r))) {
				set.add(s.charAt(r));
				maxLength = Math.max(maxLength, r -l +1);
			} else {
				while (s.charAt(l) != s.charAt(r)) {
					set.remove(s.charAt(l));
					l++;
				}
				set.remove(s.charAt(l));
				l++;
				set.add(s.charAt(r));
			}
		}
		
		return maxLength;
	}
	
	/**
	 * Sliding window approach
	 * i move till end of string
	 * J will start with 0
	 * add each unique chars to set. if there is duplicate chars then remove from the left at is j
	 * 
	 * */
	public static int longestSubString2(String s) {
		Set<Character> set = new HashSet<Character>();
		int maxLength = 0;
		int j =0;
		
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			while(set.contains(c)) {
				set.remove(s.charAt(j));
				j++;
			}
			set.add(c);
			maxLength = Math.max(maxLength, i-j + 1);
		}
		return maxLength;
	}
	
	  public static String reverseWords(String s) {
	        String[] words = s.trim().split("\\s+");
	        StringBuffer reverseWords = new StringBuffer();
	        for(int i= words.length-1; i >= 0; i--) {
	        	reverseWords.append(words[i].trim());
	        }
			return reverseWords.toString(); 
	    }
	
	

}
