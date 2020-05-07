package com.booknara.problem.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element (Easy)
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    // Boyer-Moore Voting algorithm(to find the majority element which is more than n/2
    // T:O(n), S:O(1)
    public int majorityElement(int[] nums) {
        int c = 0, res = 0;
        for (int n: nums) {
            if (c == 0) {
                res = n;
                c++;
            } else if (n == res) {
                c++;
            } else {
                c--;
            }
        }

        return res;
    }

    // T:O(nlogn), S:O(n)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // T:O(n), S:O(n)
    public int majorityElement2(int[] nums) {
        // input : the array is not empty
        int res = 0;    // the majority element always exists

        // Used map because input range is not defined (i.e. Integer.MIN_VALUE ~ Integer.MAX_VALUE)
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int n: nums) {
            int count = map.getOrDefault(n, 0);
            if (count + 1 > len / 2) {
                res = n;
                break;
            }
            map.put(n, count + 1);
        }

        return res;
    }
}
