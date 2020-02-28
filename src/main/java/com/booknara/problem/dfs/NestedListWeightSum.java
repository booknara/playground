package com.booknara.problem.dfs;

import com.booknara.problem.recursive.NestedInteger;

import java.util.List;

/**
 * 339. Nested List Weight Sum (Easy)
 * https://leetcode.com/problems/nested-list-weight-sum/
 */
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        int res = 0;
        int depth = 1;
        for (NestedInteger ni: nestedList) {
            if (ni.isInteger()) {
                res += ni.getInteger() * depth;
            } else {
                res += dfs(ni.getList(), depth + 1);
            }
        }

        return res;
    }

    public int dfs(List<NestedInteger> list, int depth) {
        int res = 0;
        for (NestedInteger ni: list) {
            if (ni.isInteger()) {
                res += ni.getInteger() * depth;
            } else {
                res += dfs(ni.getList(), depth + 1);
            }
        }

        return res;
    }
}
