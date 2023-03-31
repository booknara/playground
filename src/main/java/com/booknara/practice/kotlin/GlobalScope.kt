package com.booknara.practice.kotlin

import kotlinx.coroutines.*

fun main() {
  val states = arrayOf("Starting", "Doing Task 1", "Doing Task 2", "Ending")
  println("GlobalScope start")
  repeat(3) {
    GlobalScope.launch {
      println("GlobalScope ${Thread.currentThread()} has started")
      for (i in states) {
        println("GlobalScope ${Thread.currentThread()} - $i")
      }
    }
  }

  println("runBlocking start")
  repeat(3) {
    runBlocking {
      println("runBlocking ${Thread.currentThread()} has started")
      for (i in states) {
        println("runBlocking ${Thread.currentThread()} - $i")
      }
    }
  }
  println("end")
}
