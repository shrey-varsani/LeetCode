package org.shrey.dsa.leetcode.august;

import java.util.*;

/**
 You are given an integer array nums consisting of unique integers.

Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.

The smallest and largest integers of the original range are still present in nums.

Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.

 
 */

public class MissingElement {
    public List<Integer> getMissing(int[] nums) {

        List<Integer> res = new ArrayList<>();

        boolean[] contains = new boolean[101];
        int min  = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            contains[num] = true;
        }

        for(int i=min; i<=max; i++) {
            if(!contains[i]) {
                res.add(i);
            }
        }

        return res;
    }
}