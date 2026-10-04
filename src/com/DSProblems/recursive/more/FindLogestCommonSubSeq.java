package com.DSProblems.recursive.more;

import java.util.ArrayList;
import java.util.List;

public class FindLogestCommonSubSeq {


    public static List<Integer> longestCommonSubsequence(List<Integer> a, List<Integer> b, int m, int n) {

        if (m == 0 || n == 0) {
            return new ArrayList<>();
        }
      
        if (a.get(m-1).equals(b.get(n-1))) {
            List<Integer> result =  longestCommonSubsequence(a, b, m-1, n-1);
            result.add(a.get(m-1));
            return result;
        } else {
            List<Integer> extendA = longestCommonSubsequence(a, b, m-1, n);
            List<Integer> extendB = longestCommonSubsequence(a, b, m, n-1);

            return extendA.size() > extendB.size() ? extendA : extendB;
        }
    }

    public static StringBuilder longestCommonSubsequence(String s1, String s2, int idx1, int idx2) {

        if (s1.length() == idx1 || s2.length() == idx2) {
            return new StringBuilder();
        }
 
        if(s1.charAt(idx1) == s2.charAt(idx2)) {
            StringBuilder result =  longestCommonSubsequence(s1, s2, idx1++, idx2++);
            result.append(s1.charAt(idx1));
            return result;
        } else {
            StringBuilder extendA = longestCommonSubsequence(s1, s2, idx1++, idx2);
            StringBuilder extendB = longestCommonSubsequence(s1, s2, idx1, idx2++);

            return extendA.length() > extendB.length() ? extendA : extendB;
        }
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(1);

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        b.add(1);
        b.add(2);
        b.add(1);
        b.add(3);

        System.out.println(longestCommonSubsequence(a, b, 5, 6));

        System.out.println(longestCommonSubsequence("sdgdjjhjdfds","dsfsdjjhjderwefds", 0, 0));
    }

}
