package com.booknara.problem.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Leet code: 215. Kth Largest Element in an Array (Medium)
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }

    public int findKthLargestFaster(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        int size = nums.length;
        return quickSelect(nums, 0, size - 1, size - k);
    }

    public int quickSelect(int[] nums, int low, int high, int k) {
        if (low == high) {
            return nums[low];
        }

        Random random = new Random();
        int pivotIdx = low + random.nextInt(high - low);
        int partition = partitioning(nums, low, high, pivotIdx);
        if (partition == k) {
            return nums[k];
        }

        if (partition < k) {
            return quickSelect(nums, partition + 1, high, k);
        }

        return quickSelect(nums, low, partition - 1, k);
    }

    public int partitioning(int[] nums, int low, int high, int pivotIdx) {
        int pivotLoc = low, pivot = nums[pivotIdx];
        swap(nums, pivotIdx, high);

        for (int i = low; i <= high; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, pivotLoc);
                pivotLoc++;
            }
        }

        swap(nums, high, pivotLoc);

        return pivotLoc;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
