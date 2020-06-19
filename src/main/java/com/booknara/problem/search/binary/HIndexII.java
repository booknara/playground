package com.booknara.problem.search.binary;

/**
 * 275. H-Index II (Medium)
 * https://leetcode.com/problems/h-index-ii/
 */
public class HIndexII {
    // T:O(logn), S:O(1)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        /*
        int index = 0;
        for (int i = 0; i < citations.length; i++) {
            // find the index which a value is equal or greater than N - i;
            if (citations[i] >= citations.length - i) {
                index = citations.length - i;
                break;
            }
        }
        */

        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == citations.length - mid) {
                return citations.length - mid;
            }

            if (citations[mid] > citations.length - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return citations.length - left;
    }
}
