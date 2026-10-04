package com.DSProblems.TreeDS;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	BinaryTree root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	private BinaryTree insert(BinaryTree currentNode, int value) {
		if (currentNode  == null) {
			BinaryTree newNode = new BinaryTree(value);
			System.out.println("Inserted successfully");
			return newNode;
		} else if (value <= currentNode.data) {
			currentNode.left = insert(currentNode.left, value);
			return currentNode;
		} else {
			currentNode.right = insert(currentNode.right, value);
			return currentNode;
		}
	}
	
	
	public void insert(int value) {
		BinaryTree newNode = this.insert(root, value);
		if(root == null) {
			root = newNode;
		}
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
	
	
	public BinaryTree search(BinaryTree node, int value) {
		if (node == null) {
			System.out.println("Element is not exist in Tree");
			return null;
		} else if(node.data == value) {
			System.out.println("Element is found");
			return node;
		} else if(value < node.data) {
			return search(node.left, value);
		} else {
			return search(node.right, value);
		}
	}
	
	private BinaryTree minimumNode(BinaryTree node) {
		if (node.left == null)
			return node;
		else
			return minimumNode(node.left);
	}
	
	public BinaryTree delete(BinaryTree root, int value) {
		if (root == null) {
			System.out.println("Value is not found in BST");
			return null;
		}
		
		if(value < root.data) {
			root.left = delete(root.left, value);
		} else if (value > root.data) {
			root.right = delete(root.right, value);
		} else {
			// Found the value to delete. Now implement 3 cases here
			// 1. If node has 2 child. Find the last minimum node from right
			// 2. if node has 1 child. root = left or right
			// 3. if node has no child. hence a leaf node
			if (root.left != null && root.right != null) {
				BinaryTree temp = root;
				BinaryTree miniOfRightNode = minimumNode(temp.right);
				root.data = miniOfRightNode.data;
				root.right = delete(root.right, miniOfRightNode.data);
			} else if (root.left != null) {
				root = root.left;
			} else if (root.right != null) {
				root = root.right;
			} else {
				root = null;
			}
		}
		return root;
	}
	
}
