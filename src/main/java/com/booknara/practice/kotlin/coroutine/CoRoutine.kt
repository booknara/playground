package com.booknara.practice.kotlin.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("main starts")
    joinAll(
            async { coroutine(1, 500) },
            async { coroutine(2, 300) }
    )
    println("main ends")
}

suspend fun coroutine(number: Int, d: Long) {
    println("Coroutine $number starts work")
    delay(d)
    println("Coroutine $number has finished")
}