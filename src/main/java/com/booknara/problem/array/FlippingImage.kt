package com.booknara.problem.array

/**
 * 832. Flipping an Image (Easy)
 * https://leetcode.com/problems/flipping-an-image/
 */
class FlippingImage {
    // T:O(n^2), S:O(1)
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        // input check
        for (row in A) {
            var l = 0
            var r = row.size - 1
            while (l <= r) {
                swap(row, l, r);
                l++
                r--
            }
        }

        return A
    }

    fun swap(array: IntArray, l: Int, r: Int) {
        if (l == r) {
            if (array[l] == 0) array[l] = 1
            else array[l] = 0
            return;
        }

        if (array[l] == 0) array[l] = 1
        else array[l] = 0
        if (array[r] == 0) array[r] = 1
        else array[r] = 0

        val temp = array[l]
        array[l] = array[r]
        array[r] = temp
    }
}
/**
Input: [[1,1,0],[1,0,1],[0,0,0]]
[
[1,1,0], -> [0,1,1] -> [1,0,0]
[1,0,1], -> [1,0,1] -> [0,1,0]
[0,0,0]] -> [0,0,0] -> [1,1,1]

Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

flip -> invert == invert -> flip
 */

fun main() {
    val list = arrayOf(
            intArrayOf(1,1,0),
            intArrayOf(1,0,1),
            intArrayOf(0,0,0)
    )
    FlippingImage().flipAndInvertImage(list)
}