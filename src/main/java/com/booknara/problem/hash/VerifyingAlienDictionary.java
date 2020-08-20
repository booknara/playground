package com.booknara.problem.hash;

/**
 * 953. Verifying an Alien Dictionary (Easy)
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class VerifyingAlienDictionary {
    // T:O(n*m), S:(1)
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0) {
            return true;
        }

        int[] bucket = new int[order.length()];
        for (int i = 0; i< order.length(); i++) {
            char c = order.charAt(i);
            bucket[c - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!order(words[i], words[i + 1], bucket)) {
                return false;
            }
        }

        return true;
    }

    private boolean order(String s1, String s2, int[] bucket) {
        int m = s1.length();
        int n = s2.length();
        int i = 0;
        while (i < m && i < n) {
            // Correct order
            if (bucket[s1.charAt(i) - 'a'] < bucket[s2.charAt(i) - 'a']) {
                return true;
            }
            // Wrong order
            if (bucket[s1.charAt(i) - 'a'] > bucket[s2.charAt(i) - 'a']) {
                return false;
            }
            // Same character
            i++;
        }

        // One of strings is a subset
        return m <= n;
    }
}
