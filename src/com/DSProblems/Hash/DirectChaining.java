package com.DSProblems.Hash;

import java.util.LinkedList;

public class DirectChaining {
	
	LinkedList<String>[] hashTable;
	int maxChainSize =5;
	
	DirectChaining(int size) {
		hashTable = new LinkedList[size];
	}
	
	public int modASCIIHash(String word, int m) {
		char ch[] =  word.toCharArray();
		int i, sum;
		for(sum=0, i=0; i< word.length(); i++) {
			sum += ch[i];
		}
		return sum%m;
	}

	public void insert(String word) {
		int index = modASCIIHash(word, hashTable.length);
		
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList<String>();
			hashTable[index].add(word);
		} else {
			hashTable[index].add(word);
		}
	}
	
	public void displayHashTable() {
		if(hashTable == null)
			System.out.println(" Hashtable is not exists");
		else {
			for(int i=0; i< hashTable.length; i++) {
				System.out.println("Index " + i + " key " + hashTable[i]);
			}
		}
	}
	
	public boolean search(String word) {
		int index = modASCIIHash(word, hashTable.length);
		if(hashTable[index] != null && hashTable[index].contains(word)) {
			System.out.println("Word is at index " + index);
			return true;
		} else 
			return false;
	}
	
	public void delete(String word) {
		int index = modASCIIHash(word, hashTable.length);
		if(search(word)) {
			hashTable[index].remove(word);
		}else 
			System.out.println("Value is not found in hashtable");
		
	}
	
}
