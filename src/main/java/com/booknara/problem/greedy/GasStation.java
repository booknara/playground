package com.booknara.problem.greedy;

/**
 * 134. Gas Station (Medium)
 * https://leetcode.com/problems/gas-station/
 */
public class GasStation {
  // T: O(n), S:O(1)
  public int canCompleteCircuit(int[] gas, int[] cost) {
    // input check
    if (gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;

    int total = 0;
    int n = gas.length;
    int tank = 0;
    int start = 0;
    for (int i = 0; i < n; i++) {
      int gain = gas[i] - cost[i];
      tank += gain;
      total += gain;

      // A ~ B ~ C ~ D. if C is the first gas station that A or B can't reach,
      // that means D(next C station) could be the start gas station
      // because the previous total pass guarantees there is a solution.
      if (tank < 0) {
        start = i + 1;
        tank = 0;
      }
    }

    return total < 0 ? -1 : start;
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
