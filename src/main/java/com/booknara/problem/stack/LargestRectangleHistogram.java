package com.booknara.problem.stack;

import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int prev = stack.pop();
                max = Math.max(max, (i - 1 - stack.peek()) * heights[prev]);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int prev = stack.pop();
            max = Math.max(max, (heights.length - 1 - stack.peek()) * heights[prev]);
        }

        return max;
    }
}
