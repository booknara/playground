package com.booknara.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence (Hard)
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    // T:O(n), S:O(n)
    public int longestConsecutive(int[] nums) {
        // input check
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }

        int max = 1;
        for (int n: nums) {
            // start consecutive sequnce
            if (!set.contains(n - 1)) {
                int count = 0;
                while (set.contains(n + count)) {
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}
