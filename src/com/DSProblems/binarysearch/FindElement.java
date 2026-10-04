package com.DSProblems.binarysearch;

public class FindElement {

    private static int findelement(int[] arr, int element) {
        int left =0;
        int right = arr.length -1;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(arr[mid] == element){
                return mid;
            }

            if (arr[left] <= arr[mid]){ //left part is sorted
                if(element > arr[left] && element < arr[mid]) {
                    right = mid -1;
                } else {
                    left = mid +1;
                }
            } else { //right part is sorted
                if(element > arr[mid] && element <= arr[right]) {
                    left = mid +1;
                } else {
                    right = mid -1;
                }
            }
        }
        return -1; // if not found then return -1
    }


    public static void main(String[] args) {
        int[] arr = new int[]{10, 13, 15, 5, 6, 7, 9};

        System.out.println("Element at:" + findelement(arr, 15));
    }
}
