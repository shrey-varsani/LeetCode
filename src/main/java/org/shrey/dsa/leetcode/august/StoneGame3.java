package org.shrey.dsa.leetcode.august;

import java.util.*;
/**
 Alice and Bob continue their games with piles of stones. There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array stoneValue.

Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take 1, 2, or 3 stones from the first remaining stones in the row.

The score of each player is the sum of the values of the stones taken. The score of each player is 0 initially.

The objective of the game is to end with the highest score, and the winner is the player with the highest score and there could be a tie. The game continues until all the stones have been taken.

Assume Alice and Bob play optimally.

Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end the game with the same score.

 */
public class StoneGame3 {
    public String stoneGameIII(int[] stones) {
        int len = stones.length;

        int[] dp = new int[len];
        Arrays.fill(dp, -1);

        int res = helper(stones, dp, 0);

        if(res > 0) return "Alice";
        if(res < 0) return "Bob";
        
        return "Tie";
    }

    public int helper(int[] stones, int[] dp, int idx) {
        // base case 
        if(idx >= stones.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int currTake = 0;
        int bestOne = Integer.MIN_VALUE;

        for(int k=0; k<3 && k + idx < stones.length; k++) {
            currTake += stones[idx + k];

            bestOne = Math.max(bestOne, currTake - helper(stones, dp, idx + k + 1));
        }

        dp[idx] = bestOne;
        return bestOne;
    }
}
