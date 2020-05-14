package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number (Medium)
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsPhoneNumber {
    // T: O(3^N * 4^M(N: the length of strings, M: the length of strings, e.g. 7, 9), S:O(3^N * 4^M)
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        StringBuilder builder = new StringBuilder();
        dfs(digits, 0, builder, res);
        return res;
    }

    private void dfs(String digits, int index, StringBuilder s, List<String> list) {
        if (index == digits.length()) {
            list.add(s.toString());
            return;
        }

        String letters = getLetter(digits.charAt(index));
        //System.out.println(letters);
        for (char c: letters.toCharArray()) {
            StringBuilder builder = new StringBuilder(s.toString());
            builder.append(c);
            dfs(digits, index + 1, builder, list);
        }
    }

    private String getLetter(char c) {
        switch(c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
        }

        return null;
    }
}
