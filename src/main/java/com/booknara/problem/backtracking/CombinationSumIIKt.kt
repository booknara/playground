package com.booknara.problem.backtracking

/**
 * 40. Combination Sum II (Medium)
 * https://leetcode.com/problems/combination-sum-ii/
 */
class CombinationSumIIKt {
    // T:O(2^n), S:O(2^n)
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        // input check, the length of candidates >= 1
        val res: MutableList<List<Int>> = ArrayList()

        candidates.sort()
        val list: MutableList<Int> = ArrayList()
        helper(candidates, 0, target, list, res)
        return res
    }

    fun helper(candidates: IntArray, index: Int, remaining: Int,
               list: MutableList<Int>,
               res: MutableList<List<Int>>) {
        if (remaining < 0) return

        if (remaining == 0) {
            res.add(ArrayList<Int>(list))
            return
        }

        if (index == candidates.size) return

        // Pruning
        if (candidates[index] > remaining) return

        for (i in index until candidates.size) {
            if (i > index && candidates[i - 1] == candidates[i]) continue

            list.add(candidates[i])
            helper(candidates, i + 1, remaining - candidates[i], list, res)
            list.removeAt(list.size - 1)
        }
    }
}