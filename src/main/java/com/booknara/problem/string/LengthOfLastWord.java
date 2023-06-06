package com.booknara.problem.string;

/**
 * 58. Length of Last Word (Easy)
 * https://leetcode.com/problems/length-of-last-word
 */
public class LengthOfLastWord {
  // T:O(n), S:O(n)
  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    boolean start = false;
    StringBuilder builder = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (c == ' ') {
        if (start) {
          break;
        }
      } else {
        start = true;
        builder.insert(0, c);
      }
    }

    return builder.toString().length();
  }

  // T:O(n), S:O(1)
  public int lengthOfLastWord1(String s) {
    // input check
    if (s == null || s.length() == 0) return 0;

    int res = 0;
    boolean start = false;
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (c == ' ') {
        if (!start) {
          continue;
        } else {
          break;
        }
      } else {
        start = true;
        res++;
      }
    }

    return res;
  }
}
