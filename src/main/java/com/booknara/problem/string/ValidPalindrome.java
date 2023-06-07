package com.booknara.problem.string;

/**
 * 125. Valid Palindrome (Easy)
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
  // T:O(n), S:O(1)
  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) return true;

    int l = 0, r = s.length() - 1;
    while (l < r) {
      // filtering left character, only alphanumeric
      while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
      // filtering right character, only alphanumeric
      while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

      if (l >= r) return true;

      if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;

      l++;
      r--;
    }

    return true;
  }
}
