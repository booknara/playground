package com.booknara.practice.kotlin.design.structural.adapter

class FlightView() {
  lateinit var priceTextView: String
  lateinit var timeTextView: String
  fun showFlightData(flightDataAdapter: FlightDetailAdapter) {
    priceTextView = flightDataAdapter.getPriceInKOR().toString()
    timeTextView = flightDataAdapter.getTimeInKST().toString()
  }
}

fun main() {
  val flightView = FlightView()
  flightView.showFlightData(KoreanAirFlightDetailAdapter(KoreanAirlineAPI()))
  flightView.showFlightData(UnitedAirlinesFlightDetailAdapter(UnitedAirlineAPI()))
}
