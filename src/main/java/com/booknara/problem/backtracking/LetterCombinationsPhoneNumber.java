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

        char c = digits.charAt(index);  // 2
        String letters = getDigitLetters(c);    // "abc"
        for (char l: letters.toCharArray()) {
            builder.append(l);
            dfs(digits, index + 1, builder, res);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public String getDigitLetters(char num) {
        String res;
        switch(num) {
            case '2': res = "abc";
                break;
            case '3': res = "def";
                break;
            case '4': res = "ghi";
                break;
            case '5': res = "jkl";
                break;
            case '6': res = "mno";
                break;
            case '7': res = "pqrs";
                break;
            case '8': res = "tuv";
                break;
            case '9': res = "wxyz";
                break;
            default:
                res = "";
                break;
        }

        return res;
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