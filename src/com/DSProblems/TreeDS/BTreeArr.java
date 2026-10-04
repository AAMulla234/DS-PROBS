package com.DSProblems.TreeDS;

public class BTreeArr {
	String[] arr;
	int lastIndUsed;
	
	public BTreeArr(int size) {
		arr = new String[size+1];
		this.lastIndUsed = 0;
	}
	
	private boolean isFull() {
		if ((arr.length-1) == lastIndUsed)
			return true;
		else
			return false;
	}
	
	public void insert(String value) {
		if (!isFull()) {
			arr[lastIndUsed+1] = value;
			this.lastIndUsed++;
		}else {
			System.out.println("BT is full");
		}
	}
	
	public void preOrder(int index) {
		if (index > this.lastIndUsed) {
			return;
		}
		System.out.print(arr[index] + " ");
		preOrder(index*2);
		preOrder(index*2 +1);
	}
	
	public void inOrder(int index) {
		if (index > this.lastIndUsed) {
			return;
		}
		inOrder(index*2);
		System.out.print(arr[index] + " ");
		inOrder(index*2 +1);
	}
	
	public void postOrder(int index) {
		if (index > this.lastIndUsed) {
			return;
		}
		postOrder(index*2);
		postOrder(index*2 +1);
		System.out.print(arr[index] + " ");
	}
	
	public void levelOrder(int index) {
		if (index > this.lastIndUsed)
			return;
		System.out.print(arr[index] + " ");
		levelOrder(index+1);
	}
	
	public int search(String value) {
		for (int i =1; i < this.lastIndUsed; i++) {
			if (arr[i] == value) {
				System.out.println("Find element");
				return i;
			}
		}
		return -1;
	}
	
	public void delete(String element) {
		int location = search(element);
		if(location == -1) {
			System.out.println("Element not found");
		} else {
			arr[location] = arr[lastIndUsed];
			lastIndUsed --;
		}
	}
}
