package com.DSProblems.LinkedList;

import java.util.Stack;

public class QueueViaStack {
 
	static class Queue {
		Stack<Integer> stack1;
	    Stack<Integer> stack2;
	}
    
    public static void push(Stack<Integer> stack, Integer value) {
    	stack.push(value);
    }
    
    public static Integer pop(Stack<Integer> stack) {
    	if (stack.isEmpty())
    		return -1;
    	return stack.pop();
    }
    
    public static void enQueue(Stack<Integer> stack, Integer value) {
    	push(stack, value);
    }
    
    public static Integer deQueue(Queue queue) {
    	Integer result = null;
    	if(queue.stack1.isEmpty() && queue.stack2.isEmpty())
    		return -1;
    	if (queue.stack2.isEmpty()) {
            while (!queue.stack1.isEmpty()) {
                result = pop(queue.stack1);
                push(queue.stack2, result);
            }
        }
    	result = pop(queue.stack2);
    	return result;
    }
    
    public static void main(String[] args) {
    	Queue q  = new Queue();
    	q.stack1 = new Stack<Integer>();
    	q.stack2 = new Stack<Integer>();
    	
    	enQueue(q.stack1, 1);
        enQueue(q.stack1, 2);
        enQueue(q.stack1, 3);
        
        
        System.out.println(deQueue(q));
        System.out.println(deQueue(q));
 
    }
}