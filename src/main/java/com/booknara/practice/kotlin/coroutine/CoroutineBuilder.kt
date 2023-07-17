package com.booknara.practice.kotlin.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
//  test_launch()
//  test_async()
}

fun test_launch() {
  runBlocking {
    println("Before coroutine")

    launch {
      delay(1000)
      println("Inside coroutine")
    }

    println("After coroutine")
  }
}

fun test_async() {
  runBlocking {
    println("Before coroutine")

    val deferred = async {
      delay(1000)
      return@async (1..10).random()
    }

    println("After coroutine")
    println("Result: ${deferred.await()}")
  }
}
