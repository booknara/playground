package com.booknara.practice.kotlin

import kotlin.math.abs

val systemUsers: MutableList<Int> = mutableListOf(1, 2,3)
val sudoers: List<Int> = systemUsers

fun addSudoers(newUser: Int) {
    systemUsers.add(newUser)
}

fun getSysSudoers() : List<Int> {
    return sudoers
}

val openIssues: MutableSet<String> = mutableSetOf("uniqueDescr1", "uniqueDescr2", "uniqueDescr3")

fun addIssue(uniqueDesc: String): Boolean {
    return openIssues.add(uniqueDesc)
}

fun getStatusLog(isAdded: Boolean): String {
    return if (isAdded) "registered correctly." else "marked as duplicate and rejected."
}

const val POINTS_X_PASS = 15
val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
val EZPassReport: Map<Int, Int> = EZPassAccounts

fun updatePointsCredit(accountId: Int) {
    if (EZPassAccounts.containsKey(accountId)) {
        println("Updating $accountId...")
        EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS
    } else {
        println("Error: Trying to update a non-existing account (id: $accountId)")
    }
}

fun accountsReport() {
    println("EZ-Pass report:")
    EZPassReport.forEach {
        (k, v) -> println("ID $k: credit $v")
    }
}

fun main() {
    addSudoers(4)
    println("Tot sudoers: ${getSysSudoers().size}")
    getSysSudoers().forEach {
        i -> println("Some useful info on user $i")
    }

    val aNewIssue = "uniqueDescr4"
    val anIssueAlreadyIn = "uniqueDescr2"

    println("Issue $aNewIssue ${getStatusLog(addIssue(aNewIssue))}")
    println("Issue $anIssueAlreadyIn ${getStatusLog(addIssue(anIssueAlreadyIn))}")

    accountsReport()
    updatePointsCredit(1)
    updatePointsCredit(1)
    updatePointsCredit(5)
    accountsReport()

    // filter
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val positives = numbers.filter { x -> x > 0 }
    println(positives)
    val negatives = numbers.filter { it < 0 }
    println(negatives)

    // map
    val doubled = numbers.map { x -> x * 2 }
    println(doubled)
    val tripled = numbers.map { it * 3 }
    println(tripled)

    // any
    val anyNegative = numbers.any { it < 0 }
    println(anyNegative)
    val anyGT6 = numbers.any { it > 6 }
    println(anyGT6)

    // all
    val allEven = numbers.all { it % 2 == 0 }
    println(allEven)
    val allLess6 = numbers.all { it < 6 }
    println(allLess6)

    // none
    val nonAllEven = numbers.none { it % 2 == 1 }
    println(nonAllEven)
    val nonAllLess6 = numbers.none { it > 6 }
    println(nonAllLess6)

    // find, findLast
    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")

    val first = words.find { it.startsWith("some") }
    println(first)
    val last = words.findLast { it.startsWith("some") }
    println(last)
    val nothing = words.find { it.contains("nothing") }
    println(nothing)

    // first, last
    val firstEven = numbers.first { it % 2 == 0 }
    println(firstEven)
    val lastOdd = numbers.last { it % 2 != 0 }
    println(lastOdd)

    // count
    val totalCount = numbers.count()
    println(totalCount)
    val evenCount = numbers.count { it % 2 == 0 }
    println(evenCount)

    // associateBy, groupBy
    data class Person(val name: String, val city: String, val phone: String)

    val people = listOf(
            Person("John", "Boston", "+1-888-123456"),
            Person("Sarah", "Munich", "+49-777-789123"),
            Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
            Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"))

    val phoneBook = people.associateBy { it.phone }
    println(phoneBook)
    val cityBook = people.associateBy(Person::phone, Person::city)
    println(cityBook)
    val peopleCities = people.groupBy(Person::city, Person::name)
    println(peopleCities)

    val alphabet = listOf("a", "ab", "b")
    //println(alphabet.groupBy(String::first))
    println(alphabet.groupBy { it[0]} )

    //println(people.map(Person::name).filter { it.startsWith("S") })
    println(people.asSequence()
            .map(Person::name)
            .filter { it.startsWith("S") }
            .toList())

    // partition
    val evenOdd = numbers.partition { it % 2 == 0 } // return type: Pair
    println(evenOdd)
    val (pos, neg) = numbers.partition { it > 0 }   // Pair destructuring, each item : list
    println("$pos, $neg")

    // flatMap
    val tripledFlatMap = numbers.flatMap { listOf(it, it, it) }
    println(tripledFlatMap)

    val empty = emptyList<Int>()

    println("Numbers: $numbers, min = ${numbers.minOrNull()} max = ${numbers.maxOrNull()}")
    println("Empty: $empty, min = ${empty.minOrNull()}, max = ${empty.maxOrNull()}")

    // sorted
    val shuffled = listOf(5, 4, 2, 1, 3, -10)
    val natural = shuffled.sorted()
    println(natural)
    val inverted = shuffled.sortedBy { -it }
    println(inverted)
    val descending = shuffled.sortedDescending()
    println(descending)
    val descendingBy = shuffled.sortedByDescending { abs(it)  }
    println(descendingBy)

    // Map Element Access
    val map = mapOf("key" to 42)

    val value1 = map["key"]
    println(value1)
    val value2 = map["key2"]
    println(value2)

    val value3: Int = map.getValue("key")
    println(value3)

    val mapWithDefault = map.withDefault { k -> k.length }
    println(mapWithDefault)
    val value4 = mapWithDefault.getValue("key2")
    println(value4)

    try {
        map.getValue("anotherKey")
    } catch (e: NoSuchElementException) {
        println("Message: $e")
    }

    val A = listOf("a", "b", "c")
    val B = listOf(1, 2, 3, 4)

    val resultPairs = A zip B
    println(resultPairs)
    val resultReduce = A.zip(B) { a, b -> "$a$b" }
    println(resultReduce)

    // gerOrElse
    val list = listOf(0, 10, 20)
    println(list.getOrElse(1) { 42 })
    println(list.getOrElse(10) { 42 })

    val map1 = mutableMapOf<String, Int?>()
    println(map1.getOrElse("x") { 1 })

    map1["x"] = 3
    println(map1.getOrElse("x") { 1 })

    map1["x"] = null
    println(map1.getOrElse("x") { 1 })
}