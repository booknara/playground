package com.booknara.practice.kotlin

fun main() {
    // Kotlin uses == for structural comparison and === for referential comparison.
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    // '==' checks the value of object using equals method
    println(authors == writers)
    // '===' checks the reference. In other words, the object should be the same object to be true
    println(authors === writers)
}