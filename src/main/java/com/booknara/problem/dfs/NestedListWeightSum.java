package com.booknara.problem.dfs;

import com.booknara.problem.iterator.NestedInteger;

import java.util.List;

/**
 * 339. Nested List Weight Sum (Easy)
 * https://leetcode.com/problems/nested-list-weight-sum/
 */
public class NestedListWeightSum {
    // T:O(n + m, n: the number of nested list, m: the number of nested integer), S:O(h, the max length of depth levels)
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        int total = 0;
        for (NestedInteger ni: nestedList) {
            if (ni.isInteger()) {
                total += ni.getInteger() * depth;
            } else {
                total += dfs(ni.getList(), depth + 1);
            }
        }

        return total;
    }

    int res = 0;
    public int depthSum1(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0)  return res;

        int depth = 1;
        for (NestedInteger i: nestedList) {
            helper(i, depth);
        }

        return res;
    }

    public void helper(NestedInteger integer, int depth) {
        if (integer.isInteger()) {
            res += integer.getInteger() * depth;
        } else {
            for (NestedInteger i: integer.getList()) {
                helper(i, depth + 1);
            }
        }
    }

}
