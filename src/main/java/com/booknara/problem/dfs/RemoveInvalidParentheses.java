package com.booknara.problem.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Leet code : 301. Remove Invalid Parentheses(Hard)
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Example 1:
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 *
 * Example 2:
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 *
 * Example 3:
 * Input: ")("
 * Output: [""]

 * Example 4:
 * Input: "(((()"
 * Output: [""]
 *
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[] {'(', ')'}, false);
        return ans;
    }

    public void remove(String s, List<String> ans, int lastI, int lastJ, char[] par, boolean r) {
        System.out.println(s + " " + r);
        int stack = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;

            // We have an extra closed/opened paren we need to remove
            for (int j = lastJ; j <= i; j++) { // Try removing one at each position, skipping duplicates e.g "((", "))"
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    // Recursion: lastI = i
                    // since we now have valid # closed parenthesis thru i. lastJ = j prevents duplicates
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par, r);
                }
            }

            return; // Stop here. The recursive calls handle the rest of the string.
        }

        // No invalid closed parenthesis detected.
        // Now check opposite direction, or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            System.out.println("reversed");
            remove(reversed, ans, 0, 0, new char[] {')', '('}, !r);
        } else {
            ans.add(reversed);
        }
    }
}
