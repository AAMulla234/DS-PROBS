package com.DSProblems.TreeDS.BinaryHeap;

/**
 * Create BinaryHeap using Array
 */
public class BinaryHeap {
	int arr[];
	int sizeOfTree;
	
	public BinaryHeap(int size) {
		arr = new int[size + 1];
		sizeOfTree = 0;
	}
	
	public int sizeOfBP() {
		return sizeOfTree;
	}

	private boolean isEmpty() {
		if (sizeOfTree == 0)
			return true;
		return false;
	}
	
	public int peek() {
		if (this.isEmpty()) {
			return -1;
		}
		return arr[1];
	}
	
	private void heapifyBottomToTop(int index, String heapType) {
		int parentIndex = index/2;
		if(index <= 1) {
			return;
		}
		
		if(heapType == "Min") {
			if(arr[parentIndex] > arr[index]) {
				int tmp = arr[index];
				arr[index] = arr[parentIndex];
				arr[parentIndex] = tmp;
			}
		} else {
			if(arr[parentIndex] < arr[index]) {
				int tmp = arr[index];
				arr[index] = arr[parentIndex];
				arr[parentIndex] = tmp;
			}
		}
		heapifyBottomToTop(parentIndex, heapType);
	}
	
	public void levelOrder() {
		for(int i =1; i<= sizeOfTree; i++) {
			System.out.print(arr[i] + "  ");
		}
	}
	
	public void insert(int value, String heapType) {
		arr[sizeOfTree +1] = value;
		sizeOfTree++;
		heapifyBottomToTop(sizeOfTree, heapType);
	}
	
	private void heapifyTopToBottom(int index, String heapType) {
		int leftIndex = index * 2;
		int rightIndex = index * 2 + 1;
		int swapChild;
		
		if(sizeOfTree < leftIndex) {
			return;
		}
		
		if(heapType == "Min") {
			if(sizeOfTree == leftIndex) { // if there is only one element array
				if(arr[leftIndex] < arr[index]) {
					int tmp = arr[index];
					arr[index] = arr[leftIndex];
					arr[leftIndex] = tmp;
				}
				return;
			} else {
				if(arr[leftIndex] < arr[rightIndex]) {
					swapChild = leftIndex;
				} else {
					swapChild = rightIndex;
				}
				if (arr[index] > arr[swapChild]) {
					int tmp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = tmp;
				}
			}
		} else {
			if(sizeOfTree == leftIndex) {
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
		}
		heapifyTopToBottom(swapChild, heapType);
	}
	
	public int extractHeadBH(String heapType) {
		if (isEmpty()) {
			return -1;
		}
		
		int extractValue = arr[1];
		arr[1] = arr[sizeOfTree];
		sizeOfTree--;
		heapifyTopToBottom(1, heapType);
		return extractValue;
	}
}
