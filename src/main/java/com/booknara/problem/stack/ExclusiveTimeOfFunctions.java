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
        // input check n >= 1
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();
        String[] init = logs.get(0).split(":");
        stack.push(Integer.parseInt(init[0]));

        int prevTime = Integer.parseInt(init[2]);
        for (int i = 1; i < logs.size(); i++) {
            // "0:start:0"
            String log = logs.get(i);
            String[] array = log.split(":");
            int func = Integer.parseInt(array[0]);
            int time = Integer.parseInt(array[2]);

            if (array[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += time - prevTime;
                }

                stack.push(func);
                prevTime = time;
            } else {
                // end (inclusive ~ inclusive range)
                stack.pop();
                res[func] += time - prevTime + 1;
                prevTime = time + 1;      // increment 1 because end takes exclusive ~ inclusive range
            }
        }

        return res;
    }

    // T:O(n), S:O(n)
    public int[] exclusiveTime1(int n, List<String> logs) {
        // input check, n >= 1, logs.size() >= 1

        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        String[] init = logs.get(0).split(":");
        stack.push(Integer.parseInt(init[0]));   // function id
        int prevTime = Integer.parseInt(init[2]);
        //if (!init[1].equals("start"))             // illegal format

        for (int i = 1; i < logs.size(); i++) {
            String[] array = logs.get(i).split(":");
            int funcId = Integer.parseInt(array[0]);
            int time = Integer.parseInt(array[2]);

            // two cases
            if (array[1].equals("start")) {
                // start
                if (!stack.isEmpty()) {
                    res[stack.peek()] += (time - prevTime);
                }

                stack.push(funcId);
                prevTime = time;    // 2
            } else {
                // end
                res[stack.pop()] += (time - prevTime + 1);
                prevTime = time + 1;
            }
        }

        return res;
    }
}
/**
 function Id: 0 ~ n - 1
 Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]

 logs = [
 "0:start:0"
 "1:start:2"
 "1:end:5"
 "0:end:6"
 ]

 [0  1                        6    ]
       [2    3     4    5   ]
   2             4              1
 Output: [3,4]
 */