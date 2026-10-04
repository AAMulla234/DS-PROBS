package com.DSProblems.LinkedList;

import java.util.EmptyStackException;

public class PlateStack {
	
	Node head;
	int capacity;
	int size;
	
	public PlateStack(int capacity) {
		this.capacity = capacity;
	}

	public boolean isStackFull() {
		return size == capacity;
	}
	
	public void push(int value) {
		if (isStackFull())
			return;
		
		Node newNode = new Node();
		newNode.value = value;
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		newNode.next = head;
		head = newNode;
		size++;
	}

	public int pop() {
		if (head == null)
			throw new EmptyStackException();
		int result = head.value;
		head = head.next;
		size--;
		return result;
	}
}
