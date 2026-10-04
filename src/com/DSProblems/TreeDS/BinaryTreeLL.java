package com.DSProblems.TreeDS;

import java.util.Queue;

import java.util.LinkedList;

public class BinaryTreeLL {
	
	BinaryTree root;
	
	public BinaryTreeLL() {
		this.root = null;
	}
	
	public void preOrder(BinaryTree node) {
		if(node == null)
			return;
		
		System.out.print(node.data + ", ");
		preOrder(node.left);
		preOrder(node.right);
	}

	
	public void inOrder(BinaryTree node) {
		if(node == null)
			return;
		
		inOrder(node.left);
		System.out.print(node.data + ", ");
		inOrder(node.right);
	}
	
	public void postOrder(BinaryTree node) {
		if(node == null)
			return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + ", ");
		
	}
	
	public void levelOrder(BinaryTree node) {
		if(node == null)
			return;
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(node);
		while(!queue.isEmpty()) {
			 BinaryTree presentNode = queue.remove();
			 System.out.print(presentNode.data + ", ");
			 if (presentNode.left != null) {
				 queue.add(presentNode.left);
			 }
			 if (presentNode.right != null) {
				 queue.add(presentNode.right);
			 }
		}	
	}
	
	public void search(int value) {
		if(this.root == null) {
			System.out.print("Tree is empty...no data found");
			return;
		}
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(this.root);
		while(!queue.isEmpty()) {
			 BinaryTree presentNode = queue.remove();
			 if (presentNode.data == value) {
				 System.out.print("Value is present :: " + presentNode.data);
				 return;
			 } else {
				 if (presentNode.left != null) {
					 queue.add(presentNode.left);
				 }
				 if (presentNode.right != null) {
					 queue.add(presentNode.right);
				 }
			 }
		}	
		System.out.print("No value found");
	}
	
	public void insert(int value) {
		BinaryTree newNode = new BinaryTree(value);
		if (this.root == null) {
			this.root = newNode;
			System.out.println("Added new Node to Root node");
			return;
		}
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(this.root);
		while(!queue.isEmpty()) {
			 BinaryTree presentNode = queue.remove();
			 if (presentNode.left == null) {
				 presentNode.left = newNode;
				 System.out.println("Inserted to left node of root node::" + presentNode.data);
				 break;
			 } else if(presentNode.right == null) {
				 presentNode.right = newNode;
				 System.out.println("Inserted to right node of root node::" + presentNode.data);
				 break;
			 } else {
				 queue.add(presentNode.left);
				 queue.add(presentNode.right);
			 } 
		}
	}
	
	public BinaryTree findDeepestNode() {
		if(this.root == null)
			return null;
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(this.root);
		BinaryTree presentNode = null;
		while(!queue.isEmpty()) {
			 presentNode = queue.remove();
			 if (presentNode.left != null) {
				 queue.add(presentNode.left);
			 }
			 if (presentNode.right != null) {
				 queue.add(presentNode.right);
			 }
		}
		return presentNode;
	}
	
	public void deleteDeepestNode() {
		if(this.root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(this.root);
		BinaryTree presentNode = null, prevNode = null;
		while(!queue.isEmpty()) {
			 prevNode = presentNode;
			 presentNode = queue.remove();
			 if (presentNode.left == null) {
				 prevNode.right = null;
				 System.out.println("Deleted right");
				 return;
			 } else if (presentNode.right == null) {
				 presentNode.left =  null;
				 System.out.println("Deleted left");
				 return;
			 }
			 queue.add(presentNode.left);
			 queue.add(presentNode.right);
		}
	}
	
	public void delete(int value) {
		if(this.root == null) {
			System.out.println("Tree is empty");
			return;
		}
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(this.root);
		while(!queue.isEmpty()) {
			 BinaryTree presentNode = queue.remove();
			 if (presentNode.data == value) {
				BinaryTree lastNode = this.findDeepestNode();
				presentNode.data = lastNode.data;
				this.deleteDeepestNode();
				break;
			 } else {
				 if (presentNode.left != null) {
					 queue.add(presentNode.left);
				 }
				 if (presentNode.right != null) {
					 queue.add(presentNode.right);
				 }
			 }
		}
	}
	
}
