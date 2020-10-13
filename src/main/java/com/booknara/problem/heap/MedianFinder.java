package com.booknara.problem.heap;

import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream (Hard)
 * https://leetcode.com/problems/find-median-from-data-stream/
  */
class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        // max heap will be equal to min or one more element than min heap
        maxHeap = new PriorityQueue<>((i1, i2) -> {
            return Integer.compare(i2, i1);
        });
        minHeap = new PriorityQueue<>((i1, i2) -> {
            return Integer.compare(i1, i2);
        });
    }

    // T:O(logn)
    public void addNum(int num) {
        // if the size of min/max heap is equal, the value will be inserted into max heap
        if (minHeap.size() == maxHeap.size()) {
            minHeap.offer(num);
            int higherMin = minHeap.poll();
            maxHeap.offer(higherMin);
        } else {
            // max heap has one more value than min heap
            maxHeap.offer(num);
            int lowerMax = maxHeap.poll();
            minHeap.offer(lowerMax);
        }
    }

    // T:O(1)
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }
}
