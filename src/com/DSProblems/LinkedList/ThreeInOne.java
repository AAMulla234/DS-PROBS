package com.DSProblems.LinkedList;

public class ThreeInOne {
	  private int numberOfStacks = 3;
	  private int stackCapacity;
	  private int[] values;
	  private int[] sizes;

	  public ThreeInOne(int stackSize) {
	    stackCapacity = stackSize;
	    values = new int[stackSize];
	    sizes = new int[numberOfStacks];
	  }

	  // isFull
	  public boolean isFull(int stackNum) {
	    int size = sizes[stackNum-1];
	    
	    if (size == (stackCapacity/numberOfStacks)){
	        System.out.println("Stack " + stackNum + "is full");
	        return false;
	    }
	    return true;
	  }

	  // isEmpty
	  public boolean isEmpty(int stackNum) {
	    int size = sizes[stackNum-1];

	    if (size == 0){
	        System.out.println("Stack " + stackNum + "is empty");
	        return true;
	    }
	    return false;
	  }

	  // indexOfTop - this is helper method for push, pop and peek methods

	  private int indexOfTop(int stackNum) {
	    if( stackNum == 1){
	        return 0;
	    } else if(stackNum == 2){
	        return stackCapacity/3;         
	    } else if(stackNum == 3){
	        return (stackCapacity*2)/3;
	    } else {
	        System.out.println("Invalid stackNum");
	        return -1;
	    }
	  }

	  // push
	  public void push(int stackNum, int value) {
	    int topIndex = indexOfTop(stackNum);
	    int size = sizes[stackNum-1];
	    
	    if (isFull(stackNum)) {
	        return;
	    }
	    
	    values[topIndex + size] = value;
	    size++;
	  }

	  // pop
	  public int pop(int stackNum) {
	    int size = sizes[stackNum-1];
	    
	    if (isEmpty(stackNum)){
	        System.out.println("Stack " + stackNum + "is empty");
	        return -1;
	    }
	    int topIndex = indexOfTop(stackNum);
	    
	    int result = values[topIndex + size];
	    size--;
	    return result;
	  }

	  // peek

	  public int peek(int stackNum) {
	        if (isEmpty(stackNum)){
	             System.out.println("Stack " + stackNum + "is empty");
	            return -1;
	        }
	    int size = sizes[stackNum-1];
	    int topIndex = indexOfTop(stackNum);
	    return values[topIndex+size];
	  }

}

