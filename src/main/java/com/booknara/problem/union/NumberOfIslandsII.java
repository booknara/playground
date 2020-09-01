package com.booknara.problem.union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 305. Number of Islands II (Hard)
 * https://leetcode.com/problems/number-of-islands-ii/
 */
public class NumberOfIslandsII {
    int[][] dirs = {
            {-1, 0},    // up
            {1, 0},     // down
            {0, -1},    // left
            {0, 1}      // right
    };

    // T:O(m*n*L), L:find operation. L can be O(1) with path compression, S:O(m*n)
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0 || positions.length == 0 || positions[0].length == 0) {
            return res;
        }

        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        for (int[] pos: positions) {
            int root = getBucketIndex(pos, n);
            if (roots[root] != -1) {    // duplicated position
                res.add(count);
                continue;
            }

            roots[root] = root;
            count++;

            // four directions
            for (int[] dir: dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                int base = getBucketIndex(new int[] {r, c}, n);
                if (r < 0 || c < 0 || r >= m || c >= n || roots[base] == -1) {
                    continue;
                }

                int newRoot = findRoot(roots, base);
                if (root != newRoot) {    // find different root, union
                    roots[root] = newRoot;
                    root = newRoot;
                    count--;
                }
            }

            res.add(count);
        }

        return res;
    }

    public int findRoot(int[] roots, int idx) {
        while (roots[idx] != idx) {
            // path compression
            roots[idx] = roots[roots[idx]];
            idx = roots[idx];
        }

        return idx;
    }

    public int getBucketIndex(int[] position, int col) {
        return position[0] * col + position[1];
    }
}
