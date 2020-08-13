package com.booknara.problem.backtracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1286. Iterator for Combination (Medium)
 * https://leetcode.com/problems/iterator-for-combination/
 */
public class CombinationIterator {
    Queue<String> q;
    String s;
    int k;
    // T:O(k*C^k*n)
    public CombinationIterator(String characters, int combinationLength) {
        q = new LinkedList<>();
        s = characters;
        k = combinationLength;

        backtrack(new StringBuilder(), 0);
        System.out.println(q.size());
    }

    public void backtrack(StringBuilder builder, int index) {
        if (builder.length() == k) {
            q.offer(builder.toString());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            builder.append(s.charAt(i));
            backtrack(builder, i + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public String next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}
