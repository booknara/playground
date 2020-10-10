package com.booknara.problem.heap;

import java.util.*;

/**
 * 1057. Campus Bikes (Medium)
 * https://leetcode.com/problems/campus-bikes/
 */
public class CampusBikes {
    // Bucket approach, O(n^2), it can save logn which is heaptify
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // input clarification
        if (workers == null || workers.length == 0
                || bikes == null || bikes.length == 0) {
            return new int[0];
        }

        // Bucket
        List<int[]>[] buckets = new ArrayList[2001];
        for (int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                int dist = getDistance(worker, bike);
                if (buckets[dist] == null) {
                    buckets[dist] = new ArrayList<>();
                }
                buckets[dist].add(new int[] {i, j});
            }
        }

        int[] res = new int[workers.length];
        boolean[] bikeUsed = new boolean[bikes.length];
        Arrays.fill(res, -1);

        for (List<int[]> b: buckets) {
            if (b == null) continue;
            for (int i = 0; i < b.size(); i++) {
                int[] info = b.get(i);
                int worker = info[0];
                int bike = info[1];

                if (bikeUsed[bike] || res[worker] != -1) {
                    continue;
                }

                res[worker] = bike;
                bikeUsed[bike] = true;
            }
        }

        return res;
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0])
                + Math.abs(worker[1] - bike[1]);
    }

    // O(n^2*logn) : Too slow because of 2 loops and heaptify for priority queue
    public int[] assignBikes1(int[][] workers, int[][] bikes) {
        // input clarification
        if (workers == null || workers.length == 0
                || bikes == null || bikes.length == 0) {
            return new int[0];
        }

        // PriorityQueue by Distance ASC, Worker ASC, Bike ASC
        PriorityQueue<Distance> pq = new PriorityQueue<>((d1, d2) -> {
            if (d1.d != d2.d) {
                return Integer.compare(d1.d, d2.d);
            }

            if (d1.w != d2.w) {
                return Integer.compare(d1.w, d2.w);
            }

            return Integer.compare(d1.b, d2.b);
        });

        for (int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                int dist = Math.abs(worker[0] - bike[0])
                        + Math.abs(worker[1] - bike[1]);
                pq.offer(new Distance(dist, i, j));
            }
        }

        int count = 0;
        int[] res = new int[workers.length];
        Set<Integer> assigned = new HashSet<>();
        Arrays.fill(res, -1);

        while (assigned.size() < workers.length) {
            Distance d = pq.poll();
            int index = d.w;
            int bike = d.b;
            //System.out.println(d.d + "," + d.w + "," + d.b);

            if (assigned.contains(bike)) {
                continue;
            }

            if (res[index] == -1) {
                res[index] = bike;
                assigned.add(bike);
            }
        }

        return res;
    }

    class Distance {
        int d;
        int w;
        int b;
        Distance(int d, int w, int b) {
            this.d = d;
            this.w = w;
            this.b = b;
        }
    }
}
