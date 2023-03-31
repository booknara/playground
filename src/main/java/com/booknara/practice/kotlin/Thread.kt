package com.booknara.practice.kotlin

import kotlinx.coroutines.*
import java.lang.Runnable

fun main() {
  val t = Thread(object: Runnable {
    override fun run() {
      println("${Thread.currentThread()} has run.")
    }
  })
  //t.start()

  val thread = Thread {
    println("${Thread.currentThread()} has run.")
  }
  //thread.start()

  val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
  repeat(3) {
    val t = Thread {
      println("${Thread.currentThread()} has started")
      for (i in states) {
        println("${Thread.currentThread()} - $i")
        Thread.sleep(50)
      }
    }
    //t.start()
  }

//  repeat(3) {
//    GlobalScope.launch {
//      println("${Thread.currentThread()} has started")
//      for (i in states) {
//        println("${Thread.currentThread()} - $i")
//      }
//    }
//  }

  repeat(3) {
    GlobalScope.launch {
      print(states)
    }
  }

//  var count = 0
//  for (i in 1..50) {
//    Thread {
//      count += 1
//      println("Thread: $i count: $count")
//    }.start()
//  }
}

fun print(states: Array<String>) {
  println("${Thread.currentThread()} has started")
  for (i in states) {
    println("${Thread.currentThread()} - $i")
  }
}
