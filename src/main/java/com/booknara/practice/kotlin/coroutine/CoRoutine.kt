package com.booknara.practice.kotlin.coroutine

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking<Unit> {
  val job = launch { // launch new coroutine and keep a reference to its Job
    delay(1000L)
    println("World!")
  }
  println("Hello,")
  job.join() // wait until child coroutine completes
}

//fun main() = runBlocking {
//    println("main starts")
//    joinAll(
//            async { coroutine(1, 500) },
//            async { coroutine(2, 300) }
//    )
//    println("main ends")
//}

suspend fun coroutine(number: Int, d: Long) {
    println("Coroutine $number starts work")
    delay(d)
    println("Coroutine $number has finished")
}
