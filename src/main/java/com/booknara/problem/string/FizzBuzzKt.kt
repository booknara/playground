package com.booknara.problem.string

/**
 * 412. Fizz Buzz (Easy)
 * https://leetcode.com/problems/fizz-buzz/
 */
class FizzBuzzKt {
  // T:O(n), S:(1)
  fun fizzBuzz(n: Int): List<String> {
    val res = mutableListOf<String>()

    for (i in 1..n) {
      if (i % 3 == 0 && i % 5 == 0) {
        res.add("FizzBuzz")
      } else if (i % 3 == 0) {
        res.add("Fizz")
      } else if (i % 5 == 0) {
        res.add("Buzz")
      } else {
        res.add(i.toString())
      }
    }

    return res
  }
}
