package com.booknara.practice.kotlin.design.structural.adapter

import java.time.LocalDateTime

class KoreanAirlineAPI : AirlineAPI {
  override fun getPrice(): Int {
    return 100
  }

  override fun getTime(): LocalDateTime {
    return LocalDateTime.now()
  }
}
