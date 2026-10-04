package com.DSProblems.LinkedList;

public class CircularDoubleLinkedList {
	DNode head;
	DNode tail;
	int size;
	
	public void createCDLL(int nodeValue) {
		DNode node = new DNode();
		node.value = nodeValue;
		head = node;
		tail = node;
		node.prev = node; 
		node.next = node;
				
		size = 1;
	}
	
	public void insert(int location, int element) {
		if (head == null){
			createCDLL(element);
		}
		DNode newNode = new DNode();
		newNode.value = element;
		
		if (location == 0) {
			newNode.next = head;
			newNode.prev = tail;
			head.prev = newNode;
			head = newNode;
			tail.next = newNode;
			
		} else if(location >= size) {
			newNode.next = head;
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
			head.prev = newNode;
		} else {
			int index =0;
			DNode tempNode = head;
			while(index < location-1) {
				tempNode = tempNode.next;
				index++;
			}
			newNode.prev = tempNode;
			newNode.next = tempNode.next;
			tempNode.next = newNode;
			newNode.next.prev = newNode;
		}
		size++;
	}
	
	public void delete(int location) {
		if (location == 0) {
			if (size ==1) {
				head.next = null;
				head.prev = null;
				head = null;
				tail = null;
			}
			tail.next = head.next;
			head = head.next;
			head.prev = tail;
			size--;
		} else if (location >= size) {
			if(size == 1) {
				head.next = null;
				head.prev = null;
				head = null;
				tail = null;
				size--;
				return;
			}
			
			tail = tail.prev;
			tail.next = head; 
			head.prev =  tail;
			size--;			
		} else {
			int index =0;
			DNode tempNode = head;
			DNode prevNode = head;
			while(index != location) {
				prevNode = tempNode;
				tempNode = tempNode.next;
				index++;
			}
			prevNode.next = tempNode.next;
			tempNode.next.prev = prevNode;
			size--;
		}
	}
	
	public void print() {
		DNode tempNode = head;
		while(tempNode.next != head) {
			System.out.println(tempNode.value);
			tempNode = tempNode.next;
		}
		System.out.println(tempNode.value);
	}
	
	public void reversePrint() {
		DNode tempNode = tail;
		while (tempNode != tail) {
			System.out.println(tempNode.value);
			tempNode= tempNode.prev;
		}
	}
}
