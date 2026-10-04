package com.DSProblems.recursive.more;
/**
 * Longest Increasing subsequence
 * Find Max of sequence that are always of increasing order
 */
public class LongestIncreaseSubsequence {

    public static int maxSubSequences(int idx, int prevIdx, int[] arr) {
        if (arr.length == idx) { // stop when reach to end of the array
            return 0;
        }

        int len = 0 + maxSubSequences(idx+1, prevIdx, arr); // we are not taking, the len would be same
        if (prevIdx == -1 || arr[idx] > arr[prevIdx]) { // we will only take if prev is -1 or current is greater than prev.
            len= Math.max(len, 1 + maxSubSequences(idx+1, idx, arr)); // store max length
        }
        return len;
    }


    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println("Max length::" + maxSubSequences(0, -1, arr));
    }
}
