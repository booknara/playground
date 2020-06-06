package com.booknara.problem.string;

/**
 * 1419. Minimum Number of Frogs Croaking (Medium)
 * https://leetcode.com/problems/minimum-number-of-frogs-croaking/
 */
public class MinimumNumberOfFrogsCroaking {
    // T:O(n), S:O(1)
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs == null || croakOfFrogs.length() == 0) {
            return 0;
        }

        //c r o a k
        int max = 0;
        boolean finished = true;
        int[] bucket = new int[26];
        for (char c: croakOfFrogs.toCharArray()) {
            if (c == 'c') {
                finished = false;
                bucket[c - 'a']++;
                max = Math.max(max, bucket[c - 'a']);
            } else if (c == 'r') {
                if (bucket['c' - 'a'] == bucket[c - 'a']) return -1;
                bucket[c - 'a']++;
            } else if (c == 'o') {
                if (bucket['r' - 'a'] == bucket[c - 'a']) return -1;
                bucket[c - 'a']++;
            } else if (c == 'a') {
                if (bucket['o' - 'a'] == bucket[c - 'a']) return -1;
                bucket[c - 'a']++;
            } else if (c == 'k') {
                if (bucket['a' - 'a'] == bucket[c - 'a']) return -1;
                for (char w: "croak".toCharArray()) {
                    bucket[w - 'a']--;
                }
                finished = true;
            }
        }

        return finished ? max : -1;
    }
}
