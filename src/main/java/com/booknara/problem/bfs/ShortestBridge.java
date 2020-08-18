package com.booknara.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934. Shortest Bridge (Medium)
 * https://leetcode.com/problems/shortest-bridge/
 */
public class ShortestBridge {
    // T:O(n^2), S:(n^2)
    public int shortestBridge(int[][] A) {
        // input check, 0, or 1 are only contained
        // there are two islands
        Queue<Point> source = new LinkedList<>();
        boolean[][] visited = new boolean[A.length][A[0].length];
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean found = false;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <A[0].length; j++) {
                if (A[i][j] == 0) {
                    continue;
                }

                if (source.isEmpty()) {
                    dfs(A, i, j, source, visited);
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        int step = 0;
        while (!source.isEmpty()) {
            int len = source.size();
            for (int i = 0; i < len; i++) {
                Point p = source.poll();

                for (int[] d: directions) {
                    int newR = p.r + d[0];
                    int newC = p.c + d[1];
                    if (newR < 0 || newC < 0 || newR >= A.length || newC >= A[newR].length) {
                        // out of range
                        continue;
                    }
                    if (visited[newR][newC]) {
                        // visited
                        continue;
                    }

                    if (A[newR][newC] == 1) return step;

                    // Otherwise, A[newR][newC] == 0
                    source.offer(new Point(newR, newC));
                    visited[newR][newC] = true;
                }
            }

            step++;
        }

        return -1;
    }

    public void dfs(int[][] A, int r, int c, Queue<Point> q, boolean[][] visited) {
        // base case
        if (r < 0 || c < 0 || r >= A.length || c >= A[r].length || A[r][c] == 0) {
            return;
        }

        // A[r][c] is valid and 1
        q.offer(new Point(r, c));
        visited[r][c] = true;
        A[r][c] = 0;
        // 4 directions
        // top
        dfs(A, r - 1, c, q, visited);
        // bottom
        dfs(A, r + 1, c, q, visited);
        // left
        dfs(A, r, c - 1, q, visited);
        // right
        dfs(A, r, c + 1, q, visited);
    }


    static class Point {
        int r;
        int c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

/**
 [[0,1],
 [1,0]]

 [[0,1,0],
 [0,0,0],
 [0,0,1]]

 (0, 1) <-> (2, 2) = |0-2| + |1-2| = 3;
 */