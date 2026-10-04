package com.DSProblems.LinkedList;

public class DoublyLinkedList {
	DNode head;
	DNode tail;
	int size;
	
	public void createDLL(int nodeValue) {
		DNode node = new DNode();
		node.value = nodeValue;
		node.prev = null;
		node.next = null;
		head = node;
		tail = node;
		size = 1;
	}
	
	public void insert(int location, int nodeValue) {
		if (head == null) {
			createDLL(nodeValue);
			return;
		}
		DNode node = new DNode();
		node.value = nodeValue;
	
		if (location == 0) {
			node.prev = null;
			node.next = head;
			head.prev = node;
			head = node;
		} else if(location >= size) {
			node.next = null;
			tail.next = node;
			node.prev = tail;
			tail = node;
		} else {
			int index = 0;
			DNode tempNode = head;
			while (index < location-1) {
				tempNode = tempNode.next;
				index++;
			}
			
			node.prev = tempNode;
			node.next = tempNode.next;
			tempNode.next = node;
			node.next.prev = node;
		}
		size++;	
	}
	
	public void print() {
		DNode tempNode = head;
		while(tempNode != null) {
			System.out.println(tempNode.value);
			tempNode = tempNode.next;
		}
	}
	
	public void reversePrint() {
		DNode tempNode = tail;
		while (tempNode != null) {
			System.out.println(tempNode.value);
			tempNode= tempNode.prev;
		}
	}
	
	public void delete(int location) {
		
		if(location == 0) {
			head = head.next; 
			size--;
			if(size ==0) {
				tail = null;
			}
		} else if (location >= size) {
			DNode tempNode = head;
			DNode prevNode = head;
			while (tempNode.next != null) {
				prevNode = tempNode;
				tempNode = tempNode.next;
			}
			if (tempNode == head) {
				tail = head = null;
				size --;
				return;
			}
			prevNode.next = null;
			tail = prevNode;
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

}
