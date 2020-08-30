package com.booknara.problem.dc;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaysToAddParentheses {
    // T:O(2^n, n is the number of operators)
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) return res;

        // "2*3-4*5"
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // valid operators are only '+', '-', '*'
            if (c == '+' || c == '-' || c == '*') {
                // 2
                String first = input.substring(0, i);
                // 3-4*5
                String second = input.substring(i + 1);

                // [2]
                List<Integer> firstResult = diffWaysToCompute(first);
                // [-5, -17]
                List<Integer> secondResult = diffWaysToCompute(second);
                for (int f: firstResult) {
                    for (int s: secondResult) {
                        if (c == '+') {
                            res.add(f + s);
                        } else if (c == '-') {
                            res.add(f - s);
                        } else {
                            // '*'
                            res.add(f * s);
                        }
                    }
                }
            }
        }

        if (res.isEmpty()) {
            res.add(Integer.parseInt(input));
            return res;
        }

        return res;
    }
}
/**
 Input: "2*3-4*5"
 Output: [-34, -14, -10, -10, 10]

 1. "2 * 3-4*5"

 "3 - 4*5" or "3-4 * 5"

 "4*5"        "3-4"

 2. 2*3 - 4*5

 3. "2*3-4 * 5"
 "2*3-4"

 "2 * 3-4" or 2*3 - 4

 */