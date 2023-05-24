package com.booknara.problem.math;

/**
 * 1523. Count Odd Numbers in an Interval Range (Easy)
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range
 */
public class CountOddNumbersInAnIntervalRange {
  // T:O(1), S:O(1)
  public int countOdds(int low, int high) {
    int res = 0;
    int diff = high - low + 1;
    if (diff % 2 == 0) {
      res = diff / 2;
    } else {
      if (low % 2 == 1) {
        res = (diff / 2) + 1;
      } else {
        res = diff / 2;
      }
    }

    return res;
  }
}
/**
 2 ~ 5: 4
 odd: 3, 5
 even: 2, 4
 2 ~ 4: 3
 odd: 3
 even: 2, 4

 1 ~ 3: 3
 odd: 1, 3
 even: 2

 high - low = difference
 difference % 2 = 0 -> difference / 2
 difference % 2 = 1 -> low % 2 == 1 ? (difference / 2) + 1, difference / 2
 */
