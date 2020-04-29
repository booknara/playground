package com.booknara.problem.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 220. Contains Duplicate III (Medium)
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class ContainsDuplicateIII {
    // Time: O(n)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || t < 0) {
            return false;
        }

        Map<Long, Long> map = new HashMap<>();
        int n = nums.length;
        int w = t + 1;
        for(int i = 0; i < n; i++) {
            if(i > k) {
                map.remove(getId(nums[i - k - 1], w));
            }

            long id = getId(nums[i], w);
            //System.out.println(id);
            if(map.containsKey(id)) return true;
            if(map.containsKey(id - 1) && nums[i] - map.get(id-1) < w ) return true;
            if(map.containsKey(id + 1) && map.get(id + 1) - nums[i] < w) return true;
            map.put(id, (long) nums[i]);
        }

        return false;
    }

    private long getId(long num, long w) {
        if (num >= 0) {
            return num / w;
        }

        // Negative case
        return (num + 1) / w - 1;
    }

    // Time: O(n*k)
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        for (int i = 1; i < nums.length; i++) {
            long v = nums[i];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                long prev = nums[j];
                if (Math.abs(v - prev) <= t) {
                    return true;
                }
            }
        }

        return false;
    }
}
