package com.booknara.problem.iterator


/**
 * 251. Flatten 2D Vector (Medium)
 * https://leetcode.com/problems/flatten-2d-vector/
 */
class Vector2D(v: Array<IntArray>) {
  var r = 0
  var c = 0
  val list: Array<IntArray>

  init {
    list = v
    moveNext()
  }

  // T:O(1), S:O(1)
  fun next(): Int {
    if (c > list[r].lastIndex) {
      moveNext()
    }

    val res = list[r][c]
    c++
    return res
  }

  // T:O(1), S:O(1)
  fun hasNext(): Boolean {
    moveNext()

    return r <= list.lastIndex
  }

  fun moveNext() {
    while (r <= list.lastIndex && (list[r].isEmpty() || c > list[r].lastIndex)) {
      c = 0
      r++
    }
  }
}

//class Vector2D(v: Array<IntArray>) {
//  val list = LinkedList<Int>()
//  init {
//    for (i in v.indices) {
//      for (j in v[i].indices) {
//        list.offer(v[i][j])
//      }
//    }
//  }
//
//  fun next(): Int {
//    return list.poll()
//  }
//
//  fun hasNext(): Boolean {
//    return !list.isEmpty()
//  }
//}