package com.booknara.practice.kotlin.higherorderfunction

data class Grocery(
        val name: String,
        val category: String,
        val unit: String,
        val unitPrice: Double,
        val quantity: Int)

fun main(args: Array<String>) {
    val groceries = listOf<Grocery>(
            Grocery("Tomatoes", "Vegetable", "lb", 3.0, 3),
            Grocery("Mushroom", "Vegetable", "lb", 4.0, 1),
            Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
            Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
            Grocery("Ice cream", "Frozen", "Pack", 3.0, 2)
    )

    val highestUnitPrice = groceries.maxBy { it.unitPrice * 5 }
    println("highestUnitPrice: $highestUnitPrice")
    val lowestQuantity = groceries.minBy { it.quantity }
    println("lowestQuantity: $lowestQuantity")

    val sumQuantity = groceries.sumBy { it.quantity }
    println("sumQuantity: $sumQuantity")
    val totalPrice = groceries.sumByDouble { it.unitPrice * it.quantity }
    println("totalPrice: $totalPrice")

    val vegetables = groceries.filter { it.category == "Vegetable" }
    val unitPriceOver3 = groceries.filter { it.unitPrice > 3.0 }
    val nonFrozen = groceries.filterNot { it.category != "Frozen" }

    val groceryNames = groceries.map { it.name }
    val halfUnitPrice = groceries.map { it.unitPrice * 0.5 }

    val newPrices = groceries.filter { it.unitPrice > 3.0 }
            .map { it.unitPrice * 2 }

    for (item in groceries) {
        println(item.name)
    }

    groceries.forEach { println(it.name) }

    for (item in groceries) {
        if (item.unitPrice > 3.0) println(item.name)
    }

    groceries.filter { it.unitPrice > 3.0 }
            .forEach { println(it.name) }

    var itemNames = ""
    for (item in groceries) {
        itemNames += "${item.name} "
    }
    println("itemNames: $itemNames ")

    itemNames = ""
    groceries.forEach { itemNames += "${it.name} " }
    println("itemNames: $itemNames ")

    val groupBycategory = groceries.groupBy { it.category }
    // println(groupBycategory)
    groceries.groupBy { it.category }.forEach {
        println(it.key)
        it.value.forEach { println("    ${it.name}") }
    }

    val ints = listOf<Int>(1, 2, 3)
    val sumOfInts = ints.fold(0) {
        runningSum, item -> runningSum + item
    }

    println("sumOfInts: $sumOfInts")
    println(sumOfInts.javaClass.kotlin.simpleName)

    val productOfInts = ints.fold(1) {
        runningSum, item -> runningSum * item
    }
    println("productOfInts: $productOfInts")

    val names = groceries.fold("") {
        string, item -> string + " ${item.name}" }
    println("names: $names")

    val changeFrom50 = groceries.fold(50.0) {
        change, item -> change - item.unitPrice * item.quantity
    }
    println("changeFrom50: $changeFrom50")
}