package org.shrey.dsa.leetcode.august;

import java.util.Arrays;

/**
 Alice and Bob continue their games with piles of stones. There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i]. The objective of the game is to end with the most stones.

Alice and Bob take turns, with Alice starting first.

On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M. Then, we set M = max(M, X). Initially, M = 1.

The game continues until all the stones have been taken.

Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 */

public class StoneGame2 {
    public int stoneGameII(int[] piles) {
        int len = piles.length;

        int[][] dp = new int[len][len];     // track of points at Mth take on ith idx
        for(int[] each: dp) {
            Arrays.fill(each, -1);
        }

        return dfs(piles, dp, 1, 0);
    }

    public int dfs(int[] piles, int[][] dp, int M, int idx) {
        // update M in each call 

        // if we can take all => return all
        if(2 * M >= piles.length - idx) {
            int total = 0;

            for(int i=idx; i<piles.length; i++) {
                total += piles[i];
            }

            return total;
        }

        if(dp[idx][M] != -1) return dp[idx][M];

        // get the current stones for current call
        int total = 0;
        for(int i=idx; i<piles.length; i++) {
            total += piles[i];
        }

        // choices from X to 2*M
        int maxStones = 0;
        
        for(int X=1; X<=2*M; X++) {
            int nextM = Math.max(M, X);

            int opponentCall = dfs(piles, dp, nextM, idx + X);

            int current = total - opponentCall;     
            // if Alice collects current then how many Bob will get 

            maxStones = Math.max(current, maxStones);
            // get max among those for better choice of alice
        }

        return dp[idx][M] = maxStones;
    }
}
