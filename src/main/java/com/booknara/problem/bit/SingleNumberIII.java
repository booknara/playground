package com.booknara.problem.bit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 260. Single Number III (Medium)
 * https://leetcode.com/problems/single-number-iii/
 */
public class SingleNumberIII {
    // T:O(n), S:O(1)
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
    // T:O(n), S:O(n)
    public int[] singleNumber1(int[] nums) {
        if (nums.length == 2) return nums;

        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            if (set.contains(n)) {
                set.remove(n);
            } else {
                set.add(n);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        int[] res = new int[2];
        res[0] = list.get(0);
        res[1] = list.get(1);

        return res;
    }
}
