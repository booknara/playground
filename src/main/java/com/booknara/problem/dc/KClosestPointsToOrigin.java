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
        if (points == null || points.length <= K) return points;

        // [[18],[26],[20],[53],[41],[25]], K = 4
        int left = 0, right = points.length - 1;    // 0, 5
        while (left < right) {
            // 4,5
            int partition = getPartition(points, left, right);
            // 3
            if (partition == K) {
                break;
            }

            if (partition < K) {
                // Kth value exists after partition index
                left = partition + 1;
            } else {
                // Kth value exsite before partition index
                right = partition - 1;
            }
        }

        return Arrays.copyOf(points, K);
    }

    public int getPartition(int[][] points, int left, int right) {
        // [[18],[26],[20],[53],[41],[25]]
        // 0, 5
        int lastValue = getDistance(points[right]); // 25, pick the last index value as pivotValue for simplicity
        int partition = left;   // 0
        for (int i = left; i < right; i++) {
            if (getDistance(points[i]) < lastValue) {
                swap(points, partition, i);
                partition++;
            }
        }
        // [[18],[20],[26],[53],[41],[25]]
        // Until this partition index, all the values before this index are less than lastValue
        swap(points, partition, right);
        // [[18],[20],[25],[53],[41],[26]]
        // 3
        return partition;
    }

    // Get distance
    // distance p[0] * p[0], p[1] * p[1], no need to do square root
    public int getDistance(int[] p) {
        return (p[0] * p[0]) + (p[1] * p[1]);
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
/**
 Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 Output: [[3,3],[-2,4]]
 Method 1: Max Heap maintaning up to K size() -> 31ms, // T:O(n*logK), S:O(k)
 Method 2: Quick Select -> 3ms // T:O(n^2), S:O(1), Best T:O(n)
 [18, 26, 20], K = 2

 Pivot = 20
 [18,]

 */
