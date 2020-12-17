package com.booknara.practice.kotlin

import kotlin.math.pow

/**
 * exp -> functions names
 * a * b = times
 * a / b = div
 * a % b = mod
 * a + b = plus
 * a - b = minus
 */
fun main() {
    val array = Array(7) { 1000.0.pow(it)}

    val sizes = arrayOf("byte", "kilobyte", "megabyte", "gigabyte",
            "terabyte", "petabyte", "exabyte")
    for ((i, value) in array.withIndex()) {
        println("1 ${sizes[i]} = ${value.toLong()} bytes")
    }

    val numbers = Array(5) { 11 + it }
    val strings = mutableListOf<String>()
    for (n in numbers)
        strings.add(n.toString())

    for (s in strings)
        println("string: $s")

    val div = mutableListOf<Int>()
    for (x in 0..100 step 7) {
        div.add(x)
        print("$x ")
    }
}