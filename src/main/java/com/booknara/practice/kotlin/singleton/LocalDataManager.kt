package com.booknara.practice.kotlin.singleton

/**
 * Singleton example in Kotlin
 */
object LocalDataManager {
    var source = "File or DB"

    fun getData() : String {
        return source
    }
}