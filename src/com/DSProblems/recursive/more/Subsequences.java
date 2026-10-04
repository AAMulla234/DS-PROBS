package com.DSProblems.recursive.more;

import java.util.HashSet;
import java.util.Set;

public class Subsequences {
    
    /**
     * Simple Subsequences to print possible sequences
     */
    public static void subSequences(String str, int indx, String newStr, Set<String> strSet) {
        if (str.length() == indx) {
            if (strSet.contains(newStr)){
                return;
            } else {
                strSet.add(newStr);
                System.out.println(newStr);
                return;
            }
        }
        char  c = str.charAt(indx);

        subSequences(str, indx+1, newStr + c,  strSet);
        subSequences(str, indx+1, newStr,  strSet);

    }

    public static int countTotalSubSeq(int indx, int sum, int target, int[] array) {
        if(sum > target)
            return 0;

        if(indx == array.length){
            if(sum == target)
                return 1;
            return 0;
        }
     
        sum += array[indx];
        int l = countTotalSubSeq(indx+1, sum, target, array);
        sum -= array[indx]; 
        int r = countTotalSubSeq(indx+1, sum, target, array);

        return l+r;
    }
    
    
    public static void main(String[] args) {
        subSequences("abc", 0, "", new HashSet<>());
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println("Count total subsequences sum is::" + countTotalSubSeq(0, 0, 12, arr));
    }
}
