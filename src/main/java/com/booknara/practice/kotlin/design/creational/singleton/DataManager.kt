package com.booknara.practice.kotlin.design.creational.singleton

object DataManager {
  init {
      // Singleton is invoked
  }

  fun getUserData(): String {
    // Some code
    return "User"
  }
}

fun main() {
  val userData = DataManager.getUserData()
}
