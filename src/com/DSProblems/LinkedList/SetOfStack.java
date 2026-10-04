package com.DSProblems.LinkedList;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStack {

	public ArrayList<PlateStack> stacks = new ArrayList<PlateStack>();
	public int capacity;
	
	public SetOfStack(int capacity) {
		this.capacity = capacity;
	}
	
	public PlateStack getLastStack() {
		if (stacks.size() == 0)
			return null;
		return stacks.get(stacks.size()-1);
	}
	
	public void push(int value) {
		PlateStack lastStack = getLastStack();
		if (lastStack != null && !lastStack.isStackFull()) {
			lastStack.push(value);
			return;
		}
		PlateStack stack = new PlateStack(capacity);
		stack.push(value);
		stacks.add(stack);
	}

	public int pop() {
		PlateStack lastStack = getLastStack();
	
		if(lastStack == null) {
			throw new EmptyStackException();
		}
		int result = lastStack.pop();
		if(lastStack.size == 0) {
			stacks.remove(stacks.size()-1);
		}
		return result;
	}
}
