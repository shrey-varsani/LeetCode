import java.util.*;

public class Triangle {

    public int minPath(List<List<Integer>> triangle) {
        int len = triangle.size();

        Integer[][] dp = new Integer[len][len];
        for(Integer[] each: dp) {
            Arrays.fill(each, -1);
        }

        return solver(triangle, dp, 0, 0);
    }

    public int solver(List<List<Integer>> triangle, Integer[][] dp, int i, int j) {
        int len = triangle.size();

        if(i == len - 1) {
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        int sameCol = solver(triangle, dp, i + 1, j);
        int nextCol = solver(triangle, dp, i + 1, j + 1);

        dp[i][j] = Math.min(sameCol, nextCol) + triangle.get(i).get(j);
        return dp[i][j];
    }

    public int minPathTab(List<List<Integer>> triangle) {
        int len = triangle.size();

        int[][] dp = new int[len][len];

        for(int i=0; i<len; i++) {      // copy the last row first
            dp[len-1][i] = triangle.get(len-1).get(i);
        }

        for(int i=len-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);           // get min from same col and next col in the next row
            }
        }

        return dp[0][0];
    }

    public int minPathTabSpaceOpt(List<List<Integer>> triangle) {
        int len = triangle.size();

        int[] dp = new int[len];

        for(int i=0; i<len; i++) {      // copy the last row first
            dp[i] = triangle.get(len-1).get(i);
        }

        for(int i=len-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);           // get min from same col and next col in the next row
            }
        }

        return dp[0];
    }
}