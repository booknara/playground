package com.booknara.problem.greedy;

/**
 * 134. Gas Station (Medium)
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {
    // O(n)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0
                || cost == null || cost.length == 0) {
            return -1;
        }

        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }

        // if total is negative, there is no answer
        if (total < 0) {
            return -1;
        }

        int sum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            // A ~ B ~ C ~ D. if C is the first gas station that A or B can't reach,
            // that means D(next C station) could be the start gas station
            // because the previous total pass guarantees there is a solution.
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }

        return start;
    }

    // O(N^2) : Too slow
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0
                || cost == null || cost.length == 0) {
            return -1;
        }

        for (int i = 0; i < gas.length; i++) {
            if (enoughRotation(i, gas, cost)) {
                return i;
            }
        }

        return -1;
    }

    private boolean enoughRotation(int start, int[] gas, int[] cost) {
        int remaining = 0;
        for (int i = 0; i < gas.length; i++) {
            int idx = (start + i) % gas.length;
            remaining += gas[idx];
            remaining -= cost[idx];
            if (remaining < 0) {
                return false;
            }
        }

        return true;
    }
}
