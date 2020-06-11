package com.booknara.problem.array;

import com.booknara.problem.common.Relation;

/**
 * 277. Find the Celebrity (Medium)
 * https://leetcode.com/problems/find-the-celebrity/
 */
public class FindTheCelebrity extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        // System.out.println("candidate: " + candidate);
        // verifying the candidate
        for (int i = 0; i < n; i++) {
            // pass himsehlf/hershelf
            if (i == candidate) {
                continue;
            }

            // if celebrity knows someone, return -1
            // if someone does not knows someone, return -1
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }
}
