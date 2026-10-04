package com.DSProblems.LinkedList;

public class SingleLinkedList {
	
	Node head;
	Node tail;
	int size;
	
	public Node createSingleLinkedList(int nodeValue) {
		Node node = new Node();
		node.value = nodeValue;
		node.next = null;
		head = node;
		tail = node;
		size = 1;
		return head;
	}
	
	public void insert(int nodeValue, int location) {
		if (head == null) {
			createSingleLinkedList(nodeValue);
		} else {
			Node node = new Node();
			node.value = nodeValue;
		    if (location == 0) {
				node.next = head;
				head = node;
			} else if (location >= size) {
				node.next = null;
				tail.next = node;
				tail = node;
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
	
	public void print() {
		Node tempNode = head;
		while(tempNode != null) {
			System.out.println(tempNode.value);
			tempNode = tempNode.next;
		}
	}
	
	public int search(int element) {
		Node tempNode = head;
		int index = 0;
		while(tempNode != null) {
			if (tempNode.value == element)
				return index;
			tempNode = tempNode.next;
			index++;
		}
		return -1;
	}
	
	public void delete(int location) {
	
		if(location == 0) {
			head = head.next; 
			size--;
			if(size ==0) {
				tail = null;
			}
		} else if (location >= size) {
			Node tempNode = head;
			Node prevNode = head;
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
			Node tempNode = head;
			Node prevNode = head;
			while(index != location) {
				prevNode = tempNode;
				tempNode = tempNode.next;
				index++;
			}
			prevNode.next = tempNode.next;
			
		}
	}

	public void deleteAll() {
		head = null;
		tail = null;
	}
}
