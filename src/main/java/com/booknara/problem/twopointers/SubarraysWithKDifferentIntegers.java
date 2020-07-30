package com.booknara.problem.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * 992. Subarrays with K Different Integers (Hard)
 * https://leetcode.com/problems/subarrays-with-k-different-integers/
 */
public class SubarraysWithKDifferentIntegers {
    // Two pass, T:O(n), S:O(n)
    public int subarraysWithKDistinct(int[] A, int K) {
        // input check
        // if K is 3, get the number of at most k(0~k) and subtract the number of at most k-1(0~k-1)
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    public int atMostK(int[] A, int K) {
        // The element of A is positive integers
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int distinct = 0;
        int res = 0;
        while (r < A.length) {
            if (map.getOrDefault(A[r], 0) == 0) {
                distinct++;
            }
            map.put(A[r], map.getOrDefault(A[r], 0) + 1);

            while (distinct > K) {
                map.put(A[l], map.get(A[l]) - 1);
                if (map.get(A[l]) == 0) {
                    distinct--;
                }

                l++;
            }

            res += r - l + 1;
            r++;
        }

        return res;
    }

}
