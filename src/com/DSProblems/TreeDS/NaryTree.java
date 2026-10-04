package com.DSProblems.TreeDS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class NaryTree {
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(1);
		List<Node> children = new ArrayList<Node>();
		for(int i=2; i<= 4; i++) {
			children.add(new Node(i));
			
		}

		node.children = children;
		
		
		List<Node> ch = new ArrayList<Node>();
		ch.add(new Node(5));
		ch.add(new Node(6));
	
		node.children.get(2).children = ch;
		
		
		print(levelOrder(node));
		
		System.out.println("----------------------------------------------------------\n\n");
		
		for(Integer i : postorder(node)) 
		{
			System.out.print(i + "  ");
		}
	}
	
	
	
	 public static List<Integer> postorder(Node root) {
	        List<Integer> list = new ArrayList<Integer>();
	        postorder(root, list);
	        return list;
	 }
	 
	 private static void postorder(Node node, List<Integer> list) {
		 if(node == null) {
			 return;
		 }
		 if (node.children != null) {
			 for(Node child : node.children) {
				 postorder(child, list);
			 }
		 }
		 list.add(node.val);
	 }
	 
	 
	 
	
	public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> stack =  new Stack<Node>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
        	Node node = stack.pop();
        	list.add(node.val);
        	
        	for(int idx= node.children.size()-1; idx >=0; idx--) {
        		stack.push(node.children.get(idx));
        	}
        }
        return list;
    }
	
	
	 public static List<List<Integer>> levelOrder(Node root) {
	        Queue<Node> queue = new  LinkedList<Node>();
	        Queue<Node> nQueue = new  LinkedList<Node>();
	        List<Integer> subNodes = new ArrayList<Integer>();
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	     
	        
	        queue.add(root);
	        
	        int i=0;
	        while(!queue.isEmpty()) {
	            Node node = queue.remove();
	            subNodes.add(node.val);
	         
	            if (node.children != null) {
	            	for(Node c: node.children) {
	            		nQueue.add(c);
	            	}
	            }
	         
	            if(queue.isEmpty() && !nQueue.isEmpty()) {
	            	System.out.println("Step " + i);
	            	queue.addAll(nQueue);
	            	list.add(subNodes);
	            	
	            	nQueue = new LinkedList<Node>();
	            	subNodes = new ArrayList<Integer>();
	            }
	            i++;
	        }
	        list.add(subNodes);
	        
	        return list;
	    }
	 
	 private static void print(List<List<Integer>> list) {
		 for(List<Integer> clist: list) {
			 for(Integer c : clist) {
				 System.out.print(c + "  ");
			 }
		 }
	 }

}
