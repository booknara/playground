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
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }

        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger ni: nestedList) {
            queue.offer(ni);
        }

        int prev = 0;
        int total = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger ni = queue.poll();
                if (ni.isInteger()) {
                    sum += ni.getInteger();
                } else {
                    for (NestedInteger inner: ni.getList()) {
                        queue.offer(inner);
                    }
                }
            }

            prev += sum;
            total += prev;
        }

        return total;
    }

}
