package com.DSProblems.LinkedList;

 public class ListNode {
    Node head;
    
     public void createLL(int nodeValue) {
    	head = new Node();
 	    head.value = nodeValue;
 	    head.next = null;
 	  }

 	  public void insertNode(Node node, int nodeValue) {
 		Node newNode = new Node();
 	    newNode.value = nodeValue;
 	    newNode.next = null;
 	    node.next = newNode;
 	  }
     
 }
