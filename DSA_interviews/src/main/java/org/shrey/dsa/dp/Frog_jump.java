package org.shrey.dsa.dp;

import java.util.*;

public class Frog_jump {

    private static int[][] memo;

    public static boolean canJump(int[] stones) {
        int len = stones.length;

        if(len == 1) return true;
        
        memo = new int[len][len];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }

        if(stones[1] != 1) {
            return false;
        }

        return resolve(stones, 1, 1);
    }

    public static boolean resolve(int[] stones, int idx, int lastJump) {
        if(stones.length - 1 == idx) return true;

        if(memo[idx][lastJump] != -1) {
            return memo[idx][lastJump] == 1;
        }

        for(int option = lastJump - 1; option <= lastJump + 1; option++) {
            if(option <= 0) continue;

            int nextPosition = stones[idx] + option;

            // since sorted => use binary search
            int nextIdx = Arrays.binarySearch(stones, idx + 1, stones.length, nextPosition);

            if(nextIdx >= 0) {       // if stone exists
                if(resolve(stones, nextIdx, option)) {
                    // check if can find further => yes if find & store 1 
                    memo[idx][lastJump] = 1;
                    return true;
                }
            }
        }

        memo[idx][lastJump] = 0;
        return false;
    }

    // public boolean canCross(int[] stones) {
    //     int len = stones.length;

    //     if(len == 1) return true;

    //     for(int i=0; i<len; i++) {

    //     }
    // }
}
