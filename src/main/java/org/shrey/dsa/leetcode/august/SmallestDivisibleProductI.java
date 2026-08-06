package org.shrey.dsa.leetcode.august;

public class SmallestDivisibleProductI {

    /*
        You are given two integers n and t. Return the smallest number greater than or equal to n such that the product of its digits is divisible by t.
    */
    public int smallestNumber(int n, int t) {
        while(!isValid(n, t)) {
            n++;
        }

        return n;
    }

    public boolean isValid(int n, int t) {
        int product = 1;

        while(n > 0) {
            int rem = n % 10;

            product *= rem;
            n /= 10;        // get next digit (from last)
        }

        return product % t == 0;
    }
}
