package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram (Hard)
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleHistogram {
    // T:O(n), S:O(n)
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            // checking descending(monotonic stack)
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int h = stack.pop();
                // formula -> current index - 1(index just before) - previos stack(lower) * height
                max = Math.max(max, (i - 1 - stack.peek()) * heights[h]);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int h = stack.pop();
            max = Math.max(max, (heights.length - 1 - stack.peek()) * heights[h]);
        }

        return max;
    }
}
