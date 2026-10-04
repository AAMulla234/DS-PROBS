package com.DSProblems.SortAlgo;

public class Main {

	public static void main(String[] args) {
		
		BubbleSort bs = new BubbleSort();
		int arr[] = {10, 3, 14, 40, 2, 6, 70, 65, 25, 9};
		
		bs.bubbleSort(arr);
		bs.print(arr);

		SelectionSort ss = new SelectionSort();
		int arr2[] = {10, 3, 14, 40, 2, 6, 70, 65, 25, 9};
		
		ss.selectionSort(arr2);
		ss.print(arr2);
		
		InsertionSort is = new InsertionSort();
		int arr3[] = {10, 3, 14, 40, 2, 6, 70, 65, 25, 9};
		is.insertionSort(arr3);
		is.print(arr3);
		
		int arr4[] = {10, 3, 14, 40, 2, 6, 70, 65, 25, 9};
		BucketSort bus = new BucketSort(arr4);
		bus.bucketSort();
		
		System.out.println();
		bus.printArray();
		System.out.println("\n\n--------------------------------Merge sort----------------------------------------------");
		int arr5[] = {10, 3, 14, 40, 2, 6, 70, 65, 25, 9};
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr5, 0, arr5.length-1);
		ms.print(arr5);
		
		
		MergeSortLL msll = new MergeSortLL();
		
		msll.push(15);
		msll.push(10);
		msll.push(5);
		msll.push(23);
		msll.push(1);
		msll.push(8);
		msll.push(19);
		msll.push(45);
		msll.push(14);
		
		msll.printList(msll.head);
		msll.head = msll.mergeSort(msll.head);
		System.out.println();
		msll.printList(msll.head);
		
		System.out.println();
		QuickSort qs = new QuickSort();
		int arr6[] = {10, 3, 14, 40, 2, 6, 70, 65, 25, 9};
		qs.print(arr6);
		qs.quickSort(arr6, 0, arr6.length-1);
		
		qs.print(arr6);
		
	}

}
