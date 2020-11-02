package com.booknara.practice.kotlin

open class Dog {
    open fun sayHello() {
        println("wow wow!!")
    }
}

class Yorkshire: Dog() {
    override fun sayHello() {
        //super.sayHello()
        println("wif wif!!")
    }
}

open class Tiger(val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lino from $origin says: graoh!")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "India")

class SiberianTiger: Tiger("Siberia")

fun main() {
    val dog: Dog = Yorkshire()
    dog.sayHello()

    val tiger = SiberianTiger()
    tiger.sayHello()

    val lion = Asiatic("Rufo")
    lion.sayHello()
}