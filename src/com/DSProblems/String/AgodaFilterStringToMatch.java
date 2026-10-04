package com.DSProblems.String;

import java.util.Stack;

/**
 * This question is asked to me in Agoda interview
 * there is two string that has backspace represent as #
 * If backspace is there remove it's previous letter
 * return 1 if both string has same length and charater match at same index only
 */
public class AgodaFilterStringToMatch {
    

    private static Stack<Character> filter(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
       return stack;
    }

    public static int findStringMatch(String s1, String s2) {
        Stack<Character> stack1 = filter(s1);
        Stack<Character> stack2 = filter(s2);

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) 
                return 0;
        }
        return 1;
    }


    public static void main(String[] args) {
        System.out.println("Is both are same::" + findStringMatch("yy#pp##", "ys#krs###"));
    }
}
