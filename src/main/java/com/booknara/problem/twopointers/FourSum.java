package com.booknara.problem.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leet code: 18. 4Sum (Medium)
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);
        if (target < 4 * nums[0] || target > 4 * nums[nums.length - 1]) {
            return ans;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            // Prevent duplicated result
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                // Prevent duplicated result
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int pivot = nums[i] + nums[j];
                int k = j + 1, m = nums.length - 1;
                while (k < m) {
                    if (pivot + nums[k] + nums[m] == target) {
                        while (k < m && nums[k] == nums[k + 1]) k++;
                        while (k < m && nums[m] == nums[m - 1]) m--;
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        k++;
                        m--;
                    } else if (pivot + nums[k] + nums[m] < target) {
                        k++;
                    } else {
                        m--;
                    }
                }
            }
        }

        return ans;
    }
}
