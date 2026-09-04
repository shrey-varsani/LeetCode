package org.shrey.dsa.leetcode.september;

/**
 You are given an integer array nums of length n and an integer k.

For each index i, define its instability score as max(nums[0..i]) - min(nums[i..n - 1]).

In other words:

max(nums[0..i]) is the largest value among the elements from index 0 to index i.
min(nums[i..n - 1]) is the smallest value among the elements from index i to index n - 1.
An index i is called stable if its instability score is less than or equal to k.

Return the smallest stable index. If no such index exists, return -1.

 * ScoreMoreThanK
 */

public class ScoreMoreThanK {
    public int indexOfScore(int[] arr, int k) {
        int len = arr.length;
        int[] suffix = new int[len];

        int[] prefix = new int[len];
        prefix[0] = arr[0];
        for(int i=1; i<len; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }

        suffix[len - 1] = arr[len - 1];
        for(int i=len - 2; i >=0; i--) {
            suffix[i] = Math.min(suffix[i + 1], arr[i]);
        }

        for(int i=0; i<len; i++) {
            int score = prefix[i] - suffix[i];

            if (score <= k) {
                return i;
            }
        }

        return -1;
    }

    public int indexOfScoreWith1Arr(int[] arr, int k) {
        int len = arr.length;
        int[] suffix = new int[len];

        suffix[len - 1] = arr[len - 1];
        for(int i=len - 2; i >=0; i--) {
            suffix[i] = Math.min(suffix[i + 1], arr[i]);
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<len; i++) {
            maxVal = Math.min(maxVal, arr[i]);

            if(maxVal - suffix[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
