package com.booknara.practice.kotlin

fun main() {
    // Ranges
    for (i in 0..3) {
        print(i)
    }
    println()

    for (i in 2..8 step 2) {
        print(i)
    }
    println()

    for (i in 3 downTo 0) {
        print(i)
    }
    println()

    for (c in 'a'..'d') {
        print(c)
    }
    println()

    for (c in 'z' downTo 's' step 2) {
        print(c)
    }
    println()

    val x = 2
    if (x in 1..5) {
        print("x is in range from 1 to 5")
    }
    println()

    if (x !in 6..10) {
        print("x is not in range from 6 to 10")
    }
}