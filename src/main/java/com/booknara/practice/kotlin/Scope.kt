package com.booknara.practice.kotlin

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

    val empty = "test".let {
        println(it)
        it.isEmpty()
    }
    println(" is empty: $empty")

    getNullableLength(null)
    getNullableLength("")
    getNullableLength("some string with Kotlin")

    // with
    println(alphabetWith())
    println(alphabetApply())
}

fun alphabetWith(): String {
    return with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet")
        toString()
    }
}

fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
}.toString()

fun getNullableLength(ns: String?) {
    println("for \"$ns\":")
    ns?.run {
        println("\tis empty? " + isEmpty())
        println("\tlength = $length")
        length
    }
}

fun printNonNull(str: String?) {
    println("Printing \"$str\":")

}

fun foo() {
    // something
    println("foo")
}

fun bar() {
    // something
    println("bar")
}