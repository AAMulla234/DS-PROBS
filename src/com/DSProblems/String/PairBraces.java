package com.DSProblems.String;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PairBraces {

	public static void main(String[] args) {
		String inputString = "(]";//Need to check whether this string is balance parenthesis string
		System.out.println("Result:::"+isBalancedInput(inputString));

	}

	private static boolean isBalancedInput(String inputString) {
		Stack<Character> stack = new Stack<Character>();
		Map<Character, Character> braces = new HashMap<Character, Character>();
		braces.put('(', ')');
		braces.put('[', ']');
		braces.put('{', '}');
		
		for(int i=0; i < inputString.length(); i++){
			if (inputString.charAt(i) == '{' || inputString.charAt(i) == '(' || inputString.charAt(i) == '[' ) {
				stack.add(inputString.charAt(i));
			}
			
			if(stack.isEmpty()) {
				return false;
			}
			
			if (inputString.charAt(i) == '}' || inputString.charAt(i) == ')' || inputString.charAt(i) == ']' ) {
				if(!braces.get(stack.pop()).equals(inputString.charAt(i))){
					return false;
				}
			}
		}
	
		if(stack.isEmpty()) {
			return true;
		}
		
		return false;
	}

}
