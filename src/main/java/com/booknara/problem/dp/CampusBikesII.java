package com.booknara.problem.dp;

/**
 * 1066. Campus Bikes II (Medium)
 * https://leetcode.com/problems/campus-bikes-ii/
 */
public class CampusBikesII {
    // dp with state using bit manipulation
    // Time complexity: O(w * b * 2^b)
    public int assignBikes(int[][] workers, int[][] bikes) {
        // input clarification
        if (workers == null || workers.length == 0
                || bikes == null || bikes.length == 0) {
            return 0;
        }

        int m = bikes.length;
        int[] dp = new int[1 << m];

        return dfs(0, 0, workers, bikes, dp);
    }

    private int dfs(int worker, int state, int[][] workers, int[][] bikes, int[] dp) {
        if (worker == workers.length) return 0;

        if (dp[state] != 0) return dp[state];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            if ((state & 1 << i) == 0) {
                // no intersection means to calculate the min value for new state
                min = Math.min(min, getDistance(workers[worker], bikes[i])
                        + dfs(worker + 1, state | (1 << i), workers, bikes, dp)); // state | (1 << i) : union means accumulate all the states you calculate
            }
        }

        dp[state] = min;
        return min;
    }

    // Permutation O(n!)
    int totalMin = Integer.MAX_VALUE;
    public int assignBikes1(int[][] workers, int[][] bikes) {
        // input clarification
        if (workers == null || workers.length == 0
                || bikes == null || bikes.length == 0) {
            return 0;
        }

        boolean[] used = new boolean[bikes.length];
        dfs(0, workers, bikes, used, 0);

        return totalMin;
    }

    private void dfs(int worker, int[][] workers, int[][] bikes, boolean[] used, int sum) {
        if (worker == workers.length) {
            totalMin = Math.min(totalMin, sum);
            return;
        }

        if (sum > totalMin) {
            // No need to keep execution since the final result is always bigger than total min
            return;
        }

        for (int i = 0; i < bikes.length; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(worker + 1, workers, bikes, used, sum + getDistance(workers[worker], bikes[i]));
                used[i] = false;
            }
        }
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
