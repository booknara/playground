package com.booknara.problem.dc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin (Medium)
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {
    // O(n), Quick search
    public int[][] kClosest(int[][] points, int K) {
        List<int[]> res = new ArrayList<>();
        if (points == null || points.length == 0) {
            return res.toArray(new int[0][]);
        }

        if (points.length <= K) {
            return points;
        }

        int l = 0, h = points.length - 1;
        while (l <= h) {
            int partition = getPartition(points, l, h);
            if (partition == K) {
                break;
            }

            if (partition < K) {
                l = partition + 1;
            } else {
                h = partition - 1;
            }
        }

        return Arrays.copyOf(points, K);
    }

    public int getPartition(int[][] points, int l, int h) {
        int pivot = l;
        int pivotDistance = getDistance(points, pivot);
        while (l <= h) {
            while (l <= h && getDistance(points, l) <= pivotDistance) {
                l++;
            }

            while (l <= h && getDistance(points, h) > pivotDistance) {
                h--;
            }

            if (l > h) {
                break;
            }

            swap(points, l, h);
        }

        swap(points, h, pivot);

        return h;
    }

    public void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    public int getDistance(int[][] points, int i) {
        return (points[i][0] * points[i][0])
                + (points[i][1] * points[i][1]);
    }

    // O(nlogn)
    public int[][] kClosest1(int[][] points, int K) {
        List<int[]> res = new ArrayList<>();
        if (points == null || points.length == 0) {
            return res.toArray(new int[0][]);
        }

        if (points.length <= K) {
            return points;
        }

        // Max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            return (p2[0] * p2[0] + p2[1] * p2[1]) -
                    (p1[0] * p1[0] + p1[1] * p1[1]);
        });

        for (int[] p: points) {
            pq.offer(p);
            if (pq.size() > K) {
                int[] temp = pq.poll();
                //System.out.println(temp[0] + "," + temp[1]);
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        return res.toArray(new int[pq.size()][]);
    }
}
