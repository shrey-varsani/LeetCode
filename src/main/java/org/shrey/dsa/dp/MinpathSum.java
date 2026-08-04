package org.shrey.dsa.dp;

import java.util.*;

public class MinpathSum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // bottom-up

        // sum of first row and first col elements
        for(int j=1; j<cols; j++) {
            grid[0][j] += grid[0][j-1];
        }

        for(int i=1; i<rows; i++) {
            grid[i][0] += grid[i-1][0];
        }

        // use for next sum and then find min from them
        for(int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }

    public int minpathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // top-down (dfs, memo)
        int[][] dp = new int[rows][cols];
        for(int[] each: dp) {
            Arrays.fill(each, -1);
        }

        return dfs(grid, dp, 0, 0);

    }

    public int dfs(int[][] grid, int[][] dp, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        if(i >= rows || j >= cols) return Integer.MAX_VALUE;        // out of boundry => return max value 

        if(i == rows - 1 || j == cols - 1) {
            return grid[i][j];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = dfs(grid, dp, i, j + 1);
        int down = dfs(grid, dp, i + 1, j);

        int min = Math.min(right, down);

        dp[i][j] = min + grid[i][j];
        return dp[i][j];
    }
}
