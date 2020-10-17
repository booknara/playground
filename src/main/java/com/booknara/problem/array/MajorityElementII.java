package com.booknara.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. Majority Element II (Medium)
 * https://leetcode.com/problems/majority-element-ii/
 */
public class MajorityElementII {
    // T:O(n), S:O(1)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int count1 = 1, num1 = nums[0], count2 = 0, num2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // the two candidate majority numbers (num1, num2)
        count1 = 0;
        count2 = 0;
        // verification process
        for (int i: nums) {
            if (i == num1) count1++;
            else if (i == num2) count2++;
        }

        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);

        return res;
    }
}
