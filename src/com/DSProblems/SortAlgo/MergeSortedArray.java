package com.DSProblems.SortAlgo;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
         // nums1 has extra space to accommodate nums2
         int[] nums1 = {1, 3, 5, 0, 0, 0};
         int m = 3; // Number of elements in nums1
         int[] nums2 = {2, 4, 6};
         int n = 3; // Number of elements in nums2
 
         merge(nums1, m, nums2, n);
 
         System.out.println("Merged array: " + Arrays.toString(nums1));
    }

    public static void merge(int[] num1, int m, int[] num2, int n) {
        int i = m -1; // point to last element;
        int j = n -1;

        int p = m + n -1; // point last index of first array

        while(i >=0 && j>=0) {
            if(num1[i] < num2[j]) {
                num1[p--] = num2[j--]; // num2 element is bigger then keep at end
            } else {
                num1[p--] = num1[i--];
            }
        }

        while(j >= 0){
            num1[p--] = num2[j--];
        }
}

}
