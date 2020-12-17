package com.booknara.practice.kotlin.memory

data class Alpha(val v: Int)

fun allocateHeap() {
  var aDataClass = Alpha(-1)
  for (i in 0..10_000_000) {
    aDataClass = Alpha(i)
  }
}

fun allocateStack() {
  var count = 0
  for (i in 0..10_000_000) {
    val a = Alpha(i)
    count += a.v
  }
}

fun main() {
  var start = System.currentTimeMillis()
  allocateHeap()
  println("the time spent by the heap: ${System.currentTimeMillis() - start}")

  start = System.currentTimeMillis()
  allocateStack()
  println("the time spent by the stack: ${System.currentTimeMillis() - start}")
}