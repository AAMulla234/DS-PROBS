package com.DSProblems.Hash;

import java.util.ArrayList;

public class LinearProbing {
	
	String[] hashtable;
	int usedCellNumber;
	
	public LinearProbing(int size) {
		hashtable = new String[size];
		usedCellNumber = 0;
	}
	
	public int modASCIIHash(String word, int m) {
		char ch[] =  word.toCharArray();
		int i, sum;
		for(sum=0, i=0; i< word.length(); i++) {
			sum += ch[i];
		}
		return sum%m;
	}
	
	private double getLoadFactor() {
		 double loadfactor = usedCellNumber * 1.0/hashtable.length;
		 return loadfactor;
	}

	public void rehash(String word) {
		usedCellNumber = 0;
		ArrayList<String> data = new ArrayList<String>();
		for (String s : hashtable) {
			if (s != null) {
				data.add(s);
			}
		}
		data.add(word);
		hashtable = new String[hashtable.length * 2];
		for(String s : data) {
			insert(s);
		}
	}
	
	public void insert(String word) {
		double loadFactor = getLoadFactor();
		if(loadFactor >= 0.75) {
			rehash(word);
		}else {
			int index = modASCIIHash(word, hashtable.length);
			if (hashtable[index]  == null) {
				hashtable[index] = word;
				System.out.println("Insert at index:" + index + " word: " + word);
			}else {
				for(int i = index; i< index+hashtable.length; i++) {
					int newIndex =  i % hashtable.length;
					if(hashtable[newIndex] == null) {
						hashtable[newIndex]  = word;
						System.out.println("Insert at new index:" + newIndex + " word: " + word);
						break;
					} else {
						System.out.println("Already occupied, Trying new cell");
					}
				}
			}
			
		}
		usedCellNumber++;
	}
	
	
	public void search(String word) {
		int index = modASCIIHash(word, hashtable.length);
		if(hashtable[index] != null && hashtable[index].equals(word)) {
			System.out.println("Value at index " + index);
		} else {
			for(int i = index; i< index+hashtable.length; i++) {
				int newIndex =  i % hashtable.length;
				if(hashtable[newIndex] != null && hashtable[index].equals(word)) {
					System.out.println("Value at new index " + index);
					break;
				}
			}
		}
	}
	
	public void delete(String word) {
		int index = modASCIIHash(word, hashtable.length);
		if(hashtable[index] != null && hashtable[index].equals(word)) {
			 hashtable[index] = null;
		} else {
			for(int i = index; i< index+hashtable.length; i++) {
				int newIndex =  i % hashtable.length;
				if(hashtable[newIndex] != null && hashtable[index].equals(word)) {
					hashtable[newIndex] = null;
					break;
				}
			}
		}
	}
	
	public void displayHashTable() {
		if(hashtable == null)
			System.out.println(" Hashtable is not exists");
		else {
			for(int i=0; i< hashtable.length; i++) {
				System.out.println("Index " + i + " key " + hashtable[i]);
			}
		}
	}
}
