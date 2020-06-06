package com.booknara.problem.dp;

import java.util.Stack;

/**
 * 85. Maximal Rectangle (Hard)
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {
    // T:O(n^2), S:O(n)
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int[] memo = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    memo[j] = 0;
                } else {
                    memo[j]++;
                }
            }

            max = Math.max(max, largestRectangleArea(memo));
        }

        return max;
    }

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int max = 0;
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
