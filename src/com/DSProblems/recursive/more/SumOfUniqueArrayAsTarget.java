package com.DSProblems.recursive.more;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *  Find combination of different elements of arrays that sum is equal to target
 * 
 */
public class SumOfUniqueArrayAsTarget {

    public static Set<List<Integer>> finalAnswer = new HashSet<List<Integer>>();

    public static void combinnationOfUniqueSum(int idx, int[] candidate, int target, int currentSum, Stack<Integer> tempArray) {
        if(currentSum > target) {
            return;
        }
        
        if (idx == candidate.length) {
            if (currentSum == target) {
                finalAnswer.add(tempArray);
                System.out.println(finalAnswer);
            
            }
            return;
        }

        // Inclusion
        currentSum += candidate[idx];
        tempArray.add(candidate[idx]);
        combinnationOfUniqueSum(idx, candidate, target, currentSum, tempArray);

        // Exclusion
        currentSum -= candidate[idx];
        tempArray.pop();
        combinnationOfUniqueSum(idx+1, candidate, target, currentSum, tempArray);

    }


    public static void main(String[] args) {
        int[] candidate = {2, 3, 6, 7};
        combinnationOfUniqueSum(0, candidate, 7, 0, new Stack<Integer>());
        System.out.println(finalAnswer);
            
      
    }

}
