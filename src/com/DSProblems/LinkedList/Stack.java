package com.DSProblems.LinkedList;

public class Stack {
	
	public void push(LinkedList ll, int value) {
		Node newNode = new Node();
		newNode.value = value;
		if (ll.head == null) {
			ll.head = newNode;
			ll.tail = newNode;
			ll.tail.next = null;
			ll.size++;
			return;
		}
		newNode.next = ll.head;
		ll.head = newNode;
		ll.size++;
	}
	public boolean pop(LinkedList ll) {
		if (ll.head == null)
			return false;
		
		Node node = ll.head;
		ll.head = node.next;
		if (node.next == null) { // Last element in list
			ll.tail = null;
		}
		ll.size--;
		return true;
	}
	
	public Node peek(LinkedList ll) {
		if (ll.head == null)
			return null;
		return ll.head;
	}
	

}
