package com.DSProblems.recursive;

import java.util.ArrayList;
import java.util.Arrays;

public class Reverse {

	public static void main(String[] args) {
		String str = "java";
		Reverse r = new Reverse();
		
		System.out.println("Reverse str::" + r.reverse(str));
		
		str = "abcdba";
		
		System.out.println("Palindrom str::" + r.isPalindrome(str));
		
		System.out.println(r.capitalizeWord("i love java"));
		
		 r.checkPalindromPartition("carace");
		 
		 isSubsequence("abc", "ahbgdc");
	}

	public String reverse(String str)
    {
       if (str == null || str.length() <= 1) {
    	   return str;
       }
        
        return reverse(str.substring(1)) + str.charAt(0);
    }
	
	   public  boolean isPalindrome(String s)
	    {   
	        if (s.length() == 0 || s.length() == 1)
	            return true;
	            
	        if(s.charAt(0) == s.charAt(s.length() - 1))
	            return isPalindrome(s.substring(1, s.length()-1));
	    
	        return false;  
	    }
	
	   
	   public String capitalizeWord(String str){
		     if (str == null || str.length() == 0)
		        return str;
		     
		     if(str.length() == 1) {
		    	 return str.toUpperCase();
		     }
		        
		     String[] strArray = str.split(" ");   
		     strArray = this.makeCapital(strArray, strArray.length);
		     StringBuilder builder = new StringBuilder();
		     int i =1;
		     for(String s : strArray) {
		         builder.append(s);
		         if (i != strArray.length) {
		        	 builder.append(" ");
		         }
		         i++;
		     }
		     
		     return  builder.toString();
		     
		  } 
	   
	   public  String[] makeCapital(String[] strArray, int N) {
		      if (N == 0){
		          return strArray;
		      }
		      String subStr = strArray[N-1];
		      char c = subStr.charAt(0);
		      c = Character.toUpperCase(subStr.charAt(0));
		      subStr =  Character.toString(c) + subStr.substring(1);
		      strArray[N-1] = subStr;
		      return makeCapital(strArray, N-1);
	}
	   
	   
	public void partitionOfString(ArrayList<ArrayList<String>> res, String s, int sInd, ArrayList<String> curr) {
		
		if(sInd == s.length()) {
			res.add(new ArrayList<String>(curr));
			return;
		}
		
		for (int i =sInd; i < s.length(); i++) {
			String temp = "";
			temp += s.substring(sInd, i+1);
			if (this.isPalindrome(temp)) {
				curr.add(temp);
			}
		}
		sInd++;
		this.partitionOfString(res, s, sInd, curr);
	}
	
	
	public void checkPalindromPartition(String s) {
		// Stores all partitions generated at the end
        ArrayList<ArrayList<String>> res = new ArrayList<>();
   
        int sInd = 0;
  
        // Store the partition at current iteration
        ArrayList<String> curr = new ArrayList<>();
        
        this.partitionOfString(res, s, sInd, curr);
        
        for(ArrayList<String> iter : res) {
            System.out.println(iter);
        }
	}
	
	   public boolean isPalindromeLongStr(String s) {
	        if (s.length() == 0){
	            return false;
	        }

	        int l =0;
	        int r = s.length();
	        int n = s.length();

	        while (l <= r) {
	            char firstChar = s.charAt(l);
	            char lastChar = s.charAt(r);

	            if (!Character.isLetterOrDigit(firstChar)) {
	                l++;
	            } else if(!Character.isLetterOrDigit(lastChar)) {
	                r--;
	            } else if(Character.toLowerCase(firstChar) == Character.toLowerCase(lastChar)) {
	                l++;
	                r--;
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }

	   public static boolean isSubsequence(String s, String t) {
	        if (s.length() == 0)
	            return true;
	        else if(t.length() == 0)
	            return false;

	        if (s.length() == 1 && t.length() ==1) {
	            return false;
	        }

	        int i = 0, j = 0;
	        
	        while(i < s.length() && j < s.length()) {
	            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(t.charAt(j))) {
	                i++;
	                j++;
	                System.out.println(i);
	            } else {
	                j++;
	            }
	        } 
	       
	        if (i == s.length())
	            return true;
	        return false;
	    }
	

}
