package com.booknara.problem.list;

import com.booknara.problem.iterator.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 364. Nested List Weight Sum II (Medium)
 * https://leetcode.com/problems/nested-list-weight-sum-ii/
 */
public class NestedListWeightSumII {
    // T:O(n + m), S:O(n + m)
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;

        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger i: nestedList) {
            q.offer(i);
        }

        int res = 0;
        int sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger integer = q.poll();

                if (integer.isInteger()) {
                    sum += integer.getInteger();
                } else {
                    for (NestedInteger n: integer.getList()) {
                        q.offer(n);
                    }
                }
            }

            res += sum;
        }

        return res;
    }
}
/**
 Input: [1,[4,[6]]]
 1 * 3 = 3
 4 * 2 = 8
 6 * 1 = 6

 1 * 1 = 1
 4 * 1 + 1 * 1 = 4 + 1 = 5
 6 * 1 + 4 * 1 + 1 * 1 = 6 + 4 + 1
 Output: 17
 */
