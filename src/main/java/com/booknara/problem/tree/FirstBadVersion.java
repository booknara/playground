package com.booknara.problem.tree;

import static com.booknara.problem.tree.FirstBadVersion.VersionControl.isBadVersion;

/**
 * 278. First Bad Version (Easy)
 * https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        // input check
        if (n == 0) return -1; // new IllegalArgmentException("invalid input");
        if (n == 1) return isBadVersion(1) ? 1 : 0;

        // [1,2,3,4(B),5(B)]
        int l = 1, r = n;   // [1,5] -> [4,5] -> [4,4]
        while (l < r) {
            int m = l + (r - l) / 2;    // [3] -> [4]
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        // 1
        return r;
    }

/**
 [1,2(B),3,4,5,6]

 Method: Binary search
 [1 ~ n]
 while (l < r) {
 m = l + (m - r) / 2;
 if (isBadVersion(m)) {
 r = m;
 } else {
 l = m + 1;
 }
 }

 return r;
 */
    public static class VersionControl {
        static boolean isBadVersion(int version) {return true;}
    }
}

