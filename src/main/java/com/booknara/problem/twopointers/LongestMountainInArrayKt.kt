package com.booknara.problem.twopointers

/**
 * 845. Longest Mountain in Array (Medium)
 * https://leetcode.com/problems/longest-mountain-in-array/
 */
class LongestMountainInArrayKt {
    // T:O(n), S:O(1)
    fun longestMountain(A: IntArray): Int {
        // input check
        if (A.size <= 2) return 0

        var res = 0
        var i = 1
        while (i < A.size - 1) {
            var left = i - 1
            var right = i + 1
            if (A[left] >= A[i] || A[i] <= A[right]) {
                i = right
                continue
            }

            while ((left >= 0 && A[left] < A[left + 1]) || (right < A.size && A[right - 1] > A[right])) {
                if (left >= 0 && A[left] < A[left + 1]) {
                    left--
                }
                if (right < A.size && A[right - 1] > A[right]) {
                    right++
                }
            }

            res = Math.max(res, (right - 1) - (left + 1) + 1)

            i = right
        }

        return res
    }
}
/*
[2,1,4,7,3,2,5]
1. find the peek point
2. the prev and next neighbor should be smaller than the peek
3. move the prev and next pointers
4. get the longest mountain
5. move the peek point by adding the right point
*/