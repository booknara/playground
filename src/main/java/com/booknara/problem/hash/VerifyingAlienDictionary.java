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

    public boolean isAlienSorted1(String[] words, String order) {
        // input check words >= 1
        // order.length == 26
        int[] bucket = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            bucket[c - 'a'] = i;
        }

        // bucket has numbers. like bucket['h'- 'a'] = 0
        for (int i = 1; i < words.length; i++) {
            // compare two words
            String pre = words[i - 1];
            String cur = words[i];
            int j = 0;
            boolean guarantee = false;
            while (j < pre.length() && j < cur.length()) {
                if (bucket[pre.charAt(j) - 'a'] == bucket[cur.charAt(j) - 'a']) {
                    j++;
                    continue;
                }

                if (bucket[pre.charAt(j) - 'a'] > bucket[cur.charAt(j) - 'a']) {
                    return false;
                }

                guarantee = true;
                break;
            }

            if (!guarantee) {
                if (pre.length() > cur.length()) return false;
            }
        }

        return true;
    }

}
