package com.DSProblems.LinkedList;

public class Queue {

	Node head;
	Node tail;
	int size;
	
	public boolean isEmpty() {
		if (head == null && tail == null)
			return true;
		return false;
	}
	
	public void enQueue(int value) {
		Node newNode = new Node();
		newNode.value = value;
		if (isEmpty()) {
			newNode.next = null;
			head = newNode;
			tail = newNode;
			tail.next = null;
			size++;
			return;
		}
		tail.next = newNode;
		newNode.next = null;
		tail = newNode;
		size++;
	}
	
	public void deQueue() {
		if(isEmpty())
			return;
		
		head = head.next;
		if(head == null) {
			tail = null;
			head = null;
		}
		size--;
	}
	
	public int peek() {
		if(isEmpty()) {
			return -1;
		}
		return head.value;
	}
	
	 public void traversalLL() {
		    Node tempNode = head;
		    for (int i =0; i<size; i++) {
		      System.out.print(tempNode.value);
		      if (i != size -1) {
		        System.out.print(" -> ");
		      }
		      tempNode = tempNode.next;
		    }
		  }

	
}
