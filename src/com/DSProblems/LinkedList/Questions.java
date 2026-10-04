package com.DSProblems.LinkedList;

import java.util.HashSet;

public class Questions {

	public void deleteDups(LinkedList ll) {
        Node current = ll.head;
        Node prev = null;
        HashSet<Integer> hs = new HashSet<Integer>();
        while (current != null) {
            int value = current.value;
            if(hs.contains(value)) {
                prev.next = current.next;
                ll.size--;
            } else
            {
                hs.add(value);
                prev = current;
            }
            current = current.next;
        }
	}
	
	public Node nthToLast(LinkedList ll, int k){
		   if (k > ll.size) {
			   throw new IllegalArgumentException();
		   }
		
	       Node ptr1 = ll.head;
	       Node ptr2 = ll.head;
	       
	       while(k != 0) {
	    	   ptr2 = ptr2.next;
	    	   k--;
	       }
	       
	       while(ptr2 != null) {
	    	   ptr1 = ptr1.next;
	    	   ptr2 = ptr2.next;
	       }
	
	       return ptr1;
	  }
	
	public Node partition(LinkedList ll, int x) {
		Node currentNode = ll.head;
		
		
		Node node = new Node();
		node.value = currentNode.value;
		node.next = null;
		Node tail = node;
		currentNode = currentNode.next;
		
		while(currentNode != null) {
			Node newNode = new Node();
			newNode.value = currentNode.value;
			if (currentNode.value < x) {
				newNode.next = node;
			} else {
				node.next = newNode;
				newNode.next = null;
			}
			currentNode = currentNode.next;
		}
		return node;
	}
	
	public LinkedList sum(LinkedList ll1, LinkedList ll2) {
		if (ll1.size == 0 || ll2.size ==0)
			return null;
		
		LinkedList ll3 = new LinkedList();
		Node node1 = ll1.head;
		Node node2 = ll2.head;
		int carry = 0;
		int first = 0;
		while (node1 != null || node2 != null) {
			int sum = carry;
			
			if(node1 != null) {
				sum += node1.value;
				node1 = node1.next;
			}
			if(node2 != null) {
				sum += node2.value;
				node2 = node2.next;
			}
			if (first ==0)
				ll3.createLL(sum%10);
			else
				ll3.insertNode(sum%10);
			carry = sum/10;
			first++;
		}
		return ll3;
	}
	
	 public Node findIntersection(LinkedList ll1, LinkedList ll2) {
		    int nToSkip = 0;
		    Node node1 = ll1.head;
		    Node node2 = ll2.head;
		    
		      if (ll1.size > ll2.size){
		          nToSkip = ll1.size - ll2.size;
		          while (nToSkip != 0){
		              node1 = node1.next;
		              nToSkip--;
		          }
		      } else {
		         nToSkip = ll2.size - ll1.size;
		         while (nToSkip != 0){
		              node2 = node2.next;
		              nToSkip--;
		          }
		      }
		      
		      while (node1 != null || node2 != null){
		          if (node1 == node2){
		              return node1;
		          } else{
		              if (node1 != null)
		                node1 = node1.next;
		              if (node2 != null)
		                node2 = node2.next;
		          } 
		      }
		      return null;
	 }
	 
	  public void rotate(LinkedList ll, int number) {
		  Node head = ll.head;
	      if (head == null ||  number > ll.size || number <= 0){
	          return;
	      }
	      
	       
	      Node node = head;
	        while ((number-1) != 0){
	            node = node.next; 
	            number--;
	        }
	 
	      if (node.next == null)
	    	  return;
	        
	      Node point2 = node.next;
	      node.next = null;
	      ll.tail.next = head;
	      ll.head = point2;
	    
	  }
	  
	  /**
	   * Using two point approach Fast and slow
	   * */
	  public int getMiddle(LinkedList ll) {
		  if (ll.head == null || ll.size < 2)
			  return -1;
		  Node slow = ll.head;
		  Node fast = ll.head;

		  while(fast != null && fast.next != null) {
			  fast = fast.next.next;
			  slow = slow.next;
		  }
		  return slow.value;
	  }
	  
	  public boolean findCircleInList(CircularLinkedList ll) {
		  Node fast = ll.head;
		  Node slow = ll.head;
		  
		  while(slow != null && fast != null && fast.next != null) {
			  slow = slow.next;
			  fast = fast.next.next;
			  
			  if(slow == fast)
				  return true;
		  }
		  
		  return false;
	  }
	  
	  public void reverseGroup(DoublyLinkedList ll, int k) {
		  DNode node = ll.head;
		  DNode head = ll.head;
		  
		  while ((k-1) > 0) {
			node = node.next;
			k--;
		  }
		  
		 DNode newHead = node;
		 head.prev = head.next;
		 head.next = node.next;
		 newHead.next = node.prev;
		 newHead.prev = null;
		 

		 while(node != head) {
			 node = node.next;
			 DNode temp = node.next;
			 node.next = node.prev;
			 node.prev = temp;	 
		 } 
		 
		 while (newHead != null) {
			 System.out.println(newHead.value);
			 newHead = newHead.next;
		 }
	  }
	  
	  public Node mergeTwoLists(Node list1, Node list2) {
		  Node prev = null;
		  while(list1 != null && list2 != null) {
			  System.out.println(list1.value + " : " + list2.value);
			 if (list1.value == list2.value) {
				   Node newNode = new Node();
				   newNode.value = list2.value;
				   newNode.next = list1.next;
				   list1.next = newNode;
				   list1 = list1.next.next;
				   prev = newNode;
				   list2 = list2.next;
			  } else if (list1.value > list2.value) {
				  Node newNode = new Node();
				  newNode.value = list2.value;
				  newNode.next = list1;
				  if (prev != null) {
					  prev.next = newNode;
					  prev = newNode;
				  }else {
					  prev = newNode;
				  }
				  list2 = list2.next;
			  } else {
				  list1 = list1.next;
				  prev = list1;
			  }
		  }
		  
		  return list1;
	  }
}
