package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning (Medium)
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
    // T:O(2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtracking(s, list, res);

        return res;
    }

    private void backtracking(String s, List<String> list, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                list.add(s.substring(0, i));
                backtracking(s.substring(i, s.length()), list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
