import java.util.*;

/**
 * climbing_stairs
 */
public class climbing_stairs {
         // steps to reach nth stair

        // either 1 or 2

    // using recursion
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private static int helper(int n, int[] dp) {
        // memoization => top-down
        if(n <= 2) return n;

        if(dp[n] != -1) return dp[n];

        dp[n] = helper(n-1, dp) + helper(n-2, dp);     // (index in dp array, dp array)

        return dp[n];
    }

    // using tabulation =>  bottom-up
    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
}
