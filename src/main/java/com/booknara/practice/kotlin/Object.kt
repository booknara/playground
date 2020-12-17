package com.booknara.practice.kotlin

import java.io.File
import java.util.*

/**
 * The "object" keyword: declaring a class and creating an instance, combined
 * 1. Object declaration is a way to define a singleton
 * 2. Companion objects can contains factory methods and other methods that are related to this class, but don't require a class instance to be called
 * 3. Object expression is used instead of Java's anonymous inner class
 */
class LuckDispatcher {
    fun getNumber() {
        var random = Random()
        println(random.nextInt(90))
    }
}

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int) : Unit {
    val dayRates = object {
        var standard = 30 * standardDays
        var festivity = 50 * festivityDays
        var speical = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.speical

    println("Total prices: $$total")
}

/**
 * Singleton object
 * Object doesn't allow to call constructor
 */
object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {
            // some code
        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file1.path, ignoreCase = true)
    }
}

object DoAuth {
    fun takeParams(username: String, password: String) {
        println("input Auth parameters = $username:$password")
    }
}

class BigBen {
    companion object {
        fun getBongs(times: Int) {
            for (i in 1..times) {
                print("BONG ")
            }
            println()
        }
    }
}

fun main() {
    val d1 = LuckDispatcher()
    val d2 = LuckDispatcher()

    d1.getNumber()
    d2.getNumber()

    rentPrice(10, 2, 1)

    DoAuth.takeParams("foo", "qwerty")

    BigBen.getBongs(12)

    Payroll.allEmployees.add(Person("name", age = 55))
    Payroll.calculateSalary()
}