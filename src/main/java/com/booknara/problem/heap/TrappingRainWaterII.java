package com.booknara.problem.heap;

import java.util.PriorityQueue;

/**
 * 407. Trapping Rain Water II (Hard)
 * https://leetcode.com/problems/trapping-rain-water-ii/
 */
public class TrappingRainWaterII {
  int[][] dirs = new int[][]{
      {-1, 0},
      {1, 0},
      {0, -1},
      {0, 1},
  };

  // T:O(n^2), S:O(n^2)
  public int trapRainWater(int[][] heightMap) {
    // edge case
    if (heightMap == null) return 0;
    if (heightMap.length <= 2) return 0;

    int res = 0;
    int m = heightMap.length;
    int n = heightMap[0].length;
    boolean[][] visited = new boolean[m][n];
    // min heap based on max height
    PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> {
      return p1.maxHeight - p2.maxHeight;
    });
    // start, end unit
    for (int i = 0; i < m; i++) {
      pq.offer(new Point(i, 0, heightMap[i][0]));
      pq.offer(new Point(i, n - 1, heightMap[i][n - 1]));
      visited[i][0] = true;
      visited[i][n - 1] = true;
    }
    // top, bottom unit
    for (int j = 0; j < n; j++) {
      pq.offer(new Point(0, j, heightMap[0][j]));
      pq.offer(new Point(m - 1, j, heightMap[m - 1][j]));
      visited[0][j] = true;
      visited[m - 1][j] = true;
    }

    while (!pq.isEmpty()) {
      Point p = pq.poll();
      for (int[] d : dirs) {
        int i = p.i + d[0];
        int j = p.j + d[1];
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
          continue;
        }

        // heightMap[i][j] vs p.maxHeight
        int max = Math.max(heightMap[i][j], p.maxHeight);
        if (p.maxHeight > heightMap[i][j]) {
          res += p.maxHeight - heightMap[i][j];
        }
        visited[i][j] = true;
        pq.offer(new Point(i, j, max));
      }
    }

    return res;
  }

  class Point {
    int i;
    int j;
    int maxHeight;

    Point(int i, int j, int maxHeight) {
      this.i = i;
      this.j = j;
      this.maxHeight = maxHeight;
    }
  }
}
