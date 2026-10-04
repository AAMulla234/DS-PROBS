package com.DSProblems.LinkedList;

import java.util.Stack;

public class DoublyFlattenList {
	
	DCNode head;
	
	public void createDLL(int nodeValue) {
		DCNode node = new DCNode();
		node.val = nodeValue;
		node.prev = null;
		node.next = null;
		head = node;
	}
	
	public void insert(DCNode node, boolean child, int nodeValue) {
		if (head == null) {
			createDLL(nodeValue);
			return;
		}
		DCNode newNode = new DCNode();
		newNode.val = nodeValue;
		newNode.prev = null;
		newNode.next = null;
		newNode.child = null;
		
		
	    if (child) {
	    	node.child = newNode;
	    } else {
	    	node.next = newNode;
	    	newNode.prev = node;
	   }
	}
	
	public static void main(String[] args) {
		DoublyFlattenList dd = new DoublyFlattenList();
		dd.createDLL(1);
		
		DCNode node = dd.head;
		dd.insert(node, false, 2);
		
		node = node.next;
		dd.insert(node, false, 3);
		
		node = node.next;
		dd.insert(node, true, 7);
		
		DCNode sChild = node.child;
		dd.insert(sChild, false, 8);
		
		
		sChild = sChild.next;
		dd.insert(sChild, false, 9);
	
				
		DCNode sNext = sChild.next;
		dd.insert(sNext, false, 10);
		
		dd.insert(sChild, true, 11);
		
		sChild = sChild.child;
		dd.insert(sChild, false, 12);
		
		
		dd.insert(node, false, 4);
		node = node.next;
		dd.insert(node, false, 5);
		node = node.next;
		dd.insert(node, false, 6);
		
		
				
		dd.preOrder(dd.head);
		System.out.println("\n\n\n");
		//dd.flattern(dd.head);
		//dd.preOrder(dd.head);
		dd.flatternWithStack(dd.head);
		while (dd.head != null) {
			System.out.print(dd.head.val + ", ");
			dd.head = dd.head.next;
		} 
		
		
	}
	
	public void preOrder(DCNode node) {
		if(node == null)
			return;
		
		System.out.print(node.val + ", ");
		preOrder(node.child);
		preOrder(node.next);
	}
	
	public void flattern(DCNode head) {
		flatternNode(head, head);
	}
	
	public DCNode flatternNode(DCNode last, DCNode curr) {
		if (curr.child != null) {
			 last = flatternNode(last, curr.child);
			 System.out.println(last.val);
			 System.out.println(curr.val);
			 
			 last.next = curr.next;
			 curr.next = curr.child;
			 curr.child.prev = curr;
			 curr.child = null;
		} else if(curr.next == null) {
			return curr;
		}
		
		return flatternNode(last, curr.next);
	}
	
	
	public void flatternWithStack(DCNode node) {
		if (node == null)
			return;
		
		Stack<DCNode> stack = new Stack<DCNode>();
		
		while(node != null) {
			if(node.child != null) {
				stack.push(node);
				node = node.child;
			} else {
				node = node.next;
			}
		}
		
		while(!stack.isEmpty()) {
			DCNode curr = stack.pop();
			DCNode currNext = curr.next;
			curr.next = curr.child;
			curr.child.prev = curr;
			
			DCNode childNext = curr.child.next;
			while(childNext.next != null) {
				childNext = childNext.next;
			}
			childNext.next = currNext;
			curr.child = null;
		}
	}
	

}
