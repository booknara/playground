package com.booknara.problem.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 547. Friend Circles (Medium)
 * https://leetcode.com/problems/friend-circles/
 */
public class FriendCircles {
    // Much faster O(n)
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        int res = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                res++;
            }
        }

        return res;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        // indirect friends
        for (int j = 0; j < M.length; j++) {
            // all the target friends
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M, j, visited);
            }
        }
    }

    // O(n^2)
    public int findCircleNum1(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < M.length; i++) {
            map.put(i, i);
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                //System.out.println(M[i][j]);
                if (i == j) {
                    continue;
                }

                if (M[i][j] == 1) {
                    dfs1(M, map, i, j);
                }
            }
        }

        return new HashSet<>(map.values()).size();
    }

    private void dfs1(int[][] M, Map<Integer, Integer> map, int s, int t) {
        if (map.get(s).equals(map.get(t))) {
            return;
        }

        // value s -> value t
        map.put(t, map.get(s));

        // indirect friends
        for (int i = 0; i < M[t].length; i++) {
            // all the target friends
            if (M[t][i] == 1) {
                dfs1(M, map, t, i);
            }
        }
    }
}
