package org.shrey.dsa.dp;

import java.util.*;

// # Ninja Training

// ## Problem

// A ninja has to train for **N** consecutive days.

// On each day, the ninja can perform **exactly one** of the following three activities:

// * Activity 0
// * Activity 1
// * Activity 2

// The points earned for each activity on each day are given in a 2D array `points`, where:

// * `points[i][0]` is the points earned by performing Activity 0 on day `i`.
// * `points[i][1]` is the points earned by performing Activity 1 on day `i`.
// * `points[i][2]` is the points earned by performing Activity 2 on day `i`.

// The ninja **cannot perform the same activity on two consecutive days**.

// Return the **maximum total points** the ninja can earn after completing all `N` days.

// ### Example 1

// **Input:**

// ```text
// points = [[10,40,70],
//           [20,50,80],
//           [30,60,90]]
// ```

// **Output:**

// ```text
// 210
// ```

// **Explanation:**

// One optimal schedule is:

// * Day 0 → Activity 2 → 70 points
// * Day 1 → Activity 1 → 50 points
// * Day 2 → Activity 2 → 90 points

// Total points = `70 + 50 + 90 = 210`.

// ---

// ### Example 2

// **Input:**

// ```text
// points = [[18,11,19],
//           [4,13,7],
//           [1,8,13]]
// ```

// **Output:**

// ```text
// 45
// ```

// **Explanation:**

// One optimal schedule is:

// * Day 0 → Activity 2 → 19 points
// * Day 1 → Activity 1 → 13 points
// * Day 2 → Activity 2 → 13 points

// Total points = `19 + 13 + 13 = 45`.

// ---

// ## Constraints

// * `1 <= N <= 10^5`
// * `points.length == N`
// * `points[i].length == 3`
// * `1 <= points[i][j] <= 100`

public class NinjaTraining {
    public int maximumPoints(int[][] points) {

        return solver(points, points.length - 1, -1);       // -1 => No activity has done before
    }

    public int solver(int[][] points, int day, int lastAcitivity) {     // recursive
        if(day == 0) {

            int maxi = 0;

            for(int task=0; task<3; task++) {
                if(task != lastAcitivity) {
                    maxi = Math.max(maxi, points[0][task]);     // find task until the max one is stored in the maxi
                }
            }

            return maxi;
        }
        int maxi = 0;

        for(int task = 0; task < 3; task++) {
            if(task != lastAcitivity) {
                int curr = points[day][task] + solver(points, day - 1, task);       // add curr with prev day
                maxi = Math.max(maxi, curr);
            }
        }
        
        return maxi;
    }

    // dp[] solution => memo

    public int maxPoints(int[][] points) {
        int[][] dp = new int[points.length][points.length];

        for(int[] each: dp) {
            Arrays.fill(each, -1);
        }
        return getMaxPts(points, dp, points.length - 1, -1);
    }

    public int getMaxPts(int[][] points, int[][] dp, int currDay, int lastActivity) {
        if(currDay == 0) {
            int maxi = 0;

            for(int i=0; i<3; i++) {        // all the tasks of the day 0

                if(lastActivity != i) {     // choose only different than lastActivity
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
        }

        if(dp[currDay][lastActivity + 1] != -1) {    
            // lastAcitivity + 1 => -1 + 1 = 0 => can't store anything at -1 index
            // get the current acitivity by doing (+ 1) in last one 
               // if have result of current day => return it 
            return dp[currDay][lastActivity];
        }

        int maxi = 0;
        for(int i=0; i<3; i++) {     // for curr day

            if(currDay != i) {
                int curr = points[currDay][lastActivity] + getMaxPts(points, dp, currDay - 1, lastActivity);
                maxi = Math.max(curr, maxi);
            }
            
        }

        dp[currDay][lastActivity + 1] = maxi;       // store at curr result before returning it
        return dp[currDay][lastActivity + 1];       // curr day => lastDay + 1

    }
    
}

