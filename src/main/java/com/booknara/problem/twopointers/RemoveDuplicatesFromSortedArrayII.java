package com.booknara.problem.twopointers;

/**
 * 80. Remove Duplicates from Sorted Array II (Medium)
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {
  // T:O(n), S:O(1)
  public int removeDuplicates(int[] nums) {
    // input check
    if (nums == null) return 0;
    if (nums.length <= 2) return nums.length;

    int l = 1, r = 1;
    int count = 0;
    while (r < nums.length) {
      if (nums[r] != nums[r - 1]) {
        nums[l] = nums[r];
        r++;
        l++;
        count = 0;
        continue;
      }

      if (count >= 1) {
        // skip
        r++;
        count++;
      } else {
        nums[l] = nums[r];
        r++;
        l++;
        count++;
      }
    }

    return l;
  }

  // T:O(n), S:O(1)
  public int removeDuplicates1(int[] nums) {
    // edge case
    if (nums == null || nums.length == 0) return 0;

    final int K = 2;
    int count = 1, pivot = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[pivot]) {
        pivot++;
        nums[pivot] = nums[i];
        count = 1;
      } else if (nums[i] == nums[pivot] && count < K) {
        pivot++;
        nums[pivot] = nums[i];
        count++;
      }
    }

    return pivot + 1;   // pivot is index number
  }
}
/**
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * k = 2
 * iterate the element from the second one
 * count = 1;
 * int pivot = 0;
 * if ()
 * 1. duplicate, but count < k
 * nums[pivot] = nums[i]
 * count++
 * 2, not duplicate,
 * nums[pivot] = nums[i]
 * count = 1;
 */
