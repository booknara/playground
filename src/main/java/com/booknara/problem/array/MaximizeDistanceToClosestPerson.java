package com.booknara.problem.array;

/**
 * 849. Maximize Distance to Closest Person (Easy)
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 */
public class MaximizeDistanceToClosestPerson {
    // T:O(n), S:O(1)
    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }

        boolean init = false;
        int max = 0;
        int prev = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] != 1) {
                continue;
            }

            if (!init) {
                // the first '1'
                max = Math.max(max, i);
                init = true;
            } else {
                max = Math.max(max, (i - prev) / 2);
            }

            prev = i;
        }

        // the last '1'
        max = Math.max(max, seats.length - prev - 1);

        return max;
    }
}
