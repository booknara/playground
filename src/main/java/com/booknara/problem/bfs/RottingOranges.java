package com.booknara.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges (Medium)
 * https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {
    private static final int INVALID = -1;
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return INVALID;
        }

        int numOfFresh = 0;
        Queue<Cell> q = new LinkedList<>();
        int rowMax = grid.length;
        int colMax = grid[0].length;
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (grid[i][j] == 2) {
                    // Rotten orange
                    q.add(new Cell(i, j, 0));
                } else if (grid[i][j] == 1) {
                    // Fresh orange
                    numOfFresh++;
                }
            }
        }

        // All cells are a rotten orange
        if (numOfFresh == 0) return 0;
        // All cells are a fresh orange
        if (q.size() == 0) return INVALID;

        // BFS traversal
        int time = 0;
        while (!q.isEmpty()) {
            Cell c = q.poll();
            time = Math.max(time, c.t);     // For result
            // Top
            int i = c.i;
            int j = c.j;
            if (i > 0 && grid[i - 1][j] == 1) {
                q.add(new Cell(i - 1, j, time + 1));
                numOfFresh--;
                grid[i - 1][j] = 2;
            }
            // Bottom
            if (i < rowMax - 1 && grid[i + 1][j] == 1) {
                q.add(new Cell(i + 1, j, time + 1));
                numOfFresh--;
                grid[i + 1][j] = 2;
            }
            // Left
            if (j > 0 && grid[i][j - 1] == 1) {
                q.add(new Cell(i, j - 1, time + 1));
                numOfFresh--;
                grid[i][j - 1] = 2;
            }
            // Right
            if (j < colMax - 1 && grid[i][j + 1] == 1) {
                q.add(new Cell(i, j + 1, time + 1));
                numOfFresh--;
                grid[i][j + 1] = 2;
            }
        }

        //System.out.println("fresh one : " + numOfFresh);
        return numOfFresh == 0 ? time : INVALID;
    }

    class Cell {
        int i;
        int j;
        int t;

        Cell (int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
}
