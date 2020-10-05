package com.booknara.problem.search.binary;

/**
 * 34. Find First and Last Position of Element in Sorted Array (Medium)
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    // T:O(logn), S:O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        // input check
        if (nums == null || nums.length == 0) return res;
        if (nums.length == 1) {
            if (nums[0] == target) {
                res[0] = 0;
                res[1] = 0;
                return res;
            }
        }

        // find the first position of element
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        // Not exist
        if (nums[r] != target) return res;

        res[0] = r;

        // find the last position of element
        r = nums.length - 1;
        while (l < r) {
            int m = (l + (r - l) / 2) + 1;  // Note: add "+1" to m to make it biased to right
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }

        if (nums[l] == target) res[1] = l;

        return res;
    }
    /**
     Input: nums =
     [5,7,7,8,8,10], target = 8
     [0,5] -> m = 2 (7), l = m + 1
     [3,5] -> m = 4 (8), r = m;
     [3,4] -> m = 3 (8), r = m;
     [3,3] -> m = 3 -> exit

     [5,7,7,8,8,10], target = 8
     [3,5] -> m = 5 (10), r = m - 1
     [3,4] -> m = 4 (8), l = m;
     [4,4] -> m = 3 (8)

     Output: [3,4]

     result: the index
     */
    // T:O(logn), S:O(1)
    public int[] searchRange1(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if (nums == null || nums.length == 0) return res;

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        // Not exist
        if (nums[r] != target) return res;

        // r = the first position of element
        res[0] = r;
        res[1] = r;
        for (int i = r + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }
            res[1] = i;
        }

        return res;
    }
}
/**
 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]

 [0,1,2,3,4, 5] , [0,5] m = 2, value = 7 l = m + 1
 [5,7,7,8,8,10]   [3,5] m = 4, value = 8 r = m;
 [3,4] m = 3, value = 8, r = m;
 */