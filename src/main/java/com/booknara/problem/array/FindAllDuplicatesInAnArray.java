package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                res.add(Math.abs(nums[i]));
            }
            // Key point: changed negative value to indicate the existing value
            nums[idx] = -nums[idx];
        }

        return res;
    }

    // Time: O(n), Space: O(n)
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (set.contains(n)) {
                res.add(n);
            } else {
                set.add(n);
            }
        }

        return res;
    }
}
