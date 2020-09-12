package com.booknara.problem.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 480. Sliding Window Median (Hard)
 * https://leetcode.com/problems/sliding-window-median/
 */
public class SlidingWindowMedian {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));

    // T:O(n*klogk), S:O((n - k + 1) + k)
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new double[0];

        double[] result = new double[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                add(nums[i]);
            } else {
                add(nums[i]);
                double median = getMedian();
                result[idx++] = median;
                remove(nums[i - k + 1]);
            }
        }

        return result;
    }

    // []  n   []
    public void add(int num) {
        if (maxHeap.size() == minHeap.size()) {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        } else {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }
    }

    public void remove(int num) {
        // num is always present in one of heaps
        if (maxHeap.peek() < num) {
            // num is in minHeap
            minHeap.remove(num);
            if (maxHeap.size() == minHeap.size()) {
                int max = maxHeap.poll();
                minHeap.offer(max);
            }
        } else {
            // num is in maxHeap
            maxHeap.remove(num);
            if (maxHeap.size() != minHeap.size()) {
                int min = minHeap.poll();
                maxHeap.offer(min);
            }
        }
    }

    public double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2.0;
        }

        return (double) maxHeap.peek();
    }

    // Bruce force, T:O((n - k)*klogk), S:O(k)
    public double[] medianSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new double[0];

        double[] res = new double[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            res[idx++] = getMedian(Arrays.copyOfRange(nums, i, k + i));
        }

        return res;
    }

    public double getMedian(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);

        double median;
        if (size % 2 == 1) {
            // odd
            median = nums[(size / 2)];
        } else {
            // even
            median = ((long)nums[(size / 2) - 1] + (long)nums[(size / 2)]) / 2.0;
        }
        return median;
    }
}
