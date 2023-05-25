package com.booknara.problem.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 2244. Minimum Rounds to Complete All Tasks
 * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks
 */
public class MinimumRoundsToCompleteAllTasks {
  // T:O(n), S:O(n)
  public int minimumRounds(int[] tasks) {
    // edge case
    if (tasks == null || tasks.length == 0) {
      return 0;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < tasks.length; i++) {
      int v = map.getOrDefault(tasks[i], 0);
      map.put(tasks[i], v + 1);
    }
    int res = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int v = entry.getValue();
      if (v % 3 == 0) {
        res += v / 3;
      } else if (v % 3 == 2) {
        res += (v / 3) + 1;
      } else {
        // v % 3 == 1
        if (v / 3 == 0) {
          return -1;
        } else {
          res += (v / 3) + 1;
        }
      }
    }

    return res;
  }
}
/**
 * Input: tasks = [2,2,3,3,2,4,4,4,4,4]
 * Output: 4
 * 2 -> 3
 * 3 -> 2
 * 4 -> 5
 * <p>
 * if n % 3 == 0, count += n/3
 * if n % 3 == 2, count += n/3 + 1
 * if n % 3 == 1,
 * if n/3 == 0 -> -1
 * else count += n/3 + 1
 * <p>
 * 2 -> 4 (2)
 * 2 -> 1 ()
 */
