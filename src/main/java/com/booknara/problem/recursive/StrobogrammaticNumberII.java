package com.booknara.problem.recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 247. Strobogrammatic Number II (Medium)
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 */
public class StrobogrammaticNumberII {
    // T:O(5^(N/2)), 5 recursive branches + decreased by half, S:O(1)
    public List<String> findStrobogrammatic(int n) {
        // input check
        return dfs(n, n);
    }

    // 4
    public List<String> dfs(int n, int m) {
        // base case
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");

        List<String> list = dfs(n - 2, m);
        List<String> res = new ArrayList<>();
        for (String s: list) {
            if (n != m) {
                res.add("0" + s + "0"); //
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }
}
/**
 n = 1
 0, 1, 8
 n = 2
 11,69,88,96
 n = 3
 101,111,181
 609,619,689
 808,818,888
 906,916,986
 n = 4
 1001,1111
 */