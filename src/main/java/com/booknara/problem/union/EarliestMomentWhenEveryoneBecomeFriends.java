package com.booknara.problem.union;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1101. The Earliest Moment When Everyone Become Friends (Medium)
 * https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 */
public class EarliestMomentWhenEveryoneBecomeFriends {
  // T:O(nlogn), S:O(n)
  public int earliestAcq(int[][] logs, int n) {
    // root
    int[] root = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
      root[i] = i;
      rank[i] = 0;
    }

    // timestamp sort, O(nlogn)
    Arrays.sort(logs, (o1, o2) -> Integer.compare(o1[0], o2[0]));

    int group = n;
    for (int[] log: logs) {
      int time = log[0];
      int root1 = find(root, log[1]);
      int root2 = find(root, log[2]);

      // different group, then union
      if (root1 != root2) {
        if (rank[root1] < rank[root2]) {
          root[root2] = root1;
        } else if (rank[root1] > rank[root2]) {
          root[root1] = root2;
        } else {
          root[root1] = root2;
          rank[root2]++;
        }

        group--;
        if (group == 1) {
          return time;
        }
      }
    }

    return -1;
  }

  public int find(int[] root, int n) {
    while (root[n] != n) {
      root[n] = root[root[n]];  // path compression
      n = root[n]; // move to next root;
    }

    return n;
  }
}
