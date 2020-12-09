package com.booknara.problem.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. Partition Labels (Medium)
 * https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {
    // T:O(n), S:O(1)
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;

        // Store the last index for each letter
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndex[S.charAt(i) - 'a']);

            if (end == i) {
                // new group
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }
}
