package com.booknara.practice.kotlin.safe

fun main() {
    var w: Wolf? = Wolf()
    if (w != null) {
        w.eat()
    }

    var x = w?.hunger
    println("The value of x is $x")

    var y = w?.hunger ?: -1
    println("The value of y is $y")

    var myWolf = MyWolf()
    myWolf?.wolf?.hunger = 8
    println("The value of myWolf?.wolf?.hunger is ${myWolf?.wolf?.hunger}")

    var myArray = arrayOf("Hi", "Hello", null)
    for (item in myArray) {
        item?.let {
            println(it)
        }
    }

    getAlphaWolf()?.let {
        it.eat()
    }
    w = null
    // var z = w!!.hunger
}

fun getAlphaWolf() : Wolf? {
    return Wolf()
}

class MyWolf {
    var wolf: Wolf? = Wolf()

    fun myFunction() {
        // Compile error
//        if (w != null) {
//            w.eat()
//        }

        wolf?.eat()
//        println(w?.hunger)
//
//        w?.let {
//            println(it.hunger)
//        }
    }
}
class Wolf (var hunger: Int = 10,
            val food: String = "meat") {
    fun eat() {
        println("The Wolf is eating $food")
    }
}