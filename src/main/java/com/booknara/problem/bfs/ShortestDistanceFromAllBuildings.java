package com.booknara.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 317. Shortest Distance from All Buildings (Hard)
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/
 */
public class ShortestDistanceFromAllBuildings {
    // T:O(m^2*n^2), S:O(m^2*n^2)
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] counter =  new int[m][n];
        int building = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    building++;
                    bfs(grid, distance, counter, i, j);
                }
            }
        }

        boolean found = false;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (counter[i][j] == building) {
                    res = Math.min(res, distance[i][j]);
                    found = true;
                }
            }
        }

        return found ? res : -1;
    }

    public void bfs(int[][] grid, int[][] distance, int[][] counter, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[r][c] = true;
        int[][] dirs = new int[][] {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        Queue<Element> q = new LinkedList<>();
        q.offer(new Element(r, c, 0));
        while (!q.isEmpty()) {
            Element e = q.poll();
            for (int[] dir: dirs) {
                int newR = e.r + dir[0];
                int newC = e.c + dir[1];

                if (newR >= 0 && newC >= 0 && newR < m && newC < n
                        && !visited[newR][newC] && grid[newR][newC] == 0) {
                    visited[newR][newC] = true;
                    counter[newR][newC]++;
                    distance[newR][newC] += e.step + 1;
                    q.offer(new Element(newR, newC, e.step + 1));
                }
            }
        }
    }

    static class Element {
        int r;
        int c;
        int step;
        Element (int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }
}
