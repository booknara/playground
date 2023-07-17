package com.booknara.practice.kotlin.coroutine

import kotlinx.coroutines.*

/**
 * Structure concurrency
 * Here are the most important effects of the parent-child relationship:
 * children inherit context from their parent(but can also overwrite it)
 * a parent suspends until all the children are finished
 * when the parent is canceled, its child coroutines are canceled too
 * when a child raises an error, it destroys the parent as well
 * Link: https://medium.com/@erik.antonyan1994/understanding-structured-concurrency-in-kotlin-coroutines-5693f941a898
 */
fun main() {
//  test_not_waiting_globalscope()
//  test_waiting_globalscope()
//  test_not_waiting_coroutinescope()
//  test_children_inherit_context_coroutinescope()
//  test_children_not_inherit_parent_coroutinejob_1()
//  test_children_not_inherit_parent_coroutinejob_2()
//  test_not_waiting_children_when_children_replace_coroutinejob()
}

fun test_not_waiting_globalscope() {
  runBlocking {
    GlobalScope.launch {
      delay(1000L)
      println("Coroutine!")
    }

    GlobalScope.launch {
      delay(2000L)
      println("Coroutine!")
    }
    println("Hello,")
  }
}

fun test_waiting_globalscope() {
  runBlocking {
    GlobalScope.launch {
      delay(1000L)
      println("Coroutine!")
    }

    GlobalScope.launch {
      delay(2000L)
      println("Coroutine!")
    }
    println("Hello,")
    delay(3000L)
  }
}

fun test_not_waiting_coroutinescope() {
  runBlocking {
    launch {
      delay(1000L)
      println("Coroutine!")
    }

    launch {
      delay(2000L)
      println("Coroutine!")
    }
    println("Hello,")
  }
}

@OptIn(ExperimentalStdlibApi::class)
fun test_children_inherit_context_coroutinescope() {
  val context = CoroutineName("Run blocking") + Dispatchers.IO
  runBlocking(context) {
    val parentName = coroutineContext[CoroutineName]?.name
    val parentDispatcher = coroutineContext[CoroutineDispatcher]
    println(parentName) // Run blocking
    println(parentDispatcher) // Dispatchers.IO
    launch {
      delay(1000)
      val childName = coroutineContext[CoroutineName]?.name
      val childDispatcher = coroutineContext[CoroutineDispatcher]
      println(childName) // Run blocking
      println(childDispatcher) // Dispatchers.IO
    }
  }
}

fun test_children_not_inherit_parent_coroutinejob_1() {
  runBlocking {
    val name = CoroutineName("Parent name")
    val parentJob = Job()
    launch(name + parentJob) {
      val childName = coroutineContext[CoroutineName]
      println(childName == name) // true
      val childJob = coroutineContext[Job]
      println(childJob == parentJob) // false
      println(childJob == parentJob.children.first()) // true
    }
    parentJob.children.forEach { it.join() }
  }
}

fun test_children_not_inherit_parent_coroutinejob_2() {
  runBlocking {
    val job: Job = launch {
      delay(1000)
    }
    val parentJob: Job = coroutineContext.job
    println(job == parentJob) // false
    val parentChildren: Sequence<Job> = parentJob.children
    println(parentChildren.first() == job) // true
  }
}

fun test_not_waiting_children_when_children_replace_coroutinejob() {
  val job = Job()
  runBlocking {
    launch(job) { // the new job replaces one from parent
      delay(1000)
      println("child will not be printed")
    }
    println("parent printing")
  }
}
