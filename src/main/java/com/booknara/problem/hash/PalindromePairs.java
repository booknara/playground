package com.booknara.problem.hash;

import java.util.*;

/**
 * 336. Palindrome Pairs (Hard)
 * https://leetcode.com/problems/palindrome-pairs/
 */
public class PalindromePairs {
    // T:O(k^2*n), S:O(n)
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length <= 0) {
            return res;
        }

        // unique words list
        int n = words.length;
        Map<String, Integer> reversedMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            reversedMap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        for (int i = 0; i < n; i++) {
            String s = words[i];
            // same length
            if (reversedMap.containsKey(s) && i != reversedMap.get(s)) {
                res.add(Arrays.asList(i, reversedMap.get(s)));
            }

            // forward
            for (int j = 0; j < s.length(); j++) {
                String left = s.substring(0, j);
                // middle string check
                if (!isPalindrome(s, j, s.length() - 1)) {
                    continue;
                }

                if (reversedMap.containsKey(left)) {
                    int idx = reversedMap.get(left);
                    if (i != idx) {
                        res.add(Arrays.asList(i, idx));
                    }
                }
            }

            // backward
            for (int j = 0; j < s.length(); j++) {
                String right = s.substring(j + 1);
                // middle string check
                if (!isPalindrome(s, 0, j)) {
                    continue;
                }

                if (reversedMap.containsKey(right)) {
                    int idx = reversedMap.get(right);
                    if (i != idx) {
                        res.add(Arrays.asList(idx, i));
                    }
                }
            }
        }

        return res;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
/**
 Input: words = ["abcd","dcba","lls","s","sssll"]
 Output: [[0,1],[1,0],[3,2],[2,4]]
 Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

 Method1 Reversed string
 ["abcd","dcba","lls","s","sssll"]

 [
 "abcd" -> "dcba" : 0
 "dcba" -> "abcd" : 1
 "lls"  -> "sll"  : 2
 "s"    -> "s"    : 3
 "sssll"-> "llsss": 4
 ]
 */