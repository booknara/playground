package com.booknara.problem.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1094. Car Pooling (Medium)
 * https://leetcode.com/problems/car-pooling/
 */
public class CarPooling {
    // T:O(n*logn), S:O(n)
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) {
            return true;
        }

        Queue<Trip> pq = new PriorityQueue<>((t1, t2) -> {
            if (t1.time == t2.time) {
                // 'end'(-1) Trip first since a vehicle drops off and then pick up customers
                return Integer.compare(t1.stop, t2.stop);
            }

            return Integer.compare(t1.time, t2.time);
        });
        for (int[] t: trips) {
            pq.offer(new Trip(t[0], t[1], 1));
            pq.offer(new Trip(t[0], t[2], -1));
        }

        int currentCap = 0;
        while (!pq.isEmpty()) {
            Trip t = pq.poll();
            if (t.stop == -1) {
                // drop off
                currentCap -= t.customer;
            } else {
                // pick up
                currentCap += t.customer;
            }

            if (currentCap > capacity) {
                return false;
            }
        }

        return true;
    }

    static class Trip {
        int customer;
        int time;
        int stop;   // end : -1. start : 1
        Trip(int customer, int time, int stop) {
            this.customer = customer;
            this.time = time;
            this.stop = stop;
        }
    }
}
