package com.booknara.practice.kotlin

import java.security.Provider
import java.util.*

class MutableStack<E>(vararg items: E) {
    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun peek() = elements.last()

    fun pop() = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}

fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

fun <T: Number> oneHalf(value: T) : Double = value.toDouble() / 2.0

fun <T: Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}

// T should implement CharSequence, Appendable, both of them
fun <T> ensureTrailingPeriod(seq: T) where T:CharSequence, T:Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

class Processor<T> {
    fun process(value: T) {
        // "value" is nullable, so you have to use a safe call
        value?.hashCode()
    }
}

class NonNullProcessor<T: Any> {
    fun process(value: T) {
        // "value" is non-nullable
        value.hashCode()
    }
}

fun printSum(c: Collection<*>) {
    val intList = c as? List<Int>?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

fun printSum2(c: Collection<Int>) {
    if (c is List<Int>)
        println(c.sum())
}

//fun <T> isA(value: Any) = value is T
inline fun <reified T> isA(value: Any) = value is T

inline fun <reified T> loadService() = ServiceLoader.load(T::class.java)

fun main() {
    val stack = mutableStackOf(0.63, 3.14, 2.4)
    println(stack)

    val letters = ('a'..'z').toList()
    println(letters.slice(0..2))
    println(letters.slice(10..13))

    println(letters.subList(0, 3))
    println(letters.subList(10, 14))

    println(listOf(1, 2, 3, 4).penultimate)

    println(oneHalf(3))
    println(max(3, 5))
    println(max("A", "B"))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)

    printSum(listOf(1,2,3))
    //printSum(listOf("1", "2", "3"))
    printSum2(listOf(1,2,3))

    val items = listOf<Any>("one", 2, "three")
    println(items.filterIsInstance<String>())

    // reified use case
    //val serviceImpl = ServiceLoader.load(Provider.Service::class.java)
    val serviceImpl = loadService<Provider.Service>()
}
