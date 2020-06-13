package com.booknara.problem.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 247. Strobogrammatic Number II (Medium)
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 */
public class StrobogrammaticNumberII {
    // T:O(5^(N/2)), S:O(1)
    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }

    public List<String> dfs(int n, int m) {
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");

        List<String> list = dfs(n - 2, m);

        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (n != m) {
                // only add it inside
                res.add("0" + list.get(i) + "0");
            }
            res.add("1" + list.get(i) + "1");
            res.add("6" + list.get(i) + "9");
            res.add("9" + list.get(i) + "6");
            res.add("8" + list.get(i) + "8");
        }

        return res;
    }
}
