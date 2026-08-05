import java.util.*;

public class Triangle {

    public int minPath(List<List<Integer>> triangle) {
        int len = triangle.size();

        int[][] dp = new int[len][len];

        return solver(triangle, dp, 0, 0);
    }

    public int solver(List<List<Integer>> triangle, int[][] dp, int i, int j) {
        int len = triangle.size();

        if(i == len - 1) {
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int sameCol = solver(triangle, dp, i + 1, j);
        int nextCol = solver(triangle, dp, i + 1, j + 1);

        dp[i][j] = Math.min(sameCol, nextCol) + triangle.get(i).get(j);
        return dp[i][j];
    }

    
}