package com.booknara.problem.hash

/**
 * 409. Longest Palindrome (Easy)
 * https://leetcode.com/problems/longest-palindrome/
 */
class LongestPalindromeKt {
    // T:O(n), S:O(1)
    fun longestPalindrome(s: String): Int {
        var res = 0
        val bucket = Array(128){ 0 }

        for (c in s.toCharArray()) {
            bucket[c.toInt()]++
        }

        var odd = false
        for (n in bucket) {
            if (n % 2 == 0) {
                res += n
            } else {
                odd = true
                res += n - 1
            }
        }

        if (odd) res++

        return res
    }
}