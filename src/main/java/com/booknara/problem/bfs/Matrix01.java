package com.booknara.problem.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 Matrix (Medium)
 * https://leetcode.com/problems/01-matrix/
 */
public class Matrix01 {
    //d T:O(n^2), S:O(n^2)
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return matrix;

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i][j] != 0 ? getDistance(matrix, i, j) : 0;
            }
        }

        return matrix;
    }

    public int getDistance(int[][] matrix, int r, int c) {
        Queue<Element> q = new LinkedList<>();
        q.offer(new Element(r, c));
        int depth = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Element e = q.poll();

                if (matrix[e.r][e.c] != 0) {
                    // top
                    if (e.r > 0) q.offer(new Element(e.r - 1, e.c));
                    // bottom
                    if (e.r < matrix.length - 1) q.offer(new Element(e.r + 1, e.c));
                    // left
                    if (e.c > 0) q.offer(new Element(e.r, e.c - 1));
                    // right
                    if (e.c < matrix[e.r].length - 1) q.offer(new Element(e.r, e.c + 1));
                    continue;
                }

                return depth;
            }

            depth++;
        }

        return depth;
    }

    static class Element {
        int r;
        int c;
        Element(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
