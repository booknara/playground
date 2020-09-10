package com.booknara.problem.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 346. Moving Average from Data Stream (Easy)
 * https://leetcode.com/problems/moving-average-from-data-stream/
 */
public class MovingAverage {
    Deque<Integer> dq;
    int sum;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.dq = new ArrayDeque<>();
        this.sum = 0;
        this.size = size;
    }

    // T:O(1), S:O(n, the window size)
    public double next(int val) {
        // case 1, the current size is less than the window size
        // case 2, the current size is the window size
        if (dq.size() >= size) {
            sum -= dq.pollFirst();
        }

        sum += val;
        dq.offerLast(val);
        return (double)sum / (double) dq.size();
    }
}
