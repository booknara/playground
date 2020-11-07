package com.booknara.problem.search.binary;

/**
 * 1283. Find the Smallest Divisor Given a Threshold (Medium)
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 */
public class FindTheSmallestDivisorGivenThreshold {
    // T:O(nlogM, n: the length of input array, M: the max number of input), S:O(1)
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int n: nums) {
            max = Math.max(max, n);
        }
        int l = 1, r = max;
        while (l < r) {
            int m = l + (r - l) / 2;
            int sum = getDivisionSum(nums, m * 1.0);
            if (sum <= threshold) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return r;
    }

    public int getDivisionSum(int[] nums, double divisor) {
        int sum = 0;
        for (int n: nums) {
            sum += (int) Math.ceil(n / divisor);
        }

        return sum;
    }
}
