package com.booknara.practice.kotlin.design.structural.adapter

import java.time.LocalDateTime

class UnitedAirlineAPI : AirlineAPI {
  override fun getPrice(): Int {
    return 50
  }

  override fun getTime(): LocalDateTime {
    return LocalDateTime.now()
  }
}
