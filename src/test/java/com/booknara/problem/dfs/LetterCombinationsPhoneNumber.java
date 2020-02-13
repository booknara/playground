package com.booknara.problem.dfs;

import java.util.*;

/**
 * Leet code : 17. Letter Combinations of a Phone Number (Medium)
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsPhoneNumber {
    Map<Character, List<Character>> map = new HashMap<>();

    // Time: 3^N * 4^M(N: the length of strings, M: the length of strings, e.g. 7, 9)
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));

        dfs(digits, new StringBuilder(digits), digits.length(), 0, ans);
        return ans;
    }

    public void dfs(String input, StringBuilder source, int len, int i, List<String> ans) {
        if (len == i) {
            ans.add(source.toString());
            return;
        }

        List<Character> symbols = map.get(input.charAt(i));
        for (char c: symbols) {
            source.setCharAt(i, c);
            dfs(input, source, len, i + 1, ans);
        }
    }

}
