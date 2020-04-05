package com.booknara.problem.stack;

import java.util.Stack;
import java.util.TreeSet;

/**
 * 456. 132 Pattern (Medium)
 * https://leetcode.com/problems/132-pattern/
 */
public class Find132Pattern {
    // O(n)
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int[] lowest = new int[nums.length];
        lowest[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lowest[i] = Math.min(lowest[i - 1], nums[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            int left = lowest[i];
            while (!stack.isEmpty() && n > stack.peek()) {
                int m = stack.pop();
                if (m > lowest[i]) return true;
            }

            stack.push(n);
        }

        return false;
    }

    // TreeSet O(nlogn)
    public boolean find132pattern1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int[] lowest = new int[nums.length];
        lowest[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lowest[i] = Math.min(lowest[i - 1], nums[i]);
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (set.lower(nums[i]) != null) {
                int lower = set.lower(nums[i]);
                int left = lowest[i];
                if (left < lower) {
                    return true;
                }
            }

            set.add(nums[i]);
        }

        return false;
    }
}
