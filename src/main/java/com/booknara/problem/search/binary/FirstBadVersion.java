package com.booknara.problem.search.binary;

import static com.booknara.problem.search.binary.FirstBadVersion.VersionControl.isBadVersion;

/**
 * 278. First Bad Version (Easy)
 * https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {
    // T:O(logn), S:O(1)
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
 [1,2,3,4,5]
 [f,f,f,t,t]
 [1,5] -> 3 (f)
 [4,5] -> 4 (t)
 [4,4] -> return 4;
 */
    public static class VersionControl {
        static boolean isBadVersion(int version) {return true;}
    }
}

