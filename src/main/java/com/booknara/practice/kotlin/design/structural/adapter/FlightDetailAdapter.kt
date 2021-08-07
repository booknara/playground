package com.booknara.practice.kotlin.design.structural.adapter

import java.time.LocalDateTime

interface FlightDetailAdapter {
  fun getPriceInKOR(): Int
  fun getTimeInKST() : LocalDateTime
}
