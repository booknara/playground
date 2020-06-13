package com.booknara.problem.math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 368. Largest Divisible Subset (Medium)
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class LargestDivisibleSubset {
    // T:O(n^2), S:O(n)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);

        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        int max = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }

            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }

        while (index != -1) {
            res.addFirst(nums[index]);
            index = pre[index];
        }

        return res;
    }
}
