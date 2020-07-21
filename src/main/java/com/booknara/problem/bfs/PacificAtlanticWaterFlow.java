package com.booknara.problem.bfs;

import java.util.*;

/**
 * 417. Pacific Atlantic Water Flow (Medium)
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlanticWaterFlow {
    // T:O(n^2), S:O(n^2)
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        // border to element approach
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Element> pQueue = new LinkedList<>();
        boolean[][] pVisited = new boolean[m][n];
        Queue<Element> aQueue = new LinkedList<>();
        boolean[][] aVisited = new boolean[m][n];

        // Horizontal
        for (int i = 0; i < m; i++) {
            // pacific
            pQueue.offer(new Element(i, 0));
            pVisited[i][0] = true;
            // atlantic
            aQueue.offer(new Element(i, n - 1));
            aVisited[i][n - 1] = true;
        }

        // Vertical
        for (int j = 0; j < n; j++) {
            // pacific
            pQueue.offer(new Element(0, j));
            pVisited[0][j] = true;
            // atlantic
            aQueue.offer(new Element(m - 1, j));
            aVisited[m - 1][j] = true;
        }

        bfs(pQueue, matrix, pVisited);
        bfs(aQueue, matrix, aVisited);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public void bfs(Queue<Element> queue, int[][] matrix, boolean[][] visited) {
        // top, bottom, left, right
        int[][] direction = new int[][] {
                {-1, 0},    // top
                {1, 0},    // bottom
                {0, -1},    // left
                {0, 1},    // right
        };
        while (!queue.isEmpty()) {
            Element e = queue.poll();
            for (int[] d: direction) {
                int r = e.row + d[0];
                int c = e.col + d[1];

                if (r < 0 || r >= matrix.length ||
                        c < 0 || c >= matrix[r].length ||
                        // Note: The new index value is equals to bigger than the current index value
                        matrix[e.row][e.col] > matrix[r][c] ||
                        visited[r][c]) {
                    continue;
                }

                visited[r][c] = true;
                queue.offer(new Element(r, c));
            }
        }
    }

    static class Element {
        int row;
        int col;

        Element(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
