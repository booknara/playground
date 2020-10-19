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

    int[][] dirs = new int[][] {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    // T:O(n^2), S:O(n^2)
    public List<List<Integer>> pacificAtlantic1(int[][] matrix) {
        // input check
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        // m*n
        // Pacific
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int[] cell = new int[2];
            cell[0] = 0;
            cell[1] = i;
            q.offer(cell);
        }
        for (int i = 0; i < m; i++) {
            int[] cell = new int[2];
            cell[0] = i;
            cell[1] = 0;
            q.offer(cell);
        }

        bfs(matrix, q, pVisited);

        // Atlantic
        q.clear();
        for (int i = 0; i < n; i++) {
            int[] cell = new int[2];
            cell[0] = m - 1;
            cell[1] = i;
            q.offer(cell);
        }
        for (int i = 0; i < m; i++) {
            int[] cell = new int[2];
            cell[0] = i;
            cell[1] = n - 1;
            q.offer(cell);
        }

        bfs(matrix, q, aVisited);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    // both flowing
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public void bfs(int[][] matrix, Queue<int[]> q, boolean[][] visited) {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];
                visited[row][col] = true;

                // four directions
                for (int[] dir: dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow < 0 || newCol < 0 || newRow >= matrix.length || newCol >= matrix[0].length
                            || matrix[row][col] > matrix[newRow][newCol] || visited[newRow][newCol]) {
                        continue;
                    }

                    q.offer(new int[] {newRow, newCol});
                }
            }
        }
    }

}
