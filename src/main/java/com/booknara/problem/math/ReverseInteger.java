package com.booknara.problem.math;

/**
 * 7. Reverse Integer (Integer)
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
  // T:O(n, the number of x's digits), S:O(1)
  public int reverse(int x) {
    int negative = x < 0 ? -1 : 1;

    x = Math.abs(x);
    long res = 0;
    while (x > 0) {
      int mod = x % 10;
      x /= 10;

      res = res * 10 + mod;
      // if overflow, return 0;
      if (negative * res < Integer.MIN_VALUE
          || negative * res > Integer.MAX_VALUE) return 0;
    }

    return (int) res * negative;
  }

  // T:O(n, the number of x's digits), S:O(1)
  public int reverse1(int x) {
    int val = 0;
    while (x != 0) {
      int r = x % 10;
      x = x / 10;
      int newVal = val * 10 + r;
      if ((newVal - r) / 10 != val) { // same value condition for checking overflow
        return 0;
      }
      val = newVal;
    }

    return val;
  }
}
/**
 * val = 0;
 * r = x % 10
 * x = x / 10
 * val = val * 10 + r;
 * how to handle overflow
 */
