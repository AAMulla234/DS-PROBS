package com.DSProblems.LinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class StackViaQueue {
	
	static class Stack {
		Queue<Integer> queue1;
		Queue<Integer> queue2;
	}
	
	
	public static void push(Stack s, Integer value) {
		if (s.queue1 == null) {
			s.queue1 = new LinkedList<Integer>();
			s.queue1.offer(value);
		} else {
			s.queue2 = new LinkedList<Integer>();
			while (!s.queue1.isEmpty()) {
				s.queue2.offer(poll(s.queue1));
			}
			s.queue1.offer(value);
			while (!s.queue2.isEmpty()) {
				s.queue1.offer(poll(s.queue2));
			}
		}
	}
	
	public static Integer pop(Stack s) {
		if(s.queue1.isEmpty() && s.queue2.isEmpty())
    		return -1;
		Integer result = poll(s.queue1);
		return result;
	}
	

	private static Integer poll(Queue<Integer> queue) {
		if (queue.isEmpty())
    		return -1;
    	return queue.poll();
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.queue1 = new LinkedList<Integer>();
		stack.queue2 = new LinkedList<Integer>();

		push(stack, 10);
		push(stack, 20);
		push(stack, 30);
		push(stack, 40);

		System.out.println(pop(stack));
		System.out.println(pop(stack));
		System.out.println(pop(stack));
	}

}
