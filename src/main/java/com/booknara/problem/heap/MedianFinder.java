package com.booknara.problem.heap;

import java.util.PriorityQueue;

/**
 * Leet code : 295. Find Median from Data Stream (Hard)
 * https://leetcode.com/problems/find-median-from-data-stream/
  */
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>((i1, i2) -> {
            return i1.compareTo(i2);
        });
        maxHeap = new PriorityQueue<>((i1, i2) -> {
            return i2.compareTo(i1);
        });
    }

    public void addNum(int num) {
        if (minHeap.size() == 0 && maxHeap.size() == 0) {
            minHeap.offer(num);
            return;
        }

        if (minHeap.size() == maxHeap.size()) {
            if (minHeap.peek() > num) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        } else if (minHeap.size() > maxHeap.size()) {
            if (minHeap.peek() > num) {
                maxHeap.offer(num);
            } else {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
        } else {
            if (maxHeap.peek() > num) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
    }

    public double findMedian() {
        double median = 0;
        if (minHeap.size() == maxHeap.size()) {
            median = (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (minHeap.size() > maxHeap.size()) {
            median = (double) minHeap.peek();
        } else {
            median = (double) maxHeap.peek();
        }

        return median;
    }
}
