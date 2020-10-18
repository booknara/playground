package com.booknara.problem.list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. Sliding Window Maximum (Hard)
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    // T:O(n), S:O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        // input check, k is not 0
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] leftMax = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                max = Integer.MIN_VALUE;
            }
            leftMax[i] = Math.max(max, nums[i]);
            max = leftMax[i];
        }

        int[] rightMax = new int[n];
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (i % k == k - 1) {
                max = Integer.MIN_VALUE;
            }
            rightMax[i] = Math.max(max, nums[i]);
            max = rightMax[i];
        }

        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int right = rightMax[i];
            int left = leftMax[k - 1 + i];
            res[i] = Math.max(left, right);
        }

        return res;
    }
    /**
     Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     Output: [3,3,5,5,6,7]
     Explanation:
     Window position                Max
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

     Bruch force method O(k*n)
     [1,3,-1,-3,5,3,6,7]
     for loop 0 ~ n - k + 1
     for loop k elements -> figure out max
     PriorityQueue method O(logk*n)

     Optimanl solution
     [1,3,-1,-3,5,3,6,7]
     [0,1,2   3,4,5  6,7]
     leftMax [1,3,3  -3,5,5, 6,7]
     rightMax [3,3,-1  5,5,3, 7,7]
     -----------------------------
     res       3,3,5,5,6,7

     0 ~ n - k + 1
     for (int i = 0; i < n - k + 1; i++) {
     // i, k - 1 + i, [0,2], [1,3]
     // i -> rightMax
     // k - 1 + i -> leftMax
     res[i] = Math.max(left, right);
     }
     leftMax[i]
     */


    // O(n) using Deque
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int[] res = new int[nums.length - k + 1];
        // Dequeue: to store index
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // Remove an element out of range from k
            while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            // Remove all the smaller elements than k
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }

        return res;
    }

    // O(n*k)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }

            res[i] = max;
        }

        return res;
    }
}
