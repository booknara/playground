package com.booknara.problem.search.binary;

/**
 * 702. Search in a Sorted Array of Unknown Size (Medium)
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 */
public class SearchInSortedArrayOfUnknownSize {
    // T:O(logn), S:O(1)
    public int search(ArrayReader reader, int target) {
        int right = 1;
        int left = 0;
        while (true) {
            right *= 2;
            if (reader.get(right) == target) return right;
            if (target < reader.get(right)) {
                break;
            }
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) return mid;
            if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    interface ArrayReader {
        int get(int index);
    }
}
