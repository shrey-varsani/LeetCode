package org.shrey.dsa.dp;

/*

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouserRobber2 {
    public int rob(int[] stones) {
        int len = stones.length;

        int[] dp1 = new int[len];
        int[] dp2 = new int[len];

        // since the adjacents are not allowed
        // from 0 to n - 2
        // from 1 to n - 1

        return Math.max(
            helper(stones, dp1, 0, len - 2),
            helper(stones, dp2, 1, len - 1)
        );
    }

    public int helper(int[] stones, int[] dp, int i, int j) {
        if(i > j) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int first = stones[i] + helper(stones, dp, i + 2, j);
        int second = helper(stones, dp, i + 1, j);

        dp[i] = Math.max(first, second);
        return dp[i];
    }
}
