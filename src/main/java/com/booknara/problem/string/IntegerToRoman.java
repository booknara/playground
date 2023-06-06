package com.booknara.problem.string;

/**
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman
 */
public class IntegerToRoman {
  // T:O(n), S:O(1)
  public String intToRoman(int num) {
    // input check
    if (num <= 0) return "";
    StringBuilder builder = new StringBuilder();
    int digit = 0;
    while (num > 0) {
      int r = num % 10;
      num = num / 10;

      builder.insert(0, getRoman(r, digit));
      digit++;
    }

    return builder.toString();
  }

  public String getRoman(int n, int digit) {
    StringBuilder res = new StringBuilder();
    switch (n) {
      case 1:
        if (digit == 0) {
          res.append("I");
        } else if (digit == 1) {
          res.append("X");
        } else if (digit == 2) {
          res.append("C");
        } else if (digit == 3) {
          res.append("M");
        }
        break;
      case 2:
        if (digit == 0) {
          res.append("II");
        } else if (digit == 1) {
          res.append("XX");
        } else if (digit == 2) {
          res.append("CC");
        } else if (digit == 3) {
          res.append("MM");
        }
        break;
      case 3:
        if (digit == 0) {
          res.append("III");
        } else if (digit == 1) {
          res.append("XXX");
        } else if (digit == 2) {
          res.append("CCC");
        } else if (digit == 3) {
          res.append("MMM");
        }
        break;
      case 4:
        if (digit == 0) {
          res.append("IV");
        } else if (digit == 1) {
          res.append("XL");
        } else if (digit == 2) {
          res.append("CD");
        }
        break;
      case 5:
        if (digit == 0) {
          res.append("V");
        } else if (digit == 1) {
          res.append("L");
        } else if (digit == 2) {
          res.append("D");
        }
        break;
      case 6:
        if (digit == 0) {
          res.append("VI");
        } else if (digit == 1) {
          res.append("LX");
        } else if (digit == 2) {
          res.append("DC");
        }
        break;
      case 7:
        if (digit == 0) {
          res.insert(0, "VII");
        } else if (digit == 1) {
          res.insert(0, "LXX");
        } else if (digit == 2) {
          res.insert(0, "DCC");
        }
        break;
      case 8:
        if (digit == 0) {
          res.append("VIII");
        } else if (digit == 1) {
          res.append("LXXX");
        } else if (digit == 2) {
          res.append("DCCC");
        }
        break;
      case 9:
        if (digit == 0) {
          res.append("IX");
        } else if (digit == 1) {
          res.append("XC");
        } else if (digit == 2) {
          res.append("CM");
        }
        break;
    }

    return res.toString();
  }
}
/**
 4=IV, 9=IX
 40=XL, 90=XC
 400=CD, 900=CM
 */
