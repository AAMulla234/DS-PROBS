package com.DSProblems.LinkedList;

public class StackMin {
	
	Node2 head;
	Node2 min;
	
	public int min() {
		return min.value;
	}

	public void push(int value) {
		if (min == null) {
			min = new Node2(value, min);
		} else if (value < min.value) {
			min = new Node2(value, min);
		} else {
			min = new Node2(min.value, min);
		}
		head = new Node2(value, head);
	}
	
	public int pop() {
		min = min.next;
		int result = head.value;
		head = head.next;
		return result;
	}
}
