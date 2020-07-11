package com.booknara.problem.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 320. Generalized Abbreviation (Medium)
 * https://leetcode.com/problems/generalized-abbreviation/
 */
public class GeneralizedAbbreviation {
    // T:O(n * 2^n), S:O(n * 2^n)
    public List<String> generateAbbreviations(String word){
        List<String> res = new ArrayList<String>();
        backtrack(res, word.toCharArray(), 0, new StringBuilder(), 0);

        return res;
    }

    private void backtrack(List<String> res,
                           char[] words,
                           int pos,
                           StringBuilder builder,
                           int count) {
        if (pos == words.length) {
            if(count > 0) builder.append(count);
            res.add(builder.toString());
            return;
        }

        // abbreviate
        backtrack(res, words, pos + 1,
                new StringBuilder(builder.toString()), count + 1);
        // keep
        backtrack(res, words, pos + 1,
                new StringBuilder(builder.append(count > 0 ? count : "").append(words[pos]).toString()), 0);
    }
}
