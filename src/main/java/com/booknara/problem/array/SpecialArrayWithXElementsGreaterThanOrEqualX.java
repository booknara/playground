package com.booknara.problem.array;

/**
 * 1608. Special Array With X Elements Greater Than or Equal X (Easy)
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    // T:O(n), S:O(n)
    public int specialArray(int[] nums) {
        // input check nums.length >= 1
        int n = nums.length;
        int[] counts = new int[n + 1];
        for (int num: nums) {
            if (num >= n) {
                counts[n]++;
            } else {
                counts[num]++;
            }
        }

        int res = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            res += counts[i];
            if (res == i) {
                return i;
            }
        }

        return -1;
    }
}
