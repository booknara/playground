package com.booknara.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934. Shortest Bridge (Medium)
 * https://leetcode.com/problems/shortest-bridge/
 */
public class ShortestBridge {
    int[][] dirs = new int[][] {
            {-1, 0},    // up
            {1, 0},     // down
            {0, -1},    // left
            {0, 1}      // right
    };
    // T:O(n^2), S:(n^2)
    public int shortestBridge(int[][] A) {
        // input check, A.length >= 2
        if (A == null || A.length == 0) return 0;

        int m = A.length;
        int n = A[0].length;
        boolean found = false;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    // found the first island
                    found = true;
                    dfs(A, i, j, q, visited);
                    break;
                }
            }

            if (found) break;
        }

        // bfs
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();

                for (int[] dir: dirs) {
                    int newR = point[0] + dir[0];
                    int newC = point[1] + dir[1];
                    if (newR < 0 || newC < 0 || newR >= m || newC >= n || visited[newR][newC]) continue;

                    if (A[newR][newC] == 1) return level;

                    q.offer(new int[] {newR, newC});
                    visited[newR][newC] = true;
                }
            }

            level++;
        }

        return level;
    }

    public void dfs(int[][] A, int r, int c, Queue<int[]> q, boolean[][] visited) {
        // base case
        if (r < 0 || c < 0 || r >= A.length || c >= A[0].length
                || A[r][c] == 0 || visited[r][c]) return;

        q.offer(new int[] {r, c});
        visited[r][c] = true;
        for (int[] dir: dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(A, newR, newC, q, visited);
        }
    }
}
/**
 Input: A = [

 [0,1,0]
 [0,0,0]
 [0,0,1]

 ]

 [

 [1,1,1,1,1]
 [1,0,0,0,1]
 [1,0,1,0,1]
 [1,0,0,0,1]
 [1,1,1,1,1]
 ]

 There are islands
 1. Find the first island (dfs)
 2. Find the second island (bfs)
 Output: 2
 */