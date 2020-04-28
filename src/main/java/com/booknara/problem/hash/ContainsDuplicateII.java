package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. Contains Duplicate II (Easy)
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {
    // 04/27/2020 version
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int diff = i - map.get(num);
                // at most k btw previous and current index
                if (diff <= k) {
                    return true;
                }
            }

            map.put(num, i);
        }

        return false;
    }

    // 04/02/2020 version
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
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

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
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
