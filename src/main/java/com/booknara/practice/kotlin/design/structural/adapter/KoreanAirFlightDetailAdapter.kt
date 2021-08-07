package com.booknara.practice.kotlin.design.structural.adapter

import java.time.LocalDateTime

class KoreanAirFlightDetailAdapter(val airlineAPI: AirlineAPI) : FlightDetailAdapter {

  override fun getPriceInKOR(): Int {
    return airlineAPI.getPrice()
  }

  override fun getTimeInKST() : LocalDateTime {
    return airlineAPI.getTime()
  }
}
