package com.booknara.problem.dfs;

import com.booknara.problem.iterator.NestedInteger;

import java.util.List;

/**
 * 339. Nested List Weight Sum (Easy)
 * https://leetcode.com/problems/nested-list-weight-sum/
 */
public class NestedListWeightSum {
    // T:O(n), S:O(h, the max length of depth levels)
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
}
