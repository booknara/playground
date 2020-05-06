package com.booknara.practice.kotlin.safe

interface Roamable

open class Animal(hunger: Int) : Roamable {
    open fun eat() { }
}

class GrayWolf(hunger: Int) : Animal(hunger) {
    override fun eat() { }
}

class MyRoamable {
    var r: Roamable = GrayWolf(6)

    fun function() {
        if (r is GrayWolf) {
            val wolf = r as GrayWolf
            wolf.eat()
        }
    }

    fun function1() {
        if (r is GrayWolf) {
            val wolf = r as? GrayWolf   // as? -> safe case
            wolf?.eat()
        }
    }

}