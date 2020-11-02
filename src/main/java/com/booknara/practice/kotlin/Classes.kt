package com.booknara.practice.kotlin

class Customer

class Contact(val id: Int, var email: String)

fun main() {
    val customer = Customer()

    val contact = Contact(1, "abc@abc.com")
    println(contact.id)
    contact.email = "def@abc.com"
    println(contact.email)
}