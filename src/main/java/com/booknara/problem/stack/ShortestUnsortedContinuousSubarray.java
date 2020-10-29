package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 581. Shortest Unsorted Continuous Subarray (Medium)
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestUnsortedContinuousSubarray {
    // T:O(n), S:O(n)
    public int findUnsortedSubarray(int[] nums) {
        // input check, the number of nums >= 1

        // left (ascending)
        Stack<Integer> leftStack = new Stack<>();
        leftStack.push(-1);
        int start = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (leftStack.peek() == -1 || nums[leftStack.peek()] < n) {
                leftStack.push(i);
            } else {
                while (leftStack.peek() != -1 && nums[leftStack.peek()] > n) {
                    start = Math.min(start, leftStack.pop());
                }
            }
        }

        if (start == Integer.MAX_VALUE) return 0;

        // right (descending)
        Stack<Integer> rightStack = new Stack<>();
        rightStack.push(-1);
        int end = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            int n = nums[i];
            if (rightStack.peek() == -1 || n < nums[rightStack.peek()]) {
                rightStack.push(i);
            } else {
                while (rightStack.peek() != -1 && n > nums[rightStack.peek()]) {
                    end = Math.max(end, rightStack.pop());
                }
            }
        }

        return end - start + 1;
    }
}
