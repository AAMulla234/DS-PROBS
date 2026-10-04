package com.DSProblems.TreeDS.BinaryHeap;

public class PriorityQueueUsingBH {
	
	int arr[];
	int sizeOfTree;
	
	public PriorityQueueUsingBH(int size) {
		arr = new int[size + 1];
		sizeOfTree = 0;
	}
	
	private boolean isEmpty() {
		if (sizeOfTree == 0)
			return true;
		return false;
	}
	
	
	
	public void insert(int value) {
		arr[sizeOfTree +1] = value;
		sizeOfTree++;
		heapifyBottomToTop(sizeOfTree);
	}

	private void heapifyBottomToTop(int index) {
		int pIndex = index/2;
		
		if(index <= 1) {
			return;
		}
		
		if(arr[pIndex] < arr[index]) {
			int temp = arr[index];
			arr[index] = arr[pIndex];
			arr[pIndex] = temp;
		}
		heapifyBottomToTop(pIndex);
	}
	
	private void heapifyTopToBottom(int index) {
		int leftIndex = index * 2;
		int rightIndex = index * 2 + 1;
		int swapChild;
		
		if(sizeOfTree < leftIndex) {
			return;
		}
		
		if(sizeOfTree == leftIndex) { //only 1 element in array, just swap to max
			if(arr[leftIndex] > arr[index]) {
				int tmp = arr[index];
				arr[index] = arr[leftIndex];
				arr[leftIndex] = tmp;
			}
			return;
		} else {
			if(arr[leftIndex] > arr[rightIndex]) {
				swapChild = leftIndex;
			} else {
				swapChild = rightIndex;
			}
			
			if (arr[index] < arr[swapChild]) {
				int tmp = arr[index];
				arr[index] = arr[swapChild];
				arr[swapChild] = tmp;
			}
		}
		heapifyBottomToTop(swapChild);
	}
	
	public int extractMax() {
		int max = arr[1];
		arr[1] = arr[sizeOfTree];
		sizeOfTree--;
		heapifyTopToBottom(1); 
		return max;
	}
	
	

}
