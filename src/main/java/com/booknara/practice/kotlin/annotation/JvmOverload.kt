//@file:JvmName("SomeName") // to change the file class name
package com.booknara.practice.kotlin.annotation

import java.util.*

fun main() {
    bar()
    bar(1)
    bar(1, 0.1)
    bar(1, 0.1, "Custom string")

    Event("Birthday party")
    Event("Celebration", Date(), true)
}

@JvmOverloads
fun bar(a:Int = 0, b: Double = 0.0, c:String = "default value") {
    println("a=$a, b=$b, c = $c")
}

data class Event @JvmOverloads constructor(var name: String? = "",
                                           var date: Date? = Date(),
                                           var private: Boolean = false)