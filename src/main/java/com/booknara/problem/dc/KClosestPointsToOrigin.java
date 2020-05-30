package com.booknara.problem.dc;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 973. K Closest Points to Origin (Medium)
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {
    // O(n^2), but best/average O(n) Quick select
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length <= K) {
            return points;
        }

        int left = 0, right = points.length;

        while (left < right) {
            int partition = getPartition(points, left, right, right - 1);
            if (partition == K) {
                return Arrays.copyOf(points, K);
            }

            if (partition < K) {
                left = partition;
            } else {
                right = partition;
            }
        }

        return null;
    }

    public int getPartition(int[][] points, int left, int right, int pivot) {
        int pDistance = getDistance(points, pivot);
        int border = left;
        for (int i = left; i < right; i++) {
            if (getDistance(points, i) < pDistance) {
                swap(points, i, border);
                border++;
            }
        }

        // Move pivot to its final place
        swap(points, border, pivot);

        return border;
    }

    // Get distance
    public int getDistance(int[][] points, int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    // T:O(nlogn), S:O(k)
    public int[][] kClosest1(int[][] points, int K) {
        if (points == null || points.length <= K) {
            return points;
        }

        // 1. max heap(descending) by x^2 + y^2
        Queue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            return Integer.compare(p2[0] * p2[0] + p2[1] * p2[1],
                    p1[0] * p1[0] + p1[1] * p1[1]);
        });

        // 2. iterate points array and input them into max heap
        for (int[] p: points) {
            pq.offer(p);
            // Key part: if the number of heap size are greater than K, pop();
            // maintain the number of K points
            if (pq.size() > K) {
                pq.poll();
            }
        }

        // 3. return the remaining data from max heap
        int[][] res = new int[pq.size()][2];
        int pos = 0;
        while (!pq.isEmpty()) {
            res[pos++] = pq.poll();
        }

        return res;
    }
}
