package com.booknara.problem.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1626. Best Team With No Conflicts (Medium)
 * https://leetcode.com/problems/best-team-with-no-conflicts
 */
public class BestTeamWithNoConflicts {
  // T:O(n^2), S:O(n)
  public int bestTeamScore(int[] scores, int[] ages) {
    // edge case
    if (scores == null || scores.length == 0
        || ages == null || ages.length == 0 ) {
      return 0;
    }

    int[][] data = new int[scores.length][2];
    for (int i = 0; i < scores.length; i++) {
      data[i][0] = ages[i];
      data[i][1] = scores[i];
    }

    // sort by age and then by score
    Arrays.sort(data, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return Integer.compare(o1[1], o2[1]);
        }
        return Integer.compare(o1[0], o2[0]);
      }
    });

    int total = 0;
    int[] dp = new int[scores.length];
    for (int i = 0; i < data.length; i++) {
      dp[i] = data[i][1];
      total = Math.max(total, dp[i]);
    }

    // Similar to LIS(Longest Increasing Subsequence) problem
    for (int i = 0; i < scores.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        // older student has a higher score
        if (data[i][1] >= data[j][1]) {
          dp[i] = Math.max(dp[i], dp[j] + data[i][1]);
        }
      }

      total = Math.max(total, dp[i]);
    }

    return total;
  }
}
/**
 younger players should get lower score than older players (no rule for same age)
 Input: scores = [4,5,6,5], ages = [2,1,2,1]
 Output: 16

 Input:
 ages = [2,1,2,1] -> [1,1,2,2]
 scores = [4,5,6,5] -> [5,5,4,6]
 */
