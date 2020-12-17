package com.booknara.practice.kotlin

import java.util.*

fun main(args: Array<String>) {
    println(if (args[0].toInt() < 12) "Good morning, Kotlin" else "Good night, Kotlin")
    dayOfWeek()


    var fortune: String
    for (i in 1..10) {
        // fortune = getFortune(getBirthday())
//        println("\nYour fortune is: $fortune")
//        if (fortune.contains("Take it easy")) break
    }


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

    val sophia = Person("Sophia", age = 34)
    val claudia = Person("Claudia", age = 29)

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

fun getFortune(): String {
    val fortunes = listOf("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
    )
    println("Enter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?: 1

    return fortunes[birthday.rem(fortunes.size)]
}

fun dayOfWeek() {
    println("What day is it today?")
    val day = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> ""
    }
    println(day)
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

data class Person(
        val firsName: String,
        val lastName: String = "default",
        val phoneNUmber: String? = null,
        val age: Int = 20) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)
    }
}