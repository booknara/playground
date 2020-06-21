package com.booknara.problem.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix (Medium)
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestElementInSortedMatrix {
    /**
     * Input : n x n matrix, integer k
     * Output : kth smallest element value
     * T:O(n*n*logk), S:O(k)
     */
    public int kthSmallest(int[][] matrix, int k) {
        // input check
        // matrix is not null
        // 1 <= k <= n2

        // 1. Integer PriorityQueue(Max heap)
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // 2. iterate matrix and add matrix value,
        // if the heap size is more than k, and then poll() max value
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                pq.offer(matrix[i][j]);

                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        // 3. return pop() max value which is the kth smallest element
        return pq.poll();
    }
}
