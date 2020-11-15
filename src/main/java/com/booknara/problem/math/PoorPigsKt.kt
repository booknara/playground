package com.booknara.problem.math

/**
 * 458. Poor Pigs (Hard)
 * https://leetcode.com/problems/poor-pigs/
 */
class PoorPigsKt {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        val states = minutesToTest / minutesToDie + 1
        return Math.ceil(Math.log(buckets * 1.0) / Math.log(states * 1.0)).toInt()
    }
}