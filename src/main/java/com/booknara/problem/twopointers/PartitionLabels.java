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

        int left = 0;
        int max = -1;
        for (int i = 0; i < S.length(); i++) {
            max = Math.max(max, lastIndex[S.charAt(i) - 'a']);

            if (max == i) {
                // new group
                res.add(i - left + 1);
                left = i + 1;
            }
        }

        return res;
    }
}
