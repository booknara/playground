package com.booknara.problem.array;

/**
 * 1832. Check if the Sentence Is Pangram (Easy)
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */
public class CheckIfSentenceIsPangram {
  // T:O(n), S:O(1)
  public boolean checkIfPangram(String sentence) {
    // edge case
    if (sentence.length() == 0) return false;

    int[] data = new int[26];
    for (char c: sentence.toCharArray()) {
      data[c - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
      if (data[i] == 0) return false;
    }

    return true;
  }
}
