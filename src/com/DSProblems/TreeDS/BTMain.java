package com.DSProblems.TreeDS;

public class BTMain {

	public static void main(String[] args) {
		
		 BTreeArr btArr = new BTreeArr(9);
		 btArr.insert("N1");
		 btArr.insert("N2");
		 btArr.insert("N3");
		 btArr.insert("N4");
		 btArr.insert("N5");
		 btArr.insert("N6");
		 btArr.insert("N7");
		 btArr.insert("N8");
		 btArr.insert("N9");
		 btArr.preOrder(1);
		 System.out.println();
		 btArr.inOrder(1);
		 System.out.println();
		 btArr.postOrder(1);
		 System.out.println();
		 btArr.levelOrder(1);
		 System.out.println();
		 
		 BinarySearchTree bst = new BinarySearchTree();
		 bst.insert(70);
		 bst.insert(40);
		 bst.insert(90);
		 bst.insert(30);
		 bst.insert(50);
		 bst.insert(60);
		 bst.insert(100);
		 bst.insert(85);
		 bst.insert(80);
		 
		 bst.preOrder(bst.root);
		 System.out.println();
		 bst.levelOrder(bst.root);
		 System.out.println();
		 bst.delete(bst.root, 70);
		 bst.levelOrder(bst.root);
		
	}

}
