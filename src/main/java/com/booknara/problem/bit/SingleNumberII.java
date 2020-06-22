package com.booknara.problem.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. Single Number II (Medium)
 * https://leetcode.com/problems/single-number-ii/
 */
public class SingleNumberII {
    // input: integer array
    // output: the element that appears once
    // T:O(n), S:O(1)
    public int singleNumber(int[] nums) {
        // input check(non-empty array)
        int res = 0;
        int multiple = 3;   // three times
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            // sum the number of each digit (0 ~ 31 digits)
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }

            res |= (sum % multiple) << i;
        }

        return res;
    }

// count the number of each digit (0 ~ 31 digits)
// e.g. 2,2,3,4,2,4,4
//  10
//  10
//  11
// 100
//  10
// 100
// 100
// 341
// divide by 3 for each digit
// 3%3=0, 4%3=1,1%3=1 -> 011

    // With Space(dictionary)
    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                res = entry.getKey();
                break;
            }
        }

        return res;
    }
}
