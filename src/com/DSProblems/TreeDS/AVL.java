package com.DSProblems.TreeDS;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    
    BinaryTree root;
	
	public AVL() {
		root = null;
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

    //Get Height
    private int getHeight(BinaryTree node) {
        if (node == null)
            return 0;
        return node.height;
    }

    //Rotate right
    private BinaryTree rotateRight(BinaryTree disBalancedNode) {
        BinaryTree newRoot= disBalancedNode.left;
        disBalancedNode.left = disBalancedNode.left.right;
        newRoot.right = disBalancedNode;
        disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.left), getHeight(disBalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    //Rotate left
    private BinaryTree rotateLeft(BinaryTree disBalancedNode) {
        BinaryTree newRoot= disBalancedNode.right;
        disBalancedNode.right = disBalancedNode.right.left;
        newRoot.left = disBalancedNode;
        disBalancedNode.height = 1 + Math.max(getHeight(disBalancedNode.left), getHeight(disBalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private int getBalance(BinaryTree node) {
        if(node  == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }



}
