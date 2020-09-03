package com.booknara.problem.heap;

import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream (Hard)
 * https://leetcode.com/problems/find-median-from-data-stream/
  */
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>((i1, i2) -> {
            return i1 - i2;
        });
        maxHeap = new PriorityQueue<>((i1, i2) -> {
            return i2 - i1;
        });
    }

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

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }

        return maxHeap.peek();
    }
}
