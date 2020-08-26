package com.booknara.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. Shortest Path in Binary Matrix (Medium)
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class ShortestPathInBinaryMatrix {
    int[][] dirs = new int[][] {{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0) return -1;

        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;

        // BFS
        int res = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int[] cell = q.poll();
                if (cell[0] == m - 1 && cell[1] == n - 1) {
                    return res;
                }

                for (int[] d: dirs) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == 1) {
                        continue;
                    }
                    q.offer(new int[] {r, c});
                    grid[r][c] = 1;
                }
            }

            res++;
        }

        return -1;
    }
}
