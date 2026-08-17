package org.shrey.dsa.leetcode.august;

import java.util.*;

/**
 There are several stones arranged in a row, and each stone has an associated value which is an integer given in the array stoneValue.

In each round of the game, Alice divides the row into two non-empty rows (i.e. left row and right row), then Bob calculates the value of each row which is the sum of the values of all the stones in this row. Bob throws away the row which has the maximum value, and Alice's score increases by the value of the remaining row. If the value of the two rows are equal, Bob lets Alice decide which row will be thrown away. The next round starts with the remaining row.

The game ends when there is only one stone remaining. Alice's score is initially zero.

Return the maximum score that Alice can obtain.
 * StoneGame5
 */
public class StoneGame5 {
    public int stoneGameV(int[] stoneValue) {
        int len = stoneValue.length;

        int[][] dp = new int[len][len];

        for(int[] each: dp) {
            Arrays.fill(each, -1);
        }

        int[] prefix = new int[len + 1];
        for(int i=0; i<len; ++i) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return solve(stoneValue, dp, prefix, 0, len - 1);
    }

    public int solve(int[] stoneValue, int[][] dp, int[] prefix, int left, int right) {
        if(left > right) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        int leftSum = 0, rightSum = prefix[right + 1] - prefix[left];
        int res = 0;

        for(int k=left; k<right; ++k) {
            // left => increase
            // right => decrease

           leftSum += stoneValue[k];
           rightSum -= stoneValue[k];

           if(leftSum < rightSum) {
                if(res >= 2 * leftSum) {
                    continue;
                }
              res = Math.max(res, leftSum + solve(stoneValue, dp, prefix, left, k));   // more calls => less leftSum => res is still greater than 2 * leftSum => go to next call
           } else if(leftSum > rightSum) {

                if(res >= 2 * rightSum) {
                    break;      // no more increase in rightSum possible => each stoneValue[k], rightSum decreases => curr res is best so far so just break it 
                }
             res = Math.max(res, rightSum + solve(stoneValue, dp, prefix, k + 1, right));
           } else {
            // select either one which is the best
                res = Math.max(res, 
                    Math.max(
                        leftSum + solve(stoneValue, dp, prefix, left, k),
                        rightSum + solve(stoneValue, dp, prefix, k + 1, right)
                    )
                );
           }
        }

        return dp[left][right] = res;
    }
}
