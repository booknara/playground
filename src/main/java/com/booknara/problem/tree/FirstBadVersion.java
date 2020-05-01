package com.booknara.problem.tree;

/**
 * 278. First Bad Version (Easy)
 * https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n == 0) {
            return 0;
        }
        // binary search
        int l = 1, r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (VersionControl.isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return r + 1;
    }

    public static class VersionControl {
        static boolean isBadVersion(int version) {return true;}
    }
}

