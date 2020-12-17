package com.booknara.practice.kotlin

/**
 * Decorator pattern
 */
//class DelegatingCollection<T> : Collection<T> {
//    private val innerList = arrayListOf<T>()
//
//    override val size: Int
//        get() = innerList.size
//
//    override fun isEmpty(): Boolean = innerList.isEmpty()
//
//    override fun contains(element: T): Boolean = innerList.contains(element)
//
//    override fun iterator(): Iterator<T> = innerList.iterator()
//
//    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
//}

/**
 * Using by keyword for delegation
 */
class DelegatingCollection<T>(
        innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList {}

class CountingSet<T> (
        val innerSet: MutableCollection<T> = HashSet()
) : MutableCollection<T> by innerSet {
    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}