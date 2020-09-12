package com.booknara.problem.stack;

import java.util.List;
import java.util.Stack;

/**
 * 636. Exclusive Time of Functions (Medium)
 * https://leetcode.com/problems/exclusive-time-of-functions/
 */
public class ExclusiveTimeOfFunctions {
    // T:O(n), S:O(n)
    public int[] exclusiveTime(int n, List<String> logs) {
        // N > 0 and logs list is neither null nor empty
        if (n == 0 || logs == null || logs.size() == 0) {
            return new int[0];
        }

        // input check 1 <= n
        int[] res = new int[n];

        // Stack only contains start function_id
        Stack<Integer> stack = new Stack<>();
        Task init = new Task(logs.get(0).split(":"));
        stack.push(init.func);
        int previousTime = init.timestamp;
        for (int i = 1; i < logs.size(); i++) {
            Task t = new Task(logs.get(i).split(":"));
            if (t.start) {
                // start (the stack can be empty())
                if (!stack.isEmpty()) {
                    int preFunc = stack.peek();
                    res[preFunc] += t.timestamp - previousTime;
                }
                stack.push(t.func);
                previousTime = t.timestamp;
            } else {
                // end (inclusive ~ inclusive range)
                int preFunc = stack.peek();
                res[preFunc] += t.timestamp - previousTime + 1;
                stack.pop();
                previousTime = t.timestamp + 1;  // increment 1 because end takes exclusive ~ inclusive range
            }
        }

        return res;
    }

    static class Task {
        int func;
        boolean start;
        int timestamp;
        Task(String[] s) {
            this.func = Integer.parseInt(s[0]);
            this.start = s[1].equals("start");
            this.timestamp = Integer.parseInt(s[2]);
        }
    }
}
/**
 ["0:start:0","1:start:2","1:end:5","0:end:6"]
 [0                6]
 [2  3  4  5]
 func1: 3 [0,2] = 2, [5,6] = 1
 func2: [2,5] = 4
 */