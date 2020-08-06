package com.booknara.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II (Medium)
 * https://leetcode.com/problems/4sum-ii/
 */
public class FourSumII {
    // T:O(n^2), S:O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                int count = map.getOrDefault(-sum, 0);
                map.put(-sum, count + 1);
            }
        }

        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(sum)) {
                    res += map.get(sum);
                }
            }
        }

        return res;
    }
}
