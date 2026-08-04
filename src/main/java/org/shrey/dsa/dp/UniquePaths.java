package org.shrey.dsa.dp;

import java.util.Arrays;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class UniquePaths {
    public int getUniqueWays(int row, int col) {
        int[][] dp = new int[row][col];

        for(int[] each: dp) {
            Arrays.fill(each, -1);
        }

        return dfs(row, col, dp, 0, 0);
    }

    public int dfs(int row, int col, int[][] dp, int x, int y) {
        if(x == row - 1 || y == col - 1) return 1;
        if(x >= row || y >= col) return 0;

        if(dp[x][y] != -1) return dp[x][y];

        int toRight = dfs(row, col, dp, x, y + 1);
        int toDown = dfs(row, col, dp, x + 1, y);

        dp[x][y] = toRight + toDown;
        return dp[x][y];
    }
}
