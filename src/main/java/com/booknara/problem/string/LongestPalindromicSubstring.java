package com.booknara.problem.string;

/**
 * 5. Longest Palindromic Substring (Medium)
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    // T:O(n^2), S:O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        int max = 0;
        int start = 0, end = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            // case #1 (starting from single character)
            int l = i, r = i;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                if (max < r - l + 1) {
                    max = r - l + 1;
                    start = l;
                    end = r;
                }

                l--;
                r++;
            }

            // case #2 (starting from two characters)
            l = i - 1;
            r = i;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                if (max < r - l + 1) {
                    max = r - l + 1;
                    start = l;
                    end = r;
                }

                l--;
                r++;
            }
        }

        return s.substring(start, end + 1);
    }
}
/**
 Input: "babad"
 Output: "bab"

 Bruce force: O(n^3)


 "babad"
 01234

 "baaba"
 01234

 Palindrome case #1
 keeping expadning from index i

 Palindrome case #2
 if i != 0 && index i - 1, i is same
 keeping expadning to left/right side
 */