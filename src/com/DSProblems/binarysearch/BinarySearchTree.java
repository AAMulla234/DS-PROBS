package com.DSProblems.binarysearch;

public class BinarySearchTree {
    private BinaryNode root;

    public BinaryNode insert(BinaryNode node, int data) {
        if(node == null) {
            node = new BinaryNode(data);
            return node;
        } else if(data <= node.data) {
            node.left = insert(node.left, data);
            return node;
        } else {
            node.right = insert(node.right, data);
            return node;
        }
    }
    
    public void insert(int value) {
		BinaryNode newNode = this.insert(root, value);
		if(root == null) {
			root = newNode;
		}
	}

    public BinaryNode minimumNode(BinaryNode node) {
		if (node.left == null)
			return node;
		else
			return minimumNode(node.left);
	}

    public BinaryNode maximumNode(BinaryNode node) {
		if (node.right == null)
			return node;
		else
			return maximumNode(node.right);
	}

    public static void main(String[] args) {
        int[] arr = new int[]{10, 13, 15, 5, 6, 7, 9};

        BinarySearchTree bst = new BinarySearchTree();
         
        for(int i=0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }

        System.out.println("Minimum number is::" + bst.minimumNode(bst.root).data);
        System.out.println("Maximum number is::" + bst.maximumNode(bst.root).data);
    }

}
