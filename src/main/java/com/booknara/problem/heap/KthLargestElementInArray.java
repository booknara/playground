package com.booknara.problem.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array (Medium)
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInArray {
    // T:O(n*logk), S:O(k)
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length || k == 0) {
            return -1;
        }

        // Min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for (int n: nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }

    // T:O(n^2), S:O(1)
    public int findKthLargest1(int[] nums, int k) {
        // input check
        if (nums.length == 0 || nums.length < k) {
            new IllegalArgumentException("invalid inut");
        }

        if (nums.length == 0 && k == 1) return nums[0];

        // [-1,2,0], 1
        k = nums.length - k;    // k = 2
        int left = 0, right = nums.length - 1;  // [0,2]
        while (left <= right) {
            int partition = getPartition(nums, left, right);
            // [-1,0,2], partition = 1
            // System.out.println(partition);
            if (partition == k) return nums[k];

            if (partition < k) {
                left = partition + 1;
            } else {
                right = partition - 1;
            }
        }

        return 0;
    }
    // [0,2], [2,2]
    public int getPartition(int[] nums, int left, int right) {
        int pivotValue = nums[right];   // 0
        int partition = left;   // 0
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, partition, i);
                partition++;
            }
        }

        swap(nums, partition, right);

        // [-1,0,2], 2 -> [-1,-0,2], 2
        return partition;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
