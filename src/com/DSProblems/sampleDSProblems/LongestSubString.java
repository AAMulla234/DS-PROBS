package com.DSProblems.sampleDSProblems;

import java.util.HashMap;


public class LongestSubString {

	public static void main(String[] args) {
		String s = "ddacbbaccdedacebb";
		System.out.println("Longest unique string length is ::" + longestSubString(s, 3));
	}

	public static int longestSubString(String s, int k) {
		int ans = 0;
		int i = -1;
		int j = -1;
		int n = s.length() - 1;
		String ansStr = "";
		HashMap<Character, Integer> uniqueChars = new HashMap<Character, Integer>();
		while(true) {
			boolean f1 = false;
			boolean f2 = false;
			
			while(i < n) {
				f1 = true;
				i++;
				char c = s.charAt(i);
				uniqueChars.put(c, uniqueChars.getOrDefault(c, 0) + 1);
				
				if (uniqueChars.size() <= k) {
					int len = i - j;
					if (len > ans) {
						ans = len;
						ansStr = s.substring(i, ans);
					} else 
						break;
				}
			}
			while(j < i) {
				f2 = true;
				j++;
				char c = s.charAt(j);
				if(uniqueChars.get(c) == 1) 
					uniqueChars.remove(c);
				else
					uniqueChars.put(c, uniqueChars.get(c) - 1);
				
				if (uniqueChars.size() > k)
					continue;
				else
				{
					int len = i - j;
					if (len > ans) {
						ans = len;
					} else 
						break;
				}
					
			}
			if (f1 == false && f2 == false)
				break;
		}
		System.out.println(ansStr);
		return ans;
	}
}
