package com.booknara.problem.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 260. Single Number III (Medium)
 * https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int xor = 0;
        for (int n: nums) {
            xor ^= n;
        }
        //System.out.println(Integer.toBinaryString(xor));
        //System.out.println(Integer.toBinaryString(-xor));
        // xor has two elements appear only once
        // find the most right bit to identify two elements
        int rightMost = xor & -xor;
        //System.out.println(Integer.toBinaryString(rightMost));
        int[] res = new int[2];
        for (int n: nums) {
            if ((n & rightMost) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }

        return res;
    }

    // With space(dictionary)
    public int[] singleNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, count + 1);
        }

        int[] res = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                res[idx++] = entry.getKey();
            }
        }

        return res;
    }
}
