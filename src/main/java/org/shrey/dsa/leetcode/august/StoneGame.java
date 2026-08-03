package org.shrey.dsa.leetcode.august;
import java.util.*;
/**
Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.

Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.
 */

public class StoneGame {
    public boolean stoneGame(int[] stones) {
        int len = stones.length;

        int[][] dp = new int[len][len];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return helper(stones, dp, 0, len - 1) >= 0;
    }

    public int helper(int[] stones, int[][] dp, int i, int j) {
        // base 
        if(i == j) {
            return stones[i];
        }

        // have => return 
        if(dp[i][j] != -1) {
            return dp[i][j] = 1;
        }

        // calculation & backtracking
        int left = stones[i] - helper(stones, dp, i + 1, j);
        int right = stones[i] - helper(stones, dp, i, j - 1);

        int max = Math.max(left, right);

        dp[i][j] = max;
        return max;
    }
}
