package com.DSProblems.LinkedList;

public class QueueArray {
	
	int[] arr;
	int topOfQueue;
	int beginningOfQueue;
	
	public QueueArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginningOfQueue = -1;
	}
	
	public boolean isFull() {
		if(this.topOfQueue == arr.length-1)
			return true;
		
		return false;
	}
	
	public boolean isEmpty() {
		if (this.beginningOfQueue  == -1 || this.beginningOfQueue == arr.length) 
			return true;
		return false;
	}
	
	public void enQueue(int value) {
		if (this.isFull())
			return;
		if (this.isEmpty())
			this.beginningOfQueue = 0;
		arr[++this.topOfQueue] = value;
	}
	
	public int deQueue() {
		if(this.isEmpty())
			return -1;
		
		int result = this.arr[this.beginningOfQueue];
		this.arr[this.beginningOfQueue] = -1;
		this.beginningOfQueue++;
		if(this.beginningOfQueue > this.topOfQueue) {
			this.beginningOfQueue = this.topOfQueue = -1;
		}
		return result;
	}
	
	public int peek() {
		if(this.isEmpty())
			return -1;
		return this.arr[this.beginningOfQueue];
	}
	
	public void delete() {
		this.arr = null;
	}

}
