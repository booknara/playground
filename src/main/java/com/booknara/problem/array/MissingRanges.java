package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. Missing Ranges (Easy)
 * https://leetcode.com/problems/missing-ranges/submissions/
 */
public class MissingRanges {
    // T:O(n), S:O(1)
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            print(res, lower, upper);
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                // First case
                if (lower < nums[i]) {
                    print(res, lower, nums[i] - 1);
                }
            } else {
                if (nums[i] == nums[i - 1]) {
                    // The same number with the previous one
                    continue;
                }

                // Other cases
                if (nums[i] != nums[i - 1] + 1) {
                    print(res, nums[i - 1] + 1, nums[i] - 1);
                }
            }
        }

        // Upper case handling
        if (nums[nums.length - 1] < upper) {
            print(res, nums[nums.length - 1] + 1, upper);
        }

        return res;
    }

    public void print(List<String> list, int s, int e) {
        StringBuilder builder = new StringBuilder();
        if (s == e) {
            builder.append(s);
        } else {
            builder.append(s);
            builder.append("->");
            builder.append(e);
        }

        list.add(builder.toString());
    }
}
