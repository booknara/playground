package com.booknara.problem.dp;

/**
 * 983. Minimum Cost For Tickets (Medium)
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 */
public class MinimumCostForTickets {
    // T:O(n, the max number of days), S:(n)
    public int mincostTickets(int[] days, int[] costs) {
        // input check
        int lastDay = days[days.length - 1];
        boolean[] travel = new boolean[lastDay + 1];
        int[] dp = new int[lastDay + 1];
        for (int i = 0; i < days.length; i++) {
            travel[days[i]] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            if (!travel[i]) {
                // not travel day
                dp[i] = dp[i - 1];
                continue;
            }

            // travel day
            int one = dp[Math.max(i - 1, 0)] + costs[0];
            int seven = dp[Math.max(i - 7, 0)] + costs[1];
            int thirty = dp[Math.max(i - 30, 0)] + costs[2];

            dp[i] = Math.min(one, Math.min(seven, thirty));
        }

        return dp[lastDay];
    }
}
