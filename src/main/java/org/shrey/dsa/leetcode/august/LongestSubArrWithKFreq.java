package org.shrey.dsa.leetcode.august;

import java.util.HashMap;
import java.util.Map;

/**
 You are given an integer array nums and an integer k.

The frequency of an element x is the number of times it occurs in an array.

An array is called good if the frequency of each element in this array is less than or equal to k.

Return the length of the longest good subarray of nums.

A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class LongestSubArrWithKFreq {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int res = 0;

        while(end < nums.length) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            while(map.get(nums[end]) > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;     // removed right => go to right
            }

            res = Math.max(res, end - start + 1);
            end++;
        }

        return res;
    }
}
