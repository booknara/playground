package com.booknara.problem.array;

import java.util.Arrays;

/**
 * 274. H-Index (Medium)
 * https://leetcode.com/problems/h-index/
 */
public class HIndex {
    // T:O(n), S:O(1)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        // input check
        Arrays.sort(citations);
        int hIndex = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int count = citations.length - i;

            if (citations[i] >= count) {
                hIndex = count;
            } else {
                break;
            }
        }

        return hIndex;
    }
}
