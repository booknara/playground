package com.booknara.problem.stack;

import java.util.Stack;

/**
 * 739. Daily Temperatures (Medium)
 * https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {
    // T:O(n), S:O(n)
    public int[] dailyTemperatures(int[] temperatures) {
      // input check
      if (temperatures == null) return null;
      int[] res = new int[temperatures.length];
      // storing index value
      Stack<Integer> stack = new Stack<>();
      stack.push(0);

      for (int i = 1; i < temperatures.length; i++) {
        int num = temperatures[i];
        while (!stack.isEmpty() && num > temperatures[stack.peek()]) {
          int topIndex = stack.pop();
          res[topIndex] = i - topIndex;
        }
        stack.push(i);
      }

      return res;
    }

  // T:O(n), S:O(n)
    public int[] dailyTemperatures1(int[] T) {
        int[] res = new int[T.length];
        if (T == null || T.length < 2) {
            return res;
        }

        for (int i = T.length - 2; i >= 0; i--) {
            //System.out.println(i);
            int j = i + 1;
            while (j < T.length && T[j] <= T[i]) {
                // edge case: if T[i] is the highest element currently
                if (res[j] == 0) break;
                // Jump to next higher element
                j += res[j];
            }

            // edge case: if T[i] is the highest element currently
            if (T[i] >= T[j]) {
                continue;
            }
            res[i] = j - i;
        }

        return res;
    }

    // 4.14.2020 version
    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        if (T == null || T.length < 2) {
            return res;
        }

        // keep all the index numbers that has higher than current element
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return res;
    }

    // 3.10.2020 version
    public int[] dailyTemperatures3(int[] T) {
        if (T == null || T.length == 0) {
            return null;
        }

        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(T.length - 1);
        for (int i = T.length - 2; i >= 0; i--) {
            while (!stack.empty()) {
                int idx = stack.peek();
                if (T[idx] > T[i]) {
                    res[i] = idx - i;
                    break;
                }

                stack.pop();
            }

            stack.push(i);
        }

        return res;
    }
}
