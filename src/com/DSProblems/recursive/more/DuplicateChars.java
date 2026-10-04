package com.DSProblems.recursive.more;

public class DuplicateChars {
    
    // This is useful map to track each char in map 
    // if it present than mark as true to the position.
    private static final boolean charMap[] = new boolean[26];

    public static void removeDuplicateChars(String str, int idx, String newStr) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char c = str.charAt(idx);
        int mapIndx = c - 'a';
        if (charMap[mapIndx]) {
            removeDuplicateChars(str, idx+1, newStr);
        } else {
            newStr += c;
            charMap[mapIndx] = true;
            removeDuplicateChars(str, idx+1, newStr);
        }
    }

    public static void main(String[] args) {
        removeDuplicateChars("abcdcbade", 0, "");
    }
}
