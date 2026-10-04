package com.DSProblems.Trie;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Trie {

	public TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	// TODO: Find all words matching a pattern in the given dictionary, example

	
	public void insert(String word) {
		TrieNode currentNode = root;
		
		for(int i =0; i< word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = currentNode.charaters.get(ch);
			if(node == null) {
				node = new TrieNode();
				currentNode.charaters.put(ch, node);
			}
			currentNode = node;
		}
		currentNode.endOfString = true;
		currentNode.count++;
		currentNode.key = word;
		System.out.println("Successfully added word::" + word);
	}
	
	public void print(TrieNode curr) {
		if (curr == null) {
			return;
		}
		
		for (Entry<Character, TrieNode> entry : curr.charaters.entrySet()) {
				System.out.println(entry.getKey());
				print(entry.getValue());
		}
	}
	
	public boolean search(String word) {
		TrieNode currentNode = root;
		
		for(int i =0; i< word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = currentNode.charaters.get(ch);
			if(node == null) {
				System.out.println("The word " + word + " is not exist in this trie");
				return false;
			}
			currentNode = node;
		}
		if (currentNode.endOfString) {
			System.out.println("Word is found in this Trie");
			return true;
		} else {
			System.out.println("Word is found as prefix in this Trie but not actual word");
			return false;
		}
	}
	
	public String findLCP() {
		TrieNode curr = root;
		StringBuilder lcp = new StringBuilder();
		while (curr != null && !curr.endOfString && (curr.charaters.size() ==1)) {
			for (Entry<Character, TrieNode> entry: curr.charaters.entrySet()) {
				lcp.append(entry.getKey());
				curr = entry.getValue();
			}
		}
		return lcp.toString();
	}
	
	private boolean searchSubString(String word, TrieNode currentNode) {
		for(int i =0; i< word.length(); i++) {
			char ch = word.charAt(i);
			System.out.println(ch);
			TrieNode node = currentNode.charaters.get(ch);
			if(node == null) {
				System.out.println("return false");
				return false;
			}
			currentNode = node;
			if (node.endOfString) {
				System.out.println(word + ":" + i);
				searchSubString(word.substring(i+1), root);
			}
		}
		return true;
	}
	
	// https://leetcode.com/problems/word-break/description/
	public boolean worBreakDictionary(String word) {
		TrieNode currentNode = root;
		return searchSubString(word, currentNode);
	}
	
	
	private static void preorder(TrieNode curr, PriorityQueue<TrieNode> pq) {
		if (curr == null) {
			return;
		}

		for (Entry<Character, TrieNode> entry : curr.charaters.entrySet()) {
			// if a leaf node is reached (leaf nodes have a non-zero count),
			// push the key with its frequency in max-heap
			if (entry.getValue().count != 0) {
				pq.add(entry.getValue());
			}

			// recur for current node's charaters
			preorder(entry.getValue(), pq);
		}
	}
	
	public String findKfrequentWords(int k) {
		PriorityQueue<TrieNode> pq = new PriorityQueue<TrieNode>(Comparator.reverseOrder());
		TrieNode currentNode = root;
		preorder(currentNode, pq);
		
		while(!pq.isEmpty()) {
			TrieNode max = pq.poll();
			
			if (max.count == k) {
				return max.key;
			}
       }
		return null;
	}
	
}
