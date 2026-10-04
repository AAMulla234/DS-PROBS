package com.DSProblems.recursive.more;

public class KeyPad {
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs" ,"tu", "vwx", "yz"};
    
    public static void combinations(String str, int indx, String combinations) {
        if(str.length() ==  indx) {
            System.out.println(combinations);
            return;
        }

        char c = str.charAt(indx);
        String keys = keypad[c - '0'];
        for (int i=0; i < keys.length(); i++) {
            combinations(str, indx+1, combinations + keys.charAt(i));
        }

    }

    public static void main(String [] args) {
        combinations("23", 0, "");
    }

}
