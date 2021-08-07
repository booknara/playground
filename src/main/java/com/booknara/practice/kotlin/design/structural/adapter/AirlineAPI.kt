package com.booknara.practice.kotlin.design.structural.adapter

import java.time.LocalDateTime

interface AirlineAPI {
  fun getPrice(): Int
  fun getTime(): LocalDateTime
}
