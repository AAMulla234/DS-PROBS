package com.DSProblems.recursive.more;

import java.util.HashSet;
import java.util.Set;

public class UniquePermutation {

    public static void uniquePermutation(String str, String newStr, Set<String> set) {
        if (str.length() == 0) {
            if(set.contains(newStr)) {
                return;
            } else {
                System.out.println(newStr);
                set.add(newStr);
                return;
            }
        }

        for(int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            String otherStr = str.substring(0, i) + str.substring(i+1);
            uniquePermutation(otherStr, newStr + c, set);
        }
        
    }


    public static void main(String[] args) {
        String str = "112";
        uniquePermutation(str, "", new HashSet<String>());
    }
}
