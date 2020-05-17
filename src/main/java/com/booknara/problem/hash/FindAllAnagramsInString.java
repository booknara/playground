package com.booknara.problem.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 438. Find All Anagrams in a String (Medium)
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInString {
    // T:O(n), S:O(1)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() * p.length() == 0) {
            return res;
        }

        int[] pCount = new int[26];
        for (char c: p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int[] sCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            if (i - p.length() >= 0) {
                // remove out of range
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            if (i >= p.length() - 1) {
                // compare pCount and sCount
                boolean same = true;
                for (int j = 0; j < 26; j++) {
                    if (sCount[j] != pCount[j]) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    res.add(i - p.length() + 1);
                }
            }
        }

        return res;
    }

    // O(|s| * |p|)
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        Set<Character> set = new HashSet<>();
        for (char c: p.toCharArray()) {
            set.add(c);
        }

        int len = p.length();
        String pAnagram = getUniqueAnagram(p);
        for (int i = 0; i < s.length() - len + 1; i++) {
            if (!set.contains(s.charAt(i))) continue;

            String part = s.substring(i, i + len);
            if (isAnagram(part, pAnagram)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isAnagram(String s, String t) {
        return getUniqueAnagram(s).equals(t);
    }

    private String getUniqueAnagram(String s) {
        int[] count1 = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            count1[c1 - 'a']++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            builder.append(count1[i]);
        }

        return builder.toString();
    }
}
