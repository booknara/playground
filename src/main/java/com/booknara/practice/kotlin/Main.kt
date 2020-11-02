package com.booknara.practice.kotlin

fun main() {
    println("Hello World!")
    printMessage("Hello")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Hello")
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 2))
    println(multiply(1, 2))

    println("------------ Infix functions ------------")

    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")

    sophia likes claudia

    println("------------ Operator functions ------------")
    println(2 * "Bye ")
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[1..14])

    println("------------ Functions with vararg Parameters ------------")

    printAll("Hello", "Hallo", "Sault", "Hola")

    printAllWithPrefix("Hello", "Hallo", "Sault", "Hola", prefix = "Greetings")

    var a: String = "initial"
    println(a)
    val b: Int = 1;
    var c = 3
}

fun printMessage(message: String): Unit {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("[$prefix] $message")
}

fun sum (x: Int, y: Int): Int {
    return x + y
}

fun multiply(x: Int, y: Int) = x * y

fun printAll(vararg message: String) {
    for (m in message) println(m)
}

fun printAllWithPrefix(vararg message: String, prefix: String) {
    for (m in message) println("$prefix $m")
}

fun log(vararg entries: String) {
    printAll(*entries)
}

operator fun Int.times(str: String) = str.repeat(this)

operator fun String.get(range: IntRange) = substring(range)

fun describeString(maybeString: String?): String {
    return if (maybeString != null && maybeString.isNotEmpty()) {
        maybeString
    } else {
        "Empty or null String"
    }
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)
    }
}