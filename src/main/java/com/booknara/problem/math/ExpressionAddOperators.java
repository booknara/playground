package com.booknara.problem.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 282. Expression Add Operators (Hard)
 * https://leetcode.com/problems/expression-add-operators/
 */
public class ExpressionAddOperators {
    // T:O(n*3^n), S:O(n)
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;

        dfs(num, "", 0, target, 0L, 0L, res);

        return res;
    }

    public void dfs(String num, String path, int index, int target,
                    long eval, long multi, List<String> res) {
        // base case
        if (index == num.length()) {
            if (eval == target) {
                res.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;  // caution 2

            long cur = Long.parseLong(num.substring(index, i + 1)); // caution 1
            if (index == 0) {
                // 0 index value doesn't need to calculate
                dfs(num, path + cur, i + 1, target, cur, cur, res);
            } else {
                // +
                dfs(num, path + "+" + cur, i + 1, target, eval + cur, cur, res);

                // -
                dfs(num, path + "-" + cur, i + 1, target, eval - cur, -cur, res);

                // *, caution 3
                dfs(num, path + "*" + cur, i + 1, target, eval - multi + (cur * multi), multi * cur, res);
            }
        }
    }
}
/**
 Caution 1: Overflow -> long
 Caution 2: the number that start with 0 is invalid
 Caution 3: handling * as higher priority than +, -
 */