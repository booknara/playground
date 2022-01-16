package com.booknara.problem.string;

/**
 * 418. Sentence Screen Fitting (Medium)
 * https://leetcode.com/problems/sentence-screen-fitting/
 */
public class SentenceScreenFitting {
  public int wordsTyping(String[] sentence, int rows, int cols) {
    // input check, 1 <= rows
    String s = String.join(" ", sentence) + " ";
    //System.out.println(s);
    int start = 0, len = s.length();
    for (int i = 0; i < rows; i++) {
      start += cols;
      if (s.charAt(start % len) == ' ') {
        start++;
      } else {
        while (start > 0 && s.charAt((start - 1) % len) != ' ') {
          start--;
        }
      }
    }

    return start / s.length();
  }
  // T:O(rows * cols), S:O(1), Time Limit Exceeded
  public int wordsTyping1(String[] sentence, int rows, int cols) {
    // input check, 1 <= rows
    int res = 0;

    int index = 0;
    for (int i = 0; i < rows; i++) {
      if (sentence[index].length() > cols) {
        // one of words in the setence is longer than cols
        return 0;
      }

      int remaining = cols;
      while (remaining >= sentence[index].length()) {
        remaining -= sentence[index].length();
        index++;
        if (index == sentence.length) {
          // the end of array and reset the index
          index = 0;
          res++;
        }
        if (remaining > 0) {
          // adding space between words, but not adding space in case of the end spot
          remaining--;
        }
      }
    }

    return res;
  }
}
/*
 sentence = ["abc", "de", "f"] rows = 4, cols = 6
 012345678
 s = abc_de_f_abc_de_f_abc_de_f_abc_de_f_     |||
 len = 9
 start = 0 + 6 % 9 = 6 -> s.charAt(6) == ' '
 abc_de
 start = (7 + 6) % 9 = 4 -> s.charAt(4) == 'd' 13 - 1 = 12
 start = (12 + 6) % 9 = 0 -> s.charAt(0) == 'a' 18 - 1 = 17 (8)
 start = (17 + 6) % 9 = 8 -> s.charAt(8) == ' '
 start = 23
 */
