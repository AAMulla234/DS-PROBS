package com.DSProblems.TreeDS.BinaryHeap;

public class Main {

	public static void main(String[] args) {
		 BinaryHeap bp = new BinaryHeap(5); 
		 bp.insert(10, "Min");
		 bp.insert(5, "Min");
		 bp.insert(15, "Min");
		 bp.insert(1, "Min");
		 bp.levelOrder();
		 
		 System.out.println(" Extracting Head..................");
		// bp.extractHeadBH("Max");
		 bp.levelOrder();
	}

}
