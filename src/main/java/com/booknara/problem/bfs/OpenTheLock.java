package com.booknara.problem.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. Open the Lock (Medium)
 * https://leetcode.com/problems/open-the-lock/
 */
public class OpenTheLock {
    // T:O(n^2*m^n+d), S:O(m^n + d), n: the number of digit(10), m: the length of rotating key, d:the number of dead-end
    public int openLock(String[] deadends, String target) {
        final String start ="0000";
        // input check
        if (target.equals(start)) return 0;

        Set<String> deads = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String d: deadends) {
            deads.add(d);
        }
        // edge case
        if (deads.contains(start) || deads.contains(target)) {
            return -1;
        }

        int level = 0;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                String s = q.poll();
                if (s.equals(target)) {
                    return level;
                }

                // rotate each digit(0~4)
                for (int j = 0; j < 4; j++) {
                    // each digit can make two candiates
                    char c = s.charAt(j);
                    int before = c - '0' - 1;
                    if (before < 0) before = 9;
                    String beforeS = s.substring(0, j) + before + s.substring(j + 1, 4);
                    // check dead end and visited
                    if (!deads.contains(beforeS) && !visited.contains(beforeS)) {
                        q.offer(beforeS);
                        visited.add(beforeS);
                    }

                    int after = c - '0' + 1;
                    if (after > 9) after = 0;
                    String afterS = s.substring(0, j) + after + s.substring(j + 1, 4);
                    // check dead end and visited
                    if (!deads.contains(afterS) && !visited.contains(afterS)) {
                        q.offer(afterS);
                        visited.add(afterS);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
/**
 BFS
 '0000'
 one move candiates
 1: '9000' or '1000'
 2: '0900' or '0100'
 3: '0090' or '0010'
 4: '0009' or '0001'

 but two things to need
 deads check
 visited check
 */