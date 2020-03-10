package com.booknara.problem.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 739. Daily Temperatures (Medium)
 * https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
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

    // Time exceed
    public int[] dailyTemperatures1(int[] T) {
        if (T == null || T.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        stack.push(T[T.length - 1]);
        map.put(T[T.length - 1], T.length - 1);
        for (int i = T.length - 2; i >= 0; i--) {
            //System.out.println(T[i]);
            int temperature = T[i];
            Stack<Integer> inner = new Stack<>();
            while (!stack.empty()) {
                int temp = stack.pop();
                if (temperature < temp) {
                    res[i] = map.get(temp) - i;
                    inner.push(temp);
                    break;
                }

                inner.push(temp);
            }

            while (!inner.empty()) {
                stack.push(inner.pop());
            }

            if (stack.peek() != temperature) {
                stack.push(temperature);
            }
            map.put(temperature, i);
        }

        return res;
    }
}
