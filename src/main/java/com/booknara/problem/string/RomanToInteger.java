package com.booknara.problem.string;

/**
 * 13. Roman to Integer (Easy)
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
  // T:O(n), S:O(1)
  public int romanToInt(String s) {
    // input check
    if (s == null || s.length() == 0) return 0;

    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case 'I':
          res += 1;
          break;
        case 'V':
          if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
            res += 3;   // 4 - 1
          } else {
            res += 5;
          }
          break;
        case 'X':
          if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
            res += 8;   // 9 - 1
          } else {
            res += 10;
          }
          break;
        case 'L':
          if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
            res += 30;   // 40 - 10
          } else {
            res += 50;
          }
          break;
        case 'C':
          if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
            res += 80;   // 90 - 10
          } else {
            res += 100;
          }
          break;
        case 'D':
          if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
            res += 300;   // 400 - 10
          } else {
            res += 500;
          }
          break;
        case 'M':
          if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
            res += 800;   // 900 - 10
          } else {
            res += 1000;
          }
          break;
      }
    }

    return res;
  }
}
