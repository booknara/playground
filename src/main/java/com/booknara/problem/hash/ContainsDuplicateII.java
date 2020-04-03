package com.booknara.problem.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II (Easy)
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) return true;
        }

        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.contains(n)) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
