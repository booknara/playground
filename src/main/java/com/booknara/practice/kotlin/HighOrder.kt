package com.booknara.practice.kotlin

// passing function as argument
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int) : Int {
    return operation(x, y)
}

// returning functions
fun operation(): (Int) -> Int {
    return ::square
}

fun square(x: Int) = x * x

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate() : (Person) -> Boolean {
        val startsWithPrefix = { p: Person ->
            p.firsName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }

        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return { startsWithPrefix(it)
                && it.phoneNUmber != null
        }
    }
}

fun main() {
    val sumResult = calculate(4, 5, ::sum)
    val mulResult = calculate(4, 5) {
        a, b -> a * b
    }

    println("sumResult $sumResult, mulResult $mulResult")

    val func = operation()
    println(func(2))

    val contacts = listOf(Person("Dmitry", "Jemerov", "123-456"),
            Person("Svetlana", "Isakova",  null))
    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
}

