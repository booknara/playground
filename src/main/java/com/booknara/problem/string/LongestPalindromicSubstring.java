package com.booknara.problem.string;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j + 1);
                if (set.contains(word)) {
                    continue;
                }

                set.add(word);
            }
        }

        return "";

    }
}
