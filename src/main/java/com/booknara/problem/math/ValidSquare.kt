package com.booknara.problem.math

/**
 * 593. Valid Square (Medium)
 * https://leetcode.com/problems/valid-square/
 */
class ValidSquare {
    // T:O(1), S:O(1)
    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        // input check, there are four points
        val points = arrayOf(p1, p2, p3, p4)
        points.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

        return (getDistance(points[0], points[1]) != 0) and
                (getDistance(points[0], points[1]) == getDistance(points[1], points[3])) and
                (getDistance(points[1], points[3]) == getDistance(points[3], points[2])) and
                (getDistance(points[3], points[2]) == getDistance(points[2], points[0])) and
                (getDistance(points[0], points[3]) == getDistance(points[1], points[2]))
    }

    private fun getDistance(p1: IntArray, p2: IntArray) = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1])
}

fun main() {
    val valid = ValidSquare().validSquare(
            intArrayOf(0, 0),
            intArrayOf(5, 0),
            intArrayOf(5, 4),
            intArrayOf(0, 4)
    )
    println(valid)
}
/*
(0,4)   (5,4)

(0,0)   (5,0)
[1134,-2539]
[492,-1255]
[-792,-1897]
[-150,-3181]
 */