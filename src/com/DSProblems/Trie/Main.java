package com.DSProblems.Trie;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		 trie.insert("leet");
		trie.insert("code");
		//trie.insert("cat");
				
		System.out.println("Longest Prefix is::" + trie.findLCP());
		
		String word = "leetcode";
		System.out.println("Word Break Dict::" + trie.worBreakDictionary(word)); 
		
	/*	trie.insert("code");
		trie.insert("codable");
		trie.insert("coding");
		trie.insert("codable");
		trie.insert("code");
		trie.insert("codable");
		trie.insert("codable");
	
	
		trie.print(trie.root);
		
		System.out.println(trie.findKfrequentWords(4));
		
		System.out.println(trie.findLCP());*/
		
	}

}
