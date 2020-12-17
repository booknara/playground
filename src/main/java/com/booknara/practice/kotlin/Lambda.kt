package com.booknara.practice.kotlin

val upperCase1 : (String) -> String = { str: String -> str.toUpperCase() }

val upperCase2 : (String) -> String = { str -> str.toUpperCase() }

val upperCase3 = { str: String -> str.toUpperCase() }

val upperCase4 : (String) -> String = { it.toUpperCase() }

val upperCase5 : (String) -> String = String::toUpperCase

val sum = { x: Int, y: Int -> x + y}

fun main() {
    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase4("hello"))
    println(upperCase5("hello"))

    println(sum(1, 2))
    val people = listOf(Person("Alice", age = 29), Person("Bob", age = 31))
    println(people.maxByOrNull { it.age })
    val names = people.joinToString(separator = " ", transform = { p: Person -> p.firsName })
    println(names)

    val getAge = { p: Person -> p.age }
    people.maxByOrNull(getAge)
}