package com.DSProblems.recursive.more;

public class StringTransforming {

    private static void transform(String current, String target){
        Integer[][] dp = new Integer[current.length()+1][target.length()+1];
        int minSteps = backrack(dp, current, target,0, 0,"");
        System.out.println(current + "::" + target);
        System.out.println("Minimum steps required:::::::::" + minSteps);

    }

    private static int backrack(Integer[][] dp, String s1, String s2, int idx1, int idx2, String transformations) {
        if(dp[idx1][idx2] == null) { 
            if(idx1 == s1.length()) // if we have reached the end of s1, then insert all the remaining characters of s2
	            dp[idx1][idx2] = s2.length() - idx2;
            else if(idx2 == s2.length()) // if we have reached the end of s2, then delete all the remaining characters of s1
                dp[idx1][idx2] = s1.length() - idx1;

            else if(s1.charAt(idx1) == s2.charAt(idx2)) // If the strings have a matching character, recursively match for the remaining lengths.
                dp[idx1][idx2] = backrack(dp, s1, s2, idx1+1, idx2+1, idx1 + ":" + "idx2" + "this step both are same");
            
            else {
                    int c1 = backrack(dp, s1, s2, idx1+1, idx2, idx1 +":" + idx2 + "delete from index"); //delete
                    int c2 = backrack(dp, s1, s2, idx1, idx2+1, idx1 +":" + idx2 + "insert from index"); //insert
                    int c3 = backrack(dp, s1, s2, idx1+1, idx2+1, idx1 +":" + idx2 + "replace from index"); //replace
                    dp[idx1][idx2] = 1 + Math.min(c1, Math.min(c2, c3));
                  }    
        }

        return dp[idx1][idx2];

    }

    public static void main(String[] args) {
        transform("catch", "Halloh");
    }

}
