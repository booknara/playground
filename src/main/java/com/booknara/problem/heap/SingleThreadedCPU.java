package com.booknara.problem.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1834. Single-Threaded CPU (Medium)
 * https://leetcode.com/problems/single-threaded-cpu
 */
public class SingleThreadedCPU {
  // T:O(nlogn), S:(n)
  public int[] getOrder(int[][] tasks) {
    if (tasks == null || tasks.length == 0) {
      return null;
    }

    int n = tasks.length;
    int[][] indexedTask = new int[n][3];
    for (int i = 0; i < tasks.length; i++) {
      indexedTask[i][0] = i;
      indexedTask[i][1] = tasks[i][0];
      indexedTask[i][2] = tasks[i][1];
    }
    // sort by start time
    Arrays.sort(indexedTask, (t1, t2) -> {
      return Integer.compare(t1[1], t2[1]);
    });

    // priority queue based on job time and then index
    PriorityQueue<int[]> pq = new PriorityQueue<>((t1, t2) -> {
      if (t1[2] == t2[2]) {
        return Integer.compare(t1[0], t2[0]);
      }
      return Integer.compare(t1[2], t2[2]);
    });
    int[] res = new int[n];
    int index = 0, j = 0;
    int time = 0;
    while (index < n) {
      while (j < n && indexedTask[j][1] <= time) {
        pq.offer(indexedTask[j++]);
      }

      if (pq.isEmpty()) {
        time = indexedTask[j][1];
        continue;
      }

      int[] task = pq.poll();
      res[index++] = task[0];
      time += task[2];
    }

    return res;
  }
}
