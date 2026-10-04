package com.DSProblems.SortAlgo;

public class MergeSortLL {
	
	node head = null;

	static class node {
		int val;
		node next;

		public node(int val) {
			this.val = val;
		}
	}

	void push(int new_data) {
		node new_node = new node(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	private node sortedList(node left, node right) {
		node result = null;
		
		if(left == null)
			return right;
		if(right == null)
			return left;
		
		if(left.val <= right.val) {
			result = left;
			result.next = sortedList(left.next, right);
		}else {
			result = right;
			result.next = sortedList(left, right.next);
		}
		return result;
	}
	
	
	public node mergeSort(node head) {
		if (head == null || head.next == null)
			return head;
		node middle = getMiddle(head);  // find the middle one to divide list in halve
		node nextOfMiddle = middle.next; // next half
		
		middle.next = null;
		
		node left = mergeSort(head);   // do this until reach to end of element
		node right = mergeSort(nextOfMiddle); 
		
		node sortedList = sortedList(left, right); // compare and conquer 
		
		return sortedList;
	}


	private node getMiddle(node head) {
		if(head == null)
			return head;
		
		node slow = head;
		node fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public void printList(node headref) {
		while (headref != null) {
			System.out.print(headref.val + " ");
			headref = headref.next;
		}
	}
	

}
