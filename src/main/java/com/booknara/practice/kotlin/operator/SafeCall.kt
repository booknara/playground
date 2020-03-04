package com.booknara.practice.kotlin.operator

/**
 * https://riptutorial.com/kotlin/example/6824/safe-call-operator
 */
fun main() {
    val str: String? = "Hello World"
    // println(str.length) -> Compile issue
    println(str?.length)

    // apply() -> calling multiple methods of outer scope
    str?.apply {
        foo()
        bar()
    }

    // let() -> calling multiple methods of str scope
    str?.let { it ->
        println(it.length)
        println(it.capitalize())
    }
}

fun foo() {
    // something
    println("foo")
}

fun bar() {
    // something
    println("bar")
}