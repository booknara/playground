package com.booknara.practice.kotlin.design

import com.booknara.practice.kotlin.Context

object SomeSingleton {
    init {
        println("init complete")
    }
}

open class SingletonHolder<out T: Any, in A> (creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile private var instance: T? = null

    fun getInstance(arg: A): T {
        val i = instance
        if (i != null) return i

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}

class SomeManager private constructor(context: Context) {
    init {
        // init using context argument
    }

    fun doStuff() {
        println("doStuff")
    }

    companion object : SingletonHolder<SomeManager, Context>(::SomeManager)
}

fun main() {
    val context = Context()
    SomeManager.getInstance(context).doStuff()
}