
import java.util.Arrays;

public class Fibonacci {
    public static void printSeries(int n) {
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");

        for(int i=3; i<=n; i++) {
            
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    static void printNth(int n) {
        int a = 0, b = 1;

        for(int i=3; i<=n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        System.out.println(b); 
    }

    static int fib(int n) {
        if(n == 0 || n == 1) return n;

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        // printSeries(n);
        // printNth(5);

        // System.out.println(fib(n));

        // memoization
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(memo(n, dp));

        System.out.println(tabulation(n));
    }

    private static int memo(int n, int[] dp) {      // top down     => larger to smaller
        
        // we reach the edge case => then return / calculation
        if(n == 0 || n == 1) return dp[n] = n;

        // if solve it return stored 
        if(dp[n] != -1) return dp[n];
        
        // else => calculate it 
        dp[n] = memo(n-1, dp) + memo(n-2, dp);        // n-1th in dp array, n-2th in dp array
        return dp[n];
    }

    private static int tabulation(int n) { 
        if(n == 0) return n;     // bottom up => smaller to larger
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

// 0 1 1 2 3