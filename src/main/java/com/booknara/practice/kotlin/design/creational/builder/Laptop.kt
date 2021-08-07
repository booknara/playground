package com.booknara.practice.kotlin.design.creational.builder

class Laptop(builder: Builder) {
  // required
  private val processor = builder.processor

  // optional
  private val ram = builder.ramSize
  private val batteryCapacity = builder.batteryCapacity
  private val screenSize = builder.screenSize


  class Builder(var processor: String) {
    var ramSize = 2_000_000
    var batteryCapacity = 5000
    var screenSize = 32

    fun setRamSize(ramSize: Int): Builder {
      this.ramSize = ramSize
      return this
    }

    fun setBatteryCapacity(batteryCapacity: Int): Builder {
      this.batteryCapacity = batteryCapacity
      return this
    }

    fun setScreenSize(screenSize: Int): Builder {
      this.screenSize = screenSize
      return this
    }

    fun create(): Laptop {
      return Laptop(this)
    }
  }
}

fun main() {
  val highEndLaptop =
      Laptop.Builder("INTER")
          .setRamSize(5_000_000)
          .setBatteryCapacity(10000)
          .setScreenSize(36)
          .create()
  val lowEndLaptop =
      Laptop.Builder("AMD")
          .setRamSize(1_000_000)
          .setBatteryCapacity(1000)
          .setScreenSize(24)
          .create()
}


