package com.booknara.problem.string;

/**
 * 926. Flip String to Monotone Increasing
 * https://leetcode.com/problems/flip-string-to-monotone-increasing
 */
public class FlipStringToMonotoneIncreasing {
  // T:O(n), S:O(1)
  public int minFlipsMonoIncr(String s) {
    // edge case
    if (s == null || s.length() == 0) {
      return 0;
    }

    int flip = 0;
    int ones = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '1') {
        ones++;
      } else {
        if (ones > 0) {
          flip++;
          ones--;
        }
      }
    }

    return flip;
  }
}
/**
 Input: s = "00011000"
 Output: 2
 Explanation: We flip to get 00000000.
 00011000
 if c == '1', count '1'
 if c == '0', check the count and count  > 0 -> flip++ and count--
 000110
 */
