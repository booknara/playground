package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. Remove Invalid Parentheses (Hard)
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {
    int minIgnore = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        recur(s, 0, 0, 0, 0, new StringBuilder(), set);

        return new ArrayList<>(set);
    }

    public void recur(String s,
                      int index,
                      int leftCount,
                      int rightCount,
                      int ignoreCount,
                      StringBuilder builder,
                      Set<String> set) {
        if (index == s.length()) {
            if (leftCount == rightCount) {
                // valid parentheses
                if (ignoreCount <= minIgnore) {
                    String ans = builder.toString();
                    if (ignoreCount < minIgnore) {
                        minIgnore = ignoreCount;
                        set.clear();   // clear all the previous results
                    }

                    set.add(builder.toString());
                }
            }
        } else {
            char c = s.charAt(index);
            int len = builder.length();
            if (c != '(' && c != ')') {
                builder.append(c);
                recur(s, index + 1, leftCount, rightCount, ignoreCount, builder, set);
                builder.deleteCharAt(len);
            } else {
                // ignore
                recur(s, index + 1, leftCount, rightCount, ignoreCount + 1, builder, set);

                builder.append(c);
                // keep
                if (c == '(') {
                    recur(s, index + 1, leftCount + 1, rightCount, ignoreCount, builder, set);
                } else if (rightCount < leftCount) {
                    recur(s, index + 1, leftCount, rightCount + 1, ignoreCount, builder, set);
                }

                builder.deleteCharAt(len);
            }
        }
    }
}
