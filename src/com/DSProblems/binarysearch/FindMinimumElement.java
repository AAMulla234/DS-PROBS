package com.DSProblems.binarysearch;


/** In Rotated sorted array find the minimum element
 *  e.g [10, 13, 15, 5, 6, 7, 9]
 * 
 */
public class FindMinimumElement {
    
    private static int findMinimum(int[] arr) {
        int left =0;
        int right = arr.length -1;

        int mid =0;

        while (left < right) {
            mid = left + (right-left)/2;

            if(arr[mid] > arr[right]) {
                left = mid+1; // minimum at right side
            } else {
                right = mid; // minimum at left side
            }
        }

        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 13, 15, 5, 6, 7, 9};

        System.out.println("Minimum element is:" + findMinimum(arr));
    }

}
