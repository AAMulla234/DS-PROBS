package com.DSProblems.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode implements Comparable<TrieNode> {
	
	Map<Character, TrieNode> charaters;
	boolean endOfString;
	int count =0;
	String key = null;
	
	public TrieNode() {
		charaters = new HashMap<Character, TrieNode>();
		endOfString = false;
	}

	  @Override
	    public int compareTo(TrieNode o)
	    {
		  TrieNode node = (TrieNode)o;
	        return count - node.count;
	    }
}
