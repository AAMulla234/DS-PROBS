package com.DSProblems.LinkedList;

public class Main {

	public static void main(String[] args) {
		/*SingleLinkedList sl = new SingleLinkedList();
		sl.createSingleLinkedList(2);
		sl.insert(1, 0);
		sl.insert(3, 2);
		sl.insert(4, 2);
		sl.print();
		System.out.println("Element is at index::" + sl.search(4));
		sl.delete(1);
		sl.print();
		sl.deleteAll();
		sl.print();
		System.out.println("******************Circular List***********************");
		
		CircularLinkedList cll = new CircularLinkedList();
		cll.createCLL(1);
		cll.insert(2, 1);
		cll.insert(3, 2);
		cll.insert(4, 3);
		cll.print();
		System.out.println("Element found at::" + cll.search(3));
		cll.delete(4);
		cll.print();
		
		System.out.println("******************Double List***********************");
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.createDLL(7);
		dll.insert(1, 8);
		dll.insert(2, 9);
		dll.insert(2, 10);
		dll.insert(4, 11);
		dll.insert(5, 12);
		
		dll.print();
		System.out.println("******************Delete Double List***********************");
		
		dll.delete(6);
		dll.print();
		System.out.println("****************Reverse Print****************");
		dll.reversePrint();
		
		System.out.println("****************Circular Double List****************");
		CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
		cdll.createCDLL(11);
		cdll.insert(1, 12);
		cdll.insert(2, 13);
		cdll.insert(7, 19);
		cdll.insert(5, 17);
		cdll.insert(3, 14);
		cdll.insert(4, 15);
		cdll.print();
		System.out.println("****************Delete Circular Double List****************");
		cdll.delete(2);
		cdll.print(); */
		
		
		/***************Remove Dupblicates*******************/
	/*	LinkedList ll = new LinkedList();
		ll.createLL(2);
		ll.insertNode(1);
		ll.insertNode(2);
		ll.insertNode(1);
		ll.insertNode(3);
		ll.insertNode(4);
		ll.insertNode(5);
		ll.insertNode(4);
		ll.traversalLL();
		System.out.println();
		Questions quest = new Questions();
		//quest.deleteDups(ll);
		//ll.traversalLL();
		
		System.out.println("4th element from the last is:" + quest.nthToLast(ll, 4).value);
//		Node node = quest.partition(ll, 4);

		LinkedList ll1 = new LinkedList();
		ll1.createLL(7);
		ll1.insertNode(6);
		ll1.insertNode(5);
		ll1.insertNode(3);
		ll1.insertNode(2);
		
		
		LinkedList ll2 = new LinkedList();
		ll2.createLL(7);
		ll2.insertNode(4);
		ll2.insertNode(9);
		ll2.insertNode(5);
		ll2.insertNode(7);
		
		System.out.println("********************Additions************************");
		LinkedList ll3 = quest.sum(ll1, ll2);
		
		ll3.traversalLL();
		System.out.println();
		System.out.println("********************Rotate************************");
		LinkedList ll4 = new LinkedList();
		ll4.createLL(7);
		ll4.insertNode(4);
		ll4.insertNode(9);
		ll4.insertNode(5);
		ll4.traversalLL();
		quest.rotate(ll4, 3);
		System.out.println();
		ll4.traversalLL();
		System.out.println();
		System.out.println("********************Stack************************");
		LinkedList ll5 = new LinkedList();
		ll5.createLL(7);
		Stack stack = new Stack();
		stack.push(ll5, 5);
		stack.push(ll5, 6);
		stack.pop(ll5);
		System.out.println("Peek...." + stack.peek(ll5).value);
		stack.push(ll5, 8);
		stack.push(ll5, 12);
		//stack.pop(ll5);
		stack.push(ll5, 17);
		stack.push(ll5, 19);
		stack.push(ll5, 15);
		stack.push(ll5, 1);
		stack.push(ll5, 4);
		stack.push(ll5, 27);
		stack.push(ll5, 47);
		stack.push(ll5, 7);
		stack.push(ll5, 40);
		//stack.pop(ll5);
		//stack.pop(ll5);
		System.out.println();
		ll5.traversalLL();
		System.out.println();
		System.out.println("Middle one is......" + quest.getMiddle(ll5));
		
		DoublyLinkedList dll2 = new DoublyLinkedList();
		dll2.createDLL(1);
		dll2.insert(1, 2);
		dll2.insert(2, 3);
		dll2.insert(3, 4);
		dll2.insert(4, 5);
		
		dll2.print();
		System.out.println("*********Reversing***************");
		
		quest.reverseGroup(dll2, 4); */
		
		
		ListNode list1 = new ListNode();
		list1.createLL(2);
		Node node1 = list1.head;
		list1.insertNode(node1, 4);
		list1.insertNode(node1.next, 5);
		
		
			
		ListNode list2 = new ListNode();
		list2.createLL(1);
		Node node2 = list2.head;
		list2.insertNode(node2, 2);
		list2.insertNode(node2.next, 4);
		Questions quest = new Questions();
		quest.mergeTwoLists(node1, node2);
		
		while(node1 != null) {
			System.out.println(node1.value);
			node1 = node1.next;
		}
		
	}

}
