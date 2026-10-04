package com.DSProblems.TreeDS;

public class TreeMain {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode("Drink");
	
		TreeNode hot = new TreeNode("Hot");
		TreeNode cold = new TreeNode("Cold");
		
		TreeNode tea = new TreeNode("Tea");
		TreeNode coffee = new TreeNode("Coffee");
		
		TreeNode wine = new TreeNode("Wine");
		TreeNode limka = new TreeNode("Limka");
		
		
		tree.addChild(cold);
		tree.addChild(hot);
	
		hot.addChild(tea);
		hot.addChild(coffee);
		
		cold.addChild(wine);
		cold.addChild(limka);
		
		System.out.println(tree.print(0));
		
		
		BinaryTreeLL binaryTreeLL = new BinaryTreeLL();
		BinaryTree N1 = new BinaryTree(1);
		BinaryTree N2 = new BinaryTree(2);
		BinaryTree N3 = new BinaryTree(3);
		BinaryTree N4 = new BinaryTree(4);
		BinaryTree N5 = new BinaryTree(5);
		BinaryTree N6 = new BinaryTree(6);
		BinaryTree N7 = new BinaryTree(7);
		BinaryTree N8 = new BinaryTree(8);
		BinaryTree N9 = new BinaryTree(9);
		
		
		N1.left = N2;
		N1.right = N3;
		
		N2.left = N4;
		N2.right = N5;
		
		N3.left = N6;
		N3.right = N7;
		
		N4.left = N8;
		N4.right = N9;

		binaryTreeLL.root = N1;
		System.out.println("Pre Order Binary Tree");
		binaryTreeLL.preOrder(binaryTreeLL.root);
		System.out.println();
		System.out.println("In Order Binary Tree");
		binaryTreeLL.inOrder(binaryTreeLL.root);
		System.out.println();
		System.out.println("Post Order Binary Tree");
		binaryTreeLL.postOrder(binaryTreeLL.root);
		
		System.out.println();
		System.out.println("Level Order Binary Tree");
		binaryTreeLL.levelOrder(binaryTreeLL.root);
		System.out.println();
		binaryTreeLL.search(8);
		
		System.out.println();
		binaryTreeLL.insert(10);
		System.out.println();
		System.out.println("DeepestNode is::" + binaryTreeLL.findDeepestNode().data);
		
		binaryTreeLL.levelOrder(binaryTreeLL.root);
		System.out.println();
		binaryTreeLL.delete(4);
		binaryTreeLL.levelOrder(binaryTreeLL.root);
		
		  Integer num1 = 100;
		  Integer num2 = 100;
		  if(num1==num2){
		   System.out.println("num1 == num2");
		  } else {
			  System.out.println("num1 != num2");
		  }
		
	}
}
