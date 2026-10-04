package com.DSProblems.recursive.more;

import java.math.BigInteger;

public class SumOfDigits {

    public static int superDigit(String n, int k) {
    // Write your code here
     StringBuilder str = new StringBuilder(n);
     
     for(int i =1; i < k; i++) {
      str = str.append(n);   
     }
   
     BigInteger largeNumber = BigInteger.TEN.pow(100000);
     System.out.println(String.valueOf(largeNumber).length());
     System.out.println(str.length());
    /*  if (str.length() > String.valueOf(largeNumber).length()){
         return -1; 
     }*/
     
        return findSuperDigit(str.toString());
    }
    
    public static int findSuperDigit(String n) {
        if (n.length() == 1) {
            return Integer.parseInt(n);
        }
        Integer sum = new Integer("0");
        for(char c : n.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c)); 
        }
        return findSuperDigit(String.valueOf(sum));
    }


    public static void main(String[] args) {
        System.out.println(superDigit("861568688536788", 100000));
    }
}
