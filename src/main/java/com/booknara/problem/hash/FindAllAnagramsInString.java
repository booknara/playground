package com.booknara.problem.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    // T:O(n), S:O(1)
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // input check, non-empty string p
        if (s.length() == 0) return res;
        if (s.length() < p.length()) return res;

        int[] pBucket = new int[26];
        for (char c: p.toCharArray()) {
            pBucket[c - 'a']++;
        }

        int[] slice = new int[26];
        int l = 0, r = 0;
        while (r < s.length()) {
            // 00, 01, 02
            if (r - l < p.length()) {
                slice[s.charAt(r) - 'a']++;
                r++;
                continue;
            }

            // 03,41
            // compare pBucket and slice
            if (Arrays.equals(pBucket, slice)) {
                res.add(l);
            }
            slice[s.charAt(r) - 'a']++;
            slice[s.charAt(l) - 'a']--;
            r++;
            l++;
        }

        // the remaining comparision
        if (Arrays.equals(pBucket, slice)) {
            res.add(l);
        }

        return res;
    }
}

/**
 s: "cbaebabacd"
 p: "abc"

 // lowercase English letters only
 Slicing window
 cbaebabacd
 abc
 abc
 abc
 abc
 abc

 c: 1, b: 1, a: 1
 a: 1, b: 1, c: 1

 find all the start indices of p's anagrams in s.
 */