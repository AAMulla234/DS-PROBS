package com.DSProblems.LinkedList;

public class StackMain {

	public static void main(String[] args) {
		StackMin stack = new StackMin();
		stack.push(20);
		stack.push(16);
		stack.push(15);
		stack.push(14);
	
		stack.pop();
		
		System.out.println("Minimum is ::" + stack.min());
		
		SetOfStack plateStack = new SetOfStack(3);
		plateStack.push(1);
		plateStack.push(2);
		plateStack.push(3);
		plateStack.push(4);
		plateStack.push(5);
		System.out.println(plateStack.stacks.size());
		System.out.println("Pop is ::" + plateStack.pop());
		System.out.println("Pop is ::" + plateStack.pop());
		System.out.println(plateStack.stacks.size());
	}

}
