package com.DSProblems.LinkedList;

import java.util.Stack;

public class LongestValidParanthesis {

    public static int validMaxLength(String str) {
        Stack<Integer> stk = new Stack<>();
        int len = 0;
        for(int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                stk.push(i);
            } else {
                if(!stk.isEmpty() && str.charAt(stk.peek()) == '(') {
                    stk.pop();
                    len++;
                } else {
                    stk.push(i);
                }
            }
        }
        return (len*2);
    }

    public static void main(String[] args) {
        String str = "((()()";
        System.out.println(validMaxLength(str));

        str = "()(()))))";
        System.out.println(validMaxLength(str));

        str = "((()";
        System.out.println(validMaxLength(str));

    }

}
