package com.DSProblems.recursive.more;

/**
 * Using Recursion Back tracking solving the probs...
 * 
 */
public class FindWaysOfPower {

    public static int powerN(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
        if (n%2 == 0) {
            return powerN(x, n/2) * powerN(x, n/2);
        } else {
            return powerN(x, n/2) * powerN(x, n/2) * x;
        }
    }

    public static int findPowerways(int target, int n, int i) {
       
        int currentPower = powerN(i, n);
        if(currentPower == target)
           return 1;
        if(currentPower > target)
           return 0;
           
           //include the current number in sum
           //exclude the current number and move next
           return findPowerways(target - currentPower, n, i+1) + findPowerways(target, n, i+1);
           
       }


    public static void main(String[] args) {
        System.out.println("Number of ways power of target is:::" + findPowerways(121, 2, 1));
    }

}
