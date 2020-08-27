package com.booknara.problem.heap;

import com.booknara.problem.common.Pair;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 378. Kth Smallest Element in a Sorted Matrix (Medium)
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestElementInSortedMatrix {
    // T:O(n*log(max value - min value)), S:O(1)
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;

        // binary search using min and max value in the matrix
        int m = matrix.length;
        int n = matrix[0].length;
        int l = matrix[0][0], r = matrix[m - 1][n - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            //System.out.println(mid);
            // mid value is in the matrix all the time
            // because if mid is not in the matrix, while loop can't finish and keep looping
            // until the final answer is found in the matrix
            if (getSmallerNumber(matrix, mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    public int getSmallerNumber(int[][] matrix, int m) {
        // start from top, right corner
        int res = 0;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] <= m) {
                res += j + 1;
                i++;
            } else {
                j--;
            }
        }

        return res;
    }

    public int kthSmallest1(int[][] matrix, int k) {
        // input check
        // matrix is not null
        // 1 <= k <= n2
        // min heap based on element value using BFS

        Set<Pair> set = new HashSet<>();
        Queue<Element> q = new PriorityQueue<>((e1, e2) -> {
            return e1.val - e2.val;
        });

        q.offer(new Element(0, 0, matrix[0][0]));
        set.add(new Pair(0,0));
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Element e = q.poll();
                k--;
                if (k == 0) return e.val;

                // two directions (right, bottom)
                // right
                if (e.c < matrix[e.r].length - 1 && !set.contains(new Pair(e.r, e.c + 1))) {
                    q.offer(new Element(e.r, e.c + 1, matrix[e.r][e.c + 1]));
                    set.add(new Pair(e.r, e.c + 1));
                }
                // down
                if (e.r < matrix.length - 1 && !set.contains(new Pair(e.r + 1, e.c))) {
                    q.offer(new Element(e.r + 1, e.c, matrix[e.r + 1][e.c]));
                    set.add(new Pair(e.r + 1, e.c));
                }
            }
        }

        return -1;
    }

    static class Element {
        int r;
        int c;
        int val;
        Element (int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
}
