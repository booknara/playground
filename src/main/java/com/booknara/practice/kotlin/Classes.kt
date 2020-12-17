package com.booknara.practice.kotlin

import com.booknara.practice.kotlin.annotation.JsonExclude
import com.booknara.practice.kotlin.annotation.JsonName

class Customer

class Contact(val id: Int, var email: String)

data class User(
        @JsonName("alias") val firstName: String,
        @JsonExclude val age: Int? = null)

sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)

class Human(val humanName: String, val job: String) : Mammal(humanName)

class Client(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if (other !is Client) return false

        return name == other.name && postalCode == other.postalCode
    }

    override fun toString() = "Client(name=$name, postalCode=$postalCode)"

    override fun hashCode() = name.hashCode() * 31 + postalCode

    fun copy(name: String = this.name, postalCode: Int = this.postalCode)
            = Client(name, postalCode)
}

fun main() {
    val customer = Customer()

    val contact = Contact(1, "abc@abc.com")
    println(contact.id)
    contact.email = "def@abc.com"
    println(contact.email)

    // data class
    val user = User("Alex", 1)
    println(user)

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    // structural equality check
    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")

    println(user.hashCode())
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    // copy function
    println(user.copy())
    println(user.copy(firstName = "Max"))
    println(user.copy(age = 2))

    println("name = ${user.component1()}")
    println("id = ${user.component2()}")

    // sealed class
    println(greetMammal(Cat("Snowy")))

    val client1 = Client("Alice", 12345)
    val client2 = Client("Alice", 12345)
    println(client1)
    println(client2)
    println(client1 == client2)

    val processed = hashSetOf(client1)
    println(processed.contains(client2))
}

fun greetMammal(mammal: Mammal) : String = when (mammal) {
    is Human -> "Hello ${mammal.name}; You're working as a ${mammal.job}"
    is Cat -> "Hello ${mammal.name}"
}