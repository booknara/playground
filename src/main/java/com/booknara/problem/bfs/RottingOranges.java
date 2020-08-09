package com.booknara.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges (Medium)
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {
    // T:O(n^2), S:O(n^2)
    public int orangesRotting(int[][] grid) {
        // input check, grid.length >= 1
        // collect all the rotten orange
        Queue<Cell> q = new LinkedList<>();
        int fresh = 0, empty = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Cell(i, j));
                } else if (grid[i][j] == 0) {
                    empty++;
                } else {
                    fresh++;
                }
            }
        }

        // not exist rotten orange
        if (empty == grid.length * grid[0].length) return 0;
        if (fresh == grid.length * grid[0].length) return -1;

        int day = -1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Cell c = q.poll();

                // top
                if (c.r > 0 && grid[c.r - 1][c.c] == 1) {
                    q.offer(new Cell(c.r - 1, c.c));
                    grid[c.r - 1][c.c] = 2; // flag to indicate in process
                }
                // bottom
                if (c.r < grid.length - 1 && grid[c.r + 1][c.c] == 1) {
                    q.offer(new Cell(c.r + 1, c.c));
                    grid[c.r + 1][c.c] = 2; // flag to indicate in process
                }
                // left
                if (c.c > 0 && grid[c.r][c.c - 1] == 1) {
                    q.offer(new Cell(c.r, c.c - 1));
                    grid[c.r][c.c - 1] = 2; // flag to indicate in process
                }
                // right
                if (c.c < grid[c.r].length - 1 && grid[c.r][c.c + 1] == 1) {
                    q.offer(new Cell(c.r, c.c + 1));
                    grid[c.r][c.c + 1] = 2; // flag to indicate in process
                }
            }
            day++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return day;
    }

    static class Cell {
        int r;
        int c;
        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}
