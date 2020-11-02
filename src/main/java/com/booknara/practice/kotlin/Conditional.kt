package com.booknara.practice.kotlin

fun main() {
    println(max(99, -42))
}

// if is an expression
fun max(a: Int, b: Int) = if (a > b) a else b