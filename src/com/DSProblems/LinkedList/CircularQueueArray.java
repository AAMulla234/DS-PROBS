package com.DSProblems.LinkedList;

public class CircularQueueArray {
	int[] arr;
	int topOfQueue;
	int beginningOfQueue;
	int size;
	
	public CircularQueueArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginningOfQueue = -1;
		this.size = size;
	}
	
	public boolean isFull() {
		if(this.topOfQueue+1 == this.beginningOfQueue)
			return true;
		else if(this.beginningOfQueue == 0 && this.topOfQueue+1 == this.size)
			return true;
		return false;
	}

	public boolean isEmpty() {
		if (this.topOfQueue == -1)
			return true;
		return false;
	}
	
	public void enQueue(int value) {
		if (this.isFull())
			return;
		if (this.isEmpty()) { // Queue is completly empty
			this.beginningOfQueue = 0;
			this.arr[++this.topOfQueue] = value;
		} else {
			if (this.topOfQueue+1 == this.size) // the last element in array, go to first and add
				this.topOfQueue = 0;
			else
				this.topOfQueue++;
			
			this.arr[topOfQueue] = value;
		}
	}
	
	public int deQueue() {
		if(this.isEmpty())
			return -1;
		else {
			int result = this.arr[this.beginningOfQueue];
			this.arr[this.beginningOfQueue] = -1;
			
			if(this.beginningOfQueue == this.topOfQueue) { //inCircular queue both pointer comes at same place
				// that means only single element inbetween in list
				this.beginningOfQueue = this.topOfQueue = -1;
			} else if (this.beginningOfQueue+1 == size) { // only last element in queue
				this.beginningOfQueue = 0;
			}else {
				this.beginningOfQueue++;
			}
			return result;
		}
	}

}
