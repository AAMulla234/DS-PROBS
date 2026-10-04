package com.DSProblems.Hash;

public class Main {

	public static void main(String[] args) {
		DirectChaining dc = new DirectChaining(15);
		dc.insert("The");
		dc.insert("quick");
		dc.insert("brown");
		dc.insert("fox");
		dc.insert("over");
		dc.insert("moon");
		dc.insert("moon");
		
		dc.displayHashTable();
		
		dc.delete("moon");
		
		dc.displayHashTable();
		
		System.out.println("-------------------------Linear Probing----------------------------------------");
		LinearProbing lp = new LinearProbing(13);
		lp.insert("The");
		lp.insert("quick");
		lp.insert("brown");
		lp.insert("fox");
		lp.insert("over");
		lp.insert("moon");
		lp.insert("moon");
		lp.displayHashTable();
		
		System.out.println("Delete ----------------------------------------");
		lp.delete("brown");
		
		lp.displayHashTable();
		
	}

}
