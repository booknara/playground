package com.booknara.problem.array;

import com.booknara.problem.common.Relation;

/**
 * 277. Find the Celebrity (Medium)
 * https://leetcode.com/problems/find-the-celebrity/
 */
public class FindTheCelebrity extends Relation {
    // T:O(n), S:O(1)
    public int findCelebrity(int n) {
        int celeb = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celeb, i)) {
                celeb = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (celeb == i) continue;

            // celeb knows i or i doesn't know celeb
            if (knows(celeb, i) || !knows(i, celeb)) return -1;
        }

        return celeb;
    }
}
