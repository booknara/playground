package com.booknara.problem.greedy;

import java.util.Arrays;

/**
 * 1029. Two City Scheduling (Easy)
 * https://leetcode.com/problems/two-city-scheduling/
 */
public class TwoCityScheduling {
    // T:O(nlogn), S:O(1)
    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        // sort by cost difference (descending)
        Arrays.sort(costs, (c1, c2) -> {
            return Integer.compare(Math.abs(c2[0] - c2[1]), Math.abs(c1[0] - c1[1]));
        });
        // take the min cost until one side city becomes N (A or B)
        int N = costs.length / 2;
        int res = 0;
        int countA = 0,  countB = 0;
        for (int[] c: costs) {
            if (c[0] < c[1]) {
                // c[0], A is smaller
                if (countA < N) {
                    res += c[0];
                    countA++;
                } else {
                    res += c[1];
                    countB++;
                }
            } else {
                // c[1], B is smaller
                if (countB < N) {
                    res += c[1];
                    countB++;
                } else {
                    res += c[0];
                    countA++;
                }
            }
        }

        // And then take the other city cost to make the other N (B or A)

        return res;
    }
}
