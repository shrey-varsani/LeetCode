package org.shrey.dsa.leetcode.september;

/*
You are given an array nums1 of n distinct integers.

You want to construct another array nums2 of length n such that the elements in nums2 are either all odd or all even.

For each index i, you must choose exactly one of the following (in any order):

nums2[i] = nums1[i]
nums2[i] = nums1[i] - nums1[j], for an index j != i, such that nums1[i] - nums1[j] >= 1
Return true if it is possible to construct such an array, otherwise, return false.
 */
public class UniformArray2 {
    public boolean canFormArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;
        for(int val: arr) {
            if(val < min) {
                min = val;
            }

            if(val % 2 != 0) {
                hasOdd = true;
            }
        }

        if(min % 2 != 0) {
            return true;
        }

        if(min != Integer.MAX_VALUE) return true;
        return true;
    }
}
