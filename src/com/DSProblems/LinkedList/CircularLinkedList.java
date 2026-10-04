package com.DSProblems.LinkedList;

public class CircularLinkedList {
	Node head;
	Node tail;
	int size;
	
	public void createCLL(int nodeValue) {
		Node node = new Node();
		node.value = nodeValue;
		node.next = node;
		
		head = node;
		tail = node;
	}
	
	public void insert(int nodeValue, int location) {
		if (head == null) {
			createCLL(nodeValue);
		} else {
			Node node = new Node();
			node.value = nodeValue;
		    if (location == 0) {
				node.next = head;
				head = node;
				tail.next = head;
			} else if (location >= size) {
				tail.next = node;
				tail = node;
				node.next = head;
			} else {
				int index =0;
				Node tempNode = head;
				while(index < location-1) {
					tempNode = tempNode.next;
					index++;
				}
				Node nextNode = tempNode.next;
				tempNode.next = node;
				node.next = nextNode;
			}
		}
		size++;
	}
	
	public int search(int element) {
		Node tempNode = head;
		for (int i=0; i< size; i++) {
			if (tempNode.value == element)
				return i;
			tempNode= tempNode.next;
		}
		return -1;
	}
	
	public void delete(int location) {
		if (location == 0) {
			head = head.next; 
			tail.next = head;
			size--;
			if(size ==0) {
				tail = null;
				head.next = null;
				head = null;
			}
		} else if (location >= size) {
			Node tempNode = head;
			Node prevNode = head;
			while (tempNode.next != head) {
				prevNode = tempNode;
				tempNode = tempNode.next;
			}
			if (tempNode == head) {
				tail = head = null;
				size --;
				return;
			}
			prevNode.next = head;
			tail = prevNode;
			size--;
			
		} else {
			int index =0;
			Node tempNode = head;
			Node prevNode = head;
			while(index != location) {
				prevNode = tempNode;
				tempNode = tempNode.next;
				index++;
			}
			prevNode.next = tempNode.next;
			size--;
		}
	}
	
	public void print() {
		Node tempNode = head;
		while(tempNode.next != head) {
			System.out.println(tempNode.value);
			tempNode = tempNode.next;
		}
		System.out.println(tempNode.value);
	}

}
