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
        // input check
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        // "23"
        dfs(digits, 0, new StringBuilder(), res);

        return res;
    }

    public void dfs(String digits, int index, StringBuilder builder, List<String> res) {
        // base case
        if (index == digits.length()) {
            res.add(builder.toString());
            return;
        }

        String letters = getLetter(digits.charAt(index));    // "abc"
        for (char l: letters.toCharArray()) {
            builder.append(l);
            dfs(digits, index + 1, builder, res);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public String getLetter(char c) {
        if (c == '2') return"abc";
        if (c == '3') return"def";
        if (c == '4') return"ghi";
        if (c == '5') return"jkl";
        if (c == '6') return"mno";
        if (c == '7') return"pqrs";
        if (c == '8') return"tuv";
        if (c == '9') return"wxyz";

        return "";
    }
}
/**
 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 2 = "abc"
 3 = "def"
 4 = "ghi"
 5 = "jkl"
 6 = "mno"
 7 = "pqrs"
 8 = "tuv"
 9 = "wxyz"

 2 -> a or b or c
 3 -> ad   bd   cd
 ae   be   ce
 af   bf   cf
 */