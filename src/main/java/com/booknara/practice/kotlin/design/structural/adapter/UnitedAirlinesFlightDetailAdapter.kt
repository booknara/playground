package com.booknara.practice.kotlin.design.structural.adapter

import java.time.LocalDateTime

class UnitedAirlinesFlightDetailAdapter(val airlineAPI: AirlineAPI) : FlightDetailAdapter {

  override fun getPriceInKOR(): Int {
    return convertUSToKOR(airlineAPI.getPrice())
  }

  override fun getTimeInKST() : LocalDateTime {
    return convertUSToKST(airlineAPI.getTime())
  }

  fun convertUSToKOR(price: Int) = price * 2
  fun convertUSToKST(time: LocalDateTime) = time.plusHours(9)
}
