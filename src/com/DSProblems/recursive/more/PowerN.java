package com.DSProblems.recursive.more;

public class PowerN {

    public static void main(String[] args) {
        System.out.println("Power of x is:" + powerN(2, 4));
    }

    /**
     * Here calculating x^n using logN.
     * where stack heigh would be the half of N.
     * @param x
     * @param n
     * @return
     */
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

}
