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

    // T:O(2^n), S:O(n)
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;

        StringBuilder builder = new StringBuilder();
        Set<String> set = new HashSet<>();
        backtracking(s, 0, 0, 0, 0, builder, set);

        return new ArrayList<>(set);
    }

    public void backtracking(String s, int index, int openCount, int closeCount, int ignore,
                             StringBuilder builder, Set<String> res) {
        // base case
        if (index == s.length()) {
            // not valid parenthese
            if (openCount != closeCount) return;

            // three cases(less, equal, more)
            if (ignore <= minIgnore) {
                if (ignore < minIgnore) {
                    minIgnore = ignore;
                    res.clear();
                }
                res.add(builder.toString());
            }
            return;
        }

        if (s.charAt(index) != '(' && s.charAt(index) != ')') {
            // letters
            builder.append(s.charAt(index));
            backtracking(s, index + 1, openCount, closeCount, ignore, builder, res);
            builder.deleteCharAt(builder.length() - 1);
        } else {
            // Case #1 (ignore)
            backtracking(s, index + 1, openCount, closeCount, ignore + 1, builder, res);

            if (s.charAt(index) == '(') {
                // Case # 2 (backtracking)
                // Case 2-1 ('(')
                builder.append("(");
                backtracking(s, index + 1, openCount + 1, closeCount, ignore, builder, res);
                builder.deleteCharAt(builder.length() - 1);
            } else {
                // Case 2-1 (')'), closeCount is supposed to be less or equal to openCount
                if (openCount > closeCount) {
                    builder.append(")");
                    backtracking(s, index + 1, openCount, closeCount + 1, ignore, builder, res);
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }
    }
}
/**
 Input: "()())()"
 Output: ["()()()", "(())()"]

 Rule 1: Open parenthese >= close parenthese
 Rule 2: When index == s.length(), open parenthese == close parenthese, check minimum ignore count
 - if same, add the string to result
 - if less than previous count, clear and add
 - if more than previous count, skip
 */