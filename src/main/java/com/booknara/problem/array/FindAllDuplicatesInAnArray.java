package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array (Medium)
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesInAnArray {
    // Time: O(n), Space: O(1)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                // Note: return num[i] value
                res.add(Math.abs(nums[i]));
            }
            // Key point: changed negative value to indicate the existing value
            nums[idx] = -nums[idx];
        }

        return res;
    }
}
