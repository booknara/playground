package com.booknara.practice.kotlin.operator

/**
 * https://riptutorial.com/kotlin/example/30735/elvis-operator-----
 * https://riptutorial.com/kotlin/example/12692/null-coalescing---elvis-operator
 */
fun main() {
    var str: String? = "nullable string value"

    // Tradition way to check null
    val len1 = if (str != null) str.length else -1
    println(len1)

    // Using elvis operator instead if condition
    val len2 = str?.length ?: -1
    println(len2)

    val cap1 = str?.capitalize() ?: ""
    println(cap1)

    var nullStr: String? = null
    val cap2 = nullStr?.capitalize() ?: throw IllegalArgumentException("Value can't be null")
    println(cap2)
}
