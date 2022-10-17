package com.booknara.problem.array;

/**
 * 1832. Check if the Sentence Is Pangram (Easy)
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */
public class CheckIfSentenceIsPangram {
  final static int ALPHABET = 26;
  final static int START = 97;

  // T:O(n), S:O(1)
  public boolean checkIfPangram(String sentence) {
    int[] array = new int[256];
    for (int i = 0; i < sentence.length(); i++) {
      char c = sentence.charAt(i);
      array[c]++;
    }

    for (int i = 0; i < ALPHABET; i++) {
      if (array[97 + i] == 0) {
        return false;
      }
    }

    return true;
  }
}
