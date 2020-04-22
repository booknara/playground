package com.booknara.problem.stack;

import java.util.List;
import java.util.Stack;

/**
 * 636. Exclusive Time of Functions (Medium)
 * https://leetcode.com/problems/exclusive-time-of-functions/
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        // Input clarification
        // N > 0 and logs list is neither null nor empty
        if (n == 0 || logs == null || logs.size() == 0) {
            return new int[0];
        }

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        String[] data = logs.get(0).split(":");
        stack.push(Integer.parseInt(data[0]));
        // if data[1] is end -> throw exception
        int prev = Integer.parseInt(data[2]);
        for (int i = 1; i < logs.size(); i++) {
            //System.out.println(logs.get(i));
            data = logs.get(i).split(":");
            int id = Integer.parseInt(data[0]);
            boolean start = data[1].equals("start");
            int timestamp = Integer.parseInt(data[2]);

            if (start) {
                // start
                if (!stack.isEmpty()) {
                    res[stack.peek()] += timestamp - prev;
                }
                stack.push(id);
                prev = timestamp;
            } else {
                // end (inclusive ~ inclusive range)
                res[stack.peek()] += timestamp - prev + 1;
                stack.pop();
                prev = timestamp + 1;   // increment 1 because end takes inclusive ~ inclusive range
            }
        }

        return res;
    }
}
