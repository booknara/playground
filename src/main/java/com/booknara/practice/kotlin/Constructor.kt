package com.booknara.practice.kotlin

//class Car constructor(nickName: String) {
//    val nickName: String
//    init {
//        this.nickName = nickName
//    }
//}

//class Car constructor(nickName: String) {
//    val nickName = nickName
//}

//class Car (val nickName: String)

class Context
class AttributeSet

open class Car (val nickName: String, val isSubscribed: Boolean = true)

class Sedan(nickName: String) : Car(nickName)

open class Button

class RadioButton : Button()

open class View {
    constructor(context: Context) {
        // some code
    }

    constructor(context: Context, attributeSet: AttributeSet) {
        // some code
    }
}

class CheckButton : View {
    companion object {
        val STYLE = AttributeSet()
    }

//    constructor(context: Context) : super(context) {
//        // some code
//    }

    constructor(context: Context) : this(context, STYLE) {
        // some code
    }
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet){
        // some code
    }
}

class Home(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".
            """.trimIndent())
            field = value
        }
}

fun main() {
    val home = Home("Alice")
    home.address = "Elsenheimerstrasse 47, 80687 Muenchen"
}