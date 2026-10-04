package com.DSProblems.recursive.more;

/**
 * There are 3 students and 3 chairs. How many ways you can sit them...
 */
public class Permutation {

    public static void permutation(String str, String combinations) {
        if (str.length() == 0) {
            System.out.println(combinations);
            return;
        }
            
        for(int i=0; i< str.length(); i++) {
            char current = str.charAt(i);
            String others = str.substring(0, i) + str.substring(i+1);
         //   System.out.println("i is:" + i);
            permutation(others, combinations + current);
        }
    }


    public static void main(String[] args) {
        permutation("abc",  "");
    }
}
