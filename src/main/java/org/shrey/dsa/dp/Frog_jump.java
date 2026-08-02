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

    Map<Integer, Integer> stoneMap = new HashMap<>();
    Map<String, Boolean> memoMap = new HashMap<>();

    public boolean canCross(int[] stones) {
        int len = stones.length;
        for(int i=0; i<len; i++) {
            // last stones at indices => values

            // last index => result 
            // keeping it as value checking 
            stoneMap.put(stones[i], i);
        }

        return dfs(stones, 0, 0);
    }

    public boolean dfs(int[] stones, int idx, int lastJump) {
        // [0,1,3,5,6,8,12,17]

        // base 

        // if have => return 
        // key,value => boolean
        String key = idx + "," + lastJump;
        if(memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        // calculation and store

        for(int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
            int nextStone = stones[idx] + jump;
            // 5 => 6 or 7 or 8 
            // last jump for 5 was 5-3 = 2
            // 5 => 5 + 1 or 5 + 2 or 5 + 3 (1,2,3 variations defined by jump here)

            if(stoneMap.containsKey(nextStone)) {
                // reach at that stone and continue till the very end
                if(dfs(stones, stoneMap.get(nextStone), jump)) {
                    memoMap.put(key, true);
                    return true;
                }
            }
        }

        // after all of the stones => didn't get the result => couldn't reach
        memoMap.put(key, false);        // backtracking 
        return false;
    }
}
